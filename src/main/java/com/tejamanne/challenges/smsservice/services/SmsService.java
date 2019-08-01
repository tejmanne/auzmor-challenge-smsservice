package com.tejamanne.challenges.smsservice.services;

import java.util.List;

import com.tejamanne.challenges.smsservice.entities.Account;
import com.tejamanne.challenges.smsservice.objects.SMS;

public interface SmsService {

	public List<Account> getAllAccounts();
	
	public SMS getSmsInbounds(String from, String to, String text);
	
	public SMS getSmsOutbounds(String from, String to, String text);
}
