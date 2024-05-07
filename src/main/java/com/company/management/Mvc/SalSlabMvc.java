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

import com.company.management.entity.SalSlab;
import com.company.management.service.SalSlabService;

@Controller
@RequestMapping("/sals")
public class SalSlabMvc {
	private SalSlabService salSer;

	@Autowired
	public SalSlabMvc(SalSlabService salSer) {
		this.salSer = salSer;
	}

	@GetMapping("/list")
	public String list(Model themodel) {
		List<SalSlab> emp = salSer.findAll();
		themodel.addAttribute("salaries", emp);
		return "/salslab/list-sal";
	}

	@GetMapping("/addSal")
	public String showForm(Model theModel) {
		SalSlab theEmp = new SalSlab();
		theModel.addAttribute("salaries", theEmp);
		return "salslab/Sal-form";

	}

	@PostMapping("/save")
	public String saveStud(@ModelAttribute("salaries") SalSlab theEmp) {
		salSer.save(theEmp);
		return "redirect:/sals/list";
	}

	@GetMapping("/showUpdFrm")
	public String showUpdFrm(@RequestParam("salID") int theID, Model theModel) {
		SalSlab theStud = salSer.getByID(theID);
		theModel.addAttribute("salaries", theStud);
		return "salslab/Sal-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("salID") int theID) {
		salSer.delete(theID);
		return "redirect:/sals/list";
	}

}
