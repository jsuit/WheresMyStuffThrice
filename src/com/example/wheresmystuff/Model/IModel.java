package com.example.wheresmystuff.Model;

import java.util.Collection;
import java.util.List;

import com.example.wheresmystuff.Model.Item.Item;

import android.database.Cursor;
import android.database.SQLException;

public interface IModel {

	/**
	 * Add a person to the model
	 * 
	 * @param p
	 *            the person to add
	 * @return a long. -1 if error
	 */
	long addPerson(User p);

	/**
	 * Lookup a person by their id and password
	 * 
	 * @param uid
	 *            ,password the two things to search fby
	 * 
	 * @return returns true if we find the user; false otherwise.
	 */
	boolean findPerson(String u_name, String password);

	/**
	 * Opens the connection to the database
	 * 
	 * 
	 */
	void open() throws SQLException;

	/**
	 * find if there exists a user by their id.
	 * 
	 * @param String
	 *            uid
	 * @return true if user exists; false otherwise
	 */

	boolean find_uid(String uid);

	/**
	 * Returns the number of Login Attempts by a user. Used to determine if that
	 * user is locked or not.
	 * 
	 * @param String
	 *            u_name, name of user
	 */

	int getLoginAttempts(String u_name);

	/**
	 * Close the connection to database. Must make sure that it is already open
	 * before closing it.
	 * 
	 * @param none
	 * @return void
	 */

	void close();

	/**
	 * Increases the number of times a user has attempted to login in.
	 * 
	 * @param the
	 *            new number of times the user has attempted to login.
	 */

	void increase_login_attempts(int i, String u_name);

	/**
	 * Sets a user to locked
	 * 
	 * @param the
	 *            user id of the user to be locked
	 */
	void setLocked(String u_name);

	/**
	 * Makes the usr referenced by name, the current user
	 * 
	 * @param String
	 *            the name of the usr
	 */

	void setCurUser(String name);

	/**
	 * Returns the current user.
	 * 
	 * @param void
	 * @return String the current user
	 */
	String getCurUser();

	/**
	 * Sees if user is an admin. Returns true if user is admin; false otherwise.
	 * 
	 * @param String
	 *            the uid to search by
	 * @return boolean
	 */
	boolean isAdmin(String uid);

	/**
	 * A method that determines if there is already a user with uid and
	 * password. Returns true if user exists; false otherwise.
	 * 
	 * @param String
	 *            password, uid of user to search for
	 * @return boolean
	 */
	boolean find_password(String password, String uid);

	/**
	 * Return a collection of the uids of users that have been locked out.
	 * 
	 * @param void
	 * @return Collection<String> uid of the users that are locked out
	 */

	Collection<String> getLockedAccounts();

	/**
	 * Set an Account to unlocked. Account can be locked or unlocked and method
	 * still works.
	 * 
	 * @param String
	 *            uid of user to unlock
	 * @return void
	 */
	void unlockAccount(String uid);

	/**
	 * Makes a user a non-admin.
	 * 
	 * @param String
	 *            uid of user to search for
	 * @return void
	 * 
	 * 
	 */

	void removeAdmin(String uid);

	/**
	 * Method that makes a user an admin. User can already be admin or not
	 * 
	 * @param String
	 *            uid of user to make admin
	 * @return boolean
	 */

	void setAdmin(String uid);

	/**
	 * Method that returns the items of a certain kind of a user.
	 * 
	 * @param String
	 *            uid of user and a key to know what kind of item we want to
	 *            search
	 * @return array of Items of a kind key
	 */
	Item[] getItems(String current_user, String key);

	/**
	 * Set an Account to locked. Account can be locked or unlocked and method
	 * still works.
	 * 
	 * @param String
	 *            uid of user to unlock
	 * @return void
	 */

	void lockAccount(String uid);

	/**
	 * Deletes a user
	 * 
	 * @param String
	 *            uid of user to unlock
	 * @return void
	 */

	/**
	 * Removes user from system
	 * 
	 * @param String
	 *            uid of user to remove
	 * @return an int
	 */
	int removeUser(String uid);

	/**
	 * get all Accounts in the system
	 * 
	 * @param String
	 *            void
	 * @return void
	 */

	List<String> getAccounts();

	/**
	 * determines if uid has a given password. Returns true if usr has given
	 * password; else false;
	 * 
	 * @param String
	 *            uid of user and user's password
	 * @return boolean
	 */
	boolean find_email(String email, String uid);

	/**
	 * Method finds all items of a certain kind with a filter on items status
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByStatus(String lost_etc_categories, String refined_search);

	/**
	 * Method finds all items of a certain kind with filter on items Category
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByCategory(String lost_etc_categories, String refined_search);

	/**
	 * Method finds all items of a certain kind with a filter on Date
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByDate(String lost_etc_categories, String refined_search);

	/**
	 * Saves Item to model.
	 * 
	 * @param String
	 *            name, description, status, int keep, heir, misc (what the item
	 *            is), Long date, String current user, street of user, zip code
	 *            of user, String type (lost, found, etc).
	 * @return Cursor
	 */
	long saveItem(String name, String description, String status, int keep,
			int heir, int misc, Long date, String curUser, String street,
			String zip, String type);

	/**
	 * Searches for an Item by Name and Location
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByItemName(String lost_etc_categories, String[] strings);

	/**
	 * Searches for item by Zip
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByZip(String lost_etc_categories, String refined_search);

	/**
	 * Method searches for item by Name Only
	 * 
	 * @param String
	 *            kind of item to search (lost, etc), String refined_search
	 *            filter
	 * @return Cursor
	 */
	Cursor searchByItemName(String lost_etc_categories, String itemName);

}
