# 模拟springboot
1. springboot tomcat内嵌  （此处需注意 tomcat版本。本文只有tomcat8可以）   
2. 模拟视图解析器 ViewResolver
3. servlet 核心类 DispatcherServlet（请求sevlet）
4. 通过实现 ServletContainerInitializer 类重写onStartup() 方法，
去被tomcat执行，初始化容器
此处需注意，需要在resource文件夹下有META-INF.services文件夹。（详见spring-web.jar包）。
通过可插拔。动态的去加载ServletContainerInitializer类的实现类
5. spring官网 mvc，实现WebApplicationInitializer 类 覆盖onStartup() 。此处不同于上面需要指定，
可直接通过tomcat启动，加载spring
6. 模拟后台请求如何响应静态资源文件。通过FileInputStream 读取静态资源文件，在 response.getWriter().write出去