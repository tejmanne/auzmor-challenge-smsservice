package com.tejamanne.challenges.smsservice.controllers;

import javax.naming.AuthenticationException;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tejamanne.challenges.smsservice.entities.Account;
import com.tejamanne.challenges.smsservice.objects.HTTPResponseBean;

@RestController
@RequestMapping(value = "/login-service")
public class LoginController {

	@RequestMapping(value = "/login/success", method = RequestMethod.POST)
	public HTTPResponseBean loginSuccess(@RequestAttribute(name = "authentication") Authentication authentication) {

		System.out.println("In Login Success");
		HTTPResponseBean response = new HTTPResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Login successfull");
		response.setData(authentication);
		return response;
	}

	@RequestMapping(value = "/login/failure", method = RequestMethod.POST)
	public HTTPResponseBean loginFailure(@RequestAttribute(name = "exception") AuthenticationException exception) {

		System.out.println("In Login Failure");
		HTTPResponseBean response = new HTTPResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Login failed");
		response.setData(exception);
		return response;
	}

	@RequestMapping(value = "/signup-with/email", method = RequestMethod.POST)
	public HTTPResponseBean register(@RequestBody Account account) {

		System.out.println("In Signup.......");
		HTTPResponseBean response = new HTTPResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Registration successfull");
		response.setData(account);
		return response;
	}
	
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public HTTPResponseBean test() {

		System.out.println("In Signup.......");
		HTTPResponseBean response = new HTTPResponseBean();
		response.setAuthorizationPresent(true);
		response.setLogin(true);
		response.setMessage("Registration successfull");
		response.setData(null);
		return response;
	}

}
