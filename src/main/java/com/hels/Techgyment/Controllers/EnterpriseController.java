package com.hels.Techgyment.Controllers;

import com.hels.Techgyment.Entities.Enterprise;
import com.hels.Techgyment.Services.EnterpriseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EnterpriseController {

    @Autowired
    private EnterpriseService service;

    public EnterpriseController(EnterpriseService service) {
        this.service = service;
    }

    @GetMapping("/enterprises")
    public List<Enterprise> getEnterprises(){
        return this.service.getEnterprises();
    }

    @PostMapping("/enterprises")
    public RedirectView createEnterprise(@ModelAttribute @RequestBody Enterprise enterprise, Model model){
        model.addAttribute(enterprise);
        this.service.createEnterprise(enterprise);
        return new RedirectView("/enterprises/new");
    }

    @GetMapping("/enterprises/{id}")
    public Enterprise getEnterpise(@PathVariable("id") Long id){
        return this.service.getEnterprise(id);
    }

    @PatchMapping("/enterprises/{id}")
    public Enterprise updateEnterprise(@PathVariable("id") Long id, @RequestBody Enterprise enterprise){
        return this.service.updateEnterprise(id, enterprise);
    }

    @DeleteMapping("/enterprises/{id}")
    public String deletEnterprise(@PathVariable("id") Long id){
        return this.service.deletEnterprise(id);
    }
}
