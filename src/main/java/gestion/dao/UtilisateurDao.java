package gestion.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import gestion.model.Utilisateur;

public interface UtilisateurDao extends JpaRepository<Utilisateur, Long>, JpaSpecificationExecutor<Utilisateur> {

	@Query("SELECT u FROM Utilisateur u WHERE LOWER(u.login) = LOWER(:login)")
	Utilisateur findByLogin(@Param("login") String login);
	
	@Query("SELECT u FROM Utilisateur u WHERE LOWER(u.email) = LOWER(:email)")
	Utilisateur findByEmail(@Param("email") String email);
	
	@Query("SELECT u FROM Utilisateur u "
			+ "WHERE u.role = :role ")
	List<Utilisateur> getByRole(@Param("role") String role);
	
	@Query("SELECT u FROM Utilisateur u WHERE u.id != :id")
	List<Utilisateur> getAll(@Param("id") Long id);
	
}
