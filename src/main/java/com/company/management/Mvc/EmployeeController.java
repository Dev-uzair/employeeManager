//package com.company.management.Mvc;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.company.management.entity.Employees;
//import com.company.management.service.EmployeesService;
//
//@Controller
//@RequestMapping("/employee") 
//public class EmployeeController {
//	@Autowired
//	private EmployeesService employeeService;
//
//	@PostMapping("/")
//	public ResponseEntity<?> save(@RequestBody Employees emp){
//		employeeService.save(emp);
//		return new ResponseEntity<>("created",HttpStatus.OK);
//		
//	}
//	
//}
