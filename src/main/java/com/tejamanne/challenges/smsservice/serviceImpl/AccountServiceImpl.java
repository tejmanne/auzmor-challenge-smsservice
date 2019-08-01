package com.tejamanne.challenges.smsservice.serviceImpl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tejamanne.challenges.smsservice.entities.Account;
import com.tejamanne.challenges.smsservice.repositories.AccountRepository;
import com.tejamanne.challenges.smsservice.services.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	EntityManager em;

	@Override
	public List<Account> getAccountByUsername(String username) throws JsonProcessingException {
		List<Account> results=null;
		
		try {
			String queryString = "SELECT a FROM Account a WHERE username='"+username+"'";
			TypedQuery<Account> query = em.createQuery(queryString, Account.class);
			results = query.getResultList();
			System.out.println("........." + results.size());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return results;
	}

	public static Specification<Account> findAccountByUsername(String username) {
		return new Specification<Account>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Predicate toPredicate(Root<Account> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

				return builder.equal(root.get("username"), username);
			}
		};
	}

}
