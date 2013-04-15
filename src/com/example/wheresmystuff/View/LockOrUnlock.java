package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.R.layout;
import com.example.wheresmystuff.R.menu;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Presenter.LockUser;
import com.example.wheresmystuff.Presenter.UnlockUser;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LockOrUnlock extends Activity {

	private LockUser Lock_Presenter;
	private UnlockUser Unlock_Presenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lock_or_unlock);
		Lock_Presenter = new LockUser(this, new DB(this));
		Unlock_Presenter = new UnlockUser(this, new DB(this));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_lock_unlock_menu, menu);
		return true;
	}

	public void lockUser(View lock_button) {

		String username = ((EditText) findViewById(R.id.lock_username)).getText().toString();
		Lock_Presenter.lockUser(username);

	}

	public void unlockUser(View unlock_button) {

		String username = ((EditText) findViewById(R.id.unlock_username)).getText().toString();
		Unlock_Presenter.unlockUser(username);

	}

	public void notify_of_error(String error_message) {
		// TODO Auto-generated method stub
		TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.DKGRAY);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(30);
		Typeface typeface = Typeface.create("serif", Typeface.BOLD);
        textView.setTypeface(typeface);
        textView.setGravity(Gravity.CENTER);
        textView.setText(error_message);
        Toast t = Toast.makeText(this,null, Toast.LENGTH_SHORT);
		t.setGravity(Gravity.RELATIVE_LAYOUT_DIRECTION|Gravity.CENTER_HORIZONTAL, 0, 0);
		t.setView(textView);
		t.show();
	}

}