package com.luv2code.springsecurity.demo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	// add s reference to our security datasource
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// use  jdbc authentication
		// tell Spring Security to use JDBC authentication with our data source
		auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/").hasRole("EMPLOYEE")			// for restrict access functionality
			.antMatchers("/leaders/**").hasRole("MANAGER") 	// for restrict access functionality
			.antMatchers("/systems/**").hasRole("ADMIN")  	// for restrict access functionality
			.and()
			.formLogin()
				.loginPage("/showMyLoginPage")
				.loginProcessingUrl("/authenticateTheUser")
				.permitAll()
			.and()
			.logout()										// Logged out
			.permitAll()
			.and()
			.exceptionHandling().accessDeniedPage("/access-denied"); // for Access Denied page
	}
	
	

	
}
