package com.hz.interf;

import com.hz.registar.RedisConfRegistrar;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = RedisConfRegistrar.class)
public @interface EnableRedis {
    Class<?>[] value() default {};
    String prefix() default "";
}
