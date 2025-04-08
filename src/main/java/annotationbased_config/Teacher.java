package annotationbased_config;

import org.springframework.stereotype.Component;

@Component
public class Teacher {
	
	public void teach() {
		System.out.println("I am teaching annotation base Configuration");
	}
	
}
