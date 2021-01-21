package com.hz;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author hz
 * @create 2020-09-21
 */
public class BeanFactory {
    //解析xml
    public Map<String,Object> parseXml(String xml){
        SAXReader reader = new SAXReader();
        try {
            //定义spring map容器（包含所有bean对象）
            Map<String,Object> reslutMap = new HashMap(16);
            //获取项目工程中 spring.xml文件路径
            String springXmlUrl = this.getClass().getResource(xml).getFile();
            File file = new File(springXmlUrl);
            //通过file 形式读取xml文件 生成Document对象
            Document document = reader.read(file);
            //获取<beans>标签对象
            Element rootElement = document.getRootElement();

            for(Iterator<Element> iterator = rootElement.elementIterator();iterator.hasNext();){
                Object o = null;
                //获取 <bean> 一级标签对象
                Element firstElement = iterator.next();
                //获取<bean> 标签中的 id属性值 和 class属性值
                String id = firstElement.attribute("id").getValue();
                //获取全限定路径名称
                String className = firstElement.attribute("class").getValue();
                //通过全限定路径名称反射生成class对象
                Class<?> clazz = Class.forName(className);

                //对象依赖注入 思路判断
                //1.类中是否含有属性。2.xml是否含有 property或 constructor-arg标签
                Field[] declaredFields = clazz.getDeclaredFields();
                if(declaredFields != null && declaredFields.length>0){
                    //获取二级标签 <property>对象
                    Element secondElementProperty = firstElement.element("property");
                    // setter注入  判断
                    if(secondElementProperty != null){
                        o = clazz.newInstance();
                        for (Field declaredField : declaredFields) {
                            String name = secondElementProperty.attribute("name").getValue();
                            if(name.equals(declaredField.getName())){
                                //属性名和xml中name定义名称相同
                                String refClazzName = secondElementProperty.attribute("ref").getValue();
                                Object ref = reslutMap.get(refClazzName);
                                if(ref != null){
                                    //map中含有 该ref依赖对象名称
                                    //set方法注入
                                    declaredField.setAccessible(true);
                                    declaredField.set(o,ref);
                                }
                            }

                        }

                    }
                    //获取二级标签 <constructor-arg>对象
                    Element secondElementConst = firstElement.element("constructor-arg");
                    //构造器注入判断
                    if(secondElementConst != null){
                        for (Field declaredField : declaredFields) {
                            String name = secondElementConst.attribute("name").getValue();
                            if(name.equals(declaredField.getName())){
                                //属性名和xml中name定义名称相同
                                String refClazzName = secondElementConst.attribute("ref").getValue();
                                Object ref = reslutMap.get(refClazzName);
                                if(ref != null){
                                    //map中含有 该ref依赖对象
                                    //constructor 方法注入
                                    //因为代码里只有一个构造器 所以[0] 获取第一个
                                    Constructor<?> declaredConstructor = clazz.getDeclaredConstructors()[0];
                                    o = declaredConstructor.newInstance(ref);
                                }
                            }

                        }

                    }


                }else{
                    //无依赖注入  直接反射生成对象
                    o = clazz.newInstance();
                }

                reslutMap.put(id,o);
            }
            return reslutMap;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    //获取bean对象
    public Object getBean(String name){
        Map<String, Object> map = parseXml("/spring.xml");
        Object o = map.get(name);
        return o;
    }
}
