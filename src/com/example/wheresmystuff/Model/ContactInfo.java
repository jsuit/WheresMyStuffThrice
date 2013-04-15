package com.example.wheresmystuff.Model;

public class ContactInfo {
	/**
	 * This class holds the contact info for a user
	 * 
	 */
	private String email, name, zip, street, phoneNum;

	/**
	 * Constructor that takes in all the info to contact a user
	 * 
	 * @param Strings
	 *            : email, name, password, phoneNum, zip, street
	 */
	public ContactInfo(String email, String name, String phoneNum, String zip,
			String street) {

		this.email = email;
		this.name = name;
		this.phoneNum = phoneNum;
		this.zip = zip;
		this.street = street;
	}

	/**
	 * Getter method. Returns email as a String
	 * 
	 * @param
	 */

	public String getEmail() {

		return email;

	}

	/**
	 * Getter. Returns UID of user as a string
	 * 
	 * @param
	 */
	public String getName() {

		return name;

	}

	/**
	 * Getter method. Returns phone Number as a string
	 * 
	 * @param
	 */
	public String getPhoneNum() {

		return phoneNum;

	}

	/**
	 * Returns zip code of user as String
	 * 
	 * @param
	 */

	public String getZip() {

		return zip;

	}

	/**
	 * Getter method. Returns name of street of user as a string
	 * 
	 * @param
	 */
	public String getStreet() {

		return street;

	}

	/**
	 * Setter. Sets the email according to parameter
	 * 
	 * @param String
	 *            newEmail
	 */

	public void setEmail(String newEmail) {

		email = newEmail;

	}

	/**
	 * Setter. Sets the phone number according to parameter
	 * 
	 * @param String
	 *            newPhoneNum
	 */

	public void setPhoneNum(String newPhoneNum) {

		phoneNum = newPhoneNum;

	}

	/**
	 * Setter. Sets the zip code according to parameter
	 * 
	 * @param String
	 *            newZip
	 */

	public void setZip(String newZip) {

		zip = newZip;

	}

	/**
	 * Setter. Sets the Street name according to parameter
	 * 
	 * @param String
	 *            newStreet
	 */

	public void setStreet(String newStreet) {

		street = newStreet;

	}

	/**
	 * Setter. Sets the uid according to parameter
	 * 
	 * @param String
	 *            newName
	 */

	public void setName(String newName) {

		name = newName;

	}

	/**
	 * Returns the all of the contact info for a user as an array of Strings.
	 * 
	 * 
	 * 
	 * 
	 */

	public String[] getContactInfoAsArray() {
		String[] array = { this.email, this.name, this.phoneNum, this.zip,
				this.street };
		return array;
	}

}
