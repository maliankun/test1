package module;

import java.io.Serializable;

public class UserInfo implements Serializable{
	
	private static final long serialVersionUID = 5196713378452611515L;
	
	private String username;
	private String userid;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	

}
