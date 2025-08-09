<template>
  <div class="navbar">
    <div class="navbar-left">
      <!-- 触发按钮 -->
      <el-button type="primary" @click="openDialog">
        <el-icon><ChatDotRound /></el-icon>
        <span>智能客服</span>
      </el-button>

      <!-- 可拖拽、可缩放的非模态对话框 -->
      <div 
        v-if="dialogVisible"
        ref="dialogRef"
        class="resizable-dialog"
        :style="{
          left: dialogLeft + 'px',
          top: dialogTop + 'px',
          width: dialogWidth + 'px',
          height: dialogHeight + 'px'
        }"
      >
        <div class="dialog-header" @mousedown="startDrag">
          <span>智能客服</span>
          <el-icon class="close-btn" @click="dialogVisible = false"><Close /></el-icon>
        </div>
        <div class="dialog-body">
          <!-- 消息时间线 -->
          <div class="message-container">
            <el-timeline>
              <el-timeline-item
                v-for="(activity, index) in activities"
                :key="index"
                :color="activity.color"
                :timestamp="activity.timestamp"
              >
                {{ activity.content }}
              </el-timeline-item>
            </el-timeline>
          </div>
          
          <!-- 输入区域 -->
          <div class="input-area">
            <el-input
              v-model="msg"
              :rows="2"
              type="textarea"
              placeholder="请输入您的问题"
              @keydown.enter="sendMsg"
            />
            <el-button type="primary" @click="sendMsg">发送</el-button>
          </div>
        </div>
        
        <!-- 缩放控制点 -->
        <div class="resize-handle right" @mousedown="startResize('right', $event)"></div>
        <div class="resize-handle bottom" @mousedown="startResize('bottom', $event)"></div>
        <div class="resize-handle bottom-right" @mousedown="startResize('bottom-right', $event)"></div>
      </div>
    </div>

    <div class="navbar-right">
      <el-dropdown @command="handleCommand">
        <span class="el-dropdown-link">
          欢迎您, {{ name }}
          <el-icon class="el-icon--right"><arrow-down /></el-icon>
        </span>
        <template #dropdown>
          <el-dropdown-menu>
            <el-dropdown-item command="profile">个人中心</el-dropdown-item>
            <el-dropdown-item command="logout" divided>退出登录</el-dropdown-item>
          </el-dropdown-menu>
        </template>
      </el-dropdown>
    </div>
  </div>
</template>

<script setup>
import { computed, ref, nextTick } from 'vue'
import { useRouter } from 'vue-router'
import { useStore } from 'vuex'
import { ArrowDown } from '@element-plus/icons-vue'
import { ChatDotRound, Close } from '@element-plus/icons-vue'
import { EventSourcePolyfill } from 'event-source-polyfill';

const router = useRouter()
const store = useStore()
const name = computed(() => store.getters.name)

// 对话框相关状态
const dialogVisible = ref(false)
const dialogRef = ref(null)
const dialogLeft = ref(0)
const dialogTop = ref(0)
const dialogWidth = ref(400)  // 初始宽度
const dialogHeight = ref(500) // 初始高度
const minWidth = 350
const minHeight = 300

// 拖拽相关状态
const isDragging = ref(false)
const startDragX = ref(0)
const startDragY = ref(0)

// 缩放相关状态
const isResizing = ref(false)
const resizeDirection = ref('')
const startResizeX = ref(0)
const startResizeY = ref(0)
const startResizeWidth = ref(0)
const startResizeHeight = ref(0)

// 聊天相关状态
const activities = ref([
  {
    content: `⭐您好 ${name.value}！请问有什么可以帮您的?`,
    timestamp: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString(),
    color: '#0bbd87',
  },
])
const msg = ref('')
let eventSource = null
let aiResponseIndex = 0

const openDialog = () => {
  dialogVisible.value = true
  nextTick(() => {
    // 初始位置（屏幕右下角）
    dialogLeft.value = window.innerWidth - dialogWidth.value - 20
    dialogTop.value = window.innerHeight - dialogHeight.value - 20
  })
}

// 开始拖拽
const startDrag = (e) => {
  if (isResizing.value) return
  isDragging.value = true
  startDragX.value = e.clientX - dialogLeft.value
  startDragY.value = e.clientY - dialogTop.value
  document.addEventListener('mousemove', handleDrag)
  document.addEventListener('mouseup', stopDrag)
}

// 处理拖拽
const handleDrag = (e) => {
  if (isDragging.value) {
    dialogLeft.value = e.clientX - startDragX.value
    dialogTop.value = e.clientY - startDragY.value
  } else if (isResizing.value) {
    handleResize(e)
  }
}

// 停止拖拽
const stopDrag = () => {
  isDragging.value = false
  isResizing.value = false
  document.removeEventListener('mousemove', handleDrag)
  document.removeEventListener('mouseup', stopDrag)
}

// 开始缩放
const startResize = (direction, e) => {
  e.preventDefault()
  e.stopPropagation()
  
  isResizing.value = true
  resizeDirection.value = direction
  startResizeX.value = e.clientX
  startResizeY.value = e.clientY
  startResizeWidth.value = dialogWidth.value
  startResizeHeight.value = dialogHeight.value
  
  document.addEventListener('mousemove', handleResize)
  document.addEventListener('mouseup', stopResize)
}

