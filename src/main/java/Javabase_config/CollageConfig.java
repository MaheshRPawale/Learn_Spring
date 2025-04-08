package Javabase_config;

import java.security.Principal;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration

public class CollageConfig {

	@Bean
	public Principle principal()
	{
		return new Principle();
		
	}
	@Bean
	public Teacher teacher()
	{
		return new Teacher();
		
	}
	@Bean
	public Collage collage()
	{
		return new Collage(principal(), teacher());
		
	}
}
