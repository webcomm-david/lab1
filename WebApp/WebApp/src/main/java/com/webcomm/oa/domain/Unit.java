package com.webcomm.oa.domain;

import java.io.Serializable;
import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "UNIT")
public class Unit implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8079984345519066909L;

	@Id
	@Column(name = "UNIT_ID")
	private String unitId;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(mappedBy = "unit")
	private List<Employee>emps = new ArrayList<>();

	public String getUnitId() {
		return unitId;
	}

	public void setUnitId(String unitId) {
		this.unitId = unitId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Unit [unitId=" + unitId + ", name=" + name + ", emps=" + emps + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((unitId == null) ? 0 : unitId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Unit other = (Unit) obj;
		if (unitId == null) {
			if (other.unitId != null)
				return false;
		} else if (!unitId.equals(other.unitId))
			return false;
		return true;
	}

	

	
	
	
}
