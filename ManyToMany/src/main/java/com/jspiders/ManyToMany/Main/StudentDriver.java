package com.jspiders.ManyToMany.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.ManyToMany.bean.StudentBean;
import com.jspiders.ManyToMany.config.StudentConfig;

public class StudentDriver {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig.class);

		StudentBean student1 = context.getBean(StudentBean.class);
		System.out.println(student1);
		((AnnotationConfigApplicationContext) context).close();
	}
}
