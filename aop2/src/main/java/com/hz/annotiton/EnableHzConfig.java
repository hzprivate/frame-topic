package com.hz.annotiton;

import com.hz.app.HzConfig;
import com.hz.aware.MyPc;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(HzConfig.class)
public @interface EnableHzConfig {
}
