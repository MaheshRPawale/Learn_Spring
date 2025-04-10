package restapicontroller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserRequestController {
    
    @GetMapping
    public String getUser() {
        System.out.println("GET method called by user");
        return "GET response from server - user data";
    }
    
    @PostMapping
    public String postUser() {
        System.out.println("POST method called by user");
        return "User created successfully";
    }
    
    @PutMapping
    public String putUser() {
        System.out.println("PUT method called by user");
        return "User updated successfully";
    }
    
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        System.out.println("DELETE method called for user ID: " + id);
        return "User with ID " + id + " deleted";
    }
}