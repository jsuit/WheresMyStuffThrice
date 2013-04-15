package com.example.wheresmystuff.View;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

public class UserTaken extends DialogFragment {

	 public Dialog onCreateDialog(Bundle savedInstanceState) {
		 
		 AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		  
		 return builder.create();
	 }
}
