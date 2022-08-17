package com.ty.passwordmanager.dto;

public class Secret {
	private int userid;
	private String appName;
	private String userName;
	private String password;
	private String description;

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getAppName() {
		return appName;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "\nPassword [userid=" + userid + ", ApplicationName=" + appName + ", userName=" + userName
				+ ", password=" + password + ", description=" + description + "]";
	}

}
