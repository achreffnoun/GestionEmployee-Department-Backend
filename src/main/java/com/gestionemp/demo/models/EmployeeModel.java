package com.gestionemp.demo.models;

import com.gestionemp.demo.entities.Department;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeModel {

    private String firstname;
    private String lastname;
    private String tel;
    private long department_id;

}
