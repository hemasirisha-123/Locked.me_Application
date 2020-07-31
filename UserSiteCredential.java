package com.LockedmeApplication;
import java.io.Serializable;

public class UserSiteCredential implements Serializable {
	private static final long serialVersionUID = 1L;
	private String siteName;
	private String loggedUser;
	private String userName;
	private String password;

	public UserSiteCredential() {
	}

	public UserSiteCredential(String siteName, String loggedUser, String userName, String password) {

		this.siteName = siteName;
		this.loggedUser = loggedUser;
		this.userName = userName;
		this.password = password;
	}

	public String getSiteName() {
		return siteName;
	}

	public void setSiteName(String siteName) {
		this.siteName = siteName;
	}

	public String getLoggedUser() {
		return loggedUser;
	}

	public void setLoggedUser(String loggedUser) {
		this.loggedUser = loggedUser;
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

	@Override
	public String toString() {
		return "UserSiteCredential [siteName=" + siteName + ", loggedUser=" + loggedUser + ", userName=" + userName
				+ ", password=" + password + "]";
	}

}


