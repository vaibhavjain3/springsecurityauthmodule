package com.accolite.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/admin/**").hasRole("ADMIN")
		.antMatchers("/user/**").hasAnyRole("ADMIN","USER")
		.antMatchers("/index.html","/").authenticated()
		.antMatchers("/**").permitAll()
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
			.logoutSuccessUrl("/login")
			.permitAll();
	}
	
	/*
	 * Update the below function to change the Password Encryption Scheme 
	 * Replace `getPasswordEncoder().encode("pass")` with `"{noop}pass"` to use No Password Encryption Scheme
	 */
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// In-Memory Authentication	
		auth.inMemoryAuthentication()
			.withUser("user").password(getPasswordEncoder().encode("pass")).roles("USER")
			.and()
			.withUser("admin").password(getPasswordEncoder().encode("pass")).roles("ADMIN");
	}
}
