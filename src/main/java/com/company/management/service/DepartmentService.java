package com.company.management.service;

import java.util.List;

import com.company.management.entity.Department;

public interface DepartmentService {

	List<Department> findAll();
	Department save(Department dept);
	Department getByID(int deptID);
	Boolean findByID(int deptID);
	String delete(int deptID);
}
