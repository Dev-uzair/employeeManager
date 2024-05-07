package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.DepartmentDao;
import com.company.management.entity.Department;
import com.company.management.service.DepartmentService;
@Service
public class DepartmentImpl implements DepartmentService {
	@Autowired
	private DepartmentDao deptDao;

//read
	@Override
	public List<Department> findAll() {
		return deptDao.findAll();

	}

//create
	@Override
	public Department save(Department dept) {
		deptDao.save(dept);
		return dept;

	}

//get by id
	@Override
	public Department getByID(int deptID) {
		Optional<Department> dept = deptDao.findById(deptID);
		Department slab = dept.get();
		return slab;
	}

//find
	@Override
	public Boolean findByID(int deptID) {
		Optional<Department> sal = deptDao.findById(deptID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}
	}

//deleteO
	@Override
	public String delete(int deptID) {
		deptDao.deleteById(deptID);
		return "deletes successfully " + deptID;
	}

}
