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
import gestion.dto.VilleDTO;
import gestion.service.VilleService;

@Controller
@RequestMapping("/gestion/ville")
public class VilleController {
	
	@Autowired
	private VilleService villeServices;

	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/gestion/ville");
		modelAndView.addObject("MENU","GROUPE");
		return modelAndView;
	}
	
	@GetMapping({"/rest/list"})
	public @ResponseBody ResponseEntity<String> getList() {
		List<VilleDTO> dtos = villeServices.getList();
		String result = Util.toJson(new BaseTable<VilleDTO>(dtos, new Long(dtos.size())));
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/load/{id}")
	public @ResponseBody String load(@PathVariable Long id) {
		VilleDTO returnedDTO = villeServices.load(id);
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/save")
	public @ResponseBody String save(@RequestBody VilleDTO dto){
		VilleDTO returnedDTO = villeServices.save(dto);
		return Util.toJson(returnedDTO);
	}
	
	@GetMapping("/rest/delete/{id}")
	public @ResponseBody String delete(@PathVariable Long id){
		villeServices.delete(id);
		return Util.OK;
	}
	
	@GetMapping({"/rest/getAll"})
	public @ResponseBody String getAll() {
		List<VilleDTO> dtos = villeServices.getList();
		return Util.toJson(dtos);
	}
	
}