package com.webcomm.oa.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.webcomm.oa.data.CaseMonitorLevelEnum;
import com.webcomm.oa.data.CaseTypeEnum;
import com.webcomm.oa.util.MonitorLevelEnumConverter;
@Entity
@Table(name = "CASE_REQ")
public class CaseReq implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "CASE_NO")
	private String caseNO;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "MANAGER_EMP_ID", 
				referencedColumnName = "EMP_ID",
				nullable = false
				)
	private Employee ManagerEmp;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CONTACT_EMP_ID", 
				referencedColumnName = "EMP_ID", 
				nullable = false
				)
	private Employee ContactEmp;
	
	@Column(name = "WORK_ITEM_DESC", nullable = true)
	private String WorkItemDesc;
	
	@Column(name = "START_DATE", insertable = false, nullable = false)
	private java.sql.Timestamp StartDate;
	
	@Column(name = "END_DATE", insertable = false, nullable = false)
	private java.sql.Timestamp EndDate;
	@Enumerated()
	@Column(name = "MONITOR_LEVEL", nullable = false)
	private CaseTypeEnum type;
	
	@Column(name = "TYPE", nullable = false)
	private CaseMonitorLevelEnum monitorLevel;

	@Override
	public String toString() {
		return "CaseReq [caseNO=" + caseNO + ", ManagerEmp=" + ManagerEmp + ", ContactEmp=" + ContactEmp
				+ ", WorkItemDesc=" + WorkItemDesc + ", StartDate=" + StartDate + ", EndDate=" + EndDate + ", type="
				+ type + ", monitorLevel=" + monitorLevel + "]";
	}
	
	
}
