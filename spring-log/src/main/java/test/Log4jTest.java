package test;

import org.apache.log4j.Logger;

/**
 * log4j.jar
 * 需要 log4j.properties 配置文件搭配 放在 类路径下
 * @author hz
 * @create 2020-11-11
 */
public class Log4jTest {
    public static void main(String[] args) {
        Logger log4j = Logger.getLogger("log4j");
        log4j.info("log4j...");
    }
}
