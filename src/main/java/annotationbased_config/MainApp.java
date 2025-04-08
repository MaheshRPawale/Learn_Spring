package annotationbased_config;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
		public static void main(String[] args) {
			
			ApplicationContext context= new AnnotationConfigApplicationContext(CollegeConfig.class);
			Collage collage=context.getBean(Collage.class);
			collage.collegeIfo();
			
			
		}
}
