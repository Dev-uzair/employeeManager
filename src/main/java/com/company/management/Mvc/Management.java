package com.company.management.Mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class Management {
	@GetMapping("/")
public String toMain() {
	return "/main/main";
}
}
