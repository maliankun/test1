package module;

import java.io.Serializable;

public class UserServer implements Serializable{
	private static final long serialVersionUID = -7458765400173016513L;
	private String name;
	private String sex;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	
	

}
