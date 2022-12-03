package com.gestionemp.demo.services;

import com.gestionemp.demo.entities.Employee;
import com.gestionemp.demo.models.EmployeeModel;
import com.gestionemp.demo.repositories.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService_Imp implements EmployeeService {
    @Autowired

    private EmployeeRepo empRepo;

    @Override
    public void addEmployee(Employee e) {
        this.empRepo.save(e);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.empRepo.findAll();
    }

    @Override
    public Employee getOneEmployee(long id) {
        return this.empRepo.findById(id).get();

    }

    @Override
    public void DeleteEmployee(long id) {
        this.empRepo.deleteById(id);

    }

    @Override
    public Boolean findbyFirstname(String firstname) {
        return this.empRepo.existsByFirstname(firstname);
    }




}
