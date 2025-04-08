package Javabase_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Collage {

	private Principle principle;
	private Teacher teacher;
	
	
	
	public Collage(Principle principle, Teacher teacher) {
		super();
		this.principle = principle;
		this.teacher = teacher;
	}



	public void collageInfo()
	{
		System.out.println("Welcome to Spring College!");

	   teacher.Teach();
	   principle.principalInfo();
			}
	
}

class MainApp{
	
		public static void main(String[] args) {
			
			ApplicationContext contextobj=new AnnotationConfigApplicationContext(CollageConfig.class);
			Collage collageobj= contextobj.getBean(Collage.class);
			
			collageobj.collageInfo();
		
		}
}



