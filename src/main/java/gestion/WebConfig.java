package gestion;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		ConnectedUserInterceptor myInterceptor = new ConnectedUserInterceptor();
		registry.addInterceptor(myInterceptor);
	}
	
}
