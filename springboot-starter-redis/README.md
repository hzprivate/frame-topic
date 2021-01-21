# springboot-springboot-starter-redis
1. 自实现redis组件与springboot框架集成 通过 @EnableRedis开启redis组件支持
2. 组件使用方式： 在@EnableRedis() 配置prefix前缀名称(可不配) 
    - 2.1 web项目中redis属性配置在application.yml/xml中
    - 2.2 非web项目需要在resources文件下自己写一个配置文件并用@PropertySource扫描配置文件
3. 在配置文件中名称为ip，port，num中。如果有前缀,例如"prefix=redis" ,就配置 redis.ip,...
4. 使用案例详情见 springboot-redis-demo
5. 注意：需提供jar包版本支持 
    -5.1 spring-boot-starter-web version: 2.0.3.RELEASE (其余版本没做测试,如果使用其余版本有问题，可自行修改源码适配)
    -5.2 jedis version：2.7.3
