package com.example.wheresmystuff.View;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.R.id;
import com.example.wheresmystuff.R.layout;
import com.example.wheresmystuff.validation.Validation;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.RegularUser;
import com.example.wheresmystuff.Presenter.Register_Presenter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DialogFragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;

import android.graphics.Color;
import android.graphics.Typeface;
import android.location.Address;
import android.os.Bundle;
import android.text.Editable;
import android.view.Gravity;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;


import android.widget.TextView;

import android.widget.Toast;

public class Register extends Activity implements ILoginView{
	

	private Register_Presenter reg_presenter;
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register);
		reg_presenter = new Register_Presenter(this, new DB(this));
	}

	/**
	 * button handler for save button
	 * 
	 * @param View: save button
	 */
	
	public void saveNewPerson(View save_button){
			//get Text Entered by User
			Log.d("RegisterForm", "Save button");
			String name = ((EditText) findViewById(R.id.Name)).getText().toString();
			String email = ((EditText) findViewById(R.id.email)).getText().toString(); 
			String phone = ((EditText) findViewById(R.id.phone)).getText().toString();
			String password = ((EditText) findViewById(R.id.password)).getText().toString();
			String check_password = ((EditText) findViewById(R.id.retype_password)).getText().toString();
			String zip = ((EditText) findViewById(R.id.zip_code)).getText().toString();
			String street = ((EditText) findViewById(R.id.Street)).getText().toString();
			String address = street+" "+ zip;
			
			reg_presenter.validate(name, phone, address, email, password, check_password);
			 
				
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
	        Toast t = Toast.makeText(this,null, Toast.LENGTH_LONG);
			t.setGravity(Gravity.RELATIVE_LAYOUT_DIRECTION|Gravity.CENTER_HORIZONTAL, 0, 0);
			t.setView(textView);
			t.show();
		}

		@Override
		public <T> void call_intent(Class<T> c) {
			Intent i = new Intent(this, c);
			startActivity(i);
			Log.d("Register.java", "new intent called"+ c.getSimpleName());
			
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


	
