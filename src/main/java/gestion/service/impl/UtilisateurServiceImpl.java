package gestion.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import gestion.dao.UtilisateurDao;
import gestion.dto.UtilisateurDTO;
import gestion.dto.converter.UtilisateurDTOConverter;
import gestion.model.Utilisateur;
import gestion.service.UtilisateurService;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {

	@Autowired
	private UtilisateurDao utilisateurDao;
	
	@Autowired
	private UtilisateurDTOConverter utilisateurDTOConverter;
	
	@Autowired
    private JavaMailSender javaMailSender;

	@Override
	@Transactional
	public List<UtilisateurDTO> getList(String role) {
		List<Utilisateur> list = new ArrayList<Utilisateur>();
		if(role != null) {
			list = utilisateurDao.getByRole(role);
		}
		else {
			list = utilisateurDao.getAll(getCurrentUser().getId());
		}
		List<UtilisateurDTO> dtos = utilisateurDTOConverter.convertFromDataBeanList(list);
		return dtos;
	}
	
	@Override
	public UtilisateurDTO load(Long id) {
		Optional<Utilisateur> entity = utilisateurDao.findById(id);
		UtilisateurDTO dto = utilisateurDTOConverter.convertFromDataBean(entity.get());
		return dto;
	}
	
	@Override
	public UtilisateurDTO save(UtilisateurDTO dto) {
		Utilisateur entity = utilisateurDTOConverter.convertFromDTO(dto);
		
		if(dto.getId() == null) {
			entity.setProfileCode("default");
			entity.setProfileImage("default.png");
			
			/*String password = RandomStringUtils.randomAlphanumeric(8);
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode(password);*/
			
			PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			String hashedPassword = passwordEncoder.encode("password");
			
			entity.setPassword(hashedPassword);
		}
		
		entity = utilisateurDao.save(entity);
		if(entity.getId() == getCurrentUser().getId()) {
			updateAuthentication(entity.getId());
		}
		
//		sendMail(entity.getEmail(), entity.getLogin(), password);
		
		return utilisateurDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public UtilisateurDTO updateProfil(UtilisateurDTO dto) {
		Utilisateur entity = utilisateurDao.getOne(dto.getId());
		entity.setProfileImage(dto.getProfileImage());
		entity.setProfileCode(dto.getProfileCode());
		entity = utilisateurDao.save(entity);
		updateAuthentication(entity.getId());
		return utilisateurDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public UtilisateurDTO changePassword(UtilisateurDTO dto) {
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(dto.getNewPassword());
		
		Utilisateur entity = utilisateurDao.getOne(dto.getId());
		entity.setPassword(hashedPassword);
		entity = utilisateurDao.save(entity);
		return utilisateurDTOConverter.convertFromDataBean(entity);
	}
	
	@Override
	public void delete(Long id) {
		utilisateurDao.deleteById(id);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}
	
	@Override
	public Utilisateur findUserByLogin(String login) {
		Utilisateur utilisateur = utilisateurDao.findByLogin(login);
		if(utilisateur != null && utilisateur.getRole() != null){
			Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
			authorities.add(new SimpleGrantedAuthority(utilisateur.getRole()));
			utilisateur.setAuthorities(authorities);
		}
		return utilisateur;
	}
	
	@Override
	public UtilisateurDTO getCurrentUser() {
		Utilisateur resultat = null;
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Object principal = authentication.getPrincipal();
		if (principal instanceof Utilisateur) {
			resultat = ((Utilisateur) principal);
		}
		Utilisateur entity = utilisateurDao.getOne(resultat.getId());
		UtilisateurDTO dto = utilisateurDTOConverter.convertFromDataBean(entity);
		
		return dto;
	}
	
	@Override
	@Transactional
	public void setLastConnection(Utilisateur entity) {
		entity.setLastConnection(new Date());
		utilisateurDao.save(entity);
	}
	
	@Override
	public void updateAuthentication(Long id) {
		Utilisateur utilisateur = utilisateurDao.getOne(id);
		
		Authentication oldAuth = SecurityContextHolder.getContext().getAuthentication();
		Authentication newAuth = new UsernamePasswordAuthenticationToken(utilisateur, oldAuth.getCredentials(), oldAuth.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(newAuth);
	}
	
	@Override
	public void forgotPassword(String email) {
		
		Utilisateur entity = utilisateurDao.findByEmail(email);
		
		String password = RandomStringUtils.randomAlphanumeric(8);
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String hashedPassword = passwordEncoder.encode(password);
		
		entity.setPassword(hashedPassword);
		utilisateurDao.save(entity);
		
		sendMail(entity.getEmail(), entity.getLogin(), password);
	}
	
	public void sendMail(String email, String login, String password) {
		SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(email);
        msg.setSubject("Mot de passe");
        
        String message = "Votre Login : " + login;
        message += "\n";
        message += "Votre Mot de passe : " + password;
        
        msg.setText(message);

        javaMailSender.send(msg);
	}
	
}