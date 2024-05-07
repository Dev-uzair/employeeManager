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

import com.company.management.entity.Leaves;
import com.company.management.service.LeaveService;

@RestController
@RequestMapping("/leaves")
public class LeavesController {
@Autowired
private LeaveService levServ;
//create post
	@PostMapping("/")
	public String creating(@RequestBody Leaves lev) {
		levServ.save(lev);
		return "created the grade  " + lev;
	}


	// readAll get
	@GetMapping("/")
	public List<Leaves> readAll() {
		return levServ.findAll();
	}
	// readbyId get
	@GetMapping("/{grdId}")
	public Leaves findById(@PathVariable int levId) {
		Leaves sal = levServ.getByID(levId);
		return sal;
	}

	// update put
	@PutMapping("/")
	public String updating(@RequestBody Leaves lev) {
		levServ.save(lev);
		return "updated the leaves  " + lev;
	}

	// delete delete
	@DeleteMapping("/{levId}")
	public String DeleteById(@PathVariable int levId) {
		boolean found = levServ.findByID(levId);
		if (found == true) {
			levServ.delete(levId);
			return "deleted Successfully" + levId;
		} else {
			return "Id not found";
		}

	}








}
