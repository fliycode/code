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
          <div class="message-container" ref="messageContainer">
            <el-timeline>
              <el-timeline-item
                v-for="(activity, index) in activities"
                :key="activity.id"
                :color="activity.color"
                :timestamp="activity.timestamp"
              >
                <div class="message-content" v-html="formatMessage(activity.content)"></div>
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
              :disabled="isLoading"
              @keydown.enter.prevent="sendMsg"
            />
            <el-button 
              type="primary" 
              @click="sendMsg"
              :loading="isLoading"
              :disabled="!msg.trim()"
            >
              {{ isLoading ? '发送中' : '发送' }}
            </el-button>
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
import { computed, ref, nextTick, onUnmounted } from 'vue'
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
const messageContainer = ref(null)
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
let messageIdCounter = 0
const activities = ref([
  {
    id: messageIdCounter++,
    content: `⭐您好 ${name.value}！请问有什么可以帮您的?`,
    timestamp: new Date().toLocaleDateString() + " " + new Date().toLocaleTimeString(),
    color: '#0bbd87',
  },
])
const msg = ref('')
const isLoading = ref(false)
let eventSource = null
let currentAiMessageId = null
let streamBuffer = [] // 用数组缓存流式数据片段

const openDialog = () => {
  dialogVisible.value = true
  nextTick(() => {
    // 初始位置（屏幕右下角）
    dialogLeft.value = window.innerWidth - dialogWidth.value - 20
    dialogTop.value = window.innerHeight - dialogHeight.value - 20
  })
}

// 格式化消息内容，支持换行显示
const formatMessage = (content) => {
  return content.replace(/\n/g, '<br>')
}

// 自动滚动到底部
const scrollToBottom = () => {
  nextTick(() => {
    if (messageContainer.value) {
      messageContainer.value.scrollTop = messageContainer.value.scrollHeight
    }
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

// 更新AI消息内容
const updateAiMessage = (content, isComplete = false) => {
  const messageIndex = activities.value.findIndex(item => item.id === currentAiMessageId)
  if (messageIndex !== -1) {
    // 创建新的消息对象以触发响应式更新
    const updatedMessage = {
      ...activities.value[messageIndex],
      content: `AI: ${content}`,
      color: isComplete ? '#0bbd87' : '#67c23a' // 完成时变为绿色
    }
    
    // 使用splice确保响应式更新
    activities.value.splice(messageIndex, 1, updatedMessage)
    scrollToBottom()
  }
}

const sendMsg = async (e) => {
  // 阻止默认行为
  if (e) e.preventDefault();
  
  if (!msg.value.trim() || isLoading.value) return;

  const token = localStorage.getItem("token");
  if (!token) {
    activities.value.push({
      id: messageIdCounter++,
      content: 'AI: 请先登录',
      timestamp: new Date().toLocaleTimeString(),
      color: '#f56c6c'
    });
    return;
  }

  // 关闭之前的连接
  if (eventSource) {
    eventSource.close();
    eventSource = null;
  }

  isLoading.value = true
  streamBuffer = [] // 重置缓冲区

  // 添加用户消息
  const userMessageId = messageIdCounter++
  activities.value.push({
    id: userMessageId,
    content: `你: ${msg.value}`,
    timestamp: new Date().toLocaleTimeString(),
    color: '#409eff'
  });
  
  // 添加AI思考消息
  currentAiMessageId = messageIdCounter++
  activities.value.push({
    id: currentAiMessageId,
    content: 'AI: 思考中...',
    timestamp: new Date().toLocaleTimeString(),
    color: '#67c23a'
  });
  
  scrollToBottom()
  
  const userMessage = msg.value;
  msg.value = '';

  try {
    const url = `/api/ai/generateStreamAsString?message=${encodeURIComponent(userMessage)}`;
    console.log('Connecting to SSE:', url);

    eventSource = new EventSourcePolyfill(url, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Accept': 'text/event-stream'
      },
      withCredentials: false
    });

    let receivedData = false;
    
    eventSource.onmessage = (event) => {
      console.log('SSE Data received:', event.data);
      
      // 检查结束标志
      if (event.data.trim() === '[DONE]' || event.data.trim() === '[complete]') {
        console.log('Stream completed');
        updateAiMessage(streamBuffer.join(''), true) // 标记为完成
        eventSource.close();
        eventSource = null;
        isLoading.value = false;
        return;
      }
      
      receivedData = true;
      
      // 将新数据添加到缓冲区
      streamBuffer.push(event.data);
      
      // 实时更新显示内容
      updateAiMessage(streamBuffer.join(''));
    };

    eventSource.onerror = (error) => {
      console.log('SSE Connection state:', eventSource.readyState);
      console.error('SSE Error:', error);
      
      isLoading.value = false;
      
      // 如果没有收到任何数据，显示错误信息
      if (!receivedData) {
        updateAiMessage('服务连接异常，请稍后重试', true);
        const messageIndex = activities.value.findIndex(item => item.id === currentAiMessageId)
        if (messageIndex !== -1) {
          activities.value[messageIndex].color = '#f56c6c'
        }
      } else {
        // 如果已经收到部分数据，标记为完成
        updateAiMessage(streamBuffer.join(''), true);
      }
      
      if (eventSource) {
        eventSource.close();
        eventSource = null;
      }
    };

    eventSource.onopen = () => {
      console.log('SSE Connection established');
      receivedData = false;
    };

  } catch (error) {
    console.error('SSE Setup Error:', error);
    isLoading.value = false;
    updateAiMessage('连接初始化失败，请稍后重试', true);
    const messageIndex = activities.value.findIndex(item => item.id === currentAiMessageId)
    if (messageIndex !== -1) {
      activities.value[messageIndex].color = '#f56c6c'
    }
  }
};

const handleCommand = async (command) => {
  if (command === 'logout') {
    await store.dispatch('logout')
    router.push(`/login?redirect=${router.currentRoute.value.fullPath}`)
  } else if (command === 'profile') {
    // 个人中心导航
    console.log('Navigate to profile page')
  }
}

// 组件卸载时清理
onUnmounted(() => {
  if (eventSource) {
    eventSource.close();
    eventSource = null;
  }
})
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
  font-size: 16px;
}

.dialog-header .close-btn:hover {
  color: #f56c6c;
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
  scroll-behavior: smooth;
}

.message-content {
  word-wrap: break-word;
  white-space: pre-wrap;
  line-height: 1.5;
}

.input-area {
  padding: 16px;
  border-top: 1px solid #ebeef5;
  display: flex;
  gap: 10px;
  align-items: flex-end;
  background: #fafafa;
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

.resize-handle:hover {
  background: rgba(64, 158, 255, 0.2);
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
  background: #409eff;
  opacity: 0.3;
}

.resize-handle.bottom-right:hover {
  opacity: 0.6;
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

/* 滚动条样式 */
.message-container::-webkit-scrollbar {
  width: 6px;
}

.message-container::-webkit-scrollbar-track {
  background: #f1f1f1;
  border-radius: 3px;
}

.message-container::-webkit-scrollbar-thumb {
  background: #c1c1c1;
  border-radius: 3px;
}

.message-container::-webkit-scrollbar-thumb:hover {
  background: #a8a8a8;
}

/* 加载状态样式 */
.el-button.is-loading {
  pointer-events: none;
}
</style>