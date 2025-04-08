package annotationbased_config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Collage {

	@Autowired
	private Principal principal;
	
	@Autowired 
	private Teacher teacher;
	
	public void collegeIfo() {
		System.out.println("Welcome to Spring College!");
		principal.principalInfo();
		teacher.teach();
	}
}
