package com.maocy.entity;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {

	// 姓名
	@NotNull(message="name不能为空")
	@Size(min=1, max=5, message="name长度要大于等于1小于等于5")
	private String name;
	
	// 年龄
	@NotNull(message="age不能为空")
	@Digits(fraction = 0, integer = 3, message="年龄不能超过3位")
	private Integer age;
	
	// 性别
	@NotNull(message="sex不能为空")
	@Pattern(regexp="^[1|2]{1}$", message="性别错误!")
	private String sex; 
	
	// 邮箱
	@NotNull(message="email不能为空")
	@Pattern(regexp="\\w[-\\w.+]*@([A-Za-z0-9][-A-Za-z0-9]+\\.)+[A-Za-z]{2,14}", message="email格式错误！")
	private String email;
	
	// 手机号码
	@NotNull(message="phoneNumber不能为空")
	@Pattern(regexp="^[1](([3|5|8][\\d])|([4][5,6,7,8,9])|([6][5,6])|([7][3,4,5,6,7,8])|([9][8,9]))[\\d]{8}$", message="phoneNumber格式错误！")
	private String phoneNumber;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", sex=" + sex + ", email=" + email + ", phoneNumber="
				+ phoneNumber + "]";
	}
}
