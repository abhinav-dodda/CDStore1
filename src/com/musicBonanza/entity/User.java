package com.musicBonanza.entity;

public class User {

	private int userId;
	private String userName;
	private String signupname;
	private String signupEmail;
	private String signupPassword;
	private String confirmsignupPassword;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getSignupname() {
		return signupname;
	}
	public void setSignupname(String signupname) {
		this.signupname = signupname;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getsignupEmail() {
		return signupEmail;
	}
	public void setsignupEmail(String email) {
		this.signupEmail = email;
	}
	public String getsignupPassword() {
		return signupPassword;
	}
	public void setsignupPassword(String password) {
		this.signupPassword = password;
	}
	public String getConfirmsignupPassword() {
		return confirmsignupPassword;
	}
	public void setCofirmsignupPassword(String confirmPassword) {
		this.confirmsignupPassword = confirmPassword;
	} 
	
}
