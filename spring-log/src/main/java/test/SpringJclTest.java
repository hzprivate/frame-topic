package test;

import app.Appconfig;
import dao.QueryDao;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * spring中含有 spring-jcl  重写了 commons-logging jcl包。
 * 源码内部通过 如下 switch case 获取 对应的日志实现
 *  switch(logApi) {
 *         case LOG4J:
 *             return LogFactory.Log4jDelegate.createLog(name);
 *         case SLF4J_LAL:
 *             return LogFactory.Slf4jDelegate.createLocationAwareLog(name);
 *         case SLF4J:
 *             return LogFactory.Slf4jDelegate.createLog(name);
 *         default:
 *             return LogFactory.JavaUtilDelegate.createLog(name);
 *         }
 *
 * 静态初始化 默认jul  如果检查到其他日志实现，就会替换 ,LogApi==JUL,LOG4J(此为log4j2),SLF4J_LAL,SLF4J,;
 *  static {
 *         logApi = LogFactory.LogApi.JUL;
 *         ClassLoader cl = LogFactory.class.getClassLoader();
 *
 *         try {
 *             cl.loadClass("org.apache.logging.log4j.spi.ExtendedLogger");
 *             logApi = LogFactory.LogApi.LOG4J;
 *         } catch (ClassNotFoundException var6) {
 *             try {
 *                 cl.loadClass("org.slf4j.spi.LocationAwareLogger");
 *                 logApi = LogFactory.LogApi.SLF4J_LAL;
 *             } catch (ClassNotFoundException var5) {
 *                 try {
 *                     cl.loadClass("org.slf4j.Logger");
 *                     logApi = LogFactory.LogApi.SLF4J;
 *                 } catch (ClassNotFoundException var4) {
 *                     ;
 *                 }
 *             }
 *         }
 *
 *     }
 * @author hz
 * @create 2020-11-11
 */
public class SpringJclTest {
    //jul-to-slf4j是个意外例外，毕竟JDK自带的logging包排除不掉啊,
    // 其实是利用jul的Handler机制，在root logger上install一个handler，
    // 将所有日志劫持到slf4j上。要使得jul-to-slf4j生效，需要执行如下static代码
    static {
        SLF4JBridgeHandler.removeHandlersForRootLogger();
        SLF4JBridgeHandler.install();
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context
                = new AnnotationConfigApplicationContext(Appconfig.class);
        QueryDao queryDao = (QueryDao) context.getBean("queryDao");
        JulTest.main(null);
    }
}
