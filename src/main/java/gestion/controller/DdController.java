package gestion.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestion.dto.UtilisateurDTO;
import gestion.service.DdService;
import gestion.service.UtilisateurService;

@Controller
@RequestMapping("/gestion/DD")
public class DdController {

	@Autowired
	private DdService DdService;
	
	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/DD/DD");
		modelAndView.addObject("MENU","DD");
		
		UtilisateurDTO current = utilisateurService.getCurrentUser();
		modelAndView.addObject("editAuthority",StringUtils.equals(current.getRole(), "ROLE_ADMIN") ? true : false);
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView addDemande(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/demande/addDD");
		modelAndView.addObject("MENU","DD");
		return modelAndView;
	
}
}
