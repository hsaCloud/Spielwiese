package de.hsa.cloud.cms.core.requestHandler;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean
@RequestScoped
public class LoginHandler {

	private String user;
	private String password;
	private String output;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	public void validateLogin() {
		if (user.equals("user") && password.equals("abc")) {
			this.output = "Access granted!";
		} else {
			this.output = "Access denie!";
		}
	}
}
