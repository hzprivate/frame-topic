//package test;
//
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
//
///**
// * commons-logging.jar
// * jcl第三方  抽象门面模式， 底层会选择 如下日志顺序 实现  ,例如有log4j.jar 情况下，优先log4j；
// * {"org.apache.commons.logging.impl.Log4JLogger",
// * "org.apache.commons.logging.impl.Jdk14Logger",
// * "org.apache.commons.logging.impl.Jdk13LumberjackLogger",
// * "org.apache.commons.logging.impl.SimpleLog"
// * };
// * @author hz
// * @create 2020-11-11
// */
//public class JclTest {
//    public static void main(String[] args) {
//        Log jcl = LogFactory.getLog("jcl");
//        jcl.info("jcl");
//    }
//}
