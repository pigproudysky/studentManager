package com.nico.student.bean;

import java.math.BigDecimal;

public class Student{
	
	private Integer id;
	private String sn;
	private String name;
	private String password;
	private Integer clazz_id;
	private String sex;
	private String mobile;
	private String qq;
	//`photo` mediumblob,
	
	private BigDecimal amount;
	private Integer integral;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getClazz_id() {
		return clazz_id;
	}
	public void setClazz_id(Integer clazz_id) {
		this.clazz_id = clazz_id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public Integer getIntegral() {
		return integral;
	}
	public void setIntegral(Integer integral) {
		this.integral = integral;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", sn=" + sn + ", name=" + name + ", password=" + password + ", clazz_id=" + clazz_id
				+ ", sex=" + sex + ", mobile=" + mobile + ", qq=" + qq + ", amount=" + amount + ", integral=" + integral
				+ "]";
	}
	
	
	
}
