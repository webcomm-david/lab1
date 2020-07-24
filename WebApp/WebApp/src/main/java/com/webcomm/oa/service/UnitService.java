package com.webcomm.oa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webcomm.oa.domain.Unit;
import com.webcomm.oa.repository.UnitRepository;
@Service
public class UnitService {
	@Autowired
	UnitRepository unitRepository;
	
	public List<Unit>getAll(){
		return unitRepository.findAll();
	}
	
	public Unit getOne(String unitId) {
		if(unitId != null) {
			return unitRepository.findByUnitId(unitId);
		}
		return null;
	}
}
