package com.hz.singleTon.app;

import com.hz.singleTon.bean.MyImportSelector;
import com.hz.singleTon.bean.Student;
import org.springframework.context.annotation.*;

/**
 * @author hz
 * @create 2020-09-29
 */
@Configuration
@ComponentScan("com")
@ImportResource("classpath:/spring.xml")
@Import(MyImportSelector.class)
public class Appconfig {

	//多个别名 dd为主名 ee为别名
	@Bean({"dd","ee"})
	public Student getStudent(){
		return new Student();
	}
}
