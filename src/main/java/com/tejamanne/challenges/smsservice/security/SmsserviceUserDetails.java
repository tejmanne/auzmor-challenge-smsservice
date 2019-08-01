package com.tejamanne.challenges.smsservice.security;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;

public class SmsserviceUserDetails implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Long accountId;
	String username;
	String password;
	List<GrantedAuthority> authorities;
	boolean accountNonExpired = true;
	boolean accountNonLocked = true;
	boolean credentialsNonExpired = true;
	boolean enabled = true;

	public SmsserviceUserDetails(Long accountId, String username, String password) {
		this.accountId = accountId;
		this.username = username;
		this.password = password;
	}

	public Long getAccountId() {
		return accountId;
	}

	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {

		return password;
	}

	@Override
	public String getUsername() {

		return username;
	}

	@Override
	public boolean isAccountNonExpired() {

		return accountNonExpired;
	}

	@Override
	public boolean isAccountNonLocked() {

		return accountNonLocked;
	}

	@Override
	public boolean isCredentialsNonExpired() {

		return credentialsNonExpired;
	}

	@Override
	public boolean isEnabled() {

		return enabled;
	}

}
