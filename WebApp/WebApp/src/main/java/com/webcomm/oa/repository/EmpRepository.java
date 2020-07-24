package com.webcomm.oa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webcomm.oa.domain.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, String>{	
//	Employee findByEmpId(@Param("empId") String empId);
	
	@Query(value = "select e from Employee e where e.name =?1")
	Employee findByEmpName(String name);
	
	Employee findByEmpId(String empId);
	
}
