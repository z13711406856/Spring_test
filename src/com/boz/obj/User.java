package com.boz.obj;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	@Size(min=4,max=10,message="长度不能小于4,不能大于10")
	@Pattern(regexp="abd",message="必须包含abc字符")
	private String account;
	@NotNull(message="密码不能为空")
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
