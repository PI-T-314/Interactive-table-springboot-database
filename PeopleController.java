package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PeopleController {
	
	@Autowired
	private PeopleService ps;
	
	@ResponseBody
	@GetMapping("/hello")
	public String sayhello() {
		return "hello from people Controller!!";
	}
	
	@GetMapping("/people")
	@ResponseBody
	public List<People> people() {
		return ps.getPeople();
	}
	
	@GetMapping("/")
	public String start() {
		return "index";
	}
	
	@GetMapping("/people-table")
	public String table(Model model) {
		model.addAttribute("people", ps.getPeople());
		return "table";
	}
	
	@GetMapping("/register-page")
	public String goToRegister(Model model) {
		People p = new People();
		model.addAttribute("people", p);
		return "registration";
	}
	
	@PostMapping("/registration-complete")
	public String register(@ModelAttribute("people") People people) {
		ps.register(people);
		return "redirect:/people-table";
	}
	
	@GetMapping("/delete")
	public String deletePerson(@RequestParam int peopleid) {
		ps.deleteperson(peopleid);
		return "redirect:/people-table";
	}
	
	@GetMapping("/update")
	public String updatePerson(@RequestParam int peopleid, Model model) {
		model.addAttribute("people", ps.getPerson(peopleid));
		
		return "registration";
	}

}
