package annotationbased_config;

import org.springframework.stereotype.Component;

@Component
public class Principal {
	
	public void principalInfo()
	{
		System.out.println("Hi, I am the principal of the spring college.");
	}
}
