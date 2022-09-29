package com.hels.Techgyment.Controllers;

import com.hels.Techgyment.Entities.Employee;
import com.hels.Techgyment.Services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    //Constructor
    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    //Obtener todos los empleados
    @GetMapping("/employees")
    public List<Employee> getEmployees(){
        return this.service.getEmployees();
    }

    //Crear nuevo empleado
    @PostMapping("/employees")
    public RedirectView createEmployee(@ModelAttribute @RequestBody Employee employee, Model model){
        model.addAttribute(employee);
        this.service.createEmployee(employee);
        return new RedirectView("/employees/new");
    }

    //Obtener empleado por id
    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        return this.service.getEmployee(id);
    }

    //Actualizar información de empleado
   @PatchMapping("/employees/{id}")
    public Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee){
        return this.service.updateEmployee(id, employee);
    }

    //Borrar empleado
    @DeleteMapping("/employees/{id}")
    public String deletEmployee(@PathVariable("id") Long id){
        return this.service.deletEmployee(id);
    }


}


