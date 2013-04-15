package com.example.wheresmystuff.Presenter;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import android.database.Cursor;

import com.example.wheresmystuff.DB_Helper;
import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Model.Item.LostItem;
import com.example.wheresmystuff.View.IItemView2;
import com.example.wheresmystuff.validation.CheckDisplayAll;
import com.example.wheresmystuff.validation.CheckNameLocation;

/**
 * Class that searches and tells the UI how to display itself.
 *
 */

public class advancedSearchPresenter {

	//criteria is category, date, item name, etc.
	private String criteria;
	private final IModel myModel;
	/** the view to display to */
	private final IItemView2 myView;
	private String current_user;
	
	private String refined_search;
	private String kind;
	private String lost_etc_categories;
	private String status;

	/**
     * Constructor
     * 
     * @param myModel, view
     *
     */
	public advancedSearchPresenter(IModel myModel, IItemView2 view) {
		myView = view;
		this.myModel = myModel;
	}

	/**
     *  Criteria that determines what we are to search
     * 
     * @param String criteria
     *	@return void
     */
	public void getCriteria(String criteria) {
		this.criteria = criteria;
		this.criteria = this.criteria.toLowerCase(Locale.US);

	}


	
	

	public void displayCategory() {
		// TODO Auto-generated method stub
		if ("category".compareTo(criteria) == 0) {
			myView.makeSpinnerVisible();
			myView.makeDatePickerInvisible();
			myView.makeRadioInvisible();
			myView.makeAutoCompleteTextViewInvisible();
		} else if ("date".compareTo(criteria) == 0) {
			myView.makeInvisibleSpinner();
			myView.makeDatePickerVisible();
			myView.makeRadioInvisible();
			myView.makeAutoCompleteTextViewInvisible();
		} else if ("status".compareTo(criteria) == 0) {
			myView.makeDatePickerInvisible();
			myView.makeInvisibleSpinner();
			myView.makeRadioVisible();
			myView.makeAutoCompleteTextViewInvisible();
		}else if("item name".compareTo(criteria) == 0){
			myView.makeDatePickerInvisible();
			myView.makeInvisibleSpinner();
			myView.makeRadioInvisible();
			myView.setTextToNull();
			myView.setHint("Item Name");
			myView.makeAutoCompleteTextViewVisible();
		}
	}


	/**
	 * check to make sure we have the right amount of info. param:
	 * search_criteria: is a string, that tells us how to search
	 * search_criteria_radio: from radio buttons that lost, found, needed,
	 * donations kind: refine search, may be null
	 * 
	 * @param status
	 **/
	public boolean check(final String search_criteria_radio,
			final String search_criteria, final String kind) {
		// TODO Auto-generated method stub
		CheckDisplayAll checkObject = new CheckDisplayAll() {

			@Override
			public boolean check() {

				if (search_criteria_radio == null) {
					return true;
				} else if ("category".compareTo(criteria) == 0) {
					if (kind == null) {
						return true;
					}

				}
				return false;
			}

			@Override
			public String getNameOrlocation() {
				// TODO Auto-generated method stub
				return null;
			}
		};

		if (checkObject.check()) {
			myView.notify_of_error("Did not get enough info", "Error");
			return false;
		} else {
			lost_etc_categories = search_criteria_radio;
			refined_search = kind;
			return true;
		}
	}

	
	public void search(boolean proceed, boolean date, boolean category,
			boolean status) {
		// TODO Auto-generated method stub
		Cursor c = null;
		if (!proceed)
			return;
		myModel.open();
		if (date)
			c= myModel.searchByDate(lost_etc_categories, refined_search);
		else if (category) {
			if("item name".compareTo(criteria) == 0){
				String [] array = myView.getNameLocation();
				CheckDisplayAll check = new CheckNameLocation(array);
				//check for two items
				if(check.check())
					c = myModel.searchByItemName(lost_etc_categories, array);
				else{
					String str = check.getNameOrlocation();
					c = myModel.searchByItemName(lost_etc_categories, str);
				}
			}else{
				c= myModel.searchByCategory(lost_etc_categories, refined_search);
			}
		} else if (status) {
			c= myModel.searchByStatus(lost_etc_categories, refined_search);	
		}

		myView.setItem(toItem(c));
		myView.setAdapter();

		myModel.close();
		c.close();
	}

	public Item [] toItem(Cursor c){
		List<Item> array = new ArrayList<Item>();
		c.moveToFirst();
		while(!c.isAfterLast()){

				String itemName = c
						.getString(c.getColumnIndex(DB_Helper.ITEM_NAME));
				String itemCategory = c.getString(c
						.getColumnIndex(DB_Helper.ITEM_CATEGORY));
				String itemStatus = c.getString(c
						.getColumnIndex(DB_Helper.ITEM_STATUS));
				String itemDescription = c.getString(c
						.getColumnIndex(DB_Helper.ITEM_DESCRIPTION));
				String date = c.getString(c
						.getColumnIndex(DB_Helper.ITEM_DATE));
				int keepsake = c.getInt(c.getColumnIndex(DB_Helper.ITEM_KEEPSAKE));
				int heirloom = c.getInt(c.getColumnIndex(DB_Helper.ITEM_HEIRLOOM));
				int misc = c.getInt(c.getColumnIndex(DB_Helper.ITEM_MISC));
				String zip = c.getString(c.getColumnIndex(DB_Helper.ITEM_ZIP));
				String street = c
						.getString(c.getColumnIndex(DB_Helper.ITEM_STREET));
				//Date d = new Date(date)

				Item item = new LostItem(itemName, itemCategory, itemStatus,
						itemDescription, current_user, Long.parseLong(date), keepsake, heirloom,
						misc, zip, street);
				array.add(item);
				c.moveToNext();
			}
		int length = array.size();
		
		Item[] a_item = new Item[length];
		a_item = array.toArray(a_item);


		return a_item;

	}

}