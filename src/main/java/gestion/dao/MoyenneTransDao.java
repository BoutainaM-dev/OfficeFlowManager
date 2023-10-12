package gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.MoyenneTrans;

@Transactional(readOnly = true)
public interface MoyenneTransDao extends JpaRepository<MoyenneTrans, Long>, JpaSpecificationExecutor<MoyenneTrans> {
	
}
