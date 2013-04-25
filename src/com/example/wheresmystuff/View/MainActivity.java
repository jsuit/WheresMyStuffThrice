package com.example.wheresmystuff.View;


import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.Login_Presenter;

public class MainActivity extends Activity implements ILoginView{

	private Login_Presenter myPresenter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myPresenter = new Login_Presenter(this, new DB(this));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	/**
	 * Button handler for the save button
	 * 
	 * @param save button
	 */
	public void save(View save_button){
		
				String user_name = ((EditText) findViewById(R.id.userId)).getText().toString();
				String password = ((EditText) findViewById(R.id.login_password)).getText().toString();
				Log.d("MainActivity", "save button clicked");
				myPresenter.validate(user_name, password);
			    
				//else do nothing they have to click resubmit info.
				
	}
	
	/**
	 * Button handler for the register button
	 * 
	 * @param register button
	 */
	public void register(View register_button){
		this.call_intent(Register.class);
		Log.d("MainActivity", "register button clicked");
		
	}

	
	/**
	 * If the presenter can't validate call this method
	 * 
	 * @param String error_message: the reason(s) for the problem
	 */
	@Override
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

	@Override
	public <T> void call_intent(Class<T> c) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, c);
		startActivity(intent);
		Log.d("MainActivity", "Called Intent:" + c.getName());
	}

	

			
}

