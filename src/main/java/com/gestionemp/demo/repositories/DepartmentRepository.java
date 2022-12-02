package com.gestionemp.demo.repositories;

import com.gestionemp.demo.entities.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {

    boolean existsByName(String name);
}
