package com.hz.annotation;

import com.hz.aspect.TrimDTOAspect;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Import(value = TrimDTOAspect.class)
public @interface EnableTrimStr {
}
