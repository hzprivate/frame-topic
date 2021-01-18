package com.hz.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hz
 * @Description:
 * @create 2021-01-12
 */
//@ConfigurationProperties(prefix = "test")
//上面注解  可被 HumanBeanPostProcessor替代
public class HumanBean {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HumanBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                '}';
    }
}
