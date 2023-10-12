package gestion.controller;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.BaseTable;
import base.utils.Util;
import gestion.dto.DemandeDTO;
import gestion.dto.UtilisateurDTO;
import gestion.service.DemandeService;
import gestion.service.UtilisateurService;

@Controller
@RequestMapping("/gestion/demande")
public class DemandeController {
	
	@Autowired
	private DemandeService demandeServices;
	
	@Autowired
	private UtilisateurService utilisateurService;

	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/demande/demande");
		modelAndView.addObject("MENU","DEMANDE");
		
		UtilisateurDTO current = utilisateurService.getCurrentUser();
		modelAndView.addObject("editAuthority", StringUtils.equals(current.getRole(), "ROLE_ADMIN") ? true : false);
		return modelAndView;
	}
	
	@GetMapping("/add")
	public ModelAndView addDemande(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/demande/addDemande");
		modelAndView.addObject("MENU","DEMANDE");
		return modelAndView;
	}
	
	@GetMapping({"/rest/list"})
	public @ResponseBody ResponseEntity<String> getList() {
		List<DemandeDTO> dtos = demandeServices.getList();
		String result = Util.toJson(new BaseTable<DemandeDTO>(dtos, new Long(dtos.size())));
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/load/{id}")
	public @ResponseBody String load(@PathVariable Long id) {
		DemandeDTO returnedDTO = demandeServices.load(id);
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/save")
	public @ResponseBody String save(@RequestBody DemandeDTO dto){
		DemandeDTO returnedDTO = demandeServices.save(dto);
		return Util.toJson(returnedDTO);
	}
	
	@GetMapping("/rest/delete/{id}")
	public @ResponseBody String delete(@PathVariable Long id){
		demandeServices.delete(id);
		return Util.OK;
	}
	
	@GetMapping("/rest/cancel/{id}")
	public @ResponseBody String cancel(@PathVariable Long id){
		demandeServices.cancel(id);
		return Util.OK;
	}
	
	@GetMapping({"/rest/getAll"})
	public @ResponseBody String getAll() {
		List<DemandeDTO> dtos = demandeServices.getList();
		return Util.toJson(dtos);
	}
	
	@RequestMapping(value = "/dd", method = RequestMethod.GET)
	public String ddPage(Model model) {
	    return "DD";
	}


	
}