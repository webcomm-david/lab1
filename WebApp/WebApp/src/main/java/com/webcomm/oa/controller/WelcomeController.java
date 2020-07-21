package com.webcomm.oa.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webcomm.oa.domain.Employee;
import com.webcomm.oa.service.EmpService;

@Controller
public class WelcomeController {
	@Autowired
	EmpService empService;
	@Autowired
	DataSource dataSource;
	@RequestMapping("/index")
	public String index(Model model) {
		model.addAttribute("employee", empService.getOne("EMP01"));
		model.addAttribute("employee1", empService.getOneByName("王大明"));
		return "index";
	}
}
