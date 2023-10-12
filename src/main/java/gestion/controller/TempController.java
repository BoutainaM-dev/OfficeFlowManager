package gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/temp")
public class TempController {
	@GetMapping
	public String tem() {
		int tempo;
		return "DD";
	}
}
