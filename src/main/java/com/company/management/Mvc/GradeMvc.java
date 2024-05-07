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

import com.company.management.entity.Grade;
import com.company.management.service.GradeService;

//"/grds/list"
@Controller
@RequestMapping("/grds")
public class GradeMvc {
	private GradeService grdServ;

	@Autowired
	public GradeMvc(GradeService grdServ) {
		this.grdServ = grdServ;
	}

	@GetMapping("/list")
	public String list(Model themodel) {
		List<Grade> emp = grdServ.findAll();
		themodel.addAttribute("grades", emp);
		return "/grade/list-grade";
	}

	@GetMapping("/addGrd")
	public String showForm(Model theModel) {
		Grade theEmp = new Grade();
		theModel.addAttribute("grades", theEmp);
		return "grade/Grade-form";

	}

	@PostMapping("/save")
	public String saveStud(@ModelAttribute("grades") Grade theEmp) {
		grdServ.save(theEmp);
		return "redirect:/grds/list";
	}

	@GetMapping("/showUpdFrm")
	public String showUpdFrm(@RequestParam("grdID") int theID, Model theModel) {
		Grade theStud = grdServ.getByID(theID);
		theModel.addAttribute("grades", theStud);
		return "grade/Grade-form";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam("grdID") int theID) {
		grdServ.delete(theID);
		return "redirect:/grds/list";
	}

}
