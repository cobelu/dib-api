package com.cobelu.dib.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * TODO: Swap for not using H2
		 */
		// auth.userDetailsService(userDetailsService).passwordEncoder(User.PASSWORD_ENCODER);
		
		auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("test").password("password").roles("USER");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO: REMOVE AND CSRF DISABLE STATEMENT WHEN DONE WITH TESTING
		http.authorizeRequests().anyRequest().authenticated().and().httpBasic().and().csrf().disable();
	}

}
