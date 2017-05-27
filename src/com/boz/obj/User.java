package com.boz.obj;

import javax.validation.constraints.NotNull;

public class User {
	private String account;
	@NotNull(message="ÃÜÂë²»ÄÜÎª¿Õ")
	private String password;
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAccount() {
		return account;
	}
	public String getPassword() {
		return password;
	}
}
