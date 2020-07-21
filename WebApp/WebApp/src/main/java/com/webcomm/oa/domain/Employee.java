package com.webcomm.oa.domain;

import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "EMP_ID")
	private String empId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "UNIT_ID", 
				referencedColumnName = "UNIT_ID",
				nullable = false
				)
	private Unit unit;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit unit) {
		this.unit = unit;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", unit=" + unit + "]";
	}

	
	
}
