package com.example.demo.Controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.dto.PersonDto;
import com.example.demo.entity.PersonEntity;
import com.example.demo.repositries.personRepo;


@Controller
@ResponseBody
@RequestMapping("/person")
public class PersonController {

	@Autowired
	personRepo personRepo;
	
	@Autowired
	ModelMapper modelMapper;
	// save 
	
	@PostMapping
	public String savedata(@RequestBody PersonDto personDto)
	{
	//PersonEntity personEntity	=modelMapper.map(PersonDto, PersonEntity.class);
	
		PersonEntity personEntity	=modelMapper.map(personDto, PersonEntity.class);
	personRepo.save(personEntity);
	return"save data";
	}
	
	// here we use moddel mapper in method we take dto object we want to save . save provide by jpa .jpa only support entity so convert dto to entity obj
	
	
	
	//get
	@GetMapping
	public PersonDto getPersionDetails(@RequestParam(name = "perId",required = true) Integer personId)
	{
		PersonEntity person=personRepo.findById(personId).get();
		//create Dto object 
		PersonDto personDto=new PersonDto();
		// initialize dto object 

		personDto.setPersonId(person.getPersonId());
		personDto.setLastName(person.getLastName());
		personDto.setFirstName(person.getFirstName());
		personDto.setAge(person.getAge());
		return  personDto;
		
	}
	// update 
	
	// delete
	@DeleteMapping
	public String deleteData(@RequestParam(name="perId",required = true) Integer personId)
	{
		personRepo.deleteById(personId);
		return "Data was deleted";
		
	}
	
}