package com.webcomm.oa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.webcomm.oa.domain.Unit;
@Repository
public interface UnitRepository extends JpaRepository<Unit, String> {
	Unit findByUnitId(String unitId);
	Unit findByUnitIdAndName(String unitId, String name);
}
