package com.cobelu.dib.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

@SuppressWarnings("deprecation")
@Configuration
@EnableWebSecurity
// @EnableGlobalMethodSecurity(prePostEnabled = true)
// @RequestMapping(value = "/login", method = RequestMethod.POST)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	DetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * Discussion on REST API authentication using Spring Boot:
		 * https://www.baeldung.com/securing-a-restful-web-service-with-spring-security
		 */

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
		// TODO: REMOVE AND CSRF DISABLE STATEMENT WHEN DONE WITH TESTING

//		http.authorizeRequests().anyRequest().authenticated().and().formLogin()
//				.successHandler(new AuthenticationSuccessHandler() {
//					@Override
//					public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
//							Authentication authentication) throws IOException, ServletException {
//						// do nothing on success
//					}
//				}).permitAll().and().logout().permitAll().and().csrf().disable();

		RestAuthenticationEntryPoint restAuthenticationEntryPoint = new RestAuthenticationEntryPoint();
		SuccessHandler successHandler = new SuccessHandler();
		SimpleUrlAuthenticationFailureHandler failureHandler = new SimpleUrlAuthenticationFailureHandler();

		http.csrf().disable().exceptionHandling().authenticationEntryPoint(restAuthenticationEntryPoint).and()
				.authorizeRequests().anyRequest().authenticated().and().formLogin().successHandler(successHandler)
				.failureHandler(failureHandler).and().logout();
	}

}