// 处理缩放
const handleResize = (e) => {
  if (!isResizing.value) return
  
  const dx = e.clientX - startResizeX.value
  const dy = e.clientY - startResizeY.value
  
  if (resizeDirection.value.includes('right')) {
    dialogWidth.value = Math.max(minWidth, startResizeWidth.value + dx)
  }
  
  if (resizeDirection.value.includes('bottom')) {
    dialogHeight.value = Math.max(minHeight, startResizeHeight.value + dy)
  }
}

// 停止缩放
const stopResize = () => {
  isResizing.value = false
  document.removeEventListener('mousemove', handleResize)
  document.removeEventListener('mouseup', stopResize)
}

// 发送消息
const sendMsg = () => {
  if (!msg.value.trim()) return
  
  // 获取token
  const token = localStorage.getItem("token")
  if (!token) {
    activities.value.push({
      content: 'AI: 请先登录',
      timestamp: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString(),
      color: '#f56c6c',
    })
    return
  }
  
  // 关闭之前的连接
  if (eventSource) {
    eventSource.close()
    eventSource = null
  }
  
  // 添加用户消息
  activities.value.push({
    content: `你: ${msg.value}`,
    timestamp: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString(),
    color: '#409eff',
  })
  
  // 添加AI响应占位符
  activities.value.push({
    content: '思考中...',
    timestamp: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString(),
    color: '#0bbd87',
  })
  
  // 记录AI响应的索引
  aiResponseIndex = activities.value.length - 1
  const userMessage = msg.value
  msg.value = ''
  
  // 使用 SSE
  const url = `/api/ai/generateStreamAsString?message=${encodeURIComponent(userMessage)}`;
  console.log('Creating EventSource with URL:', url)
  console.log('Using token:', token ? 'Present' : 'Missing')
  
  eventSource = new EventSourcePolyfill(url, {
    headers: {
      'Authorization': `Bearer ${token}`,
      'Accept': 'text/event-stream',
    },
    withCredentials: false, // 改为false，通过header传递认证信息
  });
  
  // 处理消息事件
  eventSource.onmessage = (event) => {
    console.log('Received SSE event:', event)
    
    if (event.data === '[complete]') {
      eventSource.close()
      eventSource = null
      return
    }
    
    // 如果是认证错误，显示错误信息
    if (event.data.includes('认证失败')) {
      if (activities.value[aiResponseIndex]) {
        activities.value[aiResponseIndex].content = `AI: ${event.data}`
        activities.value[aiResponseIndex].color = '#f56c6c'
      }
      eventSource.close()
      eventSource = null
      return
    }
    
    // 清除"思考中..."并开始接收真实内容
    if (activities.value[aiResponseIndex] && activities.value[aiResponseIndex].content === '思考中...') {
      activities.value[aiResponseIndex].content = `AI: ${event.data}`
    } else {
      // 追加内容
      if (activities.value[aiResponseIndex]) {
        activities.value[aiResponseIndex].content += event.data
      }
    }
  }

  eventSource.onerror = (error) => {
    console.error('EventSource error:', error)
    if (activities.value[aiResponseIndex]) {
      activities.value[aiResponseIndex].content = 'AI: 服务连接错误，请重试。'
      activities.value[aiResponseIndex].color = '#f56c6c'
    }
    eventSource.close()
    eventSource = null
  }
  
  eventSource.onopen = (event) => {
    console.log('EventSource opened:', event)
  }
}

const handleCommand = async (command) => {
  if (command === 'logout') {
    await store.dispatch('logout')
    router.push(`/login?redirect=${router.currentRoute.value.fullPath}`)
  } else if (command === 'profile') {
    // 个人中心导航
    console.log('Navigate to profile page')
  }
}
</script>

<style scoped>
.navbar {
  height: 100%;
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: #fff;
  box-shadow: 0 1px 4px rgba(0,21,41,.08);
  padding: 0 20px;
}
.el-dropdown-link {
  cursor: pointer;
  display: flex;
  align-items: center;
}

.resizable-dialog {
  position: fixed;
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 12px 0 rgba(0, 0, 0, 0.1);
  z-index: 2000;
  user-select: none;
  display: flex;
  flex-direction: column;
  overflow: hidden;
  resize: none;
}

.dialog-header {
  padding: 12px 16px;
  background: #409eff;
  color: white;
  display: flex;
  justify-content: space-between;
  align-items: center;
  cursor: move;
  flex-shrink: 0;
}

.dialog-header .close-btn {
  cursor: pointer;
}

.dialog-body {
  display: flex;
  flex-direction: column;
  flex-grow: 1;
  overflow: hidden;
  padding: 0;
}

.message-container {
  flex-grow: 1;
  overflow-y: auto;
  padding: 16px;
}

.input-area {
  padding: 16px;
  border-top: 1px solid #ebeef5;
  display: flex;
  gap: 10px;
  align-items: flex-end;
}

.input-area .el-textarea {
  flex-grow: 1;
}

/* 缩放控制点样式 */
.resize-handle {
  position: absolute;
  background: transparent;
  z-index: 10;
}

.resize-handle.right {
  top: 0;
  right: 0;
  width: 5px;
  height: 100%;
  cursor: e-resize;
}

.resize-handle.bottom {
  bottom: 0;
  left: 0;
  width: 100%;
  height: 5px;
  cursor: s-resize;
}

.resize-handle.bottom-right {
  bottom: 0;
  right: 0;
  width: 10px;
  height: 10px;
  cursor: se-resize;
}

/* 自定义时间线样式 */
.el-timeline {
  padding-left: 10px;
}

.el-timeline-item {
  margin-bottom: 15px;
}

.el-timeline-item__timestamp {
  font-size: 12px;
  color: #999;
  margin-bottom: 5px;
}
</style>