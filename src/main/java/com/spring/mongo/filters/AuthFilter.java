package com.spring.mongo.filters;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;



import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.spring.mongo.services.UserService;
import com.spring.mongo.util.JwtUtil;


@Component
public class AuthFilter extends OncePerRequestFilter{
	
	@Autowired
	JwtUtil util;
	
	@Autowired
	UserService service;
	@Override
	    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
	    		throws ServletException, IOException 
	    {
	    	
		    String authorization=request.getHeader("Authorization");
		    
		   	          
//			String url= request.getRequestURI();
//			
//			List<String> exemptedList = new ArrayList<String>();
//			exemptedList .add("/swagger");
//			exemptedList .add("/webjars");
//			exemptedList .add("/images");
//			exemptedList .add("/v2");
//			exemptedList .add("/csrf");
//	//		exemptedList .add("/key");
//	//		exemptedList .add("/signup");
////			exemptedList .add("/all");
////			exemptedList .add("/update");
////			exemptedList .add("/delete");
//			
//     		boolean isListallowed=false;
//			for (String string : exemptedList) 
//			{
//				if(url.contains(string))
//				{
//					isListallowed = true;
//				}
//			}
//	    	if(isListallowed)
//	    	{
//	    		filterChain.doFilter(request, response);
//	    		response.getStatus();
//	    	}
//	    	else
//	    	{    	
//	    		if(authorization.equals(SECRET_TOKEN))
//	    		{
//	    			filterChain.doFilter(request, response);
//	        		response.getStatus();
//	    		}
//	    		else
//	    		{
//	    			System.out.println("access denied");
//	    		}
//	    	}
//		
		    String token = null;
	        String userName = null;

	        if (authorization != null && authorization.startsWith("Bearer ")) {
	            token = authorization.substring(7);
	            userName = util.extractUsername(token);
	        }

	        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

	            UserDetails userDetails = service.loadUserByUsername(userName);

	            if (util.validateToken(token, userDetails)) {

	                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
	                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
	                usernamePasswordAuthenticationToken
	                        .setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
	                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
	            }
	        }
	        filterChain.doFilter(request,response);
	    }
		
	    }		

