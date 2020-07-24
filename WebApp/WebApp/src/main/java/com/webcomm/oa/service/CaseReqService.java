package com.webcomm.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.webcomm.oa.data.CaseMonitorLevelEnum;
import com.webcomm.oa.data.CaseTypeEnum;
import com.webcomm.oa.domain.CaseReq;
import com.webcomm.oa.repository.CaseReqRepository;

@Service
public class CaseReqService {
	@Autowired
	CaseReqRepository caseReqRepository;
	
//	public CaseReq getOne(String caseNo) {
//		if(caseNo != null) {
//			return caseReqRepository.findByCaseNo(caseNo);
//			
//		}
//		return null;
//	}
	public CaseReq getOne(String caseNo) {
		if(caseNo != null) {
			return caseReqRepository.getOne(caseNo);
			
		}
		return null;
	}
	
	public List<CaseReq>getPagedCase(int page, int size){
			// page = 查詢第幾頁
			// size = 每頁共幾筆
			// Sort.by = entity property > 要使用何種條件排列
		Page<CaseReq>pageResult = caseReqRepository.findAll(
				PageRequest.of(page, size, Sort.by("caseNo").descending())
				);
		List<CaseReq> caseList = pageResult.getContent();
		return caseList;
	}
	
	public Page<CaseReq> PagesCase() {
		PageRequest casePageRequest = PageRequest.of(0, 5);
		Page<CaseReq> pageCase = caseReqRepository.findAll(casePageRequest);

		return pageCase;
		
	}
	
	public List<CaseReq> getCaseByType(Integer number){
		CaseTypeEnum test = CaseTypeEnum.fromValue(number);
		if(test != null) {
			return caseReqRepository.findByType(test);
		}
		return null;
	}
	public List<CaseReq> getCaseByTypeAndMonitor(Integer type, Integer monitor){
		CaseTypeEnum typeEnum = CaseTypeEnum.fromValue(type);
		CaseMonitorLevelEnum monitorEnum = CaseMonitorLevelEnum.fromValue(monitor);
		if(typeEnum != null && monitorEnum != null) {
			return caseReqRepository.findByTypeAndMonitorLevel(typeEnum, monitorEnum);
		}
		return null;
	}
	
	public List<CaseReq>getCaseByVar(CaseReq bean){
		if(bean.getMonitorLevel() == CaseMonitorLevelEnum.Default_ALL) {
			bean.setMonitorLevel(null);
		}
		if(bean.getType() == CaseTypeEnum.Default_ALL) {
			bean.setType(null);
		}
		Example<CaseReq> example = Example.of(bean);
		return caseReqRepository.findAll(example);
	}
	
}
