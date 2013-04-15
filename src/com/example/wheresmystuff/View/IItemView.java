package com.example.wheresmystuff.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.example.wheresmystuff.Model.Item.Item;

public interface IItemView {

	
	  /** 
	   * Tell the view what people to display
	   * 
	   * @param p the array of people to show
	   */


	<T> void call_intent(Class<T> c);
	void makeToast(String string);
	void notify_of_error(String error_message, String title);
	void confirm(String string, String string2);
	

	void setItem(Item[] i);
	void setItem(List<String> accounts);

}
