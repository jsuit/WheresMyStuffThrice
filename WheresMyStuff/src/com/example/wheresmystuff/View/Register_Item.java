package com.example.wheresmystuff.View;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.AddItemPresenter;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


public class Register_Item extends Activity implements IItemView, OnItemSelectedListener{
	private EditText item_name;
	private EditText item_description;
	private CheckBox keepsake;
	private CheckBox heirlooms;
	private CheckBox misc;
	private EditText item_zip;
	private EditText item_street;
	private Spinner drop_down_category;
	private String category;
	private AddItemPresenter my_presenter;
	
	public void onCreate(Bundle savedInstance){
		super.onCreate(savedInstance);
		my_presenter = new AddItemPresenter(new DB(this), this );
		setContentView(R.layout.register_item);	
		item_name = (EditText) findViewById(R.id.item_name);
		item_description = (EditText) findViewById(R.id.item_description);
		drop_down_category = (Spinner) findViewById(R.id.spinner_Category);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
		        R.array.Category, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		drop_down_category.setAdapter(adapter);
		drop_down_category.setOnItemSelectedListener(this);
		item_zip = (EditText) findViewById(R.id.zip_code);
		item_street = (EditText) findViewById(R.id.Street);
		keepsake = (CheckBox) findViewById(R.id.keepsakes);
		heirlooms = (CheckBox) findViewById(R.id.Heirlooms);
		misc = (CheckBox) findViewById(R.id.Misc);
	}
	
	@Override
	public void notify_of_error(String error_message, String title) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(error_message);
		builder.setTitle(title);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			      public void onClick(DialogInterface dialog, int id) {
			    	  return;

			         }

			     });
		
		builder.create().show();
	}
	
	public void confirm(String error_message, String title) {
		// TODO Auto-generated method stub
		
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(error_message);
		builder.setTitle(title);
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
			      public void onClick(DialogInterface dialog, int id) {
			    	  my_presenter.save();
			    	  return;

			         }

			     })
			     .setNegativeButton("No",new DialogInterface.OnClickListener() {
						public void onClick(DialogInterface dialog,int id) {
							// if this button is clicked, just close
							// the dialog box and do nothing
							dialog.cancel();
							
						
						}
					});
		
		builder.create().show();
		return;
	}
	
	
	@Override
	public <T> void call_intent(Class<T> c) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(this, c);
		startActivity(intent);
		Log.d("MainActivity", "Called Intent:" + c.getName());
	}
	
	
	
	public void saveItem(View v){
			String name = item_name.getText().toString();
			String description = item_description.getText().toString();
			String zip = item_zip.getText().toString();
			String street = item_street.getText().toString();
			int keep = 0;
			if(keepsake.isChecked()) keep = 1;
			int heir = 0;
			if(heirlooms.isChecked()) heir = 1;
			int m = 0;
			if(misc.isChecked()) m = 1;
			long currentTime = System.currentTimeMillis();
			
			
			Log.d("saveLostItem", "Got the goods; now to save the item");
			//saves also
			my_presenter.makeAnItem(name, category, "Open", description, currentTime, zip, street, keep, heir, m);

			Log.d("saveLostItemDone", "saved the item");		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {
		
		category = parent.getItemAtPosition(pos).toString();
		Log.d("spinner", category);
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub
		
	}
	
	public void makeToast(String message){
		TextView textView = new TextView(this);
        textView.setBackgroundColor(Color.DKGRAY);
        textView.setTextColor(Color.WHITE);
        textView.setTextSize(30);
		Typeface typeface = Typeface.create("serif", Typeface.BOLD);
        textView.setTypeface(typeface);
        textView.setText(message);
        Toast t = Toast.makeText(this,null, Toast.LENGTH_SHORT);
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		t.setView(textView);
		t.show();	
		
	}

	@Override
	public void setItem(Item[] i) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setItem(List<String> accounts) {
		// TODO Auto-generated method stub
		
	}

}

