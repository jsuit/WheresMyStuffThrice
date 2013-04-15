package com.example.wheresmystuff.View;

import com.example.wheresmystuff.Model.Item.Item;

import android.content.Context;

public interface ILoginView {

	
	void notify_of_error(String error_message);
	<T> void call_intent(Class<T> c);
	
	
	
}
