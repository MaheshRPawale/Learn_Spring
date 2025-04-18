package com.CollageRegister.GSM_Collage.controller;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;

import com.CollageRegister.GSM_Collage.Entity.Student;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;


@Controller

@RequestMapping("/form")

public class StudentController {

	@GetMapping("/register")
	public String showRegistrationForm(Model model)
	{
		model.addAttribute("student", new Student());
		return"register";
	}
	@PostMapping("/registerStd")
	public String registerStudent(@ModelAttribute Student student , Model model) {
	
		model.addAttribute("student",student);
		return"successform";
	}
	//http://localhost:8080/form/registerStd?Name=Mahesh&Email=MaheshHere123@gmail.com&Course=java
}

//Model  send data from the controller to the frontend (Thymeleaf, JSP, etc.).
//  in this project run register.html page then registerStd.