package com.company.management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.management.entity.Employees;
import com.company.management.service.EmployeesService;

/* copy this json
{
"empID":"",
"name":"",
"fName":"",
"address":"",
"mobile":"",
"deptID":"",
"slbID":"",
"grdID":"",
"gender":"",
"birthdate":"",
"joinningdate":""
}
*/
//to post copy this-----post-------->  /employees/
//to get all copy this-----get-------->  /employees/

//to getbyId copy this-----get-------->  /employees/?

//to  update copy this ------put-------> /employees/

//to delete copy this-----delete-------->  /employees/?

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	@Autowired
private EmployeesService empService;
	// create post
		@PostMapping("/")
		public String creating(@RequestBody Employees emp) {
			empService.save(emp);
			return "created the employee  " + emp;
		}
		
		// readAll get
		@GetMapping("/")
		public List<Employees> readAll() {
			return empService.findAll();
		}

		// readbyId get
		@GetMapping("/{empId}")
		public Employees findById(@PathVariable int empId) {
			Employees sal = empService.getByID(empId);
			return sal;

		}
		// update put
		@PutMapping("/")
		public String updating(@RequestBody Employees emp) {
			empService.save(emp);
			return "updated the salaryslab  " + emp;
		}
		// delete delete
		@DeleteMapping("/{empId}")
		public String DeleteById(@PathVariable int empId) {
			boolean found = empService.findByID(empId);
			if (found == true) {
				empService.deleted(empId);
				return "deleted Successfully" + empId;
			} else {
				return "Id not found";
			}

		}



}
