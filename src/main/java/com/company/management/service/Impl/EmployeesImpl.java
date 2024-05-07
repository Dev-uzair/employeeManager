package com.company.management.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.management.dao.DepartmentDao;
import com.company.management.dao.EmployeesDao;
import com.company.management.dao.GradeDao;
import com.company.management.dao.SalSlabDao;
import com.company.management.entity.Department;
import com.company.management.entity.Employees;
import com.company.management.entity.Grade;
import com.company.management.entity.SalSlab;
import com.company.management.service.EmployeesService;

@Service
public class EmployeesImpl implements EmployeesService {
	@Autowired
	private EmployeesDao empDao;

	@Autowired
	private DepartmentDao deptDao;
	
	@Autowired
	private GradeDao gradeDao;
	
	@Autowired
	private SalSlabDao salSlabDao;

	@Override
	public List<Employees> findAll() {
		return empDao.findAll();

	}

	@Override
	public Employees save(Employees emp) {
		Employees employee = new Employees();
		employee.setName(emp.getName());
		employee.setFName(emp.getFName());
		employee.setAddress(emp.getAddress());
		employee.setMobile(emp.getMobile());
		
		Department did = deptDao.findById(emp.getDeptId()).orElse(null);
//		System.out.println("The answer is "+did);
		if(did != null){
		employee.setDeptId(emp.getDeptId());
		}
		else {
			throw new RuntimeException("department Id doesnt exist");
		}
		
		Grade gid = gradeDao.findById(emp.getGradeId()).orElse(null);
//		System.out.println("The answer is "+did);
		if(gid != null){
		employee.setGradeId(emp.getGradeId());
		}
		else {
			throw new RuntimeException("grade Id doesnt exist");
		}
		
		SalSlab sid = salSlabDao.findById(emp.getSlabId()).orElse(null);
//		System.out.println("The answer is "+did);
		if(sid != null){
		employee.setSlabId(emp.getSlabId());
		}
		else {
			throw new RuntimeException("slab Id doesnt exist");
		}
		
//		if(salSlabDao.findById(emp.getSlabId()).equals(emp.getSlabId())){
//			employee.setSlabId(emp.getSlabId());
//			}
//			else {
//				throw new RuntimeException("slab Id doesnt exist");
//			}

		
		employee.setGender(emp.getGender());
		employee.setBirthdate(emp.getBirthdate());
		employee.setJoinDate(emp.getJoinDate());
		return empDao.save(employee);
	}

	@Override
	public Employees getByID(int empID) {
		Optional<Employees> sal = empDao.findById(empID);
		Employees slab = sal.get();
		return slab;
	}

	@Override
	public Boolean findByID(int empID) {
		Optional<Employees> sal = empDao.findById(empID);
		if (sal == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public String deleted(int empID) {
		empDao.deleteById(empID);
		return "deletes successfully " + empID;
	}

//
//	public void addEmployeeData(Employees emp) {
//		Employees employee = new Employees();
//		employee.setName(emp.getName());
//		employee.setFName(emp.getFName());
//		employee.setAddress(emp.getAddress());
//		employee.setGender(emp.getGender());
//		employee.setBirthdate(emp.getBirthdate());
//		employee.setJoinDate(emp.getJoinDate());
//		employee.setDepartment(mapDepartment(emp.getDepartment()));
//		empDao.save(employee);
//		
//	}
//	
//	private Department mapDepartment(Department department) {
//		Department entity = new Department();
//		entity.setDepartmentId(department.getDepartmentId());
//		return entity;
//	}
//	

}
