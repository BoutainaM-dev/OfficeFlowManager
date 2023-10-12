package gestion.controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import gestion.dto.UtilisateurDTO;
import gestion.service.UtilisateurService;

@Controller
public class HomeController {
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	@GetMapping("")
	public ModelAndView home(HttpServletRequest request, HttpServletResponse response) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		ModelAndView modelAndView = new ModelAndView();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			modelAndView.setViewName("/index");
			modelAndView.addObject("MENU", "HOME");
			
			UtilisateurDTO user = utilisateurService.getCurrentUser();
			
			DateFormat formatterD = new SimpleDateFormat("dd MMMM yyyy", Locale.FRANCE);
			String lastConnectionD = formatterD.format(user.getLastConnection());
			
			DateFormat formatterH = new SimpleDateFormat("HH:mm", Locale.FRANCE);
			String lastConnectionH = formatterH.format(user.getLastConnection());
			
			String nom = user.getNom()+" "+user.getPrenom();
			
			modelAndView.addObject("USERNAME", nom);
			modelAndView.addObject("LAST_CONNECTION_D",lastConnectionD);
			modelAndView.addObject("LAST_CONNECTION_H",lastConnectionH);
			
		} else {
			response.addHeader("REQUIRES_AUTH", "1");
			modelAndView.setViewName("redirect:/connexion");
		}
		return modelAndView;
	}
	
	@GetMapping("/connexion")
	public ModelAndView loginPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/login");
		return modelAndView;
	}
	
	@GetMapping("/connexion/error")
	public ModelAndView errorLoginPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/login");
		modelAndView.addObject("error", true);
		return modelAndView;
	}
	
	@GetMapping("/error")
	public ModelAndView error(Model model) {
		ModelAndView modelAndView = new ModelAndView("redirect:/");
		return modelAndView;
	}
	
}