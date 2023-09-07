package com.jspiders.ManyToMany.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.ManyToMany.bean.StudentBean;

public class StudentMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("CourseStudentConfig.xml");

		StudentBean student1 = context.getBean(StudentBean.class);
		StudentBean student2 = context.getBean(StudentBean.class);

		System.out.println(student1);
		System.out.println(student2);
		((ClassPathXmlApplicationContext) context).close();
	}
}
