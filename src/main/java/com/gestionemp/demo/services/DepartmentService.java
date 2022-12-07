package com.gestionemp.demo.services;

import com.gestionemp.demo.entities.Department;

import java.util.List;

public interface DepartmentService  {

    void addDepartment(Department dep);

    List<Department> getAllDepartment();

    Department getOneDepartment(long id);

    Boolean findbyName(String firstname);

    void deleteDepartment(long id);
}
