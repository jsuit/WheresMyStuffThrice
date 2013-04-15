package com.example.wheresmystuff.View;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
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
import com.example.wheresmystuff.Presenter.AddAdminPresenter;

public class AddRemoveAdmin extends Activity implements ILoginView {

	private AddAdminPresenter my_presenter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_remove_admin);
		my_presenter = new AddAdminPresenter(this, new DB(this));
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_remove_admin, menu);
		return true;
	}
	//button handler
	public void AddAdmin(View createAdminButton) {
		
		String user_name = ((EditText) findViewById(R.id.adminID)).getText().toString();
		String email_add = ((EditText) findViewById(R.id.email_address)).getText().toString();
		String password = ((EditText) findViewById(R.id.password)).getText().toString();
		String retype_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
		my_presenter.validate(user_name, email_add, password, retype_password);
		Log.d("AddRemoveAdmin", "Create admin button clicked");
		
	}
	//button handler
	public void RemoveAdmin(View v){
		
		String user_name = ((EditText) findViewById(R.id.adminID)).getText().toString();
		String email_add = ((EditText) findViewById(R.id.email_address)).getText().toString();
		String password = ((EditText) findViewById(R.id.password)).getText().toString();
		String retype_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
		my_presenter.validate(user_name, email_add, password, retype_password, "");
		
	}

	//button handler
	public void setAdminStatus(View v){
		String user_name = ((EditText) findViewById(R.id.adminID)).getText().toString();
		String email_add = ((EditText) findViewById(R.id.email_address)).getText().toString();
		String password = ((EditText) findViewById(R.id.password)).getText().toString();
		String retype_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
		my_presenter.validate(user_name, email_add, password, retype_password, "s");
		
	}
	
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
		Intent i = new Intent(this, c);
		startActivity(i);
		Log.d("AddRemoveAdmin.java", "new intent called"+ c.getSimpleName());
	}
	
	public void alreadyTaken(String str){
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(str);
		builder.setTitle("Error");
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {
			    	  return;

			         }

			     });
		
		builder.create().show();
	}

}
