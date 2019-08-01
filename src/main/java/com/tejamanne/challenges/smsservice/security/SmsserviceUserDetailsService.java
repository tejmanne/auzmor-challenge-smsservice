package com.tejamanne.challenges.smsservice.security;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tejamanne.challenges.smsservice.entities.Account;
import com.tejamanne.challenges.smsservice.repositories.AccountRepository;
import com.tejamanne.challenges.smsservice.services.AccountService;

@Component
public class SmsserviceUserDetailsService implements UserDetailsService {

	@Autowired
	AccountService accountService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		System.out.println("username:::::::" + username);
		List<Account> userDetailsList;
		try {
			userDetailsList = accountService.getAccountByUsername(username);
			
			if (userDetailsList.size() == 1) {
				Account user = userDetailsList.stream().findFirst().get();
				System.out.println("::::"+user.getUsername());
				System.out.println("::::"+user.getAuthId());
				return new SmsserviceUserDetails(user.getId(), user.getUsername(), user.getAuthId());
			} else if (userDetailsList.size() <= 0) {
				System.out.println("User doesn't exist");
			} else {
				System.out.println("More than one user exits with same username.");
			}
		} catch (JsonProcessingException e) {
			System.out.println("........." + e.getMessage());
			e.printStackTrace();
		}

		return null;
	}

}
