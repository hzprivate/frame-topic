# spring官方文档第一节 the ioc container 学习
1. xml中生成属性注入的几种方式：
    - 1.1 构造注入 
    - 1.2 set注入
    - 1.3 通过 xml中定义 autowire属性 自动装配注入可根据byName/byType自动识别类中属性name/class和已定义的bean对象是否相等去赋值
2. xml中 静态工厂方法 创建bean对象 生成bean对象
3. xml中 实例化工厂方法 从容器中调用现有bean的非静态方法来创建新bean
4. 互相循环依赖引用  stuent - sillyB  互相set注入  构造注入会循环引用报错
5. 在单例中引用了多例对象  
    - 5.1 @Lookup 查询方法 指定属性get方法
    - 5.2 放弃一部分控制反转，通过实现ApplicationContextAware接口，传递应用上下文对象，然后在bean对象方法中引用上下文对象，为属性赋值。无法通过set或构造注入

6. DefaultListableBeanFactory bean对象工厂 源码解析
7. AnnotationConfigApplicationContext() 源码解析
8. @ImportResource("classpath:/spring.xml")  等价于 new XmlBeanDefinitionReader(context).loadBeanDefinitions("spring.xml");
9. factoryBean和beanFactory区别: 
- org.springframework.beans.factory.FactoryBean 接口
- 在容器上调用getBean(“myBean”)将返回FactoryBean的产品，
而调用getBean(“&myBean”)将返回FactoryBean实例本身。
10. spring 扩展点之一 ：BeanFactoryPostProcessor后置处理器 ，可插手bean定义   BeanDefinitionRegistryPostProcessor（实现了BeanFactoryPostProcessor）可人为注册bd到容器
11. spring扩展点之一： BeanPostProcessor后置处理器  会对实例化对象前后分别调用方法
12. Import注解的作用:
    - 声明一个bean
    - 导入@Configuration注解的配置类
    - 导入ImportSelector的实现类 （返回全限定类名 赋值到 bd.beanClassName中）
    - 导入ImportBeanDefinitionRegistrar的实现类 (应用 @MapperScan)
    