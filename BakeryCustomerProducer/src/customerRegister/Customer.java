package customerRegister;

import java.io.Serializable;

public class Customer implements Serializable {
	private String cName;
	private String cAddress;
	private String cEmail;
	private String cPhone;
	private String _id;
	
	
	public Customer() {}
	
	public Customer(String cName, String cAddress, String cEmail, String cPPhone) {
		super();
		this.cName = cName;
		this.cAddress = cAddress;
		this.cEmail = cEmail;
		this.cPhone = cPPhone;
		
	}
	
	/**
	 * @return the cName
	 */
	public String getcName() {
		return cName;
	}
	/**
	 * @param cName the cName to set
	 */
	public void setcName(String cName) {
		this.cName = cName;
	}
	/**
	 * @return the cAddress
	 */
	public String getcAddress() {
		return cAddress;
	}
	/**
	 * @param cAddress the cAddress to set
	 */
	public void setcAddress(String cAddress) {
		this.cAddress = cAddress;
	}
	/**
	 * @return the cEmail
	 */
	public String getcEmail() {
		return cEmail;
	}
	/**
	 * @param cEmail the cEmail to set
	 */
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}

	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
	
	/**
	 * @return the cPhone
	 */
	public String getcPhone() {
		return cPhone;
	}

	/**
	 * @param cPhone the cPhone to set
	 */
	public void setcPhone(String cPhone) {
		this.cPhone = cPhone;
	}

	@Override
	public String toString() {
				
		return "Customer ID:" + this._id + "\nCustomer Name: " + this.cName + "\nCustomer Email:" + this.cEmail + "\nCustopmer Address" + this.cAddress + "\nCustomer Password"+this.cPhone;
	}
	

}
