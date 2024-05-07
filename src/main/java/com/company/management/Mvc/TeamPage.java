package com.company.management.Mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/team")
public class TeamPage {
	@GetMapping("/")
public String toTeam() {
	return "/team/team";
}
}
