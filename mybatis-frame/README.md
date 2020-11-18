# mybatis框架 学习
1. 单独的mybatis源码
2. spring整合的mybatis源码
3. @MapperScan() ：利用spring中的@Import 和ImportBeanDefinitionRegistrar
技术来对spring进行了扩展
4. 执行sql时，单独的mybatis和spring整合的mybatis流程：
    - 4.1：mybatis->SqlSession->defaultSqlSession#selectList---sql
    - 4.2 spring-mybatis -> SqlSession-> SqlSessionTemplate-> Sql
    SessionTemplate#selectList---Proxy.invoke ---selectList
5. mybatis 一级缓存问题：

6. spring是如何初始化mapper对象：

7.如何打印出 mybatis中的日志。 pom中引入 slfj-log4j绑定器，将日志绑定到log4j，
然后配置log4j.xml日志级别等级设为 DEBUG即可
    