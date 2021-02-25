package com.hz.aspect;

import com.hz.config.ObjectTrim;
import com.hz.util.BeanUtil;
import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hz
 * @Description:
 * @create 2021-02-25
 */
@Component
@Aspect
public class DTOTrimAspect {

    @Pointcut("execution(* com.hz.controller.*.*(..))")
    public void pointCut() {

    }


    @Around("pointCut()")
    public void before(ProceedingJoinPoint point) {
        Map<Integer,Object> paramTrimMap = new HashMap<>(16);
        try {
            MethodSignature signature = (MethodSignature) point.getSignature();
            Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
            Object[] args = point.getArgs();
            if (args.length > 0) {
                for (Annotation[] parameterAnnotation : parameterAnnotations) {
                    //获取当前参数下标
                    int paramIndex= ArrayUtils.indexOf(parameterAnnotations, parameterAnnotation);
                    //当前参数下标下 对应的所有注解
                    for (Annotation annotation : parameterAnnotation) {
                        //含有ObjectTrim注解的，标记为 要参数进行 trim
                        if (annotation instanceof ObjectTrim){
                            paramTrimMap.put(paramIndex,args[paramIndex]);
                        }
                    }
                }
                if (!paramTrimMap.isEmpty()) {
                    paramTrimMap.entrySet().forEach(entity->{
                        try {
                            args[entity.getKey()] = BeanUtil.beanTrim(entity.getValue());
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    });
                    //重新传参 执行方法
                    point.proceed(args);
                }
            }

        } catch (Throwable e) {
            e.printStackTrace();
        }
    }




}
