package test;

import org.slf4j.LoggerFactory;

/**
 * slf4j-api.jar
 * 与jcl类似 都是抽象门面模式 底层通过switch case  选择项，选择 日志实现  默认 jul
 * 绑定器种类： slf4j-nop.jar（消除日志） slf4j-simple.jar, slf4j-log4j12.jar, slf4j-jdk14.jar or logback-classic.jar
 * 绑定器：例如 slf4j-jdk14  就可以绑定到 jul 日志实现  有些绑定器包内部会依赖 slf4j-api.jar,以及日志实现jar，不需要额外引入
 * 桥接器种类: jcl-over-slf4j.jar,log4j-over-slf4j.jar jul-to-slf4j.jar等
 * 桥接器: 这里引入桥接包时，jcl-over-slf4j or log4j-over-slf4j需要把原应用中依赖的的日志实现包剔除，(它们分别重新实现了JCL和log4j    )
 * 不然程序走不了 log4j-over-slf4j.jar 中的 log4j源码。依旧走 原log4j.jar，这样就法实现桥接。（重点）
 *
 *   //jul-to-slf4j是个意外例外，毕竟JDK自带的logging包排除不掉啊,
 *     // 其实是利用jul的Handler机制，在root logger上install一个handler，
 *     // 将所有日志劫持到slf4j上。要使得jul-to-slf4j生效，需要执行如下static代码
 *     static {
 *         SLF4JBridgeHandler.removeHandlersForRootLogger();
 *         SLF4JBridgeHandler.install();
 *     }
 *
 * @author hz
 * @create 2020-11-11
 */
public class Slf4jTest {
    public static void main(String[] args) {
        //测试绑定器
        //通过 什么类型的绑定器去获取什么类型的日志 Logger对象然后打印
        LoggerFactory.getLogger("slf4j").info("slf4j");

        //测试 slf4j 桥接器 是否统一输出日志实现
        Log4jTest.main(null);
        JulTest.main(null);
    }
}
