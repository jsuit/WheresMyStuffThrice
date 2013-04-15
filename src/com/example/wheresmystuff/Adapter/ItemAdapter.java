package com.example.wheresmystuff.Adapter;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Model.Item.Item;

import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Adapter class that sets item info on a row
 * 
 * @param item the item to add to the buffer
 */


public class ItemAdapter extends ArrayAdapter<Item> {
	/** The context for the adapter */
	private final Context context;
	/** the people to show in the list */
	private final Item[] items;
	Calendar cal;
	public ItemAdapter(Context ctx, Item[] i) {
		super(ctx, R.layout.item_row, i);
		context = ctx;
		items = i;
		cal = new GregorianCalendar();
	}
	
	@Override
	
	 /**
     * This method is overriden. But the user should see the name of item, description of item, date item was added, status of item; each on
     * its own row. 
     * 
     * @param item the item to add to the buffer
     */
	  public View getView(int position, View convertView, ViewGroup parent) {
		//Set up the view by creating the widgets out of the xml spec
	    LayoutInflater inflater = (LayoutInflater) context
	        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	    View rowView = inflater.inflate(R.layout.item_row, parent, false);
	
	    //Grab the two widgets in teh view
	    TextView textView = (TextView) rowView.findViewById(R.id.item_name_row);
	    TextView item_desrc = (TextView) rowView.findViewById(R.id.item_description_row);
	    TextView item_date = (TextView) rowView.findViewById(R.id.item_date_row);
	    TextView item_status = (TextView) rowView.findViewById(R.id.item_status_row);
	    //set the widget values
	    String label1, label2, label3, label4;
	    label1 = "ITEM";
	    label2 = "DESCRIPTION";
	    label3 = "DATE ENTERED";
	    label4 = "STATUS";
	    SpannableString content = new SpannableString("ITEM:  " +items[position].getItemName());
	    content.setSpan(new UnderlineSpan(), 0, label1.length(), 0);
	    textView.setText(content);
	    SpannableString descr = new SpannableString("DESCRIPTION:  "+items[position].getItemDescription());
	    descr.setSpan(new UnderlineSpan(), 0, label2.length(), 0);
	    item_desrc.setText(descr);
	    cal.setTimeInMillis(items[position].getDateAsString());
	    
	    SpannableString date = new SpannableString("DATE ENTERED:  " + cal.getTime().toString());
	    date.setSpan(new UnderlineSpan(), 0, label3.length(), 0);
	 
	    item_date.setText(date);
	    SpannableString status = new SpannableString("STATUS:  " +items[position].getItemStatus());
	    status.setSpan(new UnderlineSpan(), 0, label4.length(), 0);
	    item_status.setText(status);
        Log.d("Adapter", "Set row for: " + position);
          
	    
	    Log.d("Model", "Got row " + position);
	    
      //lastly return the prepared view for the list to use
	    return rowView;
	  }
	
}
