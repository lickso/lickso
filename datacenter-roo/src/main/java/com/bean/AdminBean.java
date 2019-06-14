package com.bean;

import org.springframework.stereotype.Repository;

import java.io.Serializable;


@Repository("Admin")
public class AdminBean implements Serializable{
	private static final long serialVersionUID = 1L;

	private String adminId;
	private String name;
	private String sex;
	private String accessNum;
	private String password;
	private String startDate;
	private String doneDate;
	private String picture;
	private String remarks;
	private String state;
	private String ext_1;
	private String ext_2;
	private String ext_3;

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAccessNum() {
		return accessNum;
	}

	public void setAccessNum(String accessNum) {
		this.accessNum = accessNum;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getDoneDate() {
		return doneDate;
	}

	public void setDoneDate(String doneDate) {
		this.doneDate = doneDate;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getExt_1() {
		return ext_1;
	}

	public void setExt_1(String ext_1) {
		this.ext_1 = ext_1;
	}

	public String getExt_2() {
		return ext_2;
	}

	public void setExt_2(String ext_2) {
		this.ext_2 = ext_2;
	}

	public String getExt_3() {
		return ext_3;
	}

	public void setExt_3(String ext_3) {
		this.ext_3 = ext_3;
	}

}
