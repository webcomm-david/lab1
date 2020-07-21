package com.webcomm.oa.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "UNIT")
public class Unit implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "UNIT_ID")
	private String UnitId;
	
	@Column(name = "NAME", nullable = false)
	private String Name;
	
	@OneToMany(mappedBy = "unit")
	private List<Employee>emps;

	public String getUnitId() {
		return UnitId;
	}

	public void setUnit_Id(String unitId) {
		UnitId = unitId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Unit [UnitId=" + UnitId + ", Name=" + Name + ", emps=" + emps + "]";
	}
	
	
}
