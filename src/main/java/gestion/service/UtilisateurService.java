package gestion.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import gestion.dto.UtilisateurDTO;
import gestion.model.Utilisateur;

public interface UtilisateurService extends UserDetailsService {

	public List<UtilisateurDTO> getList(String role);
	
	public UtilisateurDTO load(Long id);
	
	public UtilisateurDTO save(UtilisateurDTO dto);
	
	public UtilisateurDTO updateProfil(UtilisateurDTO dto);
	
	public UtilisateurDTO changePassword(UtilisateurDTO dto);
	
	public void delete(Long id);
	
	public Utilisateur findUserByLogin(String login);
	
	UtilisateurDTO getCurrentUser();
	
	public void setLastConnection(Utilisateur entity);
	
	public void updateAuthentication(Long id);
	
	public void forgotPassword(String email);

}
