package gestion;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import gestion.model.Utilisateur;
import gestion.service.UtilisateurService;


@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler {

	@Autowired
	private UtilisateurService utilisateurService;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException authenticationException)
			throws IOException, ServletException {
		if (authenticationException instanceof BadCredentialsException) {
			response.sendRedirect("connexion/erreur");
		} else if (authenticationException instanceof CredentialsExpiredException) {
			Utilisateur secUtilisateur = utilisateurService.findUserByLogin(request.getParameter("username"));
			response.sendRedirect("changepassword/"+secUtilisateur.getToken());
		} else if (authenticationException instanceof DisabledException) {
			response.sendRedirect("connexion");
		} else if (authenticationException instanceof LockedException) {
			response.sendRedirect("connexion");
		}
	}

}
