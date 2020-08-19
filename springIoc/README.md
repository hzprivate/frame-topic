# maven-springioc
1.基于xml的 生成bean对象
2.基于注解 通过xml的包扫描 生成bena对象
3.基于java config（配置类）的 生成bean对象
4.xml，java config 混合使用
5.@Autowired 和 @Resource区别   1.@Autowired 先默认根据 byType寻找,没找到 再根据属性名byName查找 
例如：  private IndexDao indexDao2Impl;  @Resource默认根据 byName寻找 这两者都与set方法没关系
6.beanNameGenerator  自定义 spring bean name生成策略
7.@Scope 作用域
8.在单例中引用了多例对象  @Lookup  
