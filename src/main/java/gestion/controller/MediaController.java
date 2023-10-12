package gestion.controller;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/media")
public class MediaController {
	
	String UPLOAD_HOME = "D:/project";
	String GED_MEDIATHEQUE = "/profil/";
	
	@RequestMapping(value = "/image/load/{code}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImageAsResponseEntity(@PathVariable String code) throws IOException {
		HttpHeaders headers = new HttpHeaders();
	    
	    StringBuilder directory = new StringBuilder(UPLOAD_HOME);
	    directory.append(GED_MEDIATHEQUE).append(code);
		File file = new File(directory.toString());
		InputStream is = new ByteArrayInputStream(FileUtils.readFileToByteArray(file));
		
	    byte[] media = IOUtils.toByteArray(is);
	    headers.setCacheControl(CacheControl.noCache().getHeaderValue());
	     
	    ResponseEntity<byte[]> responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);
	    return responseEntity;
	}
	
}