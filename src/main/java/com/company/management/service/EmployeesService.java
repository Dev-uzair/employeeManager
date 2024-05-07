package com.company.management.service;

import java.util.List;

import com.company.management.entity.Employees;

public interface EmployeesService {
	List<Employees> findAll();
	Employees save(Employees emp);
	Employees getByID(int empID);
	Boolean findByID(int empID);
	String deleted(int empID);
}
