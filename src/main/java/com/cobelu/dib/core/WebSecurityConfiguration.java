package com.cobelu.dib.core;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Use this when not using H2
		 */
//		auth.userDetailsService(userDetailsService).passwordEncoder(User.PASSWORD_ENCODER);

		/*
		 * Use this if problems with H2 testing login
		 */
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("test")
				.password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*
		 * Login link is by default at ~/login
		 * 
		 * Logout link is by default at ~/logout
		 */
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic();
	}

}
