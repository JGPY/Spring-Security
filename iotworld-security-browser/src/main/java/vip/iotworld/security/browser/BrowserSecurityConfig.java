package vip.iotworld.security.browser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import vip.iotworld.security.core.propertise.SecurityPropertise;

@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private SecurityPropertise securityPropertise;
	
	@Autowired
	private AuthenticationSuccessHandler iotworldAuthenticationSuccessHandler;
	
	@Autowired
	private AuthenticationFailureHandler iotworldAuthenticationFailureHandler;
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.formLogin()
			.loginPage("/authentication/require")
			.loginProcessingUrl("/authentication/form")
			.successHandler(iotworldAuthenticationSuccessHandler)
			.failureHandler(iotworldAuthenticationFailureHandler)
//		http.httpBasic()
			.and() 
			.authorizeRequests()
			.antMatchers("/authentication/require",
					securityPropertise.getBrowserProperties().getLoginPage()).permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.csrf().disable();
	}
}
