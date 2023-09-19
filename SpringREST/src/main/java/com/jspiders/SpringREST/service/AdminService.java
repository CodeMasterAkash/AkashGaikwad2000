package com.jspiders.SpringREST.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.SpringREST.pojo.AdminPOJO;
import com.jspiders.SpringREST.repository.AdminRepository;

@Service
public class AdminService {

	@Autowired
	private AdminRepository repository;

	public AdminPOJO createAccount(AdminPOJO pojo) {
		AdminPOJO admin = repository.createAccount(pojo);
		return admin;
	}

	public AdminPOJO login(AdminPOJO pojo) {
		AdminPOJO admin = repository.login(pojo);
		return admin;
	}

}
