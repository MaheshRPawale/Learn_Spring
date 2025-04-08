package greetapp;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "greetapp")
public class AppConfig {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext contextobj= new AnnotationConfigApplicationContext(AppConfig.class);
		 GreetController controller = contextobj.getBean(GreetController.class);
	        System.out.println(controller);

		
	}
}
