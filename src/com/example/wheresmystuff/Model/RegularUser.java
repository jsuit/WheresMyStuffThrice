package com.example.wheresmystuff.Model;

/**
 * Reg User. Doesn't have admin priveleges.
 * 
 * 
 */

public class RegularUser implements User {

	private String email, password, zip, street, phoneNum;
	private boolean acc_status, admin_status;
	private ContactInfo contact_info;
	private int login = 0;

	/**
	 * Constructor that takes in the information of the user.
	 * 
	 * @param email
	 *            , name, password, phoneNum, zip, stret, int login attempts
	 */

	public RegularUser(String email, String name, String password,
			String phoneNum, String zip, String street, int login_attempt) {

		this.password = password;
		// abstract the contactInfo away from user
		contact_info = new ContactInfo(email, name, phoneNum, zip, street);
		login = login_attempt;
		admin_status = false;
		acc_status = false;
	}

	@Override
	public boolean getAdminStatus() {

		return admin_status;

	}

	@Override
	public boolean getAccStatus() {

		return acc_status;

	}

	@Override
	public String getEmail() {

		return contact_info.getEmail();

	}

	@Override
	public String getName() {

		return contact_info.getName();
	}

	@Override
	public String getPhoneNum() {

		return contact_info.getPhoneNum();

	}

	@Override
	public String getZip() {

		return contact_info.getZip();

	}

	@Override
	public String getStreet() {

		return contact_info.getStreet();

	}

	@Override
	public void setAdminStatus(boolean bool) {

		admin_status = bool;

	}

	@Override
	public void setAccStatus(boolean bool) {
		// if true,then unlocked
		acc_status = bool;
		if (bool)
			this.login = 0;

	}

	@Override
	public void setEmail(String newEmail) {

		contact_info.setEmail(newEmail);

	}

	@Override
	public void setName(String newName) {

		contact_info.setName(newName);

	}

	@Override
	public void setPhoneNum(String newPhoneNum) {

		contact_info.setPhoneNum(newPhoneNum);

	}

	@Override
	public void setZip(String newZip) {

		contact_info.setZip(newZip);

	}

	@Override
	public void setStreet(String newStreet) {

		contact_info.setStreet(newStreet);
	}

	@Override
	public ContactInfo getContactInfo() {
		// TODO Auto-generated method stub
		return contact_info;
	}

	@Override
	public String[] getContactInfoAsArray() {
		// TODO Auto-generated method stub
		return this.contact_info.getContactInfoAsArray();
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public int getLoginAttempts() {
		return this.login;

	}

	@Override
	/**
	 * Increase the user's login attempts.Doesn't go beyond 3.
	 * 
	 * @return String
	 */
	
	public void increaseLoginAttempts() {

		if (login < 3)
			this.login = login + 1;
		else
			this.login = 3;
	}


	@Override
	public boolean isAdmin() {
		return false;
	}

}
