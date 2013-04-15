package com.example.wheresmystuff.validation;

public class ValidateEmail {




	protected static String validate(String addr){
		if(addr.matches("[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[@]+[A-Z|a-z|]+[A-Z|a-z|.|\\d|\\-\\|_|\\.\\|]+[(com)|(org)|(net)]+")) {
			return null;
		}
		else return "Invalid Email\n";	

	}

}
