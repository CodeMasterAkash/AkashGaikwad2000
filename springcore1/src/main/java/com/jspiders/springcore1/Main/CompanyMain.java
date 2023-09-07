package com.jspiders.springcore1.Main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jspiders.springcore1.bean.CompanyBean;

public class CompanyMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("CompanyEmployeeConfig.xml");

		CompanyBean company1 = context.getBean(CompanyBean.class);
		System.out.println(company1);
		((ClassPathXmlApplicationContext) context).close();
	}
}
