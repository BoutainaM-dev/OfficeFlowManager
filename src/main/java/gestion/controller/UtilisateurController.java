package gestion.controller;

import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import base.BaseTable;
import base.utils.Util;
import gestion.dto.UtilisateurDTO;
import gestion.service.UtilisateurService;

@Controller
@RequestMapping("/administration/utilisateur")
public class UtilisateurController {
	
	@Autowired
	private UtilisateurService utilisateurServices;
	
	String UPLOAD_HOME = "D:/project";
	String MEDIA_PROFIL = "/profil/";

	
	@GetMapping("")
	public ModelAndView getPage(Model model) {
		ModelAndView modelAndView = new ModelAndView("/administration/utilisateur");
		modelAndView.addObject("MENU","UTILISATEUR");
		return modelAndView;
	}
	
	@GetMapping({"/rest/list", "/rest/list/{role}"})
	public @ResponseBody ResponseEntity<String> getList(@PathVariable("role") Optional<String> role) {
		List<UtilisateurDTO> dtos = utilisateurServices.getList(role.orElse(null));
		String result = Util.toJson(new BaseTable<UtilisateurDTO>(dtos, new Long(dtos.size())));
		return new ResponseEntity<String>(result, HttpStatus.OK);
	}
	
	@GetMapping("/rest/load/{id}")
	public @ResponseBody String load(@PathVariable Long id) {
		UtilisateurDTO returnedDTO = utilisateurServices.load(id);
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/save")
	public @ResponseBody String save(@RequestBody UtilisateurDTO dto){
		UtilisateurDTO returnedDTO = utilisateurServices.save(dto);
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/updateProfil")
	public @ResponseBody String updateProfil(@ModelAttribute UtilisateurDTO dto, BindingResult result) throws Exception {
		
		if(dto.getDocument().getSize() > 0) {
			dto.setProfileImage(dto.getDocument().getOriginalFilename());
			dto.setProfileCode(String.valueOf(new Date().getTime()));
		}
		
		UtilisateurDTO returnedDTO = utilisateurServices.updateProfil(dto);
		if(dto.getDocument().getSize() > 0) {
			uploadFile(dto);
		}
		return Util.toJson(returnedDTO);
	}
	
	@PostMapping(value="/rest/changePassword")
	public @ResponseBody String changePassword(@RequestBody UtilisateurDTO dto){
		UtilisateurDTO returnedDTO = utilisateurServices.changePassword(dto);
		return Util.toJson(returnedDTO);
	}
	
	@GetMapping("/rest/delete/{id}")
	public @ResponseBody String delete(@PathVariable Long id){
		utilisateurServices.delete(id);
		return Util.OK;
	}
	
	@GetMapping("/rest/getCurrent")
	public @ResponseBody String getCurrent(){
		UtilisateurDTO returnedDTO = utilisateurServices.getCurrentUser();
		return Util.toJson(returnedDTO);
	}
	
	@GetMapping("/rest/getAll")
	public @ResponseBody String getAll() {
		List<UtilisateurDTO> dtos = utilisateurServices.getList(null);
		return Util.toJson(dtos);
	}
	
	@ResponseBody
	@RequestMapping(value = "/profil/{id}")
	public ResponseEntity<byte[]> preview(@PathVariable Long id) throws IOException {
		UtilisateurDTO dto =  utilisateurServices.load(id);
		
		HttpHeaders headers = new HttpHeaders();
	    
	    StringBuilder directory = new StringBuilder(UPLOAD_HOME);
	    directory.append(MEDIA_PROFIL).append(dto.getProfileCode());
		File file = new File(directory.toString());
		InputStream is = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
		
	    byte[] media = IOUtils.toByteArray(is);
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	     
	    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
	
	public void uploadFile(UtilisateurDTO dto) throws IOException {
		StringBuilder directory = new StringBuilder(UPLOAD_HOME);
		directory.append("/").append(MEDIA_PROFIL).append("/").append(dto.getProfileCode());
		File file = new File(directory.toString());
		file.getParentFile().mkdirs();
		BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(file));
		stream.write(dto.getDocument().getBytes());
		stream.close();
	}
	
	@GetMapping("/create")
    public ModelAndView getCreatePage(Model model) {
        ModelAndView modelAndView = new ModelAndView("nv_utilisateur");
        modelAndView.addObject("MENU", "UTILISATEUR");
        modelAndView.addObject("user", new UtilisateurDTO()); // Create a new user DTO to bind the form
        return modelAndView;
    }

   /* @PostMapping("/create")
    public @ResponseBody String createUser(@ModelAttribute UtilisateurDTO userDTO, BindingResult result) {
        UtilisateurDTO returnedDTO = utilisateurServices.createUser(userDTO);
        return Util.toJson(returnedDTO);
    }*/
	
}