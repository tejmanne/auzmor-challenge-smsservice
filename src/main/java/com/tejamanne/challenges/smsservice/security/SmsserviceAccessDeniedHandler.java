package com.tejamanne.challenges.smsservice.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

@Component
public class SmsserviceAccessDeniedHandler implements AccessDeniedHandler {

	private static Logger logger = LoggerFactory.getLogger(SmsserviceAccessDeniedHandler.class);

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("In Access Denied Handler.....");
		if (auth != null) {
			logger.info("User with name " + auth.getName() + " tried to access " + request.getRequestURI());
		} else {
			logger.info("Authentication is null");
		}
	}

}
