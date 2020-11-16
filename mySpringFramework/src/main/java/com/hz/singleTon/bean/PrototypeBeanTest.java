package com.hz.singleTon.bean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * @author hz
 * @create 2020-10-12
 */
@Component
@Scope("prototype")

public class PrototypeBeanTest {
	private int i;
}
