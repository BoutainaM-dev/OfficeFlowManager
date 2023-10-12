package gestion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired(required = true)
	private CustomAuthenticationProvider authenticationProvider;
	@Autowired
	private CustomAuthenticationFailureHandler customAuthenticationFailureHandler;
	
	@Autowired
	public void configureGlobal(UserDetailsService userDetailsService, AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider).eraseCredentials(false);
	}
	
	@Override
	public void configure(WebSecurity webSecurity) throws Exception {
		webSecurity.ignoring().antMatchers("/resources/**");  
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		http.servletApi().rolePrefix("")
		.and()
			.authorizeRequests()
				.antMatchers("/forgotpassword/**").permitAll()
		.and()
			.authorizeRequests()
				.anyRequest()
					.authenticated()
		.and()
			.formLogin()
				.loginPage("/connexion")
					.loginProcessingUrl("/connexion")
						.defaultSuccessUrl("/")
							.failureHandler(customAuthenticationFailureHandler)
								.permitAll()
		.and()
			.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/deconnexion"))
					.logoutSuccessUrl("/")
						.permitAll()
							.invalidateHttpSession(true)
		.and()
			.csrf()
				.disable()
					.exceptionHandling().accessDeniedPage("/403");
	}
	
	public AccessDeniedHandler accessDeniedExceptionHandler() {
		throw new AccessDeniedException(null);
	}

	@Bean
	DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		DefaultWebSecurityExpressionHandler handler = new DefaultWebSecurityExpressionHandler();
		handler.setDefaultRolePrefix("");
		return handler;
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver createMultipartResolver() {
		CommonsMultipartResolver resolver=new CommonsMultipartResolver();
		resolver.setDefaultEncoding("utf-8");
		resolver.setMaxUploadSize(80000000);
		return resolver;
	}
	
}
