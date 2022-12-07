package com.gestionemp.demo.services;

import com.gestionemp.demo.entities.Department;
import com.gestionemp.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService_Imp implements DepartmentService{
    @Autowired

    private DepartmentRepository DepRepo;

    @Override
    public void addDepartment(Department dep) {
        this.DepRepo.save(dep);
    }

    @Override
    public List<Department> getAllDepartment() {
        return this.DepRepo.findAll();
    }

    @Override
    public Department getOneDepartment(long id) {
        return this.DepRepo.findById(id).get();
    }

    @Override
    public Boolean findbyName(String name) {
        return this.DepRepo.existsByName(name);
    }

    @Override
    public void deleteDepartment(long id) {
        this.DepRepo.deleteById(id);
    }
}
