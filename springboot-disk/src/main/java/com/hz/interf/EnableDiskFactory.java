package com.hz.interf;

import com.hz.autoconfigure.DiskFactoryImportSelector;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author hz
 * @create 2021-02-05
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import(DiskFactoryImportSelector.class)
public @interface EnableDiskFactory {
    Class<?>[] classes();
}
