package com.boz.obj;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Size(min=4,max=10,message="���Ȳ���С��4,���ܴ���10")
	@Pattern(regexp="abd",message="�������abc�ַ�")
	private String account;
	@NotNull(message="���벻��Ϊ��")
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
