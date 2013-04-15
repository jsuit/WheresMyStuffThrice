package com.example.wheresmystuff.validation;

public class ValidatePhone {



	protected static String validate(String phone){


		if (phone == null || "".compareTo(phone) == 0 || phone.matches("\\d{10}|\\d{11}")) {
			return null;
		}
		return "Invalid Phone Number\n";

	}



}