package com.hz.aspect;


import com.hz.annotation.TrimField;
import com.hz.annotation.TrimType;
import com.hz.annotation.TrimValidate;
import org.apache.commons.lang3.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hz
 * @Description:
 * @create 2021-02-25
 */
@Aspect
@EnableAspectJAutoProxy
public class TrimDTOAspect {
    //针对 controller包下所有controller方法 进行拦截
//    @Pointcut("execution(* com.hz.controller.*.*(..))")
//    public void pointCut() {
//
//    }

    //针对注解切面拦截
    @Pointcut("@annotation(com.hz.annotation.TrimStr)")
    public void pointCut() {

    }


    @Before("pointCut()")
    public void before(JoinPoint point) {
        //放置需要 trim的参数 Map
        Map<Integer, Object> paramTrimMap = new HashMap<>(16);

        MethodSignature signature = (MethodSignature) point.getSignature();
        Annotation[][] parameterAnnotations = signature.getMethod().getParameterAnnotations();
        Object[] args = point.getArgs();
        if (args.length > 0) {
            for (Annotation[] parameterAnnotation : parameterAnnotations) {
                //获取当前参数下标
                int paramIndex = ArrayUtils.indexOf(parameterAnnotations, parameterAnnotation);
                //当前参数下标下 对应的所有注解
                for (Annotation annotation : parameterAnnotation) {
                    //含有ObjectTrim注解的，标记为 要参数进行 trim
                    if (annotation instanceof TrimValidate) {
                        paramTrimMap.put(paramIndex, args[paramIndex]);
                    }
                }
            }
            if (!paramTrimMap.isEmpty()) {
                paramTrimMap.entrySet().forEach(entity -> {
                    try {
                        dealWith(entity.getValue());
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new RuntimeException();
                    }
                });
            }
        }


    }

    private void dealWith(Object arg) throws Exception {
        Class<?> aClass = arg.getClass();
        boolean typeTrim = aClass.isAnnotationPresent(TrimType.class);
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field field : declaredFields) {
            if (field.getType().toString().equalsIgnoreCase("class java.lang.String")) {
                if(typeTrim){
                    //对所有字段 trim处理
                    Method method = aClass.getMethod(findGetterMethodName(field));
                    Object o = method.invoke(arg);
                    if (o != null) {
                        String s = String.valueOf(o);
                        field.setAccessible(true);
                        field.set(arg, s.trim());
                    }
                }else if (field.isAnnotationPresent(TrimField.class)) {
                    //对字段 trim处理
                    Method method = aClass.getMethod(findGetterMethodName(field));
                    Object o = method.invoke(arg);
                    if (o != null) {
                        String s = String.valueOf(o);
                        field.setAccessible(true);
                        field.set(arg, s.trim());
                    }
                }
            }

        }
    }

    private String findGetterMethodName(Field field) {
        //getOrderName()
        return "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
    }

}
