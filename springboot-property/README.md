# springboot-springboot-property
1. springboot 深入分析 @EnableConfigurationProperties 注解源码
2. 模拟@ConfigurationProperties ，通过实现BeanPostProcessor 将配置文件中的属性值读入到配置对象中
3. 模拟@EnableConfigurationProperties ，自写一个 @EnableHumanBeanProperties 将配置文件中的属性值。
通过 registrar类 初始化配置类对象到spring容器
