package com.example.wheresmystuff.Model;

/**
 * User Interface. All users will extend this interface
 * 
 * 
 */

public interface User {

	/**
	 * Returns user's password as String
	 * 
	 * @return String password
	 * 
	 */
	public String getPassword();

	/**
	 * Returns user's attempted logins
	 * 
	 * @return int # of attempts to login
	 * 
	 */

	public int getLoginAttempts();

	/**
	 * Returns the user's contact info
	 * 
	 * @return ContactInfo
	 * 
	 */

	public ContactInfo getContactInfo();

	public String[] getContactInfoAsArray();

	/**
	 * Increases the number of times a user has attempted to login.
	 * 
	 * 
	 * 
	 */

	public void increaseLoginAttempts();

	/**
	 * Gets user id of user
	 * 
	 * @return String uid
	 * 
	 */

	public String getName();

	/**
	 * Returns true if user is admin. False otherwise..
	 * 
	 * @return boolean
	 * 
	 */
	public boolean isAdmin();

	/**
	 * Gets Phone Number of user as String.
	 * 
	 * @return String phone number
	 * 
	 */

	public String getPhoneNum();

	/**
	 * Gets Zip Code as String.
	 * 
	 * @return String zip code
	 * 
	 */

	public String getZip();

	/**
	 * Gets Street Name as String.
	 * 
	 * @return String name of street
	 * 
	 */

	public String getStreet();

	/**
	 * Sets account to admin if argument is true.
	 * 
	 * @param boolean bool
	 * 
	 */

	public void setAdminStatus(boolean bool);

	/**
	 * Sets account to lock if argument is true.
	 * 
	 * @param boolean bool
	 * 
	 * 
	 * 
	 *        void setAccStatus(boolean bool);
	 * 
	 *        /** Set user's email address
	 * 
	 * @param String
	 *            newEmail
	 * 
	 */

	public void setEmail(String newEmail);

	/**
	 * Set user_id.
	 * 
	 * @param String
	 *            newName
	 * 
	 */

	public void setName(String newName);

	/**
	 * Sets Phone Number
	 * 
	 * @param String
	 *            newPhoneNum
	 */

	public void setPhoneNum(String newPhoneNum);

	/**
	 * Sets the street name to given argument
	 * 
	 * @param String
	 *            newZip
	 */

	public void setZip(String newZip);

	/**
	 * Sets the street name to given argument
	 * 
	 * @param String
	 *            newStreet
	 */

	public void setStreet(String newStreet);

	/**
	 * Return True if user is locked. Return false if not
	 * 
	 * @return Boolean
	 */
	public boolean getAccStatus();

	/**
	 * Return the admin_status of user. Return true if admin; false otherwise.
	 * 
	 * @return Boolean
	 */
	public boolean getAdminStatus();

	/**
	 * Return the email of user.
	 * 
	 * @return String
	 */
	public String getEmail();

	/**
	 * set status to locked if argument is true.
	 * 
	 * @param boolean bool
	 * @return void
	 */
	void setAccStatus(boolean bool);

}
