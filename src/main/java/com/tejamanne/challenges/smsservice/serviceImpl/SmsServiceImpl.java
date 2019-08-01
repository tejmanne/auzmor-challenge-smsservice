package com.tejamanne.challenges.smsservice.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.tejamanne.challenges.smsservice.entities.Account;
import com.tejamanne.challenges.smsservice.entities.PhoneNumber;
import com.tejamanne.challenges.smsservice.objects.SMS;
import com.tejamanne.challenges.smsservice.repositories.AccountRepository;
import com.tejamanne.challenges.smsservice.services.SmsService;

@Service
public class SmsServiceImpl implements SmsService {

	@Autowired
	EntityManager em;

	@Autowired
	AccountRepository accountRepository;

	public List<Account> getAllAccounts() {
		return accountRepository.findAll();
	}

	@Override
	public SMS getSmsInbounds(String from, String to, String text) {
		SMS sms = new SMS();
		List<PhoneNumber> results = null;
		try {
			String queryString = "SELECT pn FROM PhoneNumber pn INNER JOIN Account acc ON pn.accountId=acc.id WHERE pn.number='"
					+ to + "' AND acc.username='" + SecurityContextHolder.getContext().getAuthentication().getName()
					+ "'";
			TypedQuery<PhoneNumber> query = em.createQuery(queryString, PhoneNumber.class);
			results = query.getResultList();
			if (results != null && results.size() == 0) {
				sms.setError("to parameter not found");
				sms.setMessage("");
			} else if (results != null && results.size() > 0) {
				sms.setError("");
				sms.setMessage("inbound sms ok");
			} else {
				sms.setError("unknown failure");
				sms.setMessage("");
			}
			

		} catch (Exception e) {
			sms.setError("unknown failure");
			sms.setMessage("");
		}
		return sms;
	}

	@Override
	public SMS getSmsOutbounds(String from, String to, String text) {
		SMS sms = new SMS();
		List<PhoneNumber> results = null;
		try {
			String queryString = "SELECT pn FROM PhoneNumber pn INNER JOIN Account acc ON pn.accountId=acc.id WHERE pn.number='"
					+ from + "' AND acc.username='" + SecurityContextHolder.getContext().getAuthentication().getName()
					+ "'";
			TypedQuery<PhoneNumber> query = em.createQuery(queryString, PhoneNumber.class);
			results = query.getResultList();
			if (results != null && results.size() == 0) {
				sms.setError("from parameter not found");
				sms.setMessage("");
			} else if (results != null && results.size() > 0) {
				sms.setError("");
				sms.setMessage("outbound sms ok");
			} else {
				sms.setError("“unknown failure");
				sms.setMessage("");
			}

		} catch (Exception e) {
			sms.setError("“unknown failure");
			sms.setMessage("");
		}
		return sms;
	}

}
