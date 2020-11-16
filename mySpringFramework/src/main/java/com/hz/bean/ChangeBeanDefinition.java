package com.hz.bean;

import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-10-10
 */
@Component
public class ChangeBeanDefinition {
	private String name="default color";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
