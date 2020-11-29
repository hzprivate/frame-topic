package com.hz.annotiton;

import com.hz.aware.MyPc;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
//在MyPc类上可以获取注解属性的值
@Import(MyPc.class)
public @interface AutoSetValueOnRefresh {
     String ip() default "127.0.0.1";
     String address() default "中国";

}
