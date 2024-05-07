package com.company.management.Mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.company.management.entity.Leaves;
import com.company.management.service.LeaveService;

@Controller
@RequestMapping("/levs")
public class LeavesMvc {
	private LeaveService levSev;

	@Autowired
	public LeavesMvc(LeaveService levSev) {
		this.levSev = levSev;
	}

	@GetMapping("/list")
	public String list(Model themodel) {
		List<Leaves> emp = levSev.findAll();
		themodel.addAttribute("leaves", emp);
		return "/leaves/list-leaves";
	}

	@GetMapping("/addLev")
	public String showForm(Model theModel) {
		Leaves theEmp = new Leaves();
		theModel.addAttribute("leaves", theEmp);
		return "leaves/leaves-form";

	}

	@PostMapping("/save")
	public String saveStud(@ModelAttribute("leaves") Leaves theEmp) {
		levSev.save(theEmp);
		return "redirect:/levs/list";
	}

	@GetMapping("/showUpdFrm")
	public String showUpdFrm(@RequestParam("levID") int theID, Model theModel) {
		Leaves theStud = levSev.getByID(theID);
		theModel.addAttribute("leaves", theStud);
		return "leaves/leaves-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("levID") int theID) {
		levSev.delete(theID);
		return "redirect:/levs/list";
	}

}
