package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.LockOrUnlock;

public class LockUser {

	private final IModel myModel;
	private final LockOrUnlock myView;

	public LockUser(LockOrUnlock v, IModel m) {

		myModel = m;
		myView = v;

	}

	public void lockUser(String username) {
		if("admin".compareTo(username) == 0){
			myView.notify_of_error("Can't lock super-admin");
			return;
		}
		myModel.open();
		if (myModel.find_uid(username)) {
			myModel.setLocked(username);
			myView.notify_of_error("Locked " + username);
		}else{
			myView.notify_of_error("User not Found");
		}
		myModel.close();

	}

}