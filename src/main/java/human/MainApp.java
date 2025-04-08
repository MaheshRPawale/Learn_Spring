package human;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(ConfigForDI.class);
		Heart heart=context.getBean(Heart.class);
		
		heart.beat();
		heart.pumpBlood();
	}

}
