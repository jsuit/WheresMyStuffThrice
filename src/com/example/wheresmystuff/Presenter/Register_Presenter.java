package com.example.wheresmystuff.Presenter;




import android.util.Log;

import com.example.wheresmystuff.Model.Admin;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.RegularUser;
import com.example.wheresmystuff.Model.User;
import com.example.wheresmystuff.View.ILoginView;
import com.example.wheresmystuff.View.Register;
import com.example.wheresmystuff.View.mainUserScreen;
import com.example.wheresmystuff.validation.Validation;


public class Register_Presenter {

	private final IModel myModel;
	private final ILoginView myView;
	
	
	public Register_Presenter(ILoginView v, IModel m){
		myModel = m;
		myView = v;
	}
	
	public  void validate(String name, String phone_num, String  address, String email, String password, String check_password){
		
			String [] error_messages = Validation.validate(name, phone_num, address, email, password, check_password);
			StringBuffer error_text = new StringBuffer();
			for(int i=0; i< error_messages.length; i++) {
					if(error_messages[i] != null) error_text.append(error_messages[i]);
			}
		
			if(error_text.length() != 0){
				myView.notify_of_error(error_text.toString());
				
			}//now we make sure that we don't already have this uid and password
			else{
					myModel.open();
					boolean already_taken = myModel.find_uid(name);
					if(already_taken){
						//set up dialog saying to re-enter user_name
						((Register) myView).alreadyTaken("User Name Already Taken");
						
					}else{
						//create new_user. save the user. go to welcome page
						String [] strings = address.split("//s");
						boolean switchKey = false;
						//if switchkey is true, 
						if(strings.length == 1)
							switchKey = true;
						User user;
						 if(myModel.isAdmin(name)){
							if(switchKey){
								user = new Admin(email, name ,password, phone_num, strings[0], strings[0], 0);
							}else 
								user = new Admin(email, name ,password, phone_num, strings[0], strings[1], 0);
						}else{
							if(switchKey)
								user = new RegularUser(email, name ,password, phone_num, strings[0], strings[0], 0);
							else
								user = new RegularUser(email, name ,password, phone_num, strings[0], strings[1], 0);
							}
						long id = myModel.addPerson(user);
						if(id == -1){
							myView.notify_of_error("Failed to insert user");
							Log.d("Register_Presenter", "Failed to insert user " + name);
							user = null;
						}else{
							myView.call_intent(mainUserScreen.class);
						}
						myModel.setCurUser(name);
						myModel.close();
					}
				
			}
	
	
	}

	
}