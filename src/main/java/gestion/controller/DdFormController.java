package gestion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import gestion.dto.DdDTO;
import gestion.service.DdFormService;

@Controller
public class DdFormController {
    private final DdFormService formDataService;

    @Autowired
    public DdFormController(DdFormService formDataService) {
        this.formDataService = formDataService;
    }

    @PostMapping("/submitForm")
    public String submitForm(@ModelAttribute DdDTO ddDTO) {
        formDataService.saveFormData(ddDTO);
        return "success"; // Return the name of the success view/page
    }
}

