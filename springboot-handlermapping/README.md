# springboot-springboot-handlermapping
1. 首先请求进入dispatcherServlet,去handlerMapping 提取对应的hanlder,handler找到对应的
handlerAdapter适配器，这时候开始调用hanler处理业务逻辑返回ModelAndView,这时候开始交给
viewResolver视图解析器，通过视图名称返回对应的视图。最后进行渲染返回。
2. handlerMappings 在dispatcherServlet.properties文件中事先维护，注册到beanFactory工厂
    - 2.1 BeanNameUrlHandlerMapping
    - 2.2 RequestMappingHandlerMapping
3. 我们用2种方式来注册controller 
    - 3.1 作为bean形式（走BeanNameUrlHandlerMapping） ,
    @Component("/test")以及implements org.springframework.web.servlet.mvc.Controller
    - 3.2 Annotation形式（走 RequestMappingHandlerMapping）
    @Controller
    
4. 总结：其实我们的SpringMVC关键的概念就在于Handler（处理器） 和Adapter(适配器)
      通过一个关键的HandlerMappings 找到合适处理你的Controller的Handler 然后再通过HandlerAdapters找到一个
      合适的HandlerAdapter 来执行Handler即Controller里面的逻辑。 最后再返回ModlAndView...
      
5. 源码解析
    1. 静态块初始化 DispacterServlet.java
    2. tomcat初始化servlet的init方法
    调用 org.springframework.web.servlet.HttpServletBean#initServletBean（servlet 的init）
    调用org.springframework.web.servlet.FrameworkServlet#initWebApplicationContext
    调用org.springframework.web.servlet.FrameworkServlet#onRefresh
    调用org.springframework.web.servlet.DispatcherServlet#initStrategies
    ```
    protected void initStrategies(ApplicationContext context) {
    initMultipartResolver(context);
    initLocaleResolver(context);
    initThemeResolver(context);
    initHandlerMappings(context);
    initHandlerAdapters(context);
    initHandlerExceptionResolvers(context);
    initRequestToViewNameTranslator(context);
    initViewResolvers(context);
    initFlashMapManager(context);
    }
    ```
    3. initHandlerMappings 初始化handlerMappings，在初始化adapters
    org.apache.catalina.core.StandardWrapper#instanceInitialized=true
    org.springframework.web.servlet.DispatcherServlet#doDispatch
    通过循环HandlerMapping来依次获取HandlerExecutionChain，因为spring当中存在的controller有多重形式，我
    们需要处理controller的需要通过HandlerExecutionChain来反射执行controller当中的方法，所以不同的
    controller需要new不同的HandlerExecutionChain，那么问题来了HandlerExecutionChain不知道你的
    controller是什么类型，但是HandlerMapping知道，所以HandlerExecutionChain的实例化必须依赖
    HandlerMapping
    org.springframework.web.servlet.DispatcherServlet#getHandler
    获取适配器？前面说过不同的controller会获取到不同的handler，那么不同的handler他是怎么实现处理不同的
    controller类型呢？spring的做法比较复杂，没有从代码去解决，而是使用了适配器，故而这里根据不同的handler
    或得到不同的适配器从而来处理其实就是反射调用controller当中的方法