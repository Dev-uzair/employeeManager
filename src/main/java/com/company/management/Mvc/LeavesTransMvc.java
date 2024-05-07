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

import com.company.management.entity.LeavesTrans;
import com.company.management.service.LeavesTransService;

@Controller
@RequestMapping("/levt")
public class LeavesTransMvc {
	private LeavesTransService levSev;

	@Autowired
	public LeavesTransMvc(LeavesTransService levSev) {
		this.levSev = levSev;
	}

	@GetMapping("/list")
	public String list(Model themodel) {
		List<LeavesTrans> levt = levSev.findAll();
		themodel.addAttribute("leavestrans", levt);
		return "/leavesTrans/list-leavestrans";
	}

	@GetMapping("/addLevT")
	public String showForm(Model theModel) {
		LeavesTrans theEmp = new LeavesTrans();
		theModel.addAttribute("leavestrans", theEmp);
		return "leavesTrans/leavesTrans-form";

	}

	@PostMapping("/save")
	public String saveStud(@ModelAttribute("leavestrans") LeavesTrans theEmp) {
		levSev.save(theEmp);
		return "redirect:/levt/list";
	}

	@GetMapping("/showUpdFrm")
	public String showUpdFrm(@RequestParam("levtID") int theID, Model theModel) {
		LeavesTrans theStud = levSev.getByID(theID);
		theModel.addAttribute("leavestrans", theStud);
		return "leavesTrans/leavesTrans-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("levtID") int theID) {
		levSev.delete(theID);
		return "redirect:/levt/list";
	}

}
