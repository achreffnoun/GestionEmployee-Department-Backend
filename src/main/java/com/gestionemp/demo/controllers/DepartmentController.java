package com.gestionemp.demo.controllers;

import com.gestionemp.demo.entities.Department;
import com.gestionemp.demo.models.DepartmentModel;
import com.gestionemp.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class DepartmentController {
    @Autowired

    DepartmentService depServ;

    @PostMapping("/departments")
    ResponseEntity addDepartment(@RequestBody DepartmentModel model){
        Department department = new Department();
        department.setName(model.getName());
        if(depServ.findbyName(department.getName())){
            return new ResponseEntity("Department Already exist", HttpStatus.BAD_REQUEST);
        }else {
            department.setName(model.getName());
            this.depServ.addDepartment(department);
            return new ResponseEntity("Department Created", HttpStatus.CREATED);
        }

    }


    @GetMapping("/departments")
    List<Department> getAllDepartment(){
        return this.depServ.getAllDepartment();
    }

    @GetMapping("/departments/{id}")
    Department getOneDepartment(@PathVariable long id) {
        return this.depServ.getOneDepartment(id);
    }
}
