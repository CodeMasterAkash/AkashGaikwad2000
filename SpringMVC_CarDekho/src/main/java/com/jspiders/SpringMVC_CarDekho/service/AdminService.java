package com.jspiders.SpringMVC_CarDekho.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.SpringMVC_CarDekho.pojo.AdminPOJO;
import com.jspiders.SpringMVC_CarDekho.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAccount(String username, String password) {
		AdminPOJO admin = repository.createAccount(username, password);
		return admin;
	}

	public AdminPOJO getAdmin() {
		AdminPOJO pojo = repository.getAdmin();
		return pojo;
	}

	public AdminPOJO login(String username, String password) {
		AdminPOJO pojo = repository.login(username, password);
		return pojo;
	}

}
