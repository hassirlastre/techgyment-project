package com.hels.Techgyment.Controllers;

import com.hels.Techgyment.Entities.Employee;
import com.hels.Techgyment.Entities.Enterprise;
import com.hels.Techgyment.Entities.Movement;
import com.hels.Techgyment.Services.MovementService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class FrontControllers {

    private MovementService service;

    public FrontControllers(MovementService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String home(Model model, @AuthenticationPrincipal OidcUser principal) {
        return "login";
    }

    //Transacciones
    @GetMapping("/transactions")
    public String movements(Model model){
        List<Movement> movements = this.service.getMovements();
        model.addAttribute("movements", movements);
        return "movements";
    }

    @GetMapping("/transactions/new")
    public String newMovement(Model model){
        model.addAttribute("movements", new Movement());
        return "new-movement";
    }

    @GetMapping("/employees/new")
    public String newEmployee(Model model){
        model.addAttribute("employees", new Employee());
        return "new-employee";
    }
    @GetMapping("/enterprises/new")
    public String newEnterprise(Model model){
        model.addAttribute("enterprises", new Enterprise());
        return "new-enterprise";
    }
}
