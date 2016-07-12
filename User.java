package model;

public class User {
	private String userId, userName;
	private String userPwd;
	
	public User(){}
	
	
	public User(String userId, String userPwd, 
			String userName){
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	@Override
	public String toString(){
		return userId + "," + userPwd + "," + 
				userName;
	}
}
