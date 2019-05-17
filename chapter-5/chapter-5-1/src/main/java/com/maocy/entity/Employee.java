package com.maocy.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;

public class Employee {

	@NotNull
	private String name;
	
	@NotNull
	@Digits(fraction = 1, integer = 2)
	private Integer age;
	
	@NotNull(message="sex不能为空")
	private String sex;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}
}
