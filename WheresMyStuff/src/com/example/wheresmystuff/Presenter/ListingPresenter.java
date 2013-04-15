package com.example.wheresmystuff.Presenter;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.IItemView;


public class ListingPresenter {
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
	public ListingPresenter(IModel m, IItemView view, String key) {
		myModel = m;
		myView = view;
		myModel.open();
		current_user = myModel.getCurUser();
		myView.setItem(myModel.getItems(current_user, key));
		myModel.close();
	
	}
	
	
	
	
}
