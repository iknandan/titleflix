package io.titleflix;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class APIConfig  extends WebMvcConfigurerAdapter{
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {
	registry.addMapping("/**/*")
			.allowedOrigins("*")
			.allowedHeaders("Authorization", "Origin", "Content-Type")
			.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
			.allowCredentials(false)
			.maxAge(3600);
}

}
