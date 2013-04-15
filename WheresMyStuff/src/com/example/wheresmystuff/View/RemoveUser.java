package com.example.wheresmystuff.View;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.UserAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.UserListingPresenter;

public class RemoveUser extends ListActivity implements IItemView {
	private UserListingPresenter my_presenter;
	private List<String> u;
	private UserAdapter adapter;
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayusers);
		my_presenter = new UserListingPresenter(new DB(this), this);
		if(u!=null) {
		    	adapter = new UserAdapter(this, u);
		        setListAdapter(adapter);
		        Log.i("View", "Set adapter");
		        ListView lv = getListView();
		        lv.setOnItemClickListener(new OnItemClickListener(){

					@Override
					public void onItemClick(AdapterView<?> arg0, View view,
							int arg2, long arg3) {
								
						 		String name = ((TextView) view.findViewById(R.id.user_row)).getText().toString();
						 		confirm(name, "Remove?");
					}
		        	
		        });
		        }
		       	else{
		       	  Log.i("View", "adapter Not set");
		       	}
	}
	@Override
	public <T> void call_intent(Class<T> c) {
		Intent i = new Intent(this, c);
		startActivity(i);
		Log.d("Register.java", "new intent called"+ c.getSimpleName());
		
	}
	@Override
	public void makeToast(String string) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notify_of_error(String error_message, String title) {
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
	public void confirm(String name, String title) {
		// TODO Auto-generated method stub
		final String  user_name = name;
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage("Do you want to remove user: " + name);
		builder.setTitle(title);
		builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
				
			      public void onClick(DialogInterface dialog, int id) {
			    	  my_presenter.remove(user_name);
			    	  
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
	public void setItem(Item[] i) {
		
		
	}
	

	@Override
	public void setItem(List<String> i) {
		// TODO Auto-generated method stub
		this.u = i;
	}	
	

	public void update(String user_name){
		adapter.remove(user_name);
		adapter.notifyDataSetChanged();
		
	}

}
