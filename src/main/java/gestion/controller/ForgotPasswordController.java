package gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import gestion.dto.UtilisateurDTO;
import gestion.service.UtilisateurService;

@Controller
@RequestMapping("/forgotpassword")
public class ForgotPasswordController {
	
	@Autowired
	private UtilisateurService utilisateurServices;
	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/forgot-password");
		return modelAndView;
	}
	
	@PostMapping(value="/send")
	public ModelAndView send(@ModelAttribute UtilisateurDTO dto){
		ModelAndView modelAndView = new ModelAndView("/forgot-password");
		utilisateurServices.forgotPassword(dto.getEmail());
		modelAndView.addObject("success", true);
		return modelAndView;
	}
	
}