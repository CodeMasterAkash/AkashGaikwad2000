package com.jspiders.ManyToMany.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.jspiders.ManyToMany.bean.StudentBean;
import com.jspiders.ManyToMany.config.StudentConfig1;

public class StudentMain1 {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(StudentConfig1.class);

		StudentBean student2 = (StudentBean) context.getBean("student2");
		System.out.println(student2);
		((AnnotationConfigApplicationContext) context).close();
	}
}
