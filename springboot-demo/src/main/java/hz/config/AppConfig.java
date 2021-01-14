package hz.config;

import com.hz.interf.EnableRedis;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author hz
 * @create 2021-01-14
 */
@Configuration
@EnableRedis()
//web项目启动的话、@PropertySource("classpath:/application.properties") 该行可以注释
@PropertySource("classpath:/application.properties")
public class AppConfig {

}
