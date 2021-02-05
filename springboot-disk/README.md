# springboot-springboot-disk
1. 简单开源整合springboot的抽离盘阵业务模块 -工厂策略模式分离业务
2. 利用spi机制进行业务选择性实例化到spring容器


4. 组件框架解决步骤：
    - 4.1 解决读取META-INF下的文件  -- 思路：@EnableAutoConfiguration源码查看如何读取某包下 spring.factories文件    
    - 4.2 读取到全路径名后，利用Class.forName() 反射生成Class对象。static初始化要做的
    try/catch判断是否含有，注册bd到spring容器
    - 4.3 通过外部Enable注解 import某个配置类，然后配置类中@Conditional 判断符合条件
    符合就注册到spring容器