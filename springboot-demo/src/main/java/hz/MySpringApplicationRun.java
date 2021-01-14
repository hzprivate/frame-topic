package hz;

import com.hz.interf.EnableRedis;
import com.hz.redis.RedisClient;
import hz.config.AppConfig;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hz
 * @Description:
 * @create 2021-01-12
 */
@SpringBootApplication
@PropertySource("classpath:/application.properties")//（web项目该行省略）
@EnableRedis()
public class MySpringApplicationRun {
    public static void main(String[] args) {
        //非web项目启动  初始化spring容器
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MySpringApplicationRun.class);
        RedisClient.set("name","hz");
        System.out.println(RedisClient.get("name"));
    }
}
