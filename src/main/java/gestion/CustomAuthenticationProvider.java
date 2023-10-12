package gestion;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import gestion.model.Utilisateur;
import gestion.service.UtilisateurService;

@Component("customAuthenticationProvider")
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Override
	public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setLogin(authentication.getName());
		utilisateur.setPassword(authentication.getCredentials().toString());
		
		Utilisateur user = utilisateurService.findUserByLogin(utilisateur.getLogin());
		
		if (user != null) {
			BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
			if (bCryptPasswordEncoder.matches(utilisateur.getPassword(),user.getPassword()) && user.getActif()) {
				if (StringUtils.isBlank(user.getToken())) {
					utilisateurService.setLastConnection(user);
					return new UsernamePasswordAuthenticationToken(user, authentication, user.getAuthorities());
				} else {
					throw new CredentialsExpiredException("");
				}
			} else {
				String message = "Incorrect credentials.";
				throw new BadCredentialsException("Unable to sign in. " + message);
			}
		} else {
			String message = "Incorrect username.error";
			throw new BadCredentialsException("Unable to sign in. " + message);
		}
		
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}