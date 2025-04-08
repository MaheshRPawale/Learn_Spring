package greetapp;

import org.springframework.stereotype.Component;

@Component
public class GreetHelper {

	public String createGreeting(String name)
	{
		return "Hello"+ name+" ! Welcome to Spring Layered app.";
	}
}
