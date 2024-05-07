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

import com.company.management.entity.Employees;
import com.company.management.service.EmployeesService;

//to run Employee----->"/emps/list"


@Controller
@RequestMapping("/emps")
public class EmployeeMvc {
private EmployeesService emplSrv;
@Autowired
public EmployeeMvc(EmployeesService empServ) {
	emplSrv=empServ;
}

@GetMapping("/list")
public String list(Model themodel) {
	List<Employees> emp=emplSrv.findAll();
	themodel.addAttribute("employee",emp);
	return "/Employees/list-Emp";
}

@GetMapping("/addEmp")
public String showForm(Model theModel)
{
Employees theEmp =new Employees();
theModel.addAttribute("employees", theEmp);
return "Employees/employee-form";

}

@PostMapping("/save")
public String saveStud(@ModelAttribute("employees")Employees theEmp) {
emplSrv.save(theEmp);
return"redirect:/emps/list";
}


@GetMapping("/showUpdFrm")
public String showUpdFrm(@RequestParam("employeeId")int theID,Model theModel) {
Employees theStud=emplSrv.getByID(theID)	;
theModel.addAttribute("employees",theStud);
return "Employees/employee-form";
}
@GetMapping("/delete")
public String delete(@RequestParam("employeeId")int theID) {
	emplSrv.deleted(theID);
	return "redirect:/emps/list";
}
///showUpdFrm
///delete
///save
}
