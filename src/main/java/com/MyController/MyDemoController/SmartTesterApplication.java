package com.MyController.MyDemoController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import servicecomponent.TestService;

@SpringBootApplication
public class SmartTesterApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SmartTesterApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
       
        System.out.println("Application started successfully!");
        
      
        AnnotationConfigApplicationContext context = 
            new AnnotationConfigApplicationContext(SmartTesterApplication.class);
        
        TestService testService = context.getBean(TestService.class);
        testService.testControllerDependency();
        
        context.close();
    }
}