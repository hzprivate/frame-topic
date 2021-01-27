# maven-proxy-custom
1. 什么是代理？ 增强一个对象的功能。  

2. 静态代理：
    - 2.1 继承:代理对象继承目标对象。重写需要增强的方法。
    - 2.2 聚合:代理对象和目标对象实现同一个接口。代理对象包含目标对象。
    - 静态代理区别：都会产生类爆炸。不确定情况下不要使用。

3. jdk动态代理是基于接口。cglib代理是基于继承。jdk 代理对象是因为本身继承了 Proxy对象所以无法继承只能实现共同的接口。

4. 自模拟jdk动态代理底层如何实现。 字符串-> java文件（io实现） ->class对象（通过第三方编译技术）
-> new 一个对象 （UrlClassLoader把动态编译的类加载到jvm 最后通过反射 class生成类的实例）

5. 真正jdk动态代理底层实现： 通过接口反射得到字节码（byte[]） 然后字节码转成class对象 （利用 native() 本地方法）

6. cglib和jdk动态代理 性能上并无多大区别。都是操作字节码。最后还是取决于业务是选择父类还是接口。

7. 自模拟jdk动态代理和cglib代理 源码注意事项
    - 7.1 jdk动态代理：通过 Proxy.newProxyInstance(类加载器、接口class[]、InvocationHandler实现类)
    InvocationHandler 实现类，持有目标对象，invoke()反射调用目标对象具体逻辑并且增强该对象方法。最终返回代理对象
    - 7.2 cglib代理：通过@Congiguration的配置类最后生成代理对象被注入到对象引用中。
    源码中可发现利用 Enhance enhance = new Enhance(); 以及enhance.setSuperClass，setCallback(MethodInterceptor的实现类)等
    对目标对象功能进行增强 ;enhance.create()生成代理对象
    