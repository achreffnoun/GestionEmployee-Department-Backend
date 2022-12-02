package com.gestionemp.demo.repositories;

import com.gestionemp.demo.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Long> {

    boolean existsByFirstname(String firstname);

}
