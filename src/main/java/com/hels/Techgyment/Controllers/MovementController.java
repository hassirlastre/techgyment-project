package com.hels.Techgyment.Controllers;

import com.hels.Techgyment.Entities.Movement;
import com.hels.Techgyment.Services.MovementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class MovementController {

    @Autowired
    private MovementService service;

    public MovementController(MovementService service) {
        this.service = service;
    }

    @GetMapping("/movements")
    public List<Movement> getTransactions(){
        return this.service.getMovements();
    }

    @PostMapping("/movements")
    public RedirectView createTransaction(@ModelAttribute @DateTimeFormat(pattern = "YYYY-MM-DD") Movement movement, Model model){
        model.addAttribute(movement);
        this.service.createMovement(movement);

        return new RedirectView("/transactions");
    }

    @GetMapping("/movements/{id}")
    public Movement getTransaction(@PathVariable("id") Long id){
        return this.service.getMovements(id);
    }

    @PatchMapping("/movements/{id}")
    public Movement updateTransaction(@PathVariable("id") Long id, @RequestBody Movement movement){
        return this.service.updateMovement(id, movement);
    }

    @DeleteMapping("/movements/{id}")
    public RedirectView deleteMovement(@PathVariable("id") Long id){
       this.service.deleteMovement(id);
      return new RedirectView("/transactions");
    }
}
