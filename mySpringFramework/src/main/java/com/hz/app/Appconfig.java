package com.hz.app;

import com.hz.bean.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author hz
 * @create 2020-09-29
 */
@Configuration
@ComponentScan("com")
//@ImportResource("classpath:/spring.xml")
public class Appconfig {

	//多个别名 dd为主名 ee为别名
	@Bean({"dd","ee"})
	public Student getStudent(){
		return new Student();
	}
}
