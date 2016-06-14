package com.czq.shop;

public class UserInfo {
	private  String userName;
	
	private  String passWord;

	UserInfo()
	{}
	UserInfo(String userName,String passWord)
	{
		this.setPassWord(passWord);
		this.setUserName(userName);
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserName() {
		return userName;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}
	public String getPassWord() {
		return passWord;
	}
	

		
}
