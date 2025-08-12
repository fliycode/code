 介绍 

![img](https://cdn.nlark.com/yuque/0/2025/svg/22309163/1747741168425-a383115b-dad3-4b21-816c-5341b4e06e57.svg)



Spring AI 是一个面向人工智能工程的应用框架。解决了 AI 集成的基本挑战：将企业数据和API与AI 模型连接起来。



 特性： 

 提示词工厂 

可以说是大模型应用中最简单也是最核心的一个技术。他是我们更大模型交互的媒介，提示词给的好大模型才能按你想要的方式响应。

 对话拦截advisors 

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747830520019-359b73ff-8526-45ba-952c-3ede2f45ae0b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_56%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



面向切面的思想对对模型对话和响应进行增强。

 对话记忆 



通过一个bean组件就可以让大模型拥有对话记忆功能，可谓是做到了开箱即用

 tools 

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747830520060-5e3615a6-ca38-467e-964c-aa6a72862756.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_46%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



让大模型可以跟企业业务API进行互联 ，这一块实现起来也是非常的优雅



 RAG技术下的 ETL 

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747830520070-10ff2cbb-5292-4f22-8229-ea9cb4e66331.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_96%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



让大模型可以跟企业业务数据进行互联（包括读取文件、分隔文件、向量化） 向量数据库支持 目前支持20+种向量数据库的集成 这块我到时候也会详细去讲

 MCP 

让tools外部化，形成公共工具让外部开箱即用。 原来MCP协议的JAVA SDK就是spring ai团队提供的 提供了MCP 客户端、服务端、以及[MCP认证授权方案](https://spring.io/blog/2025/05/19/spring-ai-mcp-client-oauth2) ，还有目前正在孵化的[Spring MCP Agent](https://github.com/tzolov/spring-mcp-agent) 开源项目:

 模型的评估 

可以测试大模型的幻觉反应(在系列课详细讲解）

 可观察性 

它把AI运行时的大量关键指标暴露出来， 可以提供Spring Boot actuctor进行观测(在系列课详细讲解）

 agent应用 

springai 提供了5种agent模式的示例

1[Evaluator Optimizer](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/evaluator-optimizer) – The model analyzes its own responses and refines them through a structured process of self-evaluation.

![img](https://raw.githubusercontent.com/spring-io/spring-io-static/refs/heads/main/blog/tzolov/20250520/anthropic-augmented-llm-agents.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



1[Routing](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/routing-workflow) – This pattern enables intelligent routing of inputs to specialized handlers based on classification of the user request and context.

2[Orchestrator Workers](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/orchestrator-workers) – This pattern is a flexible approach for handling complex tasks that require dynamic task decomposition and specialized processing

3[Chaining](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/chain-workflow) – The pattern decomposes complex tasks into a sequence of steps, where each LLM call processes the output of the previous one.

4[Parallelization](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/parallelization-worflow) – The pattern is useful for scenarios requiring parallel execution of LLM calls with automated output aggregation.

 学完这5种你会对对模型下的agent应用有一个完整认识(在系列课详细讲解）





 langchain4j vs springAI 

 

|        | ![aui26-9kegj.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750768821298-20a7d9eb-6e79-4c56-aa3a-c8c462b9667f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_11%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp) | SBRINGA图6![2.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750768832185-9c0429a9-86b4-435c-8645-052b44178b38.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp) |
| ------ | ------------------------------------------------------------ | ------------------------------------------------------------ |
| 生态   | 不依赖Spring，需要单独集成Spring                             | Spring官方，和Spring无缝集成                                 |
| 诞生   | 更早，中国团队，受 LangChain 启发                            | 稍晚，但是明显后来居上                                       |
| jdk    | v0.35.0 前的版本支持jdk8   ，后支持jdk17                     | 全版本jdk17                                                  |
| 功能   | 没有mcp server, 官方建议使用[quarkus-mcp-server](https://github.com/quarkiverse/quarkus-mcp-server) | 早期落后langchain4j， 现在功能全面，并且生态活跃，开源贡献者众多 |
| 易用性 | 尚可，中文文档                                               | 易用，api优雅                                                |
| 最终   | 不需要spring选择！                                           | 无脑选！                                                     |





 大模型选型 

1自研（算法 c++  python 深度学习 机器学习 神经网络 视觉处理 952 211研究生 ）AI算法岗位

2云端大模型     占用算力  token计费     功能完善成熟   

3开源的大模型（本地部署）Ollama  购买算力    

a选型

b自己构建选型-->评估流程

ⅰ业务确定：（ 电商、医疗、教育 ）

ⅱ样本准备：数据集样本 选择题

ⅲ任务定制：问答  （利用多个大模型）

ⅳ评估： 人工评估

c通用能力毕竟好的

ⅰ2月份   deepseek   6710亿   671b = 算力 显存   H20  96G   140万  ； 比 openai gpt4节省了40/1 成本。

ⅱ3月份   阿里  qwq-32b(不带深度思考)   32b=320亿   媲美deepseek-r1  32G   比deepseek-r1节省20/1

ⅲ4月份   阿里  qwen3 (深度思考)    2350亿=235b   赶超了deepseek-r1  比deepseek-r1节省2-3倍    选择(qwen3-30b)

ⅳ5月    deepseek-r1-0528     6710亿   671b  性能都要要

4对成本有要求： 选择(qwen3-30b)      

5不差钱 deepseek-r1-0528 满血版本

ⅰ

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750856081070-bd44ac03-07d8-468f-a75a-6304f697812a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_97%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750856081223-6550aa2b-d971-4987-a8f4-c96875ed5129.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_97%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





![img](https://raw.githubusercontent.com/jeinlee1991/chinese-llm-benchmark/main/pic/%E6%80%BB%E5%88%86.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_109%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)











 快速使用 

1创建项目

PROJECTWILLBECREATEDIN:D:LIDEAWORKSPACELGIT_PULL2LSPRIL

D:LIDEAWORKSPACELGITPULL2

317JAVAVERSION"17.0.10

KOTLINMULTIPLATFORN

CREATEGITREPOSITORY

MMAVENARCHETYPE

SPRINGINITIALIZR

MICRONAU

SPRING-AI-GA

EIDEPLUGIN

SERVERURL:

START.SPRINGIO

PACKAGENAME:

LVYIIV小VV

PACKAGING:

EXEXPRESS

COMPOSEFORDESK

AKARTAEE

GRADLE-GROOVY

COM.EXAMPLE

ANGULARCLL

GREAC

LANGUAGE:

SPRING-AI-GA

ARTIFACT:

NEWPROJECT

GRADLE-KOTLIN

QUARKUS

CANCEL

GROUP:

SANDROIC

GENERATORS

NEXT

KOTLIN

COM.XS

HTML

VUEJS

JDK

WAR

JAVA:

LOCATION:

AVA

GROOVY

NAME:

MAVEN

PLAY2

TYPE:

JAR

KTOR

VITE

G

JAVAFX

G

17

可

5

L

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747831963607-5dfd6f93-1d11-4408-acee-a8116d0cf0e7.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 接入deepseek 

1依赖



2获取deepseek api-key

●API Key：需从 DeepSeek 创建并获取 API 密钥：https://platform.deepseek.com/api_keys

DEEPSEEKV3模型更新,各项能力全面进价,在网页端,APP和AP全面上线,点击查看详情,

EEPSEEK

EEPSEEK官方推出的免费AL助手

与DEEPSEEKV3和R1免费对话

搜索写作阅读解题翻译工具

探索未至之境

体验全新旗舰模型

取手机APP

开始对话

AP开放平台

DEEPSEEK

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747832077989-a12b8be5-a8d2-4d2a-8ae5-7d4913b50acb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



7存护M的账中安全,我们可能会自动禁用我们发现已公开泄露的APKEY,我们未对2024年4月25日前创建的APKEY的使用情次进T温

列表内是你的全部APKEY,APKEY仅在创建时可见可复制,请妥善保存.不要与他人共享你的APKEY,或将其暴愿在浏览器或其他套户端代码中,

-(32水水水本水水水水水本本水水家本本家本凉本家米本53日

SK-24((已本米非电市本************水米球冰冰4C2日

DLEEPSEEK

025-02-06

QAPLKEY

最新使用日期

202505-08

账单

智能航空助

APLKEYS

2025-05-08

2025-05-08

二充值

K-590F5米家米本冰本家水本水本米水米水米米米米米米本*8日8C

,用址信息

接口文档

创建APLKEY

建日期

EST2

TEST

名称

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747832096179-5c93c5b2-e568-4915-8463-ceeaac75f62b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_52%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



3配置



4测试

<artifactId>spring-ai-starter-model-deepseek</artifactId> 会为你增加自动配置类， 其中DeepSeekChatModel这个就是专门负责智能对话的。



供信息,陪你聊天,甚至帮你处理各种文本和文件.无论是学习,工作,还是日常生活中的疑问,

我是DEEPSEEKCHAT,由深度求索公司创造的智能AI助手!包+我

都可以来问我!有什么我可以帮你的吗?

我的使命是帮助你解答问题,提

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747832330018-cbc151a4-6de9-4949-9d84-4ad7d5fdb559.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_37%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 流式对话 





 options配置选项 

 temperature（温度）    

0-2  浮点数值    

数值越高  更有创造性   热情

数值越低  保守  



也可以通过配置文件配置



temperature:0.2   规规矩矩，像是被应试教育出来的老实学生没有创造力

露凝千叶垂清响,

一线天光破晓来.

满城灯火正徐开.

莫道君行独踏月,

晨调)

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747890503560-3f26de5a-a3f3-48a6-86f8-c7bf6dc6923a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_15%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



temperature:1.9   可以看出来表现欲更强， 像是一个在领导面前想要表现的你.

注:我的诗中"几枝寒里露同明",通过描绘晨康中沾露的枝条与晨光交映的景象,既表现了清晨的寒

意,又呼应了露珠的透亮,以简洁的笔触捕提瞬间的光影交织.

推窗星眼对鱼青,雪沫收光避早鸯.

残激一场呈小劫,几枝寒里露同明.

南斋早起)

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747890748919-bf48b998-7b65-455d-a304-5d6c01677e5f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



也可以通过提示词降低他的主观臆想：

●只引用可靠来源中的信息，不做任何假设或扩展描述。
●请只基于已知事实回答，不要主观臆想或添加额外内容。
●请简明、客观地给出答案，不要进行修饰或补充未经请求的信息。

 建议 

| temperature 范围 | 建议业务场景                     | 输出风格           | 说明/应用举例                           |
| ---------------- | -------------------------------- | ------------------ | --------------------------------------- |
| 0.0 ~ 0.2        | 严谨问答、代码补全、数学答题     | 严格、确定、标准   | 法律/金融答题、接口返回模板、考试答卷等 |
| 0.3 ~ 0.6        | 聊天机器人、日常摘要、辅助写作   | 稍有变化、较稳妥   | 公众号摘要、普通对话、邮件生成等        |
| 0.7 ~ 1.0        | 创作内容、广告文案、标题生成     | 丰富、有创意、灵活 | 诗歌、短文案、趣味对话、产品描述等      |
| 1.1 ~ 1.5        | 脑洞风格、头脑风暴、灵感碰撞场景 | 大开脑洞、变化极强 | 故事创作、异想天开的推荐语、多样化内容  |

说明：

●温度越低，输出越收敛和中规中矩；

●温度越高，输出越多变、富有惊喜但有风险；

●实战用法一般建议选 0.5~0.8 作为日常生产起点，需要根据业务不断测试调整。



 maxTokens  

默认低 token

maxTokens：限制AI模型生成的最大token数（近似理解为字数上限）。

●需要简洁回复、打分、列表、短摘要等，建议小值（如10~50）。

●防止用户跑长对话导致无关内容或花费过多token费用。

●如果遇到生成内容经常被截断，可以适当配置更大maxTokens。

 stop 

 截断你不想输出的内容  比如：



 模型推理 

设置深度思考，  思考的内容有个专业名词叫：Chain of Thought (CoT)

您好!我是由中国的深度求索(DEEPSEK)公司开发的替能助手DEEPSEEKR1,如您有任何任何问题,我会尽我所能

您好!我是由中国的深度求索(DEEPSEEK)公司开发的智能助手DEEPSEEKR1.如您有任何任何问题,

我会尽我所能为您提供帮助

02<2/2)

给DEEPSEEK发送消息

窗已深度思考(用时2秒)

深度思考(R1)

为您提供帮助.

联网搜素

你是谁?

开启新对话

0日

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747914817445-76e8a32a-ddea-4ed0-bb6d-d498f14ad682.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_24%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





在deepseek中，  deepseek-reasoner模型是深度思考模型：

NER是DEEPSEEK最新佳出的佳理模型DEEPSEEK-R1,通过指定MODEL.'DEEPSEEK-REASONER",即可调用

R,即可调用DEEPSEEK-R1.

T即可周用DEEPSEEK-V

MIODELE'DEEPSEEK-CHAT

已全面升级

DEEDSEEK-REASONERN

DEEPSEEK-V

接口不变

通过指定

DEEPSEEK-

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747914659592-870470ec-2b9e-4fd8-963e-446808af56f6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_26%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)







也可以在配置文件中配置





 原理： 



DEEPSEEK

基础大模型

应用程序

SPRINGAL

![spring-ai (9).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750928853497-d5ef1895-6b22-480e-8f80-721797eada97.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_16%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



1当调用chatModel.call



a首先会将提示词解析到Prompt对象中 （用于远程请求的messages）

ROLE":"SYSTEM","CONTENT":"YOUAREAHELPFULASSIS

HTTPS://API.DEEPSEEK.COM/CHAT/COMPLETIONS

"CONTENT-TYPE:APP1ICATION/JSON

ROLE":"USER",CONTENT":HELLO!M

H"AUTHORIZATION:BEARER<DEEPSEEKAPIKEY>

"STREAM":FALSE

MESSAGES":

MODE1:"DEEPSEEK-CHAT

UR1

D

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748356262503-f20736ce-10bd-426d-9e99-73ddcdd06bc7.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_24%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



2调用deepseekModel#call---> internalCall方法



a通过createRequest封装为远程请求所需的json对象

b通过spring retry 重试机制去远程请求

deepseekthis.deepSeekApi.chatCompletionEntity(request)



c封装响应数据

 接入阿里百炼 

S万QW

WEN

![Qwen-3-01.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750994049968-43797508-45f3-426a-adfa-3f5dcd73ef13.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_112%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



阿里自己的团队维护spring-ai-alibaba.   但是也必须依赖spring-ai 。   好处是扩展度更高，坏处是必须是springai先出来， spring-ai-alibaba.延迟几天出来。

如果需要接入阿里的百炼平台， 就必须用该组件



 使用 

1申请api-key

在调用前，您需要[开通模型服务并获取API Key](https://help.aliyun.com/zh/model-studio/get-api-key)，再[配置API Key到环境变量](https://help.aliyun.com/zh/model-studio/developer-reference/configure-api-key-through-environment-variables)。

2依赖



2配置



3使用



 文生图 



 文生语音text2audio 



 语音翻译audio2text 

 



 多模态 

图片  语音  视频  传给大模型  理解



 文生视频（更多功能） 







   

 接入ollama本地模型 

ollama是大语言模型的运行环境  ，  支持将开源的大语言模型以离线的方式部署到本地，进行私有化部署。  这也是企业中常用的方案，  因为本地化部署能保证企业级的数据安全， 降低企业使用成本。



 1.1本地大模型安装 

1. https://ollama.com/download



2. 点击下载， 一直下一步即可非常简单



DOWNLOADOLLAMA

WHILEOLLAMADOWNLOADS,SIGNUPTOGET

NOTIFIEDOFNEWUPDATES

DOWNLOADFORWINDOWS

GETUPDATES

YOUREMAILADDRESS

REQUIRESWINDOWS10ORLATER

WINDOWS

MACOS

LINUX

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747915924346-0df0e1a5-be5d-4fab-8805-970f30d60a5e.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_16%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



3安装完后运行cmd --> ollama list  查看已安装的大模型（开始肯定什么都没有）

4拉取模型 ollama run qwen3:4b 

a这里的4b=40亿参数   对应gpu显存差不多是4G ，当然8B也可以只是比较卡

5测试

下来,我要考虑如何回应才能既友好又专业,中文的"你好"通常对应您好",所以回复"您好"是合适的,然后,我需要引导

用户进一步说明他们的需求,比如询问是否有问题需要帮助,或者是否需要了解某些信息.

还要注意,用户可能没有明确说明他们的意图,所以需要通过提问来明确他们的需求,例如,可以问"有什么我可以帮您的吗?"或

同时,要确保回复简洁明了,避免使用过于复杂的句子,让用户容易理解,另外,保持语气亲切,使用适当的标点符号,比如句号和

嗯,用户发来"你好",这是一句常见的问候语,首先,我需要确认用户的需求是什么.可能他们只是想打貂呼,或者有更具体的问

外,用户可能在测试我的反应,或者他们可能有隐藏的需求,比如需要帮助解决某个问题,因此

您好!有什么我可以帮您的吗?

让用户感到舒适,愿意进一步交流.

/THINK>

避免池7.

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747917729824-c0ee37c7-2768-46a7-ae1e-7df3554f8383.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 1.2基于spring-ai使用 

1添加依赖





2配置



3测试



我是通义千间,是阿里巴巴集团旗下的通义实验在研发的大型语言模型,我的主要功能是回答问题,创作内容,提供信息和帮助用户解决问题,我被

型,然后要提到我的主要功能,比如回答问题,创作内容,提供信息等.同时,要强调我的设计目的是帮助用户解决问题,提供有用的信息,并保

户容易理解.检查是否有遗漏的信息,比如是否需要提到我的训练数据米源或技术特点,但可能用户更关注的是我的用途和能力,所以保持回咨重

的,用户问"你是非",我需要明确回答自己的身价,首先,我应该说明自己是阿里巴巴集团旗下的通义实验蜜研发的通义千问,这是最新的语

持友好和开次的态度.另外,要提醒用户如果他们有任何问题或需要都助,我都会尽力协助,最后,确保回答简洁明了,避免使用复尔术语,让用

设计成一个友好,开放和有用的助手,能够根据用户的请求提供帮助.如果您有任何问题或需要帮助,我会尽力协助您.

点突出.确认没有错误,比如正确的公司名称和广产品名称然后组织语言,确保流畅自然

</THINK>

<THINK>

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747918232750-104c6590-3bf0-40aa-8019-af8a43befa0b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 1.3关闭thingking 

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751199163428-8570576c-1cf9-4b4e-ba78-4991cdcd13d1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_163%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



  可以通过 在提示词结尾加入“/no_think” 指令



但是依然有<think>标签， 暂时可以前端单独处理下

我是通义千问,阿里巴巴集团旗下的大语言模型,我能够帮助您回答问题,创作内容,提供信息和进行对话.您可以问我

任何问题,我会尽力为您提供帮助.您有什么需要我帮忙的吗?

/THINK>

<THINK>

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747921581411-27f379ce-ebb8-45d1-ba78-898f80b3ee50.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



ollama  0.9.0  支持了关闭think。但是在spring1.0版本还不兼容

https://ollama.com/blog/thinking

 1.4流式输出 

 

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751199935702-f444a59a-b3b5-46b3-aafe-71669d3460fb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_86%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





ollama  0.8.0之前的版本不支持  stream+tools 

https://ollama.com/blog/streaming-tool  0.8.0+支持stream+tools .  但是和springai1.0有兼容问题：https://github.com/spring-projects/spring-ai/issues/3369

在SpringAi 1.0.1已修复:
●在Ollama聊天模型响应中添加了持续时间元数据的空安全检查，以防止潜在的空指针异常[1eecd17](https://github.com/spring-projects/spring-ai/commit/1eecd17529fbfc3c25d95a4324adb6fe2c302a65)



 1.5多模态  

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751201032657-afcb978c-9da7-41cf-ae95-d3eaf9732a2f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_173%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



目前ollama支持的多模态模型：  

●[Meta Llama 4](https://ollama.com/library/llama4)

●[Google Gemma 3](https://ollama.com/library/gemma3)

●[Qwen 2.5 VL](https://ollama.com/library/qwen2.5vl)

●[Mistral Small 3.1](https://ollama.com/library/mistral-small3.1)

●and more [vision models](https://ollama.com/search?c=vision).



RADLE是一个流行的构建自动化系统,主要用于ANDROID开发,但也支持其他语言和平台.

根据图片,这是GRADLE的标,

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749038999303-f187d9b1-dfb1-44ae-8f47-3aef01134ca3.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_25%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)







 ChatClient 



ChatClient 基于ChatModel进行了封装提供了通用的 API，它适用所有的大模型， 使用ChatClient可以让你面向SpringAi通用的api 而无需面向为每一种不同的模型的api来进行编程，   虽然您仍然可以使用 ChatModel 来实现某些模型更加个性化的操作（ChatModel更偏向于底层），但 ChatClient 提供了灵活、更全面的方法来构建您的客户端选项以与模型进行交互： 比如系统提示词、格式式化响应、聊天记忆 、tools 都更加易用和优雅，所以除非ChatClient无法实现，否则我们优先考虑用ChatClient。

所以我们后续基于ChatClient来进行学习应用。   基于ChatModel来学习源码，因为ChatClient底层依然还是ChatModel的封装。



 基本使用 

**●**必须通过ChatClient.Builder 来进行构造



 

这种方式会在底层自动注入1个ChatModel ， 如果你配置了多个模型依赖，  会无法注入。

NAP<STRING,0BJECT>USERPARANS,CULABLESTRINGSYSTENTEXT,NLP-STNING,0BJECT>SYSTENPARANS,

(ULABLECHATCLIENTOBSERVATIONCONVENTIONOBSERVATIONCONVENTION,NAP-STRING,0BJECT>TOOLCONTEXT,

IST<TOOLCALLBACKTOCALLBACKS,LIST<ESSAGE>MESSAGES,LIST<STRING>TOLNAMES,LIST<NEDA>ME0A,

GNULLABLETENPLATERENDERERTENPLATERENDERER)

NULLABLECHAT0PTIONSCHATO0PTIONS,LIST<CADVISOR>ADVISONS,NLP-STNING,0BJECT>ADVISOPARANS,

UBSERVAT1OHREG1STRYOBSEVAT1ONREG1STRY

BLICDEFAULTCHATCLIEHTREQUESTSPE

NULLABLESTRINGU

TMODELCHATMODEL,OL

TSPECHATMO

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748589278091-50435556-59e5-4967-8bba-c7aded90781a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



可以通过这种方式动态选择ChatModel：







 流式 







 《多个模型动态切管理实战》 

1）application.properties





定义3个ChatClient的bean。  也可以根据请求动态创建， 看需求





请求：



 提示词 

在生成式人工智能中，创建提示对于开发人员来说是一项至关重要的任务。这些提示的质量和结构会显著影响人工智能输出的有效性。投入时间和精力设计周到的提示可以显著提升人工智能的成果。

例如，一项重要的研究表明，以“深呼吸，一步一步解决这个问题”作为提示开头，可以显著提高解决问题的效率。这凸显了精心选择的语言对生成式人工智能系统性能的影响。

 提示词类型： 



●SYSTEM系统角色：引导AI的行为和响应方式，设置AI如何解释和回复输入的参数或规则。这类似于在发起对话之前向AI提供指令。

●USER用户角色：代表用户的输入——他们向AI提出的问题、命令或语句。这个角色至关重要，因为它构成了AI响应的基础。

●ASSISTANT助手角色：AI 对用户输入的响应。它不仅仅是一个答案或反应，对于维持对话的流畅性至关重要。通过追踪 AI 之前的响应（其“助手角色”消息），系统可以确保交互的连贯性以及与上下文的相关性。助手消息也可能包含功能工具调用请求信息。它就像 AI 中的一项特殊功能，在需要执行特定功能（例如计算、获取数据或其他不仅仅是对话的任务）时使用。

●TOOL工具/功能角色：工具/功能角色专注于响应工具调用助手消息返回附加信息。

 提示词模板： 

有时候， 提示词里面的内容不能写死， 需要根据对话动态传入

 chatModel $  

可以使用SystemPromptTemplate  



 chatClient 



  

 自定义提示词模板 

 chatModel $  



 chatClient 



 提示词模板文件 

 chatModel $  



 chatClient 

/prompts/system-message.st









 提示词设置技巧 $ 

 简单技巧 

●[文本摘要](https://www.promptingguide.ai/introduction/examples.en#text-summarization)： 将大量文本缩减为简洁的摘要，捕捉关键点和主要思想，同时省略不太重要的细节。

●[问答](https://www.promptingguide.ai/introduction/examples.en#question-answering)： 专注于根据用户提出的问题，从提供的文本中获取具体答案。它旨在精准定位并提取相关信息以响应查询。

●[文本分类](https://www.promptingguide.ai/introduction/examples.en#text-classification)： 系统地将文本分类到预定义的类别或组中，分析文本并根据其内容将其分配到最合适的类别。

●[对话](https://www.promptingguide.ai/introduction/examples.en#conversation)： 创建交互式对话，让人工智能可以与用户进行来回交流，模拟自然的对话流程。

●[代码生成](https://www.promptingguide.ai/introduction/examples.en#code-generation)： 根据特定的用户要求或描述生成功能代码片段，将自然语言指令转换为可执行代码。

 高级技术 

●[零样本](https://www.promptingguide.ai/techniques/zeroshot)、[少样本学习](https://www.promptingguide.ai/techniques/fewshot)： 使模型能够利用特定问题类型的极少或没有先前的示例做出准确的预测或响应，并使用学习到的概括来理解和执行新任务。

●[思路链](https://www.promptingguide.ai/techniques/cot)： 将多个AI响应连接起来，创建连贯且符合语境的对话。它帮助AI保持讨论的线索，确保相关性和连续性。

●[ReAct（推理 + 行动）](https://www.promptingguide.ai/techniques/react)： 在这种方法中，人工智能首先分析输入（推理），然后确定最合适的行动或响应方案。它将理解与决策结合在一起。

 Microsoft 指导 

●[提示创建和优化框架](https://github.com/microsoft/guidance)： 微软提供了一种结构化的方法来开发和完善提示。该框架指导用户创建有效的提示，以便从 AI 模型中获取所需的响应，并优化交互以提高清晰度和效率。



**1**指令明确

a避免情绪化内容

ⅰ“求求你好好说啊~！”“你这样我不会啊~”

b不要让大模型去猜去臆想你的想法， 描述足够清楚

ⅰ补充必要背景信息：身份、场景、用途、已有内容等，避免 AI “脑补” 出错。

ⅱ避免“或许、可能、你懂的”等模糊修饰语 

c把大模型当一个小学生，你描述的任务越清楚他执行越具体 ❌ 模糊：写一篇文章 ✅ 清晰：写一篇 800 字的高考作文，主题 “坚持与创新”，结构分引言、三个论点（每个配历史案例）、结论，语言风格正式书面

2格式清晰（结构化） 可以通关markdown格式，确定一级标题、二级标题、列表 这样更利于模型理解。后续维也更加清晰

公式：「角色设定」+「具体任务（技能）」+「限制条件（约束）」+「示例参考」





 Advisor对话拦截 

Spring AI 利用面向切面的思想提供 Advisors API ， 它提供了灵活而强大的方法来拦截、修改和增强 Spring 应用程序中的 AI 驱动交互。

基础大模型

SPRING-AI

应用程序

对话栏截ADVISOR

口

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748595841228-a2cc26e0-025d-4795-b9d5-acc8aa14ce12.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_13%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





Advisor 接口提供了CallAdvisor和组成CallAdvisorChain（适用于非流式场景），以及StreamAdvisor和 （StreamAdvisorChain适用于流式场景）。它还包括ChatClientRequest，用于表示未密封的 Prompt 请求，以及 ，ChatClientResponse用于表示聊天完成响应。

![img](https://cdn.nlark.com/yuque/0/2025/jpeg/22309163/1748596397995-c75e2484-0562-4e76-94e5-785c48fa3da9.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_56%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp%2Finterlace%2C1)



 日志拦截： 

由于整个对话过程是一个“黑盒”， 不利于我们调试， 可以通过SimpleLoggerAdvisor拦截对话记录可以帮助观察我们发了什么信息给大模型便于调试。

1设置defaultAdvisors



2设置日志级别





日志中就记录了 request:  请求的日志信息

response: 响应的信息

 自定义拦截： 

 重读（Re2） 

 重读策略的核心在于让LLMs重新审视输入问题，这借鉴了人类解决问题的思维方式。通过这种方式，LLMs能够更深入地理解问题，发现复杂的模式，从而在各种推理任务中表现得更加强大。









可以基于BaseAdvisor来实现自定义Advisor， 他实现了重复的代码 提供 模板方法让我们可以专注自己业务编写即可。







测试：





 原理 

DEFAULTCHATMODELADVISOR

DEEPSEEK

基础大模型

应用程序

SPRINGAL

ADVISORS

图

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751620554294-e45fc2f1-68ab-4551-ae10-bfdd21d3891a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_13%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



记住！   

![15DE3F1F.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748870548847-b2868cb2-027b-42f0-b0bf-42a21bf462d2.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_9%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



dvisor只有结合ChatClient才能用！   是SpringAi上层提供的。  模型底层并没有这个东西

 对话记忆 

大型语言模型 (LLM) 是无状态的，这意味着它们不会保留先前交互的信息。



你的名字是"除庶"吗?如果是的话,这是一个源自三国时期的薯名历史人物名字.徐庶字元直,曾为刘备谋士,后因母亲被善操扣拥而赫迪转投曹管,

你的名字是"用户"哦!不过如果你愿意告诉我你的真实名字,我也可以记住它~

(如果是想探讨历史人物徐庶的故事,也可以告诉我哦~)

留下"徐庶进曹营一一言不发"的典故.

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748870080223-31727dfd-e598-4a56-8d4a-de362b0d82e8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_32%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



那我们平常跟一些大模型聊天是怎么记住我们对话的呢？实际上，每次对话都需要将之前的对话消息内置发送给大模型，这种方式称为多轮对话。

ANSWERTHATISAWAREOF

TOSTATELESSMODEL

SENDCHATHISTORYALONG

PRECEDINGCONVERSATION

USERMESSAGE

AIMESSAGE3

SYSTEMMESSAGEOPTIONAL

USERMESSAGE

AIMESSAGE2

USERMESSAGE3

AIMESSAGE

MODEL

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748870240621-6c24ff74-035a-426e-bd0f-a5e60e5c15f4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_33%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



SpringAi提供了一个ChatMemory的组件用于存储聊天记录，允许您使用 LLM 跨多个交互存储和检索信息。并且可以为不同用户的多个交互之间维护上下文或状态。

可以在每次对话的时候把当前聊天信息和模型的响应存储到ChatMemory， 然后下一次对话把聊天记录取出来再发给大模型。  



 

但是这样做未免太麻烦！ 能不能简化？ 思考一下！

思索ING

![15DA44A1.jpg](https://cdn.nlark.com/yuque/0/2025/jpeg/22309163/1748870288123-c016b85f-a5cf-4771-9291-0c18b3ae205b.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_11%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



![15DACB26.gif](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1748870322552-35a0ab03-ea1f-46c7-9c32-21ebb241dbad.gif)

用我们之前的Advisor对话拦截是不是就可以不用每次手动去维护了。  并且SpringAi早已体贴的为我提供了

ChatMemoryAutoConfiguration

自动配置类









所以我们可以这样用：

 使用 

SpringAi提供了  PromptChatMemoryAdvisor   专门用于对话记忆的拦截



 配置聊天记录最大存储数量 

你要知道， 我们把聊天记录发给大模型， 都是算token计数的。

大模型的token是有上限了，  如果你发送过多聊天记录，可能就会导致token过长。

DEEPSEEK-REASONER

默认32K,最大64

默认4K,最大8张

DLEEPSEEK-CHAT

上下文长度

输出长度(3

模型1

64K

64K

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748871034319-bcb8f5e9-b1bb-431e-8776-f54d93d6ff85.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



并且更多的token也意味更多的费用， 更久的解析时间.  所以不建议太长

（DEFAULT_MAX_MESSAGES默认20即10次对话）

  一旦超出DEFAULT_MAX_MESSAGES只会存最后面N条（可以理解为先进先出），参考MessageWindowChatMemory源码



 配置多用户隔离记忆 

如果有多个用户在进行对话， 肯定不能将对话记录混在一起， 不同的用户的对话记忆需要隔离





会发现， 不同的CONVERSATION_ID，会有不同的记忆

根据我们的对话记录,我还没有获取到您的名字信息.您可以告诉我您的名字,我会记住

根据之前的对话记录,您曾说过'我叫徐麻".因此您的名字是:*徐

您说"我叫徐庶",这是一个陈述句而非疑问句.以下是相关说明:

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748871907406-385208ea-02bf-40d8-ab33-48ee834f59a4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_22%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 原理源码$ 

主要有前置存储

MessageWindowChatMemory

具体存储实现

ChatMemoryRepository

LNMEMORYCHATMEMORYREPOSITORY

SPRING-AI

JDBCCHATMEMORYREPOSITORY

CHATMEMORYREPOSITORY

基础大模型

应用程序

对话拦截ADVISOR

MAXMESSAGE=1

.你好,我叫徐底

问.我是谁

INDOWCHATMLEMORY

1.你安,我叫徐底

MESSAAEWINDC

2.徐庶你好

2.徐庶你好

存储实现

3.我是谁一

控制数量

答徐庶你好

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748936717843-1c2d02a4-1b8a-4e14-89c8-e6809b240893.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)











 数据库存储对话记忆 

默认情况， 对话内容会存在jvm内存会导致：

1一直存最终会撑爆JVM导致OOM。

2重启就丢了， 如果已想存储到第三方存储进行持久化

springAi内置提供了以下几种方式（例如 Cassandra、JDBC 或 Neo4j）， 这里演示下JDBC方式



1添加依赖





2添加配置







3配置类



4resources/schema-mysql.sql（目前1.0.0版本需要自己定义，没有提供脚本）





5测试



可以看到由于我设置.maxMessages(1)数据库只存一条

根据我们的对话记录,您告诉我您的名字是"徐庶.有什么其他问题我可以帮您A

IMESTAMP

ONVERSATIONCOL

ASSISTANT

CONTENT

TYPE

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1748937116139-c2400662-b5af-4f98-8c37-cce47407912a.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_42%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 Redis存储 

如果你想用redis ， 你需要自己实现ChatMemoryRepository接口（自己实现增、删、查）

但是alibaba-ai有现成的实现：（还包括ES）

https://github.com/alibaba/spring-ai-alibaba/tree/main/community/memories













 多层次记忆架构 痛点 

记忆多=聪明， 记忆多会触发token上限

要知道， 无论你用什么存储对话以及， 也只能保证服务端的存储性能。  

但是一旦聊天记录多了依然会超过token上限， 但是有时候我们依然希望存储更多的聊天记录，这样才能保证整个对话更像“人”。    



多层次记忆架构（模仿人类）

○近期记忆：保留在上下文窗口中的最近几轮对话，每轮对话完成后立即存储（可通过ChatMemory）；   10 条

○中期记忆：通过RAG检索的相关历史对话(每轮对话完成后，异步将对话内容转换为向量并存入向量数据库）    5条

○长期记忆：关键信息的固化总结 

**■**方式一：定时批处理

●通过定时任务（如每天或每周）对积累的对话进行总结和提炼

●提取关键信息、用户偏好、重要事实等 

●批处理方式降低计算成本，适合大规模处理 

**■**方式二：关键点实时处理

●在对话中识别出关键信息点时立即提取并存储

●例如，当用户明确表达偏好、提供个人信息或设置持久性指令时 

●采用"写入触发器"机制，在特定条件下自动更新长期记忆 



 结构化输出 

 基础类型： 

以Boolean为例 ， 在agent中可以用于判定用于的内容2个分支，  不同的分支走不同的逻辑



 Pojo类型： 

用购物APP应该见过复制一个地址， 自动为你填入每个输入框。  用大模型轻松完成！

请检查拆分地址,姓名,电话信息是否准确,如有遗漏请及时补充

张三,电话13588888888,地址:浙江省杭州市西湖

爸图片识别语音识别地址码

文一西路100号8幢202室

区文一西路100号8禅202室

浙江省杭州市西湖区

收件人(微信地址

公司名称(选填)

收件人地址填写

13588888888

保存到地址饰

请核对收件人电话

%C35

20:33

也址郊

顺丰ID

通讯深

张三

识别

清空

公司

定位

中6

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749126843402-3cca89cf-d3a8-40c6-aa95-3664d526feb9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_11%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)











 原理 

![img](https://cdn.nlark.com/yuque/0/2025/jpeg/22309163/1749126360371-0165c51c-79c1-4058-9b1e-32c75182f51d.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_80%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp%2Finterlace%2C1)



ChatModel或者直接使用低级API：



  



 链接多个模型协调工作实战 - 初代tools： $ 

 背景： 

大模型如果它无法和企业API互联那将毫无意义！  比如我们开发一个智能票务助手，  当用户需要退票， 基础大模型它肯定做不到， 因为票务信息都存在了我们系统中， 必须通过我们系统的业务方法才能进行退票。  那怎么能让大模型“调用”我们自己系统的业务方法呢？ 今天叫大家通过结构化输入连接多个模型一起协同完成这个任务：



  票务助手请输入姓名和预定号调用智能客服CHATCLIENT否有性名补退票方法调用我要退票提取任务类预定号IOBCANCE关键字IOB:UNKNOW你尔好一IOB:...-一是![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133561508-8d90a71e-e734-471e-a36e-5605fabc6b8c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp) 

 效果 

正在计划任务..,<R/>退票失败,请输入姓名和订单号

HTTP://LOCALHOST:8080/STREAM?MESSAGE=我要退票

X命

0

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133770407-472b9b4b-f1a8-43f2-b3d2-86d40abb3491.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_17%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133811144-c451d972-8ffc-4760-8b47-dfd14d4db5df.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_11%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



输入姓名和预定号：

正在计划任务...<BR/>退票成功!

HTTP://LOCALHOST:8080/STREAM?MESSAGE=徐110

一之X向

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133789344-aab6fec6-8dd9-415f-98cc-1f77c7c45f60.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_18%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133804610-66c41dfc-a556-49be-9353-e90eee657c20.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_21%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





普通对话：

正在计划任务,(少你好!我是航空的智能客服代理,你可以叫我小%,我在这里为你提供贴心的服务,无论是航班查询,订票,退票还是改签,都

HTTP://LOCALHOST:8080/STREAM?MESSAGE-你子,

可以帮我处理哦!有什么可以帮您的吗?

X命

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749133832665-d12ca731-fae6-4991-8f17-cb0039a9a1ac.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 代码： 









 tools/function-call 

FUNCTIONCALLING

4

FUNCTIONS

PROMPT

LLM

![img](https://cdn.nlark.com/yuque/0/2025/webp/22309163/1751958968629-336b4ca5-3ea0-4ad3-bb1a-32b5c89ba5ae.webp?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_23%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



想做企业级智能应用开发，  你肯定会有需求要让大模型和你的企业API能够互连，  

因为对于基础大模型来说， 他只具备通用信息，他的参数都是拿公网进行训练，并且有一定的时间延迟，  无法得知一些具体业务数据和实时数据， 这些数据往往被各软件系统存储在自己数据库中：



比如我问大模型：“中国有多少个叫徐庶的” 他肯定不知道，  我们就需要去调用政务系统的接口。

比如我现在开发一个智能票务助手，  我现在跟AI说需要退票， AI怎么做到呢？  就需要让AI调用我们自己系统的退票业务方法，进行操作数据库。



在之前我们可以通过链接多个模型的方式达到，  但是很麻烦，  那用tools， 可以轻松完成。



tool calling也可以直接叫tool（也称为function-call）, 主要用于提供大模型不具备的信息和能力：

1信息检索：可用于从外部源（如数据库、Web 服务、文件系统或 Web 搜索引擎）检索信息。目标是增强模型的知识，使其能够回答无法回答的问题。例如，工具可用于检索给定位置的当前天气、检索最新的新闻文章或查询数据库以获取特定记录。  这也是一种检索增强方式。

2采取行动：例如发送电子邮件、在数据库中创建新记录、提交表单或触发工作流。目标是自动执行原本需要人工干预或显式编程的任务。例如，可以使用工具为与聊天机器人交互的客户预订航班，在网页上填写表单等。

![3501C1F8.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749392971318-e337a759-874f-45ca-a4f1-8d61d7b05245.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_9%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)

需要使用tools必须要先保证大模型支持。   比如ollama列出了支持tool的模型



SEARCHMODELS

MBEDDING

HINKING

MODELS

DISCORD

VISION

GITHUB

POPULAR

TOOLS

O

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749392917151-41ed9d80-529d-49c2-93e9-abe22b2c4b94.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 使用 

基础大模型

.使用工具需要什么参数

应用程序

调用方法

诉大模型:

提供了什么工具

GWEN-MAX

.@TOOL方法

SPRINGAI

再让A组织语言

一调用一

返回结果

提取参数

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751958667763-7a8e7375-fa12-44b8-8521-b219f9ba10e3.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_35%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)

​		



1声明tools的类:



1将Tool类配置为bean（非必须）

2@Tool 用户告诉大模型提供了什么工具

3@ToolParam 用于告诉大模型你要用这个工具需要什么参数（非必须）



2绑定到ChatClient





![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749453132339-95c40010-427f-452a-8f6e-580b62b493eb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_15%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 原理 

CURLHTTPS://API.OPENAI.COM/V1/CHAT/COMPLETIONS

-H"AUTHORIZATION:BEARER$OPENALAPLKEY"

"DESCRIPTION":"长沙有多少名字的数量

-HCONTENT-TYPE:APPLICATION/JSON

CONTENT":"长沙有多少个叫徐庶的?

2.使用工具需要什么参数一@TOOLPARAM

NAMELOCATIONNAMECOUNTS

OCATIONNAMECOUNTS

应用程序

"TYPE:"FUNCTION,

1提供了什么工具一@TOOL

(NAME:徐庶))

QWENMAX

TYPE:"OBJECT

DESCRIPTION":"姓名

TOOLCHOICEAUTO

TYPE":STRING,

MODEL:GPT-4.1,

爱

.再让A组织语言

返回结果

SPRINGAI

MESSAGESL

PROPERTIES:

3.调用@TOO方法

FUNCTION":

PARAMETERS.

ROLE":"USER,

基础大模型

TOOLS":[

.调用一

告诉大模型:

NAME:

0徐麻

3

![spring-ai (6).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749454119801-20e17389-b5da-4af2-a683-af5ec9ee3bd3.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



1 当我们设置了defaultTools 相当于就告诉了大模型我提供了什么工具， 你需要用我的工具必须给我什么参数， 底层实际就是将这些信息封装了json提供给大模型

2当大模型识别到我们的对话需要用到工具， 就会响应需要调用tool





 源码 

需90H5)投0关号品0力发有时反的家制回信的中家制的个

ATCOMPLETIONESAGE[CONTENT=NULL,ROLE=ASSISTANT,NAME=NUL,TOOTLCAULID=NU

PUBLICRECORDREQUEST(STRINGNANE,STRINGLOCATION){}

,FUNCTION=CHATCONPLETIONFUNCTION[NAME=GETWAITIME,ARGUMENTS={"LOCATION":"长少,

OPUBLICRECORDRESPONSE(STRINGWEATHER){}

RETURNNEWRESPONSE(LOCATION+"有1E个!");

TOOLCALLS=[TOOL(AL(ID=CAL-GNCRREZ2N生FOEDC47YZHAN0,TYUE=FUNCTJOT..,

HGEAGTEEGCIETEEAIEARAEAT

STRING1OCATION-REQUEST.1OCATION();

PUBLICRESPONSEAPPLY(REQUESTREQUEST){

IONGALBACREGISTERGETFUNCTIONAME)GALFUNCTIONARGUMENIS

STRINGNANE-REQUEST,NANE();

FUNCTION<WAITTIMESERVICE.REQUEST,WAITTIESERVICE.RESPO

国5品52

品的公信营方

ILD这,会将WAITIMESERVICE,REQUEST的属性直接转为

LISTOF(USERMESSAGE),

CREATEREQUESIPROMPTFA

FUNCATION-CALBACK

0

SONFUNETIONARGUMENTS,INPUTYPER

THSCALWITHFUNETIONSUPPORTREGUEST;

NSERESPONSE-CHATCLIENTCAL1(NEWPR

CTNLAMECGRTAIRNARGRERBUIAE

,WITHFUNCTION("GETWAITTIME")

NTIONCALBAEKCONTESTGATFUNCTIONCALBACH

BGCIIONFEIUETE可T组成油球OPENAI所需要参数

WTNFUREAEONGATOATTIMEY

"NANE""能EH]

R化入的PR的品实基欧可用O

SHANDLETRE:VESOTNTGYFRETUNKEN

拿到之前解折FUNCATION时缓存的信息

将解析的FUNCTIONCALBACK缓存起来,后续还

这里当福食用PP方法车

CERESPONSE>GETWAITTINE(){

THIS.FUNCTIONCALLBACKREGISTERGETFUNCTIONNAN

.BUILD()));

CAL

1/TODO.,

![spring-ai (7).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749454861533-d726d036-c384-44c7-aa9c-25d084837e79.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_170%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 tools注意事项： 

**1**参数或者返回值不支持：

以下类型目前不支持作为工具使用的方法的参数或返回类型:

(COMP1ETAB1EFUTURE例LFUTURE

(例如F1OW,MONO,F1UX)

功能类型(例如FUNCTION,,S

异步类型

OPTIONA1

反应类型(例

SUPPLIER

ONSUMERO

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1751966390991-d75eacfb-c7ae-4b5f-91fb-d3c3f3f2f0ec.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_22%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



推荐：  pojo  record   java基础类型   list  map 

**2**Tools参数无法自动推算问题

●温度（即模型随机性）太低，AI可能缺失自由度变得比较拘谨（从一定程度可以解决， 但是不推荐）

●也可以通过描述更加明确







**3**大模型“强行适配”Tool参数的幻觉问题

●加严参数描述与校验



●后端代码加强校验和兜底保护

●系统Prompt设定限制



●高风险接口（如资金、风控等）tools方法加强人工确认，多走一步校验。



**4**工具暴露的接口名、方法名、参数名要可读、业务化

●AI是“看”你的签名和注释来决定用不用工具的；

●尽量避免乱码、缩写等。



**4**方法参数数量不宜过多

●建议每个工具方法尽量少于5个参数，否则AI提示会变复杂、出错率高。

**5**工具方法不适合做超耗时操作， 更长的耗时意味着用户延迟响应时间变长

性能优化 能异步处理就异步处理、 查询数据  redis









**6**关于Tools的权限控制

a可以利用SpringSecurity限制



b将tools和权限资源一起存储， 然后动态设置tools



根据当前用户读取当前用户所属角色的所有tools



**7**tools过多导致AI出现选择困难证     

问题：    

atoken上限

b选择困难证



tools的描述作用   保存  向量数据库。 

实现方式：

1把所有的tools描述信息存入到向量数据库

2每次对话的时候根据当前对话信息检索到相似的tools（RAG）

3然后动态设置tools 

 



 《智能客服项目实战》 

https://www.yuque.com/geren-t8lyq/ncgl94/yqnlrri5gavanx0f?singleDoc# 《Spring AI1.0 智能航空助手项目》

 项目效果： 

 角色预设： 

您好,欢迎联系图灵航空公司客服!我是您的在线支持助手,很高兴

欢迎来到图灵航空+!请问有什么可以帮您

您提供帮助.请问您今天需要咨询或办理什么业务呢?

2025/7/1321:04:40

2025/7/1321:04:40

2025/71320:53:54

更改预定退

你:你好

BUSINESS

BOOKING

BUSINESS

ECONOMY

CONOMY

更改预定

PERATIONS

更政改预定

更改预定

ECONOMY

REMIUM_

PLEASEINPU

STATUS

NAME

重庆

ROM

退订

青岛

深圳

退订

百里

CLASS

广州

退订

改预定

北京

杭州

退订

105

诸葛

武汉

101

DATE

徐庶

成都

103

102

庄周

退订

海

楼兰

北京

TO

V

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752411906784-7e52fb76-0f69-4224-b4ec-8217d525bea6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_53%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 记忆对话 

您好!您提供的预订号是"101",姓名是"徐庶".正在为您查询预订信

您好,徐庶先生/女士!您的预订(预订号:101)已成功取消.根据我

并返回到您的原支付账户.如果您有其他问题或需要进一步的帮助,请

们的服务条款,经济舱的取消费用为75美元,退款将在7个工作日内处理

息,请稍等片刻.您好,徐庶先生/女士!您的预订信息如下:预订

ECONOMY)如果您确认取消此预订,请回复"确认",我将协助您完

CONFIRMED)-出发地:上海-目的地:北京-舱位等级:经济舱

号:101-出行日期:2025年7月15日-预订状态:已确认

随时告知我们!祝您生活愉快!

2025/7/1321:05:38

2025/7/1321:05:38

2025/7/1321:06:04

20257/1321:06:04

成取消流程.

PLEASEINPUT

你:101徐庶

你:确认

发送

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752412010405-7e36f066-e742-4dec-9f1a-7f608e70f8e1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_18%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 tools 

们的服务条款,经济舱的取消费用为75美元,退款将在7个工作日内处理

您好,徐庶先生/女士!您的预订(预订号:101)已成功取消.根据我

您好!看起来您想取消预订.为了继续进行此操作,我需要角认您的预

订号和姓名.请提供这些详细信息,以便我们协助您完成取消流程.

息,请稍等片刻.您好,徐庶先生/女士!您的预订信息如下:预订

并返回到您的原支付账户.如果您有其他问题或需要进一步的帮助,请

(ECONOMY)如果您确认取消此预订,请回复确认",我将协助您完

(CONFIRMED)-出发地:上海-目的地:北京-舱位等级:经济舱

您好!您提供的预订号是"101",姓名是"徐庶".正在为您查询预订信

号:101-出行日期:2025年7月15日-预订状态:已确认

随时告知我们!祝您生活愉快!

2025/71321:05:38

2025/7/1321:06:04

2025/71321:05:28

2025/7/1321:05:38

2025/7/1321:06:04

你:确认

更改预定

成取消流程.

OPERATION

PREMIUM_

BUSINESS

更改预定

BOOKING

PLEASEINPUT

ECONOMY

BUSINESS

更改预定

更改预定

你:101徐庶

ECONOM

CONOMY

北京

更改预定

AME

TATU

退订

CLASS

ROM

退订

退订

成都

庄周

诸葛

广州

深圳

0

退订

ATE

徐庶

101

X

庆

北京

退订

102

杭州

楼兰

105

武汉

百里

103

青岛

口

海

104

1

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752412032155-7ee5fea7-1003-42f5-9c87-951be3343f04.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 MCP 

 问题： 

1当有服务商需要将tools提供外部使用（比如高德地图提供了位置服务tools， 比如百度提供了联网搜索的tools...）

2 或者在企业级中， 有多个智能应用，想将通用的tools公共化

  怎么办？  



可以把tools单独抽取出来，  由应用程序读取外部的tools。     那关键是怎么读呢？ 怎么解析呢？  如果每个提供商各用一种规则你能想象有多麻烦！ 所以MCP就诞生了，  他指定了标准规则，  以jsonrpc2.0的方式进行通讯。 

那问题又来了， 以什么方式通讯呢？   http?  rpc?  stdio?      mcp提供了sse和stdio这2种方式。

ENEROTIVEA

MODELCONTEXTPROTOCOL

WEB/STDLIO

EXTERNALTOOLS

FO上MAAE

A应用

TOOLS

AME-GETAIRQUALITY,

AI应用

DESCRIPTION-获取指定位置的空气质

TEQUIRED-[LOCATION]

AI应用

,DESCRIPTION-地P

PEOAPEUESAEELOCATION

TOOLS

PROPERTIES

TOOLS

NPUTSCHEMA=

园

园

LOCATION=

石

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749538652064-fa3cda1e-d919-4e45-999c-db97817ba693.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_55%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 使用 

Streamable http目前springai1.0版本不支持， 我们先掌握SSE和STDIO

分别说下STDIO和SSE的方式：

●STDIO更适合客户端桌面应用和辅助工具

●SSE更适合web应用 、业务有关的公共tools



MCPSENVER(STDIO)

MCPSERVER(SSE)

SENVERPROCESS

JAVAMCPSERVER

JAVAMCPSERVER

SINGLEPROCESS

JAVAMCPSERVER

MCPPROTOCOL(SSE)

SINGLEPROCESS

LLMAPPLICATION

CLIENTPROCESS

CLIENTPROCESS

JAVAMCPSERVER

LLMAPPLICATION

LLMAPPLICAITON

SINGLEPROCESS

MCPCLIENTA

WEBCONTAINER

LLMAPPLICATION

CLIENTPROCESS

YOUBACKEND

LLMAPPLICATION

APPLICATIONS

MCPPROTOCO

APPLICATIONS

APPLICATIONS

APPLICATIONS

MCPCLIENT

MCPCLIENT

MCPCLIENT

MCPCLIENT

YOUBACKEND

MCPCLLIEN

MCPCLIENT

LLMAPPLICAITOR

MCPCLIENTA

YOUBACKEND

YOUBACKEND

MCPCLIENTAPL

JAVASCRIPT

JAVASCRIPT

SSECLIENTTRANSPOR

DBS

PYTHON

PYTHON

(STDIO)

TDLOSENVERTRANSPORT

JAVA

JAVA

JAVA

PO

6

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749543212615-6e6d670b-73d7-4c49-aab9-6640ee8b98c8.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 STDIO 

 MCP Server 

 现成共用MCP Server 

 自定义MCP Server 

 MCP Client 

 通过工具 

 通过Spring AI 

  





 SSE 



 MCP Server 

 MCP Client 

  



 原理 

1STDIO 是基于标准输入\输出流的方式， 需要在MCP 客户端安装一个包（可以是jar包、python包、npm包等..）. 它是“客户端”的MCP Server。

CLOSESTDIN,TERMINATESUBPROCESS

OPTIONALLOGSONSTDERR

IMESSAGEEXCHANGE]

LAUNCHSUBPROCESS

WRITETOSTDOUT

WRITETOSTDIN

SERVERPROCESS

SERVERPROCESS

OOOOAOOAAOOOOOOOOOOOOETCACOOOOE

CLIENT

CLIENT

公和的开和的的的的的OOO生进开为

ARRRRRRRRRRRRRRRRA

OOP

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752585876004-6075ff95-4059-4c69-a950-3a0c51f7a0d3.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_18%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





2SSE  是基于Http的方式进行通讯， 需要将MCP Server部署为一个web服务. 它是服务端的MCP Server





 STDIO原理 

NORMALPROTOCOLOPERATIONS

INITIALIZEDNOTIFICATION

LNITIALIZATIONPHASE

INITIALIZERESPONSE

CONNECTIONCLOSED

PERATIONPHASE

INITIALIZEREGUEST

SHUTDOWN

SERVER

DISCONNECT

CLIENT

CLIENT

SERVER

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752591174064-97591e76-da2c-4c04-81d4-6aebe59361fd.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_16%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



很多人不理解stdio到底什么意思， 为什么一定要把stdio server的banner关掉， 还要清空控制台？

SONRPCRESPONSEISOODC=COLD:LCILOACRLOLRESLCOERCOAOCCALVELAIERLLCOILROECLROLILEDILLDO

SONNRLRESDONSESOAEEOLECEATAATELIESUITITOOSL(OALTE:AETYEAINETOLECRATEYLOCATON

DLIDEAWORKSPACELLGITPULLTULING-FLIGHTBOOKING_ALNLMCP-STDIO-SERVERLTARGETLMCP-STDIO-SERVERXS-1.

("PROTACOLVERSION:"2024-11:05",'CAPABILITIES":0,"CLIENTLNFO":("NAME":"SPRING-A

OAOEEOETAOEESEEETEOOOS,EYITOUESEOAOOEOBIER

NAME:GETYEPTHEREOSSASTEYLOCATION,ARGUMENTS.

(JSONRPC":"2.0","METHOD":"INITIALIZE","ID":2C7095CF-0","PARAMS":

OEESEYEEEOENAOEAEO

RPC":"2.0","METHOD":"TOOLS/CALL","ID:"39E77B62-3"PARAMS

(JSONRPC":"2.0""METHOD":"TOOLS/LIST","ID":"3B33431-1","PAR

(JSONRPC":"2.0","METHOD":"NOTIFICATIONS/INITIALIZED

DOAGNGPATEOSOE

OOLS=LISTCHANGED=TRUE,SERVERLNFO-{NAME=MY-WEATHER-SERVER,VERSION-0.0

COEAE

度:17.2C(体感温度:18.2(

SONBCBESDEDSESN(BSA1

大模型调用运程MCP的TOAL

向:北风(64KM/H

风(10.2KM/)N降水量:11(需本0..品:宜.1A3.2.2640天气:N风向:西北风(

告诉大模型TOOLS

降水量:0.0毫米

):N温度:18.1C~24.0CLN天气:多云N风向:西北风(118KM/)

询长沙天年

SONRPCRESPONSE[JSONRPC=2.0,ID=2C7095CF-0,RESULT-(PROTOCOVE

初始化完成

WTE

2420DK2025-0427(周日)N温度:18.9C22.9CR

READ

调用工具

(NAME-GETAIRQUALITY,DESCRIPTION-获取指定位置的空气质量信息(模拟教据INNUISCHEM-IR-

REAC

A9S:[

取工具列表

WRITE

报,INPUTSCHEMA三(TYPEOADDITIONALPROPERTIES-FALSE

.:..-ONOA11-05,CAPABILTIES={LOGGING=0

BLE,REQUIREOU),INPUTSC..FORMAT-DOUDIE

![未命名文件 (4).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749543942465-684dee68-7d74-4a28-aa11-914d178dd9e2.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_98%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



1首先SpringAi底层会读取到mcp-servers-config.json的信息

2然后执行命令（其实聪明的小伙伴早就发现了，mcp-servers-config.json文件中就是一堆shell命令）

a怎么执行？  熟悉java的同学应该知道，java里面有一个对象用于执行命令：



3所以springAi底层相当于读取到信息后， 会通过processBuilder去执行命令





其实你也完全可以自己通过mcd去执行命令

R:DOUBLE"NDESCRIPTION":编"),"RAQUIREDR:LARG0,ANG"],PADITONALPROPERTIE:FALSE),(NANET:"GETLEATHERFORECASTBYLACATI

29999T21:28:19.941+08:08TNE052225

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749544393733-af10cef8-2d9d-4fb9-a14b-1b61761afcda.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_54%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



1运行jar -jar mcp-stdio-server.jar

2输入{"jsonrpc":"2.0","method":"tools/list","id":"3b3f3431-1","params":{}}

3输出tools列表

这就是标准输入输出流!    看到这里你应该知道， 为什么需要-Dlogging.pattern.console=  完全是为了清空控制台，才能读取信息!



所以利用java也是一样的原理：



1通过ProcessBuilder执行命令

2通过子线程轮询 process.getInputStream 获取输出流

3通过process.getOutputStream(); 进行写入流

所以整个过程是这样的：再回顾上面的图

启动程序--->读取mcpjson--->通过ProcessBuilder启动命令---> 写入初始化jsonrpc---->写入获取tools列表jsonrpc---->请求大模型（携带tools）---->写入请求外部tool的jsonrpc---->获取数据--->发送给大模型---->响应。







 STDIO源码 

STARTOUTBOUNDPROCESSINGSTDIN

生

连接成功,发送给接收订阅者

PROCESSGETEUTPUTSTEAM0

OUTBOUNDSINK.TRYEMITNEX

WEBMVCSSESERVERTRANSPORT

HANDLELNCOMINGMESSAC

发送给出站订阅者

TDIOCLIENTTRANSPORT

HTTPSERVLETSSESERVERTRANSPORT

STDIOMCPTRANSPORT

SENDMESSAGE

获取进程的响应流

..会读取到信息

MCPTRANSPOR

STARTLNBOUNDPROCESSINGSTDOU

ERVER端会输出信

MCPCLIENTAUTO

2.返回TOOL

送消息

长沙天气

3.告知TOOLS

返回响应

输连接

.调用TOO

OCESS.AETLNPUTSTREAM

连接成功,发送给接收订阅者

初始化并启动传

启动

ALTOOL

TBOUNDPROCESSIN

FLOWSSECLIENT.SU

![未命名文件 (5).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749543994705-06c671de-1be4-4d18-838f-2148c7eac45d.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_96%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 MCP鉴权 

在做MCP企业级方案落地时， 我们可能不想让没有权限的人访问MCP Server,  或者需要根据不同的用户返回不同的数据， 这里就涉及到MCP Server授权操作。



那MCP Server有2种传输方式，  实现起来不一样：

 STDIO 

这种方式在本地运行,它 将MCP Server作为子进程启动。 我们称为标准输入输出， 其实就是利用运行命令的方式写入和读取控制台的信息，以达到传输。  

CLOSESTDIN,TERMINATESUBPROCESS

LMESSAGEEXCHANGE

OPTIONALLOGSONSTDERR

AUNCHSUBPROCESS

SERVERPROCESS

SERVERPROCESS

WRITETOSTDOUT

WRITETOSTDIN

CLIENT

CLIENT

OOP

IIINIIIINIIIIINIIIIINIIIIIIIIIIIIIIIIN

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747376380238-74bfcf1f-4ed0-41f2-ac6a-39cdf3b54fd1.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_22%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_22%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 通常我们会配置一段json，比如这里的百度地图MCP Server ：

●其中command和args代表运行的命令和参数。

●其实env中的节点BAIDU_MAP_API_KEY就是做授权的。

如果你传入的BAIDU_MAP_API_KEY不对， 就没有使用权限。





所以STDIO做授权的方式很明确， 就是通过env【环境变量】，实现步骤如下：

1服务端发放一个用户的凭证（可以是秘钥、token）  这步不细讲，需要有一个授权中心发放凭证。

2通过mcp client通过env传入凭证

3mcp server通过环境变量鉴权

 

所以在MCP Server端就可以通过获取环境变量的方式获取env里面的变量：

也可以通过AOP的方式统一处理





这种方式要注意：  他不支持动态鉴权，  也就是动态更换环境变量，  因为STDIO是本地运行方式，它 将MCP Server作为子进程启动, 如果是多个用户动态切换凭证， 会对共享的环境变量造成争抢， 最终只能存储一个。  除非一个用户对应一个STDIO MCP  Server.     但是这样肯定很吃性能！   如果要多用户动态切换授权，  可以用SSE的方式；

 SSE 

 说明 

不过，如果你想把 MCP 服务器开放给外部使用，就需要暴露一些标准的 HTTP 接口。对于私有场景，MCP 服务器可能并不需要严格的身份认证，但在企业级部署下，对这些接口的安全和权限把控就非常重要了。为了解决这个问题，[2025 年 3 月发布的最新 MCP 规范](https://modelcontextprotocol.io/specification/2025-03-26/basic/authorization)引入了安全基础，借助了广泛使用的 [OAuth2 框架](https://modelcontextprotocol.io/specification/2025-03-26/basic/authorization)。



![img](https://cdn.nlark.com/yuque/0/2025/webp/22309163/1747373008252-ea86cf42-b7c5-49b2-96f4-9abdc4d986cf.webp?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)





本文不会详细介绍 OAuth2 的所有内容，不过简单回顾一下还是很有帮助。

在规范的草案中，MCP 服务器既是资源服务器，也是授权服务器。

●作为资源服务器，MCP 负责检查每个请求中的 Authorization请求头。这个请求头必须包括一个 OAuth2access_token（令牌），它代表客户端的“权限”。这个令牌通常是一个 JWT（JSON Web Token），也可能只是一个不可读的随机字符串。如果令牌缺失或无效（无法解析、已过期、不是发给本服务器的等），请求会被拒绝。正常情况下，调用示例如下：



●作为授权服务器，MCP 还需要有能力为客户端安全地签发 access_token。在发放令牌前，服务器会校验客户端的凭据，有时还需要校验访问用户的身份。授权服务器决定令牌的有效期、权限范围、目标受众等特性。

用 Spring Security 和 Spring Authorization Server，可以方便地为现有的 Spring MCP 服务器加上这两大安全能力。



![img](https://cdn.nlark.com/yuque/0/2025/webp/22309163/1747373008252-989690c4-f96d-4333-87a1-0b027a0f42f0.webp?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)





 给 Spring MCP 服务器加上 OAuth2 支持 

这里以官方例子仓库的【天气】MCP 工具演示如何集成 OAuth2，主要是让服务器端能签发和校验令牌。

首先，pom.xml 里添加必要的依赖：



接着，在 application.properties配置里加上简易的 OAuth2 客户端信息，便于请求令牌：



这样定义后，你可以直接通过 POST 请求和授权服务器交互，无需浏览器，用配置好的 /secret 作为固定凭据。 比如 最后一步是开启授权服务器和资源服务器功能。通常会新增一个安全配置类，比如 SecurityConfiguration，如下：



这个过滤链主要做了这些事情：

●要求所有请求都要经过身份认证。也就是访问 MCP 的接口，必须带上 access_token。

●同时启用了授权服务器和资源服务器两大能力。

●关闭了 CSRF（跨站请求伪造防护），因为 MCP 不是给浏览器直接用的，这部分无需开启。

●打开了 CORS（跨域资源共享），方便用 MCP inspector 测试。

这样配置之后，只有带 access_token 的访问才会被接受，否则会直接返回 401 未授权错误，例如：



要使用 MCP 服务器，先要获取一个 access_token。可通过 client_credentials 授权方式（用于机器到机器、服务账号的场景）：



把返回的 access_token 记下来（它一般以 “ey” 开头），之后就可以用它来正常请求服务器了：



你还可以直接在 MCP inspector 工具里用这个 access_token。从菜单的 Authentication > Bearer 处粘贴令牌并连接即可。





 为MCP Client设置请求头 

目前，  mcp 的java sdk 没有提供api直接调用，  经过徐庶老师研究源码后， 你只能通过2种方式实现：

 重写源码 

扩展mcp 的sse方式java sdk的源码，  整个重写一遍。 工作量较大， 并且我预计过不了多久， spring ai和mcp协议都会更新这块。  看你的紧急程度， 如果考虑整体扩展性维护性，可以整体重写一遍：



提供一个重写思路

重写McpSseClientProperties

MCPSse客户端属性配置：新增请求头字段



重写SseWebFluxTransportAutoConfiguration

自动装配添加请求头配置信息

 





 使用：

3<CORRETTO-17>/USERS/GUOTAO/LIBRARY/JAVA/JAVAVIRTU

LMAVEN:CH.GOS.LOGBACKLOGBACK-CLASSIC:1.4.14

URL:HTTP://LOCALHOST:18085

WEB-APPLICATION-TYPE:NONE

API-KEY:$DASHSCOPEAPIKEY}

TOKEN-YINGZI-2:YINGZI-2

NAME:MCP-CLIENT-WEBFLUX

TOKENYINGZI-3:YINGZI-3

MODELCONTEXTPROTOCOL

TOKEN-YINGZI:YINGZI

CDAPPLICATION.YML

L3MCP-CLIEN

HEXTERNALLIBRARIES

MREADME.MD

N1ION十NFRLIG

LMCP-RESTFUL

APPLICATION:

HEADERSMAP:

LRESOURCES

L3MCP-SERVER

DASHSCOPE:

GITIGNORE

调试日志

门TARGET

MPOM.XML

CONNECTIONS:

TARGET

MPOM.XML

CLIENT:

MAIN:

\>TEST

OGGING:

TEST

\>MAIN

DIMGS

MPOM.XML

.IDEA

SERVER1:

LEVEL:

SRC

口JAVA

SRC

MCP:

SPRING:

了MAIN

17

SSE:

I0:

13

18

AVAVIRTUI2G

20

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1747380936959-4787c998-23ca-4e5e-b3be-24fb49476be9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_47%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_47%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





设置WebClientCustomizer



在用Spring-ai-M8版本的时候， 发现提供了WebClientCustomizer进行扩展。 可以尝试：



1根据用户凭证进行授权



2根据授权后的token进行请求：





SSE是支持动态切换token的，  因为一个请求就是一个新的http请求，  不会出现多线程争抢。 
但是需要动态请求：
curl -XPOST http://localhost:8080/oauth2/token --data grant_type=client_credentials --user xushu:xushu666    进行重新授权

  

 RAG 

检索增强生成（Retrieval-augmented Generation）

对于基础大模型来说， 他只具备通用信息，他的参数都是拿公网进行训练，并且有一定的时间延迟，  无法得知一些具体业务数据和实时数据， 这些数据往往在各种文件中（比如txt、word、html、数据库...）



虽然function-call、SystemMessage可以用来解决一部分问题

但是它只能少量，并且针对的场景不一样

如果你要提供大量的业务领域信息，  就需要给他外接一个知识库：



比如

1我问他退订要多少费用

2

这些资料可能都由产品或者需求编写在了文档中：  



terms-of-service.txt(1 KB)



a所以需要现在需求信息存到向量数据库（这个过程叫Embedding， 涉及到文档读取、分词、向量化存入）

3去向量数据库中查询“退订费用相关信息”

4将查询到的数据和对话信息再请求大模型

5此时会响应退订需要多少费用

美元,豪华经济舱50美元,商务舱25美元

取消费用:经济舱75美元,豪

基础大模型

退订要多少费用

LANGCHAIN-4

订要多少费用

向量数据:

退订要多少费用一

应用程序

EMBEDDING

向量数据库

资料,知识

用户信息:

三

数据

RAG

口十一?

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741158263487-85d26245-bcab-48ee-8d0c-45322c292687.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_31%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 概念 

 向量： 

向量通常用来做相似性搜索，比如语义的一维向量，可以表示词语或短语的语义相似性。例如，“你好”、“hello”和“见到你很高兴”可以通过一维向量来表示它们的语义接近程度。

见到你很高兴[14

HELLO[13

(一维)

你好[12]

徐底

我叫

EEIIIHIEEEAN

EAEAAA

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741703979687-3dfe46b9-8bbc-4c8a-8ff7-11a63cd32800.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_33%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_33%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



然而，对于更复杂的对象，比如小狗，无法仅通过一个维度来进行相似性搜索。这时，我们需要提取多个特征，如颜色、大小、品种等，将每个特征表示为向量的一个维度，从而形成一个多维向量。例如，一只棕色的小型泰迪犬可以表示为一个多维向量 [棕色, 小型, 泰迪犬]。

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741703733774-aafd18f8-6d1c-4f9c-ac0a-55eb5c2ef03e.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_44%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



如果需要检索见过更加精准， 我们肯定还需要更多维度的向量， 组成更多维度的空间，在多维向量空间中，相似性检索变得更加复杂。我们需要使用一些算法，如余弦相似度或欧几里得距离，来计算向量之间的相似性。向量数据库会帮我实现。

 

TEXT

TEXT

一向量化一

TEXT

向量模型

一嵌入一

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752672648271-7cafe1a1-33e0-4c4d-8f70-d8c3fb819cd6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_24%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 文本向量化 

通过向量模型即可向量化,  这里我们学到了一种新的模型， 叫“向量模型” 专门用来做文本向量化的。

大语言模型不能做向量化， 所以需要单独找一个向量模型

1deepseek不支持向量模型

2阿里百炼有大量向量模型

a默认模型DashScopeEmbeddingProperties#DEFAULT_EMBEDDING_MODEL="text-embedding-v1"

通用文本向量的批处理接口,通过这个接口客户可以以文本方式一次

文本向量,是通义实验室基于LLM底座的多语吉文本统一向量投

是通义实验室基于QWEN3训练的多语言文本统一向量模型,相V3

性的提交大批量的向量计算请求,在系统完成所有的计算之后,大模

通义实验室基于预训练多模态大模型构建的多模态向量模型.该模型

通用文本向量,是通义实验室基于LUM底座的多语吉文本统一向

性的提交大批量的向量计算请求,在系统完成所有的计算之后,大模

通用文本向量的批处理接口,通过这个接口客户可以以文本方

型,面向全速多个主流语种,提供高水准的向量取务,帮助开爱者

用文本向量,是通义实验室基于LLM底座的多语言文本统一向

,面向全球多个主流语种,提供高水准的向量服务,帮助开发者

根据用户的输入生成高维连续向量,这些输入可以是文本,图片或视

型服务平台会将结果信息存储在结果文件中供客户下载解析

,面向全球多个主流语种,提供高水准的向量服务,帮助开发者拍

版本在文本检索,聚买,分类性能大福提升;在M[B多语言,中

通用文本向量-ASYNC

通用文本向量ASYNC-V2

解视频理解视频生成图片处理图片理解

型服务平台会将结果信息存储在结果文件中供客户下载解析.

通用文本向量-V

文本数据快速转换为高质量的向量数据.

通用文本向量-V3

本数据快速转换为高质量的向量数据.

用文本向量-V

通用文本向量V

通用多模态向量

从全部模型中搜索

2025-06-05更新

2024-12-23更新

O查看详情

2024-07-12更新

2024-04-09更新

BLACKFORESTLABS

能智请AIBELLE

园AP参考

O查看详情

0查看详情

入立即体验

回AP参考

回AP参考

7个模型

O查看详情

入立即体验

回AP参考

.多模态向量在可应用于图片搜索,文投图视频投索,图片分

语音合成

STABILITYALT

2024-04-09更新

百川智能

文本数据快速转换为高质量的向量数据

2024-04-09更新

IDEA研究院

英,CODE检索等评测任务上效果提升15%.40%;支持64.2048

元语智能

入立即体验

模型广场

0查看详情

64K以上

司AP约考

语音识别

本生成

零一万物

DATABRICKS

园AP参考

MINIMAX

2024-04-09更第

0查看详情

排序模型

全模态

0查看详情

型类型

DEEPSEEK

回AP参考

音频理解

最新推荐

向量模型

K-64K

推理模型

量模型

6K以下

图片生成

立即体验

模型筛选

向量模型

向量模型

供应商

向量模型

全部

视频理解

向量模型

META

命清空

通义

向量模型

5

下文长度

立即体验

万

元

万

万

方

通义

全部

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749557877276-e1c0b9b2-feed-410d-92e4-f6fb41b98775.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_48%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





3ollama有大量向量模型, 自己拉取

AHIAH-PERFORMINGOPENEMBEDDINGMODELWITHALARGETOKER

NOMIC-EMBED-TEXT

28.4MPULLS3TAGSOUPDATED1YEARAG

QSEARCHMODELS

CONTEXTWINDOW

EMBEDDING

HINKING

MODELS

POPULAR

EMBEDDINC

DISCORD

ISION

GITHUB

OOLS

(SIGR

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749557970769-1073e1ca-eee5-4275-ba03-6c46f03ba9f2.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_47%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





以ollama为例：







-0.029880228,0.011493611,-00075620427-0.036051176,-0.0070782374,-0.05910842

0.07505905-0.017607443-0.01990077,0.02768513,0.001411081-0.030866312,

6.236339E-4,-0.036202922,-0.04435769,-0.042318165,-0.05182244,0.05119332.

0.034040496,-0.025835162,0.09211509,0.016864466,-4.3604593E-4,0.0300993,

0.025100322-0.0121360235,0.06947452,2.3044019E-4,0.010730448,0.035851907

0.06643883,0.09382374,-0.05350642,0.00300773-0.010261671-0.014190193

[-0.0052351956,0.0011280776,-012706275,0.026365565,0.039662328,0.026655024

.1716028,0.008059387,0.014496826,0.043016035,0.007994747,0.011526618

0.0011055802,-0.013589621,0.0013687313,0.01693778,-0.066704676,-0.012817239,

0.06058546,0.03052305,-0.019710518,-0.04616847,-0.024103487,.0.03197414.

768

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749559505646-45b28c7e-2599-4f11-a628-d99b1c872573.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_32%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



从结果可以知道"我叫徐庶"这句话经过OllamaEmbeddingModel向量化之后得到的一个长度为768的float数组。注意，768是向量模型nomic-embed-text-v1.5固定的，不会随着句子长度而变化，不同的向量模型提供了不同的维度。





那么，我们通过这种向量模型得到一句话对应的向量有什么作用呢？非常有用，因为我们可以基于向量来判断两句话之间的相似度，举个例子：

查询跟秋田犬类似的狗，  在向量数据库中根据每个狗的特点进行多维向量， 你会发现秋田犬的向量数值和柴犬的向量数值最接近， 就可以查到类似的狗。    （当然我这里只是举例，让你对向量数据库有一个印象）

(12,321,813,312)

(50,321,3213,654)

(中小黄色,温顺日本

(111,321,3213,987

(111,447,250,546

大小,颜色,性格,品种.)

(大小,颜色,性格,品科

(50,321,3213,654)

(中大,黑白,傻,俄罗斯

(大小颜色,性格,品种)

(中大,黄色,温顺,英国

(大小,颜色,性格,品种.)

(中小黄色温顺日本)

小颜色,性格,品种.

(小型,黄色,活泼,法

量数据库

秋田犬

哈士奇

泰迪

金毛

柴犬

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741159536310-23b0c084-513b-4801-9436-f63790fe47dc.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_30%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





●向量模型的本质目标，就是把语义相似的内容用“相近”的向量表示，把“不相关”内容尽量拉远。  
●所以好的向量模型能够更好的识别语义， 进行向量化.



 向量数据库 

对于向量模型生成出来的向量，我们可以持久化到向量数据库，并且能利用向量数据库来计算两个向量之间的相似度，或者根据一个向量查找跟这个向量最相似的向量。

在SpringAi中，VectorStore 表示向量数据库，目前支持的向量数据库有

●[Azure Vector Search](https://docs.spring.io/spring-ai/reference/api/vectordbs/azure.html) - The [Azure](https://learn.microsoft.com/en-us/azure/search/vector-search-overview) vector store.

●[Apache Cassandra](https://docs.spring.io/spring-ai/reference/api/vectordbs/apache-cassandra.html) - The [Apache Cassandra](https://cassandra.apache.org/doc/latest/cassandra/vector-search/overview.html) vector store.

●[Chroma Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/chroma.html) - The [Chroma](https://www.trychroma.com/) vector store.

●[Elasticsearch Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/elasticsearch.html) - The [Elasticsearch](https://www.elastic.co/) vector store. 可以“以向量+关键词”方式做混合检索。深度优化更多针对文本，不是专门“向量搜索引擎”。向量存储和检索容量有限制，查询延迟高于 Milvus。

●[GemFire Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/gemfire.html) - The [GemFire](https://tanzu.vmware.com/content/blog/vmware-gemfire-vector-database-extension) vector store.

●[MariaDB Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/mariadb.html) - The [MariaDB](https://mariadb.com/) vector store.

●[Milvus Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/milvus.html) - The [Milvus](https://milvus.io/) vector store.

●[MongoDB Atlas Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/mongodb.html) - The [MongoDB Atlas](https://www.mongodb.com/atlas/database) vector store.

●[Neo4j Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/neo4j.html) - The [Neo4j](https://neo4j.com/) vector store.可以结合结构化图谱查询与向量检索， 大规模嵌入检索（如千万—亿级高维向量）性能明显落后于 Milvus

●[OpenSearch Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/opensearch.html) - The [OpenSearch](https://opensearch.org/platform/search/vector-database.html) vector store.

●[Oracle Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/oracle.html) - The [Oracle Database](https://docs.oracle.com/en/database/oracle/oracle-database/23/vecse/overview-ai-vector-search.html) vector store.

●[PgVector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/pgvector.html) - The [PostgreSQL/PGVector](https://github.com/pgvector/pgvector) vector store.

●[Pinecone Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/pinecone.html) - [PineCone](https://www.pinecone.io/) vector store.

●[Qdrant Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/qdrant.html) - [Qdrant](https://www.qdrant.tech/) vector store.

●[Redis Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/redis.html) - The [Redis](https://redis.io/) vector store.  低门槛实现小规模向量检索。对于高维大规模向量（如几百万到上亿条），性能和存储效率不如专用向量库。

●[SAP Hana Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/hana.html) - The [SAP HANA](https://news.sap.com/2024/04/sap-hana-cloud-vector-engine-ai-with-business-context/) vector store.

●[Typesense Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/typesense.html) - The [Typesense](https://typesense.org/docs/0.24.0/api/vector-search.html) vector store.

●[Weaviate Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/weaviate.html) - The [Weaviate](https://weaviate.io/) vector store.

●[SimpleVectorStore](https://github.com/spring-projects/spring-ai/blob/main/spring-ai-vector-store/src/main/java/org/springframework/ai/vectorstore/SimpleVectorStore.java) - A simple implementation of persistent vector storage, good for educational purposes.



其中有我们熟悉的几个数据库都可以用来存储向量，比如Elasticsearch、MongoDb、Neo4j、Pgsql、Redis。

视频中我会讲解2种：

1[SimpleVectorStore](https://github.com/spring-projects/spring-ai/blob/main/spring-ai-vector-store/src/main/java/org/springframework/ai/vectorstore/SimpleVectorStore.java) 教学版向量数据库

2[Milvus Vector Store](https://docs.spring.io/spring-ai/reference/api/vectordbs/milvus.html)  Milvus（国产团队）、文档友好、社区国内活跃、性能最佳、市场占用率大。 实战中使用的向量数据库.

THEFORRESTERWAVE:VECTORDATABASES

THEFORRESTERWAVE

OQO)

AMAZONWEBSERVICES

STRONGERSTRATEGY

DATASTAX

WEAKERSTRATEGY

COUCHBASE

CHALLENGERS

MARKETPRESENCE

CONTENDERS

SINGLESTORE

OFFERING

MIONGODB-

FFERING

MICROSOFT

PINECONE

PERFORMERS

QDRANT

STRONGER

CURRENT

REDISO

STRONG

LEADERS

ORACLEO

TMATTERMOSTANDHOWTHEYSTAC

Q32024

WEAKER

ELASTIC-

CURRENT

ZILIZ

NEO4

RRESTEI

ORRESTERWAVE:VECTORDAT

X.

GURE1

INAUTHORZE

SOURCE:HORRESTERR

VECTORDATABASES,Q32

OVIDERSTHATMAT

![3a75c44d44f535cc6c35c6e05fcaddb9f18b4438-2088x2798.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749561837608-0462ab68-315f-4da5-89e5-17ee84dd843b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_60%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 匹配检索 

在这个示例中， 我分别存储了预订航班和取消预订2段说明到向量数据库中

然后通过"退票要多少钱" 进行查询

些那用全在您的取间请求被处理后,在7个工作日内从应退还款项中扣除.如果您取消的射时间不在现定的则时间范围内(最晚在航班起飞前48小时)

俘到思款或者可能会有额外的罚金.请确保您按照航空公司的规定时间内提出取消请求,

数据嵌入阶段

VECTOR:0.23498.0.23084

据您提供的FUNNAIR服务条款,取消预订的费用如下:

TEXT0:WHEN.C.C

TEXT1WHEN.........

TEXT1.WITH...........

VECTOR:0.23498,0.23084

向量模型

EMBADDING

TEXT2CONVERT.............

数据检索阶段

UESTION:退票多少钱

QUESTION:退票多少钱

TEXTO:WHEN........

向量数据库

大语言模型

EMBEDDING

豪华经济能:50美元

-经济舱:75美元

商务0:25美元

INSERT

LLM

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741702267256-ccae55e5-3820-4f1a-8f52-feffc37affe7.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_40%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



代码执行结果为：

OllamaEmbedding结果









 SearchRequest 

可以利用searchRequest设置检索请求：

●query 代表要检索的内容

●topK  设置检索结果的前N条   

○通常我们查询所有结果查出来， 因为查询结果最终要发给大模型， 查询过多的结果会：

■1. 过多的token意味着更长延迟，  更多的费用，  并且过多上下文会超限；

■2. 研究表明过多的内容会降低 LLM 的*召回性能*；

●similarityThreshold  设置相似度阈值， 可以通关设置分数限制召回内容相似度.  从而过滤掉废料。  （中文语料要适当降低分数）  ， 所以应遵循始终以“业务召回效果”为主，而不是追求网上常说的高分阈值。



可以看到明显阿里的向量模型归类的更加准确，Ollama的向量模型查出来后结果并不正确。  所以为了你的准确性，请选择性能更好的向量模型。  想要更快更相似的搜索，用好的向量数据库。



 接入ChatClient 

1依赖



2代码



3测试

实际你会发现， 最核心的是通过拦截器：QuestionAnswerAdvisor  . 你应该能猜到底层肯定会通过拦截对话将相似内容发给大模型。   可以结合SimpleLoggerAdvisor 查看日志内容.





 RetrievalAugmentationAdvisor  

●查询空时扩展策略  ：



●查询检索器

○检索提示词重写



**○**翻译重写



●后置处理器：需要文档后处理和重排序



●实现复杂的 RAG 流水线





 ELT 

在之前，我们主要完成了数据检索阶段，  但是完整的RAG流程还需要有emedding阶段， 即：

提取（读取）、转换（分隔）和加载（写入）

![img](https://cdn.nlark.com/yuque/0/2025/jpeg/22309163/1752825687770-5d5b57f7-8aa6-48f9-aa9d-bfc071a044bb.jpeg?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_140%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp%2Finterlace%2C1)



 1.1[Document Loaders](https://docs.langchain4j.dev/category/document-loaders) 文档读取器VECTOR:[0.23498,0.23084.]TEXT1:WHENCO.....TEXT0:WHEN.......知识库生成TEXTLWTHOOOOOOOO..VECTOR:0.23498.0.23084TEXTOWHENTEXT2:CONVERT......EMBEDDINGBEDDINGSHORTANDLONGCONTEN向量数据库读取INSERTTSCOA..OOOO.OOSPLIT![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741186496899-c89b21c0-6e7b-4503-853f-9c0e109d3b1b.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp) 

springai提供了以下文档阅读器

●[JSON](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_json)

●[文本](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_text)

●[HTML（JSoup）](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_html_jsoup)

●[Markdown](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_markdown)

●[PDF页面](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_pdf_page)

●[PDF段落](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_pdf_paragraph)

●[Tika（DOCX、PPTX、HTML……）](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_tika_docx_pptx_html)

alibaba ai也提供了很多阅读器

https://github.com/alibaba/spring-ai-alibaba/tree/main/community/document-parsers

●document-parser-apache-pdfbox：用于解析 PDF 格式文档。

●document-parser-bshtml：用于解析基于 BSHTML 格式的文档。

●document-parser-pdf-tables：专门用于从 PDF 文档中提取表格数据。

●document-parser-bibtex：用于解析 BibTeX 格式的参考文献数据。

●document-parser-markdown：用于解析 Markdown 格式的文档。

●document-parser-tika：一个多功能文档解析器，支持多种文档格式。

以及网络来源文档读取器：

https://github.com/alibaba/spring-ai-alibaba/tree/main/community/document-readers



M9横店影视股份有限公司0.MC

TERMS-OF-SERVICETXT2O2

T202541

RAG

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749974735407-b036f47f-1eb5-46fa-9a77-092eaa246fce.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_12%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 1.1.1 读取Text 



 1.1.2读取markdown 





 1.1.3pdf 

●PagePdfDocumentReader一页1个document

●ParagraphPdfDocumentReader 按pdf目录分成一个个document





 1.1.4B站： 





 1.2[DocumentSplitter‌](https://docs.langchain4j.dev/tutorials/rag#document-splitter) 文档拆分器（转换器） 

VECTOR:[0.23498,0.23084]

TEXT1:WHENOOOOOO......

TEXT0:WHE们....C*

VECTOR:[0.23498,0.23084]

知识库生成

TEXT1WITHOO

TEXT2:CONVERT.....-.....

TEXTOWHEN...

EMBEDDINGSHORTANDLONGCO

向量数据库

MBEDDING

INSERT

分割

SPLIT

OOAOOOOOOOOON.O

RTOOOOOOOON..

LPDFFILE

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741186628965-bab8cbb0-71d6-4cd5-bfab-0287b13a2540.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_38%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



由于文本读取过来后， 还需要分成一段一段的片段(分块chunk)， 分块是为了更好地拆分语义单元，这样在后面可以更精确地进行语义相似性检索，也可以避免LLM的Token限制。

SpringAi就提供了一个文档拆分器：

●[TextSplitter](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_textsplitter)    抽象类

●[TokenTextSplitter](https://docs.spring.io/spring-ai/reference/api/etl-pipeline.html#_tokentextsplitter)   按token分隔

 1.2.1 TokenTextSplitter 

1chunkSize (默认值: 800)      100

○每个文本块的目标大小，以token为单位

2minChunkSizeChars (默认值: 350)     建议小一点

○如果块超过最小块字符数( 按照块的最后. ! ? \n  符号截取)

○如果块没超过最小块字符数，  不会按照符号截取(保留原块）。



3minChunkLengthToEmbed (默认值: 5)  5

○丢弃短于此长度的文本块(如果去掉\r\n， 只剩5个有效文本， 那就丢掉）



4maxNumChunks (默认值: 10000)

○最多能分多少个块， 超过了就不管了



5keepSeparator (默认值: true)

○是否在块中保留分隔符、换行符 \r\n



整个流程如下：

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749993911885-95202323-3010-46cb-8bc7-e69fe606b220.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_19%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 1.2.2自定分割器： 

支持中英文：同时支持中文和英文标点符号



 1.2.3分隔经验： 

过细分块的潜在问题

1‌语义割裂‌： 破坏上下文连贯性，影响模型理解‌ 。

2‌计算成本增加‌：分块过细会导致向量嵌入和检索次数增多，增加时间和算力开销‌。

3‌信息冗余与干扰‌：碎片化的文本块可能引入无关内容，干扰检索结果的质量，降低生成答案的准确性‌。

分块过大的弊端

1‌信息丢失风险‌：过大的文本块可能超出嵌入模型的输入限制，导致关键信息未被有效编码‌。

2‌检索精度下降‌：大块内容可能包含多主题混合，与用户查询的相关性降低，影响模型反馈效果‌。

| ‌场景‌        | ‌分块策略‌                           | ‌参数参考‌         |
| ----------- | ---------------------------------- | ---------------- |
| 微博/短文本 | 句子级分块，保留完整语义           | 每块100-200字符‌  |
| 学术论文    | 段落级分块，叠加10%重叠            | 每块300-500字符‌  |
| 法律合同    | 条款级分块，严格按条款分隔         | 每块200-400字符‌  |
| 长篇小说    | 章节级分块，过长段落递归拆分为段落 | 每块500-1000字符‌ |

 不要过分指望按照文本主题进行分隔，  因为实战中的资料太多而且没有规律，  根本没办法保证每个chunk是一个完整的主题内容， 哪怕人为干预也很难。  所以实战中往往需要结合资料来决定分割器，大多数情况就是按token数分， 因为没有完美的， 还可以加入人工干预,或者大模型分隔。



 1.2.4分块五种策略 

以下是 RAG 的五种分块策略：

![img](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1753853837683-32cb032f-28d9-406e-b3e5-cc7ec87038ed.gif)



 

 1.2.4.11）固定大小分块 

生成块的最直观和直接的方法是根据预定义的字符、单词或标记数量将文本分成统一的段。

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753853836122-f0cc462f-5950-4cba-b11d-e1bce7eb52e6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_27%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



由于直接分割会破坏语义流，因此建议在两个连续的块之间保持一些重叠（上图蓝色部分）。

这很容易实现。而且，由于所有块的大小相同，它简化了批处理。

但有一个大问题。这通常会打断句子（或想法）。因此，重要的信息很可能会分散到不同的块之间。

 1.2.4.22）语义分块 

这个想法很简单。

![img](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1753853837572-b20e461c-2dac-44d1-8edb-d3e2ae6ced7b.gif)



●根据句子、段落或主题部分等有意义的单位对文档进行细分。

●接下来，为每个片段创建嵌入。

●假设我从第一个片段及其嵌入开始。

○如果第一个段的嵌入与第二个段的嵌入具有较高的余弦相似度，则这两个段形成一个块。

○这种情况一直持续到余弦相似度显著下降。

○一旦发生这种情况，我们就开始新的部分并重复。

输出可能如下所示：

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753853836031-5db335da-e799-4a83-bc13-8f90a05c7dcb.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_27%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



与固定大小的块不同，这保持了语言的自然流畅并保留了完整的想法。

由于每个块都更加丰富，它提高了检索准确性，进而使 LLM 产生更加连贯和相关的响应。

一个小问题是，它依赖于一个阈值来确定余弦相似度是否显著下降，而这个阈值在不同文档之间可能会有所不同。

 1.2.4.33）递归分块 

这也很简单。

![img](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1753853836600-2acd37dd-3cb8-4714-8688-72fd216e58ee.gif)



首先，根据固有分隔符（如段落或章节）进行分块。

接下来，如果每个块的大小超出了预定义的块大小限制，则将其拆分成更小的块。但是，如果块符合块大小限制，则不再进行进一步拆分。

输出可能如下所示：

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753853837553-448a3d2b-1cf7-4036-955f-6efc28f602bf.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



如上图：

●首先，我们定义两个块（紫色的两个段落）。

●接下来，第 1 段被进一步分成更小的块。

与固定大小的块不同，这种方法还保持了语言的自然流畅性并保留了完整的想法。

然而，在实施和计算复杂性方面存在一些额外的开销。

 1.2.4.44）基于文档结构的分块 

这是另一种直观的方法。

![img](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1753853838253-c6ae6f8e-08eb-41a8-83c0-c39e4b6ce25d.gif)



它利用文档的固有结构（如标题、章节或段落）来定义块边界。

这样，它就通过与文档的逻辑部分对齐来保持结构完整性。

输出可能如下所示：

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753853839556-9ea8dab6-5905-4fef-9469-7151da720546.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



也就是说，这种方法假设文档具有清晰的结构，但事实可能并非如此。

此外，块的长度可能会有所不同，可能会超出模型令牌的限制。您可以尝试使用递归拆分进行合并。

 1.2.4.55）基于LLM的分块 

![img](https://cdn.nlark.com/yuque/0/2025/gif/22309163/1753853841393-bfd2a2be-2db9-4b40-b723-4dfd1aaf3de6.gif)



既然每种方法都有优点和缺点，为什么不使用 LLM 来创建块呢？

可以提示 LLM 生成语义上孤立且有意义的块。

显然，这种方法将确保较高的语义准确性，因为 LLM 可以理解超越简单启发式方法（用于上述四种方法）的上下文和含义。

唯一的问题是，它是这里讨论的所有五种技术中计算要求最高的分块技术。

此外，由于 LLM 通常具有有限的上下文窗口，因此需要注意这一点。

每种技术都有其自身的优势和劣势。

我观察到语义分块在很多情况下效果很好，但同样，您需要进行测试。

选择将在很大程度上取决于内容的性质、嵌入模型的功能、计算资源等。

我们很快就会对这些策略进行实际演示。

同时，如果您错过了，昨天我们讨论了构建依赖于成对内容相似性的强大 NLP 系统的技术（RAG 就是其中之一）。





 1.2.5ContentFormatTransformer 

检索到的内容最终会发给大模型，  由该组件决定发送到模型的RAG内容



即：假设：

●文本内容："The World is Big and Salvation Lurks Around the Corner"

●元数据：Map.of("fileName", "xushu.pdf")

最终发送给大模型的格式化内容是：



很少会去改， 了解即可





 1.2.6KeywordMetadataEnriching 

使用生成式AI模型从文档内容中提取关键词并将其添加为元数据,为文档添加关键词标签，提升检索精度

new KeywordMetadataEnricher(chatModel, 5);  

1chatModel 需要提取关键字的模型

2关键字数量



![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1749997147499-7bafe6d5-bcaa-47cb-ae35-8489d3102d7c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



作用： 帮助做元数据过滤。    并不参数向量数据库的相似性检索

问题：

KeywordMetadataEnriching 生成出来的关键字无法进行元数据过滤

在SpringAi1.0.1 中已支持KeywordMetadataEnriching 自定义模版：
●Enhanced KeywordMetadataEnricher with custom template functionality to provide more flexible metadata enrichment capabilities [2082a59](https://github.com/spring-projects/spring-ai/commit/2082a594a40b6552b57cdbc51cae7c2112efd0f9)



 1.2.7SummaryMetadataEnricher 

使用生成式AI模型为文档创建摘要并将其添加为元数据。它可以为当前文档以及相邻文档（前一个和后一个）生成摘要，以提供更丰富的上下文信息 。



场景： 有顺序关联的文档，比如西游记小说的RAG，‘三打白骨精的故事以及后续剧情’。

●技术文档：前后章节有依赖关系

●教程内容：步骤之间有逻辑顺序

●法律文档：条款之间有关联性

●学术论文：章节间有逻辑递进





Document{id='66e859b2-f719-43ca-8466-d97f1880b530', text='更改预订

\- 允许在航班起飞前 24 小时更改。
\- 通过在线更改或联系我们的支持人员。
\- 改签费：经济舱 50，豪华经济舱 30，商务舱免费。
3.
取消预订

\- 最晚在航班起飞前 48 小时取消。', media='null', metadata={prev_section_summary=The key topics and entities of the section include:

1. **Service Terms Agreement**: The terms apply to the user's experience with 图灵航空 (Turing Airlines).
2. **Acceptance of Terms**: By booking a flight, the user agrees to these terms.
3. **Flight Booking**:

   \- Bookings can be made via the website or mobile application.
   \- Full payment is required at the time of booking.
   \- Personal information must be accurate to avoid a correction fee of 25 units.

Entities:
\- 图灵航空 (Turing Airlines)
\- Website and mobile application
\- Flight bookings
\- Payment process
\- Personal information (name, ID), charset=UTF-8, filename=terms-of-service.txt, source=terms-of-service.txt, section_summary=The key topics and entities of the section are as follows:

1. **更改预订 (Modifying Reservations)**:

   \- Allowed within 24 hours before the flight departure.
   \- Can be done either online or by contacting support personnel.
   \- Change fees: 
     \- Economy class: 50
     \- Premium economy class: 30
     \- Business class: Free

2. **取消预订 (Canceling Reservations)**:

   \- Must be done at least 48 hours before the flight departure.

Summary: The section outlines the policies for modifying and canceling reservations, including timeframes and associated fees for different classes (economy, premium economy, and business)., next_section_summary=The section outlines the **cancellation fees** for different cabin classes and the **refund processing time**. Key entities include:  
\- Cancellation fees: **Economy class (75 USD)**, **Premium Economy class (50 USD)**, **Business class (25 USD)**.  
\- Refund processing time: **7 business days**.}, score=null}

   





 1.3文本向量化 

知识库生成

VECTOR:0.23498.0.23084-

TEXT1:WHE门OOOOOOOOOOOOOOOO

VECTOR:0.23498.0.23084

向量模型

向量化

TEXT2:CONVERT

TEXTO:WHEN......

TEXTOWHEN

TEXT1:WITH.

向量数据库

EMBEDDING

INSERT

MBEDDINGSHORTAND

SPLIT

O...

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741188324988-536ef32b-5a6d-4999-9e08-df15d488a342.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_39%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



向量化存储之前在“文本向量化”介绍了， 就是通过向量模型库进行向量化



代码：

依然通过Qwen向量模型进行向量化：  将第分割的chunk进行向量化









 1.4存储向量 

但是我告诉你其实 ，  我们通过向量数据库存储document， 可以省略向量化这一步， 向量数据库会在底层自动完成向量化



![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750055863649-e1a58a18-23f4-482d-9c0d-123ee5a893fc.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)









 1.5向量数据库检索 



代码：

需要先将文本进行向量化， 然后去向量数据库查询，  







完整代码：











 1.6对话阶段 

如果结合ChatClient 可以直接将检索和Advisor整合在一起

些费用会在您的取消请求被处理后,在7个工作日内从应退还款项中扣除.如果您取消的时何不在规定的时间范围内(最晚在航斑起飞前4.小时)

VECTOR:[0.23498.0.23084.

VECTOR:[0.23498,0.23084..

得到限教成者可能全有板外的罚金,清降保您按照抗空公司的规定时间内提出取消请求.

根据您提供的FUNNAIR服务条款,取消预订的费用如下

向量模型

语言模型

知识库生成

EMBEDDINGSHORTANDLONGCONTENT

QUESTION:退票多小少钱

UESTION:退票多少钱

TEXTOWHEN.

MBEDDING

TEXT1:WHEH

TEXT2CONVERT

INSERT

向量数据库

TEXT1WITH...

TEXTOWHEN.

-经济舱:75美元

豪华经济舱50美元

SPLIT

OTTETTTATEAAT

团表示烟同营区监务款助际

商务舱:25美元

MEANG,THECOMPANEONWOULDNAURLYBEDONEONTHARLEVELWHERN

LLM

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1741847699874-61b078b9-8d57-4f61-ac3d-5927d7bad5f6.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_117%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)







SpringAI整个过程原理：

济舱50美元,商务舱25美元.

取消费用:经济舱75美元,豪华经

基础大模型

退订要多少费用

SPRING-AI

ADVISOR

预处理阶段

应用程序

一退订要多少费用

CHUNKL

向量数据库

检索阶段

退订要多少费用

一向量数据:_

用户信息:

EMBEDDING

CHUNK:0

CHUNK:0}

SPLIT

READ

![spring-ai (8).png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750057895102-987392e8-f52a-417d-9df1-35764077748c.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_67%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 提升检索精度—rerank(重排序） 

 为什么需要 rerank 

取消费用:经济舱75美元,豪华经

基础大模型

SPRING-AI

济舱50美元.简务舱25美.

兰

退订要多少费用

应用程序

_退订要多少费用

退订要多少费用

向量[121,12]一

要多少费用

DOCUMENT:...}

福

DOCUMENT:...

1预处理阶段

分块(CHUNKS)

文本向量化

2.检素阶段

EMBEDDING

用户信息:

_READ

向量模型

向量数据库

ADVISOR

DOCUMENTLJ

RAG

文挡邹K

向量文档:

文栏2

SPLITMM

文档当1:

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753779425195-b3fcc518-dd15-40cb-ac6d-fb5e77285348.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_35%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



传统的向量检索存在几个关键问题：

语义相似度的局限性：向量检索主要基于余弦相似度等数学计算，但相似的向量表示不一定意味着内容一定绝对相关。单纯的向量相似度无法充分理解查询的真实意图和上下文。

排序质量不佳：初始检索的排序往往不是最优的，可能将不太相关的文档排在前面，尤其性能差的向量模型更为明显。

上下文理解缺失：传统检索（完全依赖向量数据库和向量模型）缺乏对查询和文档完整上下文的深度理解，容易出现语义漂移问题。



 重排序： 

主要在检索阶段进行改进：

2.精筛(留下比如TOPK:5)

1粗筛(查询大量比如

取消费用:经济舱75美元,豪华经

一退订要多少费用TOPNSCORE-

济舱50美元,商务舱25美元.

济舱50美元,商务舱25美元.

退订要多少费用

取消费用:经济舱75美元,豪华经

TOPN:2O0

BLALALALALALALALALALLA

退订要多少费用

SPRING-AI

RERANKADVISOR

应用程序

基础大模型

退订要多少费用

文档N(200)

.检素阶段

向量文档:

用户信息:

文档K(5个)

重排序模型

RAG

向量文档:

量数据库

店

退订要多少费用

文档2

文档1:

文档2:

文档1:

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753779476732-44858afa-eacb-4758-8362-411138c71e97.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_35%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





二阶段优化架构：rerank 采用"粗排+精排"的两阶段架构。第一阶段快速检索大量候选文档，第二阶段使用专门的重排序模型进行精确评分。

专业化模型：重排序模型（如 gte-rerank-hybrid）专门针对文档相关性评估进行训练，能够更准确地计算查询与文档的语义匹配度。

分数阈值过滤：通过设置最小分数阈值，可以过滤掉低质量的文档，确保只有高相关性的内容被保留。在实现中可以看到这个过滤逻辑：  

动态参数调整：支持根据实际效果动态调整 topN 等参数，优化最终返回的文档数量和质量。

 代码 

说明：

为了更好的测试

1我这里用的事ollama一个性能较差的向量模型， 这样才能更好体现他瞎排的顺序

2我分隔的比较小new ChineseTokenTextSplitter(80,10,5,10000,true);为了有更多的document；

3粗排需要设置数量较大的topk(建议200） ， 精排（默认topN5）



重排前：

排第一的doucment跟退费并没有关系：

三0=/DOC.UMENT@1532)D0QUMENTID=LE9H4DE45-48DA-4D8E-9BEF-35E022AHA0/TEX=-通过在线电或联

DCUMENT(ID='E9B4DE45-48DA-4D8E-9BEF-35E0022ABA0B',TEXT=-通过在线更改或联系我们的支持人员.

改签费:经济舱50,豪华经济舱30,商务舱免费

.,MEDIAENULL,METADATA-CHANSET-UTF-8,FILENANE-TERMS-OF-SERVICE,TXT,?

S0URCE=TENNS-OF-SERVICE,TXT,DISTANCE=0,28141060666411666},SCORE=0.718589393335833)

最晚在航班起飞前48小时取消.

,取消预订

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752846171180-c3491a36-4fe2-451a-b3df-d7354e7423c9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_45%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



重排后：

排第一的document:

退款将在7工作日内处理.,MEDIAENUL',METADATA=(CHARSET-UTF-8,FILENANE=TEMS-OF-SEVICE,TXT,

S0URCE=TERMS-OF-SERVICE.TXT,DISTANCE=0.3255027195911914),SCONE=0.674972280408809

OCUMENT{ID=6D0E8605-3881-427C-BEB4-509783CA84D6),TEXT=-取消费用:经济舱75美元,蒙华经济船50美元,商务

OLAAATAAAUMAATA

ARRAYLISTA1

-/DAUM.CTA11.2.LUNOUMN+/IA-L.A00.AG.2001/07.-HNH.E00709.OO/TOT-肌出用用,必次E7

ODOCUMENTS

舱25美元.

12010

SIZE三

OCUMENTIDEOAUEOOUOOOA

TOPNS-0F-SENVICETXT

E0-DAOUAAOVAT

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1752846203397-eba6baeb-fe2b-4a00-8ad1-c1cc17ccc841.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_46%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





  



 《基于航空智能客服+RAG》实战 

1配置向量数据库

2写入数据（Embedding）

3查询



terms-of-service.txt(1 KB)







 向量数据库 



写入向量数据库

![img](https://cdn.nlark.com/yuque/0/2024/jpeg/22309163/1730894384826-1fc20e94-3ba1-4514-b20f-bb04a24dc3e1.jpeg?x-oss-process=image%2Fformat%2Cwebp%2Fresize%2Cw_1634%2Climit_0%2Finterlace%2C1%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_47%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Finterlace%2C1)









配置Advisor：

new QuestionAnswerAdvisor(vectorStore, SearchRequest.defaults()), // RAG

QuestionAnswerAdvisor可以在用户发起的提问时，先向数据库查询相关的文档，再把相关的文档拼接到用户的提问中，再让模型生成答案。那就是RAG的实现了。





   

 文档嵌入 

在上面的VectorStore配置中我们提供了EmbeddingModel，调用vectorStore.add(splitDocuments)底层会把文档给EmbeddingModel把文本变成向量然后再存入向量数据库。



 文档查询 

调用vectorStore.similaritySearch(query)时同样会先把用户的提问给EmbeddingModel，将提问变成向量，然后与向量数据库中的文档向量进行相似度计算（cosine值）。

要注意：此时向量数据库不会回答用户的提问。要回答用户的提问需要指定advisor



指定advisor









 《基于RAG技术的个人知识库AI问答系统》实战 

不对外开放

前端（提供）：  Vue 3 + TypeScript + Vite    

后端： 

●Spring Boot: 3.4.2

●JDK: 17

●spring-ai: 1.0.0 GA

●spring-ai-alibaba: 1.0.0.2

●maven: 3.9.6

●Mysql 5.7

●Milvus(向量存储)

●LLM使用的通义千问

●对象存储使用阿里云OSS (文生图模型）



https://www.yuque.com/geren-t8lyq/ncgl94/ndw2tv9u6bu3zo2h?singleDoc# 《基于RAG技术的个人知识库AI问答系统》实战

拖拽文件至此或点击选择文件进行上传

文件支持PD,DOC,MD,EXCELTEX等,最大可上传10OMB

批量下载

请输入文件名称

全部上传

NODATA

10/PAGE

更新时间

批呈删除

TOTAL0

上传时间

搜索

文件名

文件名:请

序号

GOTO

操作

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750060429372-81d7966d-b83b-457d-8a79-9232641f4be9.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_46%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



你好!我是A助手,请问有什么可以帮助你的吗?

请输入您的问题.

清空对话

普通回答

RAG回答

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750060452904-049ad8c2-878a-49b1-96e3-7e3ccf85a691.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_46%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)





 模型RAG评测 

 模型理解力评测  

RAG 之所以广受欢迎，是因为它（基于检索到的真实资料）能够减少幻觉。然而， RAG 并不一定意味着幻觉会被完全消除。

 现实中出现事实性幻觉的常见场景 

**1**上下文提供了明确事实，但模型未读取或匹配，凭常识胡乱生成。

**2**模型“看”到的背景信息有限，但它仍然自信地“虚构”细节回答问题。

问：马云在阿里巴巴创办初期遇到了哪些具体困难？
RAG:马云，著名企业家，阿里巴巴创始人。
答A（幻觉）：
马云在阿里巴巴创立初期曾因办公楼失火导致数据全部丢失，团队一度陷入危机。

**3**多个相似案例混淆，模型输出了正确格式但内容错误的事实



怎么你确定是否有这些问题：

事实性的评估    



评估器主要用于以下场景：

1开发和测试阶段：在集成测试中验证 RAG 系统的质量 

2批量质量检查：对一批历史对话进行离线评估 

3系统监控：定期抽样评估生产环境中的对话质量，比如每100次对话评估1次

4模型验证：当更换 AI 模型或调整 RAG 配置时，用于验证新配置的效果



解决：

●高风险领域（医疗、法律、金融等）必须进行事实性幻觉定期评估

●限定上下文范围：通过系统提示词让模型明确只能在指定背景或文档内容中作答，禁止引用未检索到的信息。

**●**"回答不确定"机制 

**●**调整分数、定义精确RAG相似性搜索能力

 RAG幻觉评测 

当我们发现大模型回答的内容并没有按照检索的documents进行有效回答， 就可以通过这种方式进行测试，评估 AI 生成的响应的事实准确性。该评估器通过验证给定的语句（responseContent）是否在逻辑上得到提供的上下文（文档）的支持，帮助检测并减少 AI 输出中的错觉。

“responseContent”和“document”将提交给人工智能模型进行评估。目前已有更小、更高效的人工智能模型专门用于此目的，例如 Bespoke 的 Minicheck，与 GPT-4 等旗舰模型相比，它有助于降低执行这些检查的成本。Minicheck 也可通过 Ollama 使用。

什么时候需要用到：

●验证已构建的RAG系统的响应质量

●在集成测试中自动化质量检查

●调试和优化RAG配置时评估效果



经济舱75美元,豪华经济舱50美元,商务舱25美元.

EVALUATIONRESPONSEPASSTNUE,SCOREL.0,FEEDBACK

METADLATAEHY

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750393171415-ab39fd5d-e127-4c49-94eb-0af9f51be3c3.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_28%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



query = "我叫什么名字";  

EVALUATIONRESPONSEPASSEFALSE,SCOREEU0

METADATAEH

FEEDBACKE

不知道.

![image.png](https://cdn.nlark.com/yuque/0/2025/png/22309163/1750393227492-de8a71f7-a330-4466-8e2e-6578cea525f7.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_29%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 观测性 

 为什么Spring AI应用急需可观测性？ 

 AI服务成本失控的痛点 

在企业级AI应用中，使用DeepSeek、OpenAI、Google Gemini或Azure OpenAI等服务时，成本控制是一个严峻挑战：

●• Token消耗不透明：无法精确了解每次AI调用的成本

●• 费用增长失控：大规模应用中，AI服务费用可能呈指数级增长

●• 性能瓶颈难定位：AI调用链路复杂，问题排查困难

●• 资源使用不合理：缺乏数据支撑的优化决策

 Spring AI可观测性的价值 

Spring AI的可观测性功能为这些痛点提供了完美解决方案：

●• ✅ 精准Token监控：实时追踪输入/输出Token消耗，精确到每次调用

●• ✅ 智能成本控制：基于使用统计制定成本优化策略

●• ✅ 深度性能分析：识别AI调用瓶颈，优化响应时间

●• ✅ 完整链路追踪：端到端记录请求在Spring AI应用中的完整流转

 实战演练：构建可观测的Spring AI翻译应用 

 第一步：Spring AI项目初始化 

在start.spring.io[1]创建Spring Boot项目，集成Spring AI核心依赖：

Maven依赖配置（Spring AI BOM管理）：



 第二步：Spring AI客户端配置 

主应用类配置：



Spring AI配置文件：



环境变量设置：

export DEEPSEEK_API_KEY=your-deepseek-api-key

 第三步：构建Spring AI翻译服务 

智能翻译控制器：



 第四步：Spring AI翻译API测试 



 Spring AI监控指标深度解析 

 核心指标1：Spring AI操作性能监控 

指标端点：/actuator/metrics/spring.ai.chat.client



业务价值：

●• 监控Spring AI翻译服务调用频次

●• 分析Spring AI响应时间分布

●• 识别Spring AI性能瓶颈

 核心指标2：Spring AI Token使用量精准追踪 

指标端点：/actuator/metrics/gen_ai.client.token.usage



成本控制价值：

●• 精确计算Spring AI服务成本

●• 优化Prompt设计降低Token消耗

●• 制定基于使用量的预算策略

 Agent应用 

什么是ai agent: 

你给个任务，它自己拆分、规划、调用资源、执行链路，直到返回结果。

你给个任务，它自己规划（根据你指定的规划方式）、拆分（根据你指定的拆分方式）、调用资源（根据你提供的资源）、（自动）执行链路，直到返回结果。

 1[评估优化器模式](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/evaluator-optimizer)(evaluator-optimizer) 

根据任务-->生成信息--->通过评估器不断完善--->最终输出结果

![img](https://raw.githubusercontent.com/spring-io/spring-io-static/refs/heads/main/blog/tzolov/20250520/anthropic-augmented-llm-agents.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



这个模式实现了双 LLM 过程，其中一个模型生成响应，另一个模型在迭代循环中提供评估和反馈

1生成器 LLM 为给定任务产生初始解决方案

2评估器 LLM 根据质量标准评估解决方案

3如果解决方案通过评估，则作为最终结果返回

4如果需要改进，反馈被纳入新的生成周期

5重复该过程直到达到满意的解决方案



示例代码：







1 一个模型作为由浅入深的代码生成器

2另一个模型作为性能分析员

3一直优化直到最佳







 2[路由模式](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/routing-workflow)(routing-workflow) 

模式能够根据用户请求和上下文的分类将输入智能路由到专门的处理程序。

![img](https://camo.githubusercontent.com/f24087710985a7d76000aab04f083eefcc7460fb965c9f2bac6ca0783329c5c3/68747470733a2f2f7777772e616e7468726f7069632e636f6d2f5f6e6578742f696d6167653f75726c3d68747470732533412532462532467777772d63646e2e616e7468726f7069632e636f6d253246696d61676573253246347a727a6f76626225324677656273697465253246356330633065396665346465663062353834633034643337383439393431646135356535653731632d3234303178313030302e706e6726773d3338343026713d3735?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



这个工作流特别适用于复杂任务，其中：

●路由器LLM: 通过设置提示词进行路由规则设定，由usermessage决定路由的分支。  

●分类可以通过 LLM 或业务代码进行处理

●不同类型的输入需要不同的专门处理或专业知识

 

 



 3[编排工作者](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/orchestrator-workers)(orchestrator-workers) 

这种模式是一种灵活的方法，用于处理需要动态任务分解和专门处理的复杂任务 manus就是这个模式

![img](https://camo.githubusercontent.com/953d1b88a05e93e1707bc955924cff7742b408515af0df34c4790c2a27f60131/68747470733a2f2f7777772e616e7468726f7069632e636f6d2f5f6e6578742f696d6167653f75726c3d68747470732533412532462532467777772d63646e2e616e7468726f7069632e636f6d253246696d61676573253246347a727a6f76626225324677656273697465253246383938356663363833666165343738306662333465616231333635616237386337653531626338652d3234303178313030302e706e6726773d3338343026713d3735?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



该模式包含三个主要组件：

●编排器（Orchestrator）：分析任务并确定所需子任务的LLM

●工作者（Workers）：执行特定子任务的专门 LLM

●合成器（Synthesizer）：将工作者输出合并为最终结果的组件





测试







 4[链接](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/chain-workflow)（chain-workflow） 

该模式将复杂的任务分解为一系列步骤，其中每个 LLM 调用都会处理前一个调用的输出。

![img](https://camo.githubusercontent.com/093824e1ad0326017ab84b949bb2eafd5b3f28bbd8b55447f9a488a57f7c7701/68747470733a2f2f7777772e616e7468726f7069632e636f6d2f5f6e6578742f696d6167653f75726c3d68747470732533412532462532467777772d63646e2e616e7468726f7069632e636f6d253246696d61676573253246347a727a6f76626225324677656273697465253246373431383731396533646162323232646363623337396238383739653164633038616433346337382d3234303178313030302e706e6726773d3338343026713d3735?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)





这种模式特别适用于：

●具有清晰顺序步骤的任务

●当您愿意用延迟换取更高准确性时

●每个步骤都建立在前一步输出基础上的场景

使用场景

常见应用包括：

●数据转换管道

●多步骤文本处理

●结构化步骤的文档生成



与 orchestrator-workers 或 evaluator-optimizer 模式不同，链式工作流不是基于多个独立的 LLM 角色协作，而是通过单一的处理链条，每个步骤都建立在前一步的输出基础上



代码



测试





 5[并行化](https://github.com/spring-projects/spring-ai-examples/tree/main/agentic-patterns/parallelization-worflow)（parallelization-workflow） 

该模式对于需要并行执行 LLM 调用并自动进行输出聚合的情况很有用。

deepseek   MoE 多专家  多路并行  

![img](https://camo.githubusercontent.com/c0614dadbbcee40b9cb94111644400106384ee6254e83275cd11091824197c1f/68747470733a2f2f7777772e616e7468726f7069632e636f6d2f5f6e6578742f696d6167653f75726c3d68747470732533412532462532467777772d63646e2e616e7468726f7069632e636f6d253246696d61676573253246347a727a6f76626225324677656273697465253246343036626230333263613030376664313632346632363161663731376437306536636138363238362d3234303178313030302e706e6726773d3338343026713d3735?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_68%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10)



并行化工作流模式通过并发处理多个 LLM 操作来提高效率，主要有两种变体：

1分段处理（Sectioning）：将复杂任务分解为独立的子任务并行处理

2投票机制（Voting）：对同一任务运行多次以获得不同视角或进行多数投票

使用场景

该模式特别适用于：

●处理大量相似但独立的项目

●需要多个独立视角的任务

●处理时间关键且任务可并行化的场景

  





  



 agent实战《手写manus》 

 效果展示 

话不多说，先看运行效果，以下是我们通过几个实际问答记录展示的 Spring AI Alibaba OpenManus 实际使用效果。

**1**打开百度浏览器，在搜索框输入：阿里巴巴最最近一周股价，根据搜索到的信息绘制最近一周的股价趋势图并保存到本地目录。

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753361269042-5aa48e61-f6f5-49ff-9c33-5262cb61396f.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_43%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



**1**我计划在接下来的五一劳动节假期到韩国旅行，行程是从杭州出发到韩国首尔，总预算为10000元。我想体验韩国的风土人情、文化、普通老百姓的生活，总行程计划为5天。请提供详细的行程并制作成一个简单的HTML旅行手册，其中包含地图、景点描述、基本的韩语短语和旅行提示，以供我在整个旅程中参考。

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753361269161-8ce376b1-af1b-4608-a9ed-f37c786956d2.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_43%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



**1**在本机的/tmp/docs目录下有一些中文文档 ，请依次将这些文档翻译为中文并保存到一个独立文件，将新生成的文件都存放到/tmp/endocs目录下

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753361269183-f3a033ea-b70d-464c-853a-f1cb326cf15e.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_43%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



 总体架构与原理 

Spring AI Alibaba Openmanus 与 Python 版本 OpenManus 设计理念相似，其总体架构如下图所示。

![img](https://cdn.nlark.com/yuque/0/2025/png/22309163/1753361269182-043dee63-8a81-4e7e-bf18-609c0108d6f4.png?x-oss-process=image%2Fwatermark%2Ctype_d3F5LW1pY3JvaGVp%2Csize_35%2Ctext_5b6Q5bq26ICB5biI%2Ccolor_FFFFFF%2Cshadow_50%2Ct_80%2Cg_se%2Cx_10%2Cy_10%2Fformat%2Cwebp)



分析上图架构，我们可以把它看作是一款多 Agent 智能自动协作实现，其中：

●Planning Agent 负责任务的分解与规划，将用户问题拆解成几个可顺序执行的 step。planning agent 调用 planning tool 动态生成一个串行的 Manus Agent 子工作流。

●多个 Manus Agent 组成一个链式、可顺序依次执行的子工作流。子工作流中的每个 agent 对应上述规划的一个 step，每个 agent 都是一个 ReAct 架构设计，即通过多轮 Tool 调用完成具体子任务。

●Summary Agent 用来做最后的任务总结









  