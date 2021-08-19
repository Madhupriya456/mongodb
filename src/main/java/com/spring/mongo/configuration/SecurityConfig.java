package com.spring.mongo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.NoOpPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.spring.mongo.filters.AuthFilter;
import com.spring.mongo.services.UserService;

@Configuration
@EnableWebMvc
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	  @Autowired
	    private UserService service;

	    @Autowired
	    private AuthFilter filter;
	    
	    private static final String[] PUBLIC_URLS = {
	    		"/v2/api-docs",
	            "/swagger-resources",
	           "/swagger-resources/**",
	            "/configuration/ui",
	            "/configuration/security",
	            "/swagger-ui.html",
	            "/webjars/**",
	            "/v3/api-docs/**",
	            "/swagger-ui/**"
	    };
	    
	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.userDetailsService(service);
	    }
	    @Bean
	    public PasswordEncoder passwordEncoder(){
	        return NoOpPasswordEncoder.getInstance();
	    }

	    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	    @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.csrf().disable().authorizeRequests()
	                .antMatchers("/signup").permitAll()
	                .antMatchers("/authenticate").permitAll()
	                .antMatchers(PUBLIC_URLS)
	                .permitAll()
	                .anyRequest()
	                .authenticated()
	                .and().exceptionHandling().and().sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);;
	    }
		
}
