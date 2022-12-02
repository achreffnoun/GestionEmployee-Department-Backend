package com.gestionemp.demo.controllers;

import com.gestionemp.demo.entities.Employee;
import com.gestionemp.demo.models.EmployeeModel;
import com.gestionemp.demo.services.DepartmentService;
import com.gestionemp.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class EmployeeController {
    @Autowired
    EmployeeService empServ;
    @Autowired
    DepartmentService depServ;

    @PostMapping("/employees")
    ResponseEntity addEmployee(@RequestBody EmployeeModel model){
        Employee employee = new Employee();
        employee.setFirstname(model.getFirstname());
        if(empServ.findbyFirstname(employee.getFirstname())){
            return new ResponseEntity("Employee already exist!",HttpStatus.BAD_REQUEST);
        }else {
            employee.setFirstname(model.getFirstname());
            employee.setLastname(model.getLastname());
            employee.setTel(model.getTel());
            employee.setDepartment(this.depServ.getOneDepartment(model.getDepartment_id()));
            this.empServ.addEmployee(employee);
            return new ResponseEntity("Employee Created", HttpStatus.CREATED);
        }
    }

    @GetMapping("/employees")
    List<Employee> getAllEmployee(){

        return this.empServ.getAllEmployees();
    }

    @GetMapping("/employees/{id}")
    Employee getOneEmployee(@PathVariable long id){
        return this.empServ.getOneEmployee(id);
    }

    @DeleteMapping("/employees/{id}")
    void DeleteEmployee(@PathVariable long id) {
        this.empServ.DeleteEmployee(id);
    }


}
