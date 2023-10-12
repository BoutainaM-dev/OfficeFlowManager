package gestion.controller;

import java.util.List;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.BaseTable;
import base.utils.Util;
import gestion.dto.MoyenneTransDTO;
import gestion.service.MoyenneTransService;

@Controller
@RequestMapping("/gestion/moyenneTrans")
public class MoyenneTransController {
	
	@Autowired
	private MoyenneTransService moyenneTransServices;

	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/moyenneTrans");
		modelAndView.addObject("MENU","GROUPE");
		return modelAndView;
	}
	
	@GetMapping({"/rest/list"})
	public @ResponseBody ResponseEntity<String> getList() {
		List<MoyenneTransDTO> dtos = moyenneTransServices.getList();
		String result = Util.toJson(new BaseTable<MoyenneTransDTO>(dtos, new Long(dtos.size())));
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/load/{id}")
	public @ResponseBody String load(@PathVariable Long id) {
		MoyenneTransDTO returnedDTO = moyenneTransServices.load(id);
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/save")
	public @ResponseBody String save(@RequestBody MoyenneTransDTO dto){
		MoyenneTransDTO returnedDTO = moyenneTransServices.save(dto);
		return Util.toJson(returnedDTO);
	}
	
	@GetMapping("/rest/delete/{id}")
	public @ResponseBody String delete(@PathVariable Long id){
		moyenneTransServices.delete(id);
		return Util.OK;
	}
	
	@GetMapping({"/rest/getAll"})
	public @ResponseBody String getAll() {
		List<MoyenneTransDTO> dtos = moyenneTransServices.getList();
		return Util.toJson(dtos);
	}
	
}