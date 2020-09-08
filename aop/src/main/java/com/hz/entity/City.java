package com.hz.entity;

import com.hz.annotiton.Entity;

/**
 * @author hz
 * @Description:
 * @create 2020-09-07
 */
@Entity(name = "city")
public class City {
    private String id;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
