package com.example.wheresmystuff.View;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Presenter.User_Screen_Presenter;

public class mainUserScreen extends Activity implements IMyProfilePage {
	private User_Screen_Presenter presenter;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_main_user_screen);
		presenter = new User_Screen_Presenter(this, new DB(this));
		presenter.checkAdmin();
	}

	/**
	 * Button handler for when you want to add item
	 * 
	 * @param View
	 *            post_button
	 * 
	 */
	public void postItem(View post_button) {
		Intent i = new Intent(this, Register_Item.class);
		startActivity(i);
		Log.d("mainUserScreen",
				"Post Item clicked. starting display lost items class");
	}

	/**
	 * Button handler for when you want to see your listings
	 * 
	 * @param View
	 *            your_listings
	 * 
	 */

	public void yourListings(View your_listings) {
		Intent i = new Intent(this, DisplayItems.class);
		startActivity(i);
		Log.d("mainUserScreen",
				"Your Listings clicked. starting display lost items class");
	}

	/**
	 * This method makes buttons that are only visible to admin visible
	 * 
	 * 
	 * 
	 */

	public void makeAdminButtonsVisisble() {

		Button add_remove = (Button) findViewById(R.id.addRemove);
		Button lock_unlock = (Button) findViewById(R.id.lock_unlock);
		Button remove_user = (Button) findViewById(R.id.remove_user_button);
		remove_user.setVisibility(View.VISIBLE);
		add_remove.setVisibility(View.VISIBLE);
		lock_unlock.setVisibility(View.VISIBLE);

	}

	/**
	 * Button handler adding or removing admin. Jumps to page where you can do
	 * that
	 * 
	 * @param View
	 *            v
	 * 
	 */

	public void addOrRemoveAdmin(View v) {
		Intent i = new Intent(this, AddRemoveAdmin.class);
		startActivity(i);
	}

	/**
	 * This method makes buttons that are only visible to admin invisible
	 * 
	 * 
	 * 
	 */
	public void makeAdminButtonsInvisisble() {
		Button remove_user = (Button) findViewById(R.id.remove_user_button);
		remove_user.setVisibility(View.GONE);
		Button add_remove = (Button) findViewById(R.id.addRemove);
		Button lock_unlock = (Button) findViewById(R.id.lock_unlock);
		add_remove.setVisibility(View.GONE);
		// ImageView view = (ImageView)
		// findViewById(R.drawable.wheresmystuffimage);
		// view.setVisibility(View.VISIBLE);
		lock_unlock.setVisibility(View.GONE);

	}

	// button handler
	public void lockOrUnlock(View v) {

		Intent i = new Intent(this, LockOrUnlock.class);
		startActivity(i);

	}

	/**
	 * Button handler to remove a user. Jumps to page where you can do that
	 * 
	 * @param View
	 *            v
	 * 
	 */
	public void removeUser(View v) {
		Intent i = new Intent(this, RemoveUser.class);
		startActivity(i);
		Log.d("Lock/Unlock screen", "RemoveUser clicked");
	}

	// unused
	public void ButtonClick(View v) {

	}

	// unused
	public void yourContacts(View v) {

	}

	/**
	 * Button handler for doing searches on items
	 * 
	 * 
	 * @param View
	 *            v
	 * 
	 */
	public void advanced_search(View v) {

		Intent i = new Intent(this, DisplayAllItems.class);
		startActivity(i);
		Log.d("displayallitems clicked", "display all items");
	}

	/**
	 * Button handler for logging out
	 * 
	 * 
	 * @param View
	 *            v
	 * 
	 */
	public void logout(View v) {
		Intent i = new Intent(this, MainActivity.class);
		i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | 
                Intent.FLAG_ACTIVITY_CLEAR_TASK |
                Intent.FLAG_ACTIVITY_NEW_TASK);
		startActivity(i);
		finish();
	}
}
