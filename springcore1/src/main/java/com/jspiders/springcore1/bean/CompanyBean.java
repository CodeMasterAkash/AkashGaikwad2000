package com.jspiders.springcore1.bean;

import java.util.List;

import lombok.Data;

@Data
public class CompanyBean {

	int id;
	String name;
	List<EmployeeBean> employees;
}
