package com.webcomm.oa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webcomm.oa.data.CaseMonitorLevelEnum;
import com.webcomm.oa.data.CaseTypeEnum;
import com.webcomm.oa.domain.CaseReq;
@Repository
public interface CaseReqRepository extends JpaRepository<CaseReq, String> {
	CaseReq findByCaseNo(String caseNo);
	
	List<CaseReq> findByType(CaseTypeEnum type);
	
	List<CaseReq> findByTypeAndMonitorLevel(CaseTypeEnum type, CaseMonitorLevelEnum monitorLevel);
}
