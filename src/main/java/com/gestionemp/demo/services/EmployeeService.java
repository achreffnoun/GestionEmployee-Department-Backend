package com.gestionemp.demo.services;

import com.gestionemp.demo.entities.Employee;

import java.util.List;

public interface EmployeeService {

    void addEmployee(Employee e);

    List<Employee> getAllEmployees();

    Employee getOneEmployee(long id);

    void DeleteEmployee(long id);

    Boolean findbyFirstname(String firstname);



}
