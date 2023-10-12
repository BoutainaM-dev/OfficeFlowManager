package gestion;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import gestion.model.Utilisateur;

public class ConnectedUserInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		if(SecurityContextHolder.getContext().getAuthentication() != null && SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			Utilisateur resultat = null;
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			Object principal = authentication.getPrincipal();
			if (principal instanceof Utilisateur) {
				resultat = ((Utilisateur) principal);
				request.setAttribute("USER_FNAME", resultat.getPrenom());
				request.setAttribute("USER_LNAME", resultat.getNom());
				request.setAttribute("PROFILE_CODE", resultat.getProfileCode());
			}
		}

		return super.preHandle(request, response, handler);
	}

}
