package test;

import java.util.logging.Logger;

/**
 * jdk自带日志实现
 * @author hz
 * @create 2020-11-11
 */
public class JulTest {
    public static void main(String[] args) {
        Logger.getLogger("jul").info("jul...");
    }
}
