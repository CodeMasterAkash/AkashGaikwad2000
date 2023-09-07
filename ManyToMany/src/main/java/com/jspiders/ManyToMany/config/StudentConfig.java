package com.jspiders.ManyToMany.config;

import org.springframework.context.annotation.Bean;

import com.jspiders.ManyToMany.bean.StudentBean;

public class StudentConfig {

	@Bean
	public StudentBean getStudent() {
		StudentBean student1 = new StudentBean();
		student1.setId(1);
		student1.setName("Akash");
		student1.setEmail("akash@gmail.com");
		return student1;
	}
}
