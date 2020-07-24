package com.webcomm.oa.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.webcomm.oa.data.CaseMonitorLevelEnum;
import com.webcomm.oa.data.CaseTypeEnum;
import com.webcomm.oa.util.MonitorLevelEnumConverter;
@Entity
@Table(name = "CASE_REQ")
public class CaseReq implements Serializable{
	

	private static final long serialVersionUID = 9070818169722348609L;

	@Id
	@Column(name = "CASE_NO")
	private String caseNo;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_EMP_ID", 
				referencedColumnName = "EMP_ID",
				nullable = false
				)
	private Employee managerEmp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTACT_EMP_ID", 
				referencedColumnName = "EMP_ID", 
				nullable = false
				)
	private Employee contactEmp;
	
	@Column(name = "WORK_ITEM_DESC", nullable = true)
	private String workItemDesc;
	
	@Column(name = "START_DATE", insertable = false, nullable = false)
	private java.sql.Timestamp startDate;
	
	@Column(name = "END_DATE", insertable = false, nullable = false)
	private java.sql.Timestamp endDate;
	@Enumerated()
	@Column(name = "TYPE", nullable = false)
	private CaseTypeEnum type;
	@Enumerated
	@Column(name = "MONITOR_LEVEL", nullable = false)
	private CaseMonitorLevelEnum monitorLevel;
	public String getCaseNo() {
		return caseNo;
	}
	public void setCaseNo(String caseNo) {
		this.caseNo = caseNo;
	}
	public Employee getManagerEmp() {
		return managerEmp;
	}
	public void setManagerEmp(Employee managerEmp) {
		this.managerEmp = managerEmp;
	}
	public Employee getContactEmp() {
		return contactEmp;
	}
	public void setContactEmp(Employee contactEmp) {
		this.contactEmp = contactEmp;
	}
	public String getWorkItemDesc() {
		return workItemDesc;
	}
	public void setWorkItemDesc(String workItemDesc) {
		this.workItemDesc = workItemDesc;
	}
	public java.sql.Timestamp getStartDate() {
		return startDate;
	}
	public void setStartDate(java.sql.Timestamp startDate) {
		this.startDate = startDate;
	}
	public java.sql.Timestamp getEndDate() {
		return endDate;
	}
	public void setEndDate(java.sql.Timestamp endDate) {
		this.endDate = endDate;
	}
	public CaseTypeEnum getType() {
		return type;
	}
	public void setType(CaseTypeEnum type) {
		this.type = type;
	}
	public CaseMonitorLevelEnum getMonitorLevel() {
		return monitorLevel;
	}
	public void setMonitorLevel(CaseMonitorLevelEnum monitorLevel) {
		this.monitorLevel = monitorLevel;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "CaseReq [caseNo=" + caseNo + ", managerEmp=" + managerEmp + ", contactEmp=" + contactEmp
				+ ", workItemDesc=" + workItemDesc + ", startDate=" + startDate + ", endDate=" + endDate + ", type="
				+ type + ", monitorLevel=" + monitorLevel + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caseNo == null) ? 0 : caseNo.hashCode());
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
		CaseReq other = (CaseReq) obj;
		if (caseNo == null) {
			if (other.caseNo != null)
				return false;
		} else if (!caseNo.equals(other.caseNo))
			return false;
		return true;
	}

	
	
	
	
}
