package com.jspiders.springcore1.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore1.bean.StudentBean;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class StudentMain {

	public static void main(String[] args) {

		ApplicationContext context = new ClassPathXmlApplicationContext("StudentConfig.xml");

		StudentBean student1 = (StudentBean) context.getBean("student1");
		System.out.println(student1);
		((ClassPathXmlApplicationContext) context).close();

	}
}
