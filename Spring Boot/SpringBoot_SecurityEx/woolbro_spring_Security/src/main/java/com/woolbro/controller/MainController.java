package com.woolbro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.woolbro.dao.WoolbroDAO;
import com.woolbro.model.Employees;

@RestController
@RequestMapping(path = "/woolbro")
public class MainController {

	@Autowired
	private WoolbroDAO dao;
	
	@GetMapping(path="/", produces="application/json")
	public Employees getEmployees() {
		return dao.getAllEmployees();
	}
}
