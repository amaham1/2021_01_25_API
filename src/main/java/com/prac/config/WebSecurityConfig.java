package com.prac.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsUtils;

import com.prac.jwt.JwtAuthenticationEntryPoint;
import com.prac.jwt.JwtAuthenticationFilter;

@Configuration
class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Bean
    public JwtAuthenticationFilter authenticationTokenFilterBean() throws Exception {
        return new JwtAuthenticationFilter();
    }
    
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.cors().and()
			.addFilterAfter(new JwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
			.authorizeRequests()
			.antMatchers("/admin/login"
					, "/user/login"
					, "/test"
					, "/test/*")
			.permitAll()
			.requestMatchers(CorsUtils::isPreFlightRequest).permitAll()
			.anyRequest().authenticated();
	}
}
    
