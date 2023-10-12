package gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gestion.dto.DdDTO;
import gestion.model.DD;
import gestion.model.Demande;

@Transactional(readOnly = true)
public interface DdDao extends JpaRepository<DD, Long>, JpaSpecificationExecutor<DD> {

	@Query("SELECT d FROM DD d WHERE d.id = :userId")
	List<DD> findByUser(@Param("userId") Long userId);

	@Transactional
    DD save(DD dd);
}
