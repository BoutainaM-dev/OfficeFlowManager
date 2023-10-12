package gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Ville;

@Transactional(readOnly = true)
public interface VilleDao extends JpaRepository<Ville, Long>, JpaSpecificationExecutor<Ville> {
	
}
