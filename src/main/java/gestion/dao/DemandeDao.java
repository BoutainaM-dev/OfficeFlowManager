package gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import gestion.model.Demande;
import gestion.model.Utilisateur;

@Transactional(readOnly = true)
public interface DemandeDao extends JpaRepository<Demande, Long>, JpaSpecificationExecutor<Demande> {

	@Query("SELECT d FROM Demande d WHERE d.utilisateur.id = :userId")
	List<Demande> findByUser(@Param("userId") Long userId);
	
}
