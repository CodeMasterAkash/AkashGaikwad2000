package com.jspiders.ManyToMany.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {

	int id;
	String name;
	String email;
	String address;

	List<CourseBean> courses;
}
