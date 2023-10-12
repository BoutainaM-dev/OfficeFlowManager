package gestion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication 
@ComponentScan(basePackages = "gestion") 
public class Application {

	public static void main(String[] args) {
//		System.setProperty("server.servlet.context-path", "/university");
		SpringApplication app = new SpringApplication(Application.class);
		app.run(args);
	}
	
	
}
