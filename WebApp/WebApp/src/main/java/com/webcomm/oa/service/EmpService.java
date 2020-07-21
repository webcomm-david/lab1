package com.webcomm.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.webcomm.oa.domain.Employee;
import com.webcomm.oa.repository.EmpRepository;
@Service
public class EmpService {
	@Autowired
	EmpRepository empRepository;
	
	public List<Employee> getAll(){
		return (List<Employee>) empRepository.findAll();
	}	
	public Employee getOne(String id) {
		return empRepository.findByEmpId(id);
	}
	
	public Employee getOneByName(String name) {
		if(name != null) {
			return empRepository.findByEmpName(name);
		}
		return null;
	}
	
	
	
}
