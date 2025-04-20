package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Mahesh;
import com.example.demo.repository.UserRepo;

@Controller
@RequestMapping("/user")
@ResponseBody
public class UserController {

	@Autowired
	UserRepo userRepo;
	
	@GetMapping("/getinfo")
	public String getData()
	{
		System.out.println("Get info");
		userRepo.getById(6);
		return "get data from db ";
		
	}
	
	// this logic is 	Hardcoded data in Java
	@PostMapping("/insert")
	public String setData()
	{
		Mahesh entityobj=new Mahesh();
		entityobj.setMy_id(19);
		entityobj.setMy_name("naresh");
		entityobj.setMyemailid("nareshdewasi2002@gamil.com");
		
		userRepo.save(entityobj);
		return "Good for basic insert testing";
	}
	
	// this logic Accepts dynamic data from JSON request body
	@PostMapping("/postuserinfo")
	public String setData1(@RequestBody Mahesh entityobj)
	{
				System.out.println("Recived:"+ entityobj.getMy_name());
				userRepo.save(entityobj);
		  return"Best for real API usage"; 
	}
	
	
	@DeleteMapping("/nisha")
	public String removeData()
	{
		userRepo.deleteById(10);
		return "i am trying to  remove myfriend nisha info";
	}
}
