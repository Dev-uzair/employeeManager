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

import com.company.management.entity.Department;
import com.company.management.service.DepartmentService;

/*
 to run department copy this  ------------------> "/depts/list"
 */

@Controller
@RequestMapping("/depts")
public class DepartmentMvc {
	private DepartmentService deptService;
@Autowired
	public DepartmentMvc(DepartmentService deptServ) {
		deptService=deptServ;
	}
@GetMapping("/list")
public String list( Model theModel ) {
	List<Department> depts=deptService.findAll();
	theModel.addAttribute("departments",depts);
	return "department/list-Dept";
}
	@GetMapping("/addDept")
public String showForm(Model theModel)
{
	Department thedept =new Department();
	theModel.addAttribute("departments", thedept);
	return "department/department-form";
	
}

@PostMapping("/save")
public String saveStud(@ModelAttribute("departments")Department thedept) {
deptService.save(thedept);
return"redirect:/depts/list";
}

@GetMapping("/showUpdFrm")
public String showUpdFrm(@RequestParam("deptID")int theID,Model theModel) {
Department theStud=deptService.getByID(theID)	;
theModel.addAttribute("departments",theStud);
return "department/department-form";
}
@GetMapping("/delete")
public String delete(@RequestParam("deptID")int theID) {
	deptService.delete(theID);
	return "redirect:/depts/list";
}
}
