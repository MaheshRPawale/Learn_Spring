package greetapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetService {

	private final GreetHelper greetHelper;

	@Autowired
	public GreetService(GreetHelper greetHelper)
	{
		this.greetHelper=greetHelper;
	}
	
	public String generateGreeting(String name)
	{
		return greetHelper.createGreeting(name);
	}
}
