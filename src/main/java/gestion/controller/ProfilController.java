package gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/profil")
public class ProfilController {
	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/profil");
		return modelAndView;
	}
	
}