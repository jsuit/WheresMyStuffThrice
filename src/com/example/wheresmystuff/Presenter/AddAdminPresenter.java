package com.example.wheresmystuff.Presenter;

import android.util.Log;

import com.example.wheresmystuff.Model.Admin;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.User;
import com.example.wheresmystuff.View.AddRemoveAdmin;
import com.example.wheresmystuff.View.Register;
import com.example.wheresmystuff.View.mainUserScreen;
import com.example.wheresmystuff.validation.Validation;

/**
 * Presenter class to add Admin to system, or changing status to Admin of existing user
 * 
 * 
 */

public class AddAdminPresenter {

	private final IModel myModel;
	private final AddRemoveAdmin myView;
	
	public AddAdminPresenter(AddRemoveAdmin v, IModel m) {
		
		myModel = m;
		myView = v;
		
	}
	
	/**
     *  Validates whether we have the right info to create a new user that is admin. Else Display error message 
     * 
     * @param String name, email, password, check_password
     *	@return void
     */
	
	public void validate(String name, String email, String password, String check_password) {
		
		String [] error_messages = Validation.validate(name, null, null, email, password, check_password);
		StringBuffer error_text = new StringBuffer();
		for(int i=0; i< error_messages.length; i++) {
				if(error_messages[i] != null) error_text.append(error_messages[i]);
		}
		
		if(error_text.length() != 0){
			myView.notify_of_error(error_text.toString());
			
		}
		else {
			myModel.open();
			boolean nameTaken = myModel.find_uid(name);
			if (nameTaken) {
				myView.alreadyTaken("User Name Already Taken");
				
			}
			else {
				User user = new Admin(email, name, password, null, null, null, 0);
				long id = myModel.addPerson(user);
				if(id == -1){
					myView.notify_of_error("Failed to insert user");
					Log.d("Register_Presenter", "Failed to insert user " + name);
					user = null;
				}
				myModel.close();
				myView.finish();
			}
			
		}
		
	}
	
	/**
     *  Changes the status of current usr to admin.
     * 
     * @param String name, email, password, check_password, dummy
     *	@return void
     */
	
	public void validate(String name, String email, String password, String check_password, String key){
		
		String [] error_messages = Validation.validate(name, null, null, email, password, check_password);
		StringBuffer error_text = new StringBuffer();
		for(int i=0; i< error_messages.length; i++) {
				if(error_messages[i] != null) error_text.append(error_messages[i]);
		}
		
		if(error_text.length() != 0){
			myView.notify_of_error(error_text.toString());
			
		}
		
		else {
			myModel.open();
			boolean personFound = myModel.findPerson(name, check_password);
			boolean rightPassword = myModel.find_email(email, name);
			//if person is not found or wrong password, display error message
			if (!(personFound && rightPassword)) {
				myView.alreadyTaken("Incorrect Info");	
			}
			else {
				//if saving admin
				if("s".compareTo(key)==0){
					myModel.setAdmin(name);
					myView.notify_of_error("Set " + name + " to an Admin.");
				}else{
					///remove admin status as long as it is not the user "admin"
					if("admin".compareTo(name) != 0){
						myModel.removeAdmin(name);
						myView.notify_of_error("Removed " + name);
					}
				
				}
				myModel.close();
				myView.finish();
			}
		
		}
	
	}
	
}
