package com.web.aluminio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.web.aluminio.config.JWTAuthorizationFilter;

@SpringBootApplication
public class AluminioItaliaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AluminioItaliaApplication.class, args);
	}

	@SuppressWarnings("deprecation")
	@EnableWebSecurity
	@Configuration
	class WebSecurityConfig extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.cors().and()
			.csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.antMatchers( "/trabajo/admin/**").authenticated()
				.antMatchers("/categoria/admin/**").authenticated()
				.anyRequest().permitAll();
		}
	}
}
