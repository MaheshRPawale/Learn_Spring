package com.example.demo.controller;

import com.example.demo.dto.UserRequestDto;
import com.example.demo.dto.UserResponseDto;
import com.example.demo.service.UserService;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService  userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Accept input as UserRequestDTO
    
    @PostMapping("/add")
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userDTO) {
        // Pass to service → convert → save → return DTO
        UserResponseDto response = userService.createUser(userDTO);
        return ResponseEntity.ok(response);
        
        //   return ResponseEntity.ok(userService.createUser(userDto));
    }
    @GetMapping
   public ResponseEntity<UserService> getAllUser(){
	return ResponseEntity.ok(userService);
	   
   }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserByID(@PathVariable Long id)
    {
    	return ResponseEntity.ok(userService.getUserById(id));
    	
    }
    @PutMapping("/{id}")
    public ResponseEntity<UserResponseDto> updateUser(
            @PathVariable Long id, 
            @RequestBody UserRequestDto userDto) {
        return ResponseEntity.ok(userService.updateUser(id, userDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
    
}
