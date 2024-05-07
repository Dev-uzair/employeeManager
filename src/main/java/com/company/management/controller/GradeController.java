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

import com.company.management.entity.Grade;
import com.company.management.service.GradeService;
//to post copy this-----post-------->  /grades/
//to get all copy this-----get-------->  /grades/

//to getbyId copy this-----get-------->  /grades/?

//to  update copy this ------put-------> /grades/

//to delete copy this-----delete-------->  /grades/?



/*JSON body
 {
 "grdID":"",
 "grade":"",
 "baseSal":""

 }
 
 */


@RestController
@RequestMapping("/grades")
public class GradeController {
	@Autowired
	private GradeService grdService;

//create post
	@PostMapping("/")
	public String creating(@RequestBody Grade grd) {
		grdService.save(grd);
		return "created the grade  " + grd;
	}

	// readAll get
	@GetMapping("/")
	public List<Grade> readAll() {
		return grdService.findAll();
	}

	// readbyId get
	@GetMapping("/{grdId}")
	public Grade findById(@PathVariable int grdId) {
		Grade sal = grdService.getByID(grdId);
		return sal;
	}

	// update put
	@PutMapping("/")
	public String updating(@RequestBody Grade grd) {
		grdService.save(grd);
		return "updated the grade  " + grd;
	}

	// delete delete
	@DeleteMapping("/{grdId}")
	public String DeleteById(@PathVariable int grdId) {
		boolean found = grdService.findByID(grdId);
		if (found == true) {
			grdService.delete(grdId);
			return "deleted Successfully" + grdId;
		} else {
			return "Id not found";
		}

	}

}
