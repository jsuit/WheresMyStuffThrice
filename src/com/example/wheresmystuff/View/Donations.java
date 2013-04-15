package com.example.wheresmystuff.View;



import com.example.wheresmystuff.R;

import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
 
public class Donations extends ListActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_donations);
    }
}