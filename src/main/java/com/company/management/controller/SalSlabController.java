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

import com.company.management.entity.SalSlab;
import com.company.management.service.SalSlabService;
// to post copy this-----post-------->  /salSlabs/
/* copy this json
 {
  "slbID":"",
  "HRA":"",
  "DA":"",
  "TA":"",
  "PF":""
 }
  */
// to get all copy this-----get-------->  /salSlabs/

// to getbyId copy this-----get-------->  /salSlabs/?

//to  update copy this ------put-------> /salSlabs/

// to delete copy this-----delete-------->  /salSlabs/?

@RestController
@RequestMapping("/salSlabs")
public class SalSlabController {
	@Autowired
	private SalSlabService salServ;

	// create post
	@PostMapping("/")
	public String creating(@RequestBody SalSlab sal) {
		salServ.save(sal);
		return "created the salaryslab  " + sal;
	}

	// readAll get
	@GetMapping("/")
	public List<SalSlab> readAll() {
		return salServ.findAll();
	}

	// readbyId get
	@GetMapping("/{SlabId}")
	public SalSlab findById(@PathVariable int SlabId) {
		SalSlab sal = salServ.getByID(SlabId);
		return sal;

	}

	// update put
	@PutMapping("/")
	public String updating(@RequestBody SalSlab sal) {
		salServ.save(sal);
		return "updated the salaryslab  " + sal;
	}

	// delete delete
	@DeleteMapping("/{SlabId}")
	public String DeleteById(@PathVariable int SlabId) {
		boolean found = salServ.findByID(SlabId);
		if (found == true) {
			salServ.delete(SlabId);
			return "deleted Successfully" + SlabId;
		} else {
			return "Id not found";
		}

	}

}
