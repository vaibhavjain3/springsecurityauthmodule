package com.accolite.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers("/**").hasAnyRole("ADMIN","USER")
			.and()
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/",true)
				.permitAll()
			.and()
				.logout()
				.invalidateHttpSession(true)
				.deleteCookies("JSESSIONID")
				.logoutUrl("/logout")
				.logoutSuccessUrl("/login?logout")
				.permitAll();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In-Memory Authentication
		auth.inMemoryAuthentication()
			.withUser("user").password("pass").roles("USER")
			.and()
			.withUser("admin").password("pass").roles("ADMIN");
	}
}
