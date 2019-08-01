package com.tejamanne.challenges.smsservice.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "phone_number_id_seq_generator")
    @SequenceGenerator(
            name = "phone_number_id_seq_generator",
            sequenceName = "phone_number_id_seq"
    )
	Integer id;

	@Column(columnDefinition = "number")
	String number;


	@Column(columnDefinition = "account_id")
	Integer accountId;
	

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="accountId", referencedColumnName="id", insertable=false, updatable=false)
	Account account;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

}
