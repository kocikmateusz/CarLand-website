package com.carland.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
        .inMemoryAuthentication()
        .withUser("user").password("{noop}pass").roles("USER")
        .and()
        .withUser("admin").password("{noop}pass").roles("ADMIN");
		
		/*auth.jdbcAuthentication().dataSource(securityDataSource)
			.usersByUsernameQuery("select username,password,enabled from users where username=?")
			.authoritiesByUsernameQuery("select username,authority from authorities where username=?");

*/
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
			.antMatchers("/", "/home", "/registration").permitAll()
			.antMatchers("/sellmycar").hasAnyRole("USER")
			.anyRequest().authenticated()
        .and()
        .formLogin()
			.loginPage("/login")
			.permitAll()
		.and()
	        .logout()
	        .permitAll();
			
		
	}
}
