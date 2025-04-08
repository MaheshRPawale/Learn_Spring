package greetapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
@Controller
public class GreetController {
	
	private final GreetService  greetService;
	

    @Autowired
    public GreetController(GreetService greetService) {
        this.greetService = greetService;
    }

   
    public String greet( String name) {
        return greetService.generateGreeting(name);
    }
}
