package com.emre.hrmsProject.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emre.hrmsProject.entities.concretes.Employee;

public interface EmployeeDao extends JpaRepository<Employee, Integer>{

}
