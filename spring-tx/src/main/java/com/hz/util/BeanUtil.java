package com.hz.util;

import com.alibaba.fastjson.JSON;
import com.hz.config.DTOTrim;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author hz
 * @Description:
 * @create 2021-02-26
 */
public class BeanUtil {
    public static Object beanTrim(Object o) throws InvocationTargetException, IllegalAccessException {
        Map resultMap = new HashMap(16);
        Map paramMap = JSON.parseObject(JSON.toJSONString(o), Map.class);

        //判断需要trim的字段 放在set集合里
        Field[] declaredFields = o.getClass().getDeclaredFields();
        Set<String> fieldTrimSet = new HashSet<>();
        for (Field field : declaredFields) {
            String name = field.getName();
            if (field.isAnnotationPresent(DTOTrim.class)) {
                fieldTrimSet.add(name);
            }
        }

        //循环遍历 map 拿到所有值在trim
        Set<Map.Entry<String, String>> entryseSet = paramMap.entrySet();
        for (Map.Entry<String, String> entry : entryseSet) {
            if (fieldTrimSet.contains(entry.getKey())) {
                resultMap.put(entry.getKey(), entry.getValue() == null ? null : entry.getValue().trim());
            } else {
                resultMap.put(entry.getKey(), entry.getValue());
            }
        }

        return JSON.parseObject(JSON.toJSONString(resultMap), o.getClass());
    }

}
