package com.example.wheresmystuff.Presenter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import android.view.View;

import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.View.DisplayItems;
import com.example.wheresmystuff.View.IItemView;
import com.example.wheresmystuff.View.ILoginView;
import com.example.wheresmystuff.View.MainActivity;
import com.example.wheresmystuff.View.RemoveUser;


public class UserListingPresenter {
	private final  IModel myModel;
	/** the view to display to */
	private final IItemView myView;
	private String current_user;
	

	/**
	 * Make a new presenter. Gets the the items. And sets the view to have the items. The key tells it what kind of items to get (lost, 
	 * found, donations, needed).
	 * @param m the model
	 * @param view the view
	 */
	public UserListingPresenter(IModel m, IItemView view) {
		myModel = m;
		
		myView = view;
		myModel.open();
		List<String> accounts = myModel.getAccounts();
		myView.setItem(accounts);
		myModel.close();
	
	}


	
	public void remove(String name){
		if("admin".compareTo(name) == 0){
			myView.notify_of_error("Can't remove admin", "Error");
		}else{
			
			myModel.removeUser(name);
			((RemoveUser) myView).update(name);
			myView.notify_of_error("Removed " + name, "Removal");
			String string = myModel.getCurUser();
			myModel.open();
			if(myModel.getCurUser().compareTo(name) == 0){
				myView.call_intent(MainActivity.class);
			}
			myModel.close();
		}
	}

	
	
	
}
