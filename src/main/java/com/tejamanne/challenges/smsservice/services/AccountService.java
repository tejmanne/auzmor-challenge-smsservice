package com.tejamanne.challenges.smsservice.services;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tejamanne.challenges.smsservice.entities.Account;

public interface AccountService {

	List<Account> getAccountByUsername(String username) throws JsonProcessingException;
}
