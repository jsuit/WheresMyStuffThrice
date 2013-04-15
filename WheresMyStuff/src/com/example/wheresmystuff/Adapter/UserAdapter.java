package com.example.wheresmystuff.Adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.wheresmystuff.R;

public class UserAdapter extends ArrayAdapter<String> {
	 /**
     *	sets a row with the user's name.
     * 
     * @param item the item to add to the buffer
     */
	
	/** The context for the adapter */
	private final Context context;
	/** the people to show in the list */
	private final Collection<String> users;
	
	
	
	  public UserAdapter(Context ctx, List<String> u) {
		// TODO Auto-generated constructor stub
		    super(ctx, R.layout.user_row, u);
			context = ctx;
			users = u;
	}

	@Override
	  public View getView(int position, View convertView, ViewGroup parent) {
		  LayoutInflater inflater = (LayoutInflater) context
			        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			    View rowView = inflater.inflate(R.layout.user_row, parent, false);
				
			    TextView textView = (TextView) rowView.findViewById(R.id.user_row);
			    textView.setText(((List<String>) users).get(position));
			    return rowView;
	}
	  
	
}
	
