# ReadingList
采用SpringBoot2+gradle+Thymeleaf构建一个读书清单记录。

【2018-11-17】重构代码，调整结构，简化controller代码，启用hikari数据连接池。后期如果可能的话，改成前后端分离，前端重新调整（确实太丑了），后端改成提供REST服务。

## 前言

提样一下Java后端渲染前端页面，采用springboot2中推荐使用thymeleaf模板引擎。简单写了一个读书清单记录，很简陋，主要实现登录注册，读书记录功能，界面没怎么调，全用Bootstrap的组件。



## 界面展示

首页

![](./screenshot/index.png)

登录注册：

![](./screenshot/login.png)

读书记录页：

![](./screenshot/reading.png)