package tracker;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/api/**/*")
		.allowedOrigins("http://mocker.egen.io/")
		.allowedMethods("PUT", "DELETE","POST","GET","OPTIONS")
		.allowedHeaders("header1", "header2", "header3")
		.exposedHeaders("header1", "header2")
		.allowCredentials(false).maxAge(3600);
	}
	
	

}
