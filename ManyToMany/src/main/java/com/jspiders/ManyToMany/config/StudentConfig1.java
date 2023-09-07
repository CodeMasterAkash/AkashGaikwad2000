package com.jspiders.ManyToMany.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.ManyToMany.bean.StudentBean;

public class StudentConfig1 {

	@Bean("student2")
	public StudentBean getStudent() {
		return new StudentBean(2, "Akash", "akash@gmail.com", null, null);
	}
}
