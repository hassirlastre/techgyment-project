package com.hels.Techgyment.Services;

import com.hels.Techgyment.Entities.Employee;
import com.hels.Techgyment.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    //Constructor
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //Obtener todos los empleados
    public List<Employee> getEmployees(){
        return this.employeeRepository.findAll();
    }

    //Obtener empleados por Id
    public Employee getEmployee(Long id){
        Optional<Employee> employee = this.employeeRepository.findById(id);
        return employee.orElse(null); //En cada de que no encuentre un Id
    }

    //Crear nuevo empleado
    public Employee createEmployee(Employee employee){
        return this.employeeRepository.save(employee);
    }

    //Actualizar información de empleado
   public Employee updateEmployee(Long id, Employee employee){
        Optional<Employee> bdData = this.employeeRepository.findById(id);

        if(bdData.isPresent()){
            Employee e = bdData.get();
            e.setId(employee.getId());
            e.setName(employee.getName());
            e.setEmail(employee.getEmail());
            e.setRole(employee.getRole());
            e.setEnterprise(employee.getEnterprise());
            e.setUsername(e.getUsername());
            e.setPassword(employee.getPassword());
            this.employeeRepository.save(e);
            return e;
        }
        return null;
    }

    //Borrar empleado
    public String deletEmployee(Long id){
        try{
            this.employeeRepository.deleteById(id);
            return "The employee information was deleted successfully";
        } catch (Exception e){
            return "The employee information was not deleted";
        }
    }
}
