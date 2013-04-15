package com.example.wheresmystuff.Presenter;

import java.util.ArrayList;

import android.content.Intent;
import android.database.Cursor;

import com.example.wheresmystuff.Model.IModel;
import com.example.wheresmystuff.View.DisplayAllItems;
import com.example.wheresmystuff.View.ILoginView;
import com.example.wheresmystuff.View.IMyProfilePage;
import com.example.wheresmystuff.View.RemoveUser;


public class User_Screen_Presenter {

	private IModel myModel;
	private IMyProfilePage myView;
	
	public User_Screen_Presenter(IMyProfilePage v, IModel m){
		myModel = m;
		myView = v;
		
	}
	
	public void checkAdmin(){
		
		myModel.open();
		String uid = myModel.getCurUser();
		if(myModel.isAdmin(uid)){
			myView.makeAdminButtonsVisisble();
		}else myView.makeAdminButtonsInvisisble();
		myModel.close();
	}

	
	
	
	
	
	
}
