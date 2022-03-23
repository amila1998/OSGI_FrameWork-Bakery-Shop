package deliveryRegister;

import java.io.Serializable;

public class deliveyR implements Serializable{
	private String dName;
	private String dPhone;
	private String dUserName;
	private String dPassword;

	public deliveyR() {
	}
	public deliveyR(String dName, String dPhone, String dUserName, String dPassword) {
		super();
		this.dName = dName;
		this.dPhone = dPhone;
		this.dUserName = dUserName;
		this.dPassword = dPassword;
	}
	
	public String getdName() {
		return dName;
	}
	public void setdName(String dName) {
		this.dName = dName;
	}
	public String getdPhone() {
		return dPhone;
	}
	public void setdPhone(String dPhone) {
		this.dPhone = dPhone;
	}
	public String getdUserName() {
		return dUserName;
	}
	public void setdUserName(String dUserName) {
		this.dUserName = dUserName;
	}
	public String getdPassword() {
		return dPassword;
	}
	public void setdPassword(String dPassword) {
		this.dPassword = dPassword;
	}
	public String toString() {
		
		return "delivery preson name:" + this.dName + "\n delivery preson contact number"+this.dPhone;
	}
}
