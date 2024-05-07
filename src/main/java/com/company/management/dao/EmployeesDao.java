package com.company.management.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.company.management.entity.Employees;
@Repository
public interface EmployeesDao extends JpaRepository<Employees, Integer> {

}
