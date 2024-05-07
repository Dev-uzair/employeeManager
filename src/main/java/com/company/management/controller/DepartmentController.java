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

import com.company.management.entity.Department;
import com.company.management.service.DepartmentService;

//to post copy this-----post-------->  /departments/
/* copy this json
{
"deptID":"",
"department":""
}
*/
//to get all copy this-----get-------->  /departments/

//to getbyId copy this-----get-------->  /departments/?

//to  update copy this ------put-------> /departments/

//to delete copy this-----delete-------->  /departments/?


@RestController
@RequestMapping("/departments")
public class DepartmentController {
	@Autowired
private DepartmentService deptService;
	// create post
		@PostMapping("/")
		public String creating(@RequestBody Department dept) {
			deptService.save(dept);
			return "created the salaryslab  " + dept;
		}
		
		// readAll get
		@GetMapping("/")
		public List<Department> readAll() {
			return deptService.findAll();
		}
		// readbyId get
		@GetMapping("/{deptId}")
		public Department findById(@PathVariable int deptId) {
			Department dept = deptService.getByID(deptId);
			return dept;

		}

		// update put
		@PutMapping("/")
		public String updating(@RequestBody Department dept) {
			 deptService.save(dept);
			return "updated the salaryslab  " + dept;
		}		
		
		// delete delete
		@DeleteMapping("/{deptId}")
		public String DeleteById(@PathVariable int deptId) {
			boolean found = deptService.findByID(deptId);
			if (found == true) {
				deptService.delete(deptId);
				return "deleted Successfully" + deptId;
			} else {
				return "Id not found";
			}

		}
}
