package com.example.wheresmystuff.validation;

 public class Validation {



		public static String[] validate(String name, String phone_num, String  address, String email, String password, String check_password){
			String[] validate = {ValidateName.validate(name), ValidateAddress.validate(address), ValidatePhone.validate(phone_num), ValidateEmail.validate(email), ValidatePassword.validate(password, check_password)};
			return validate; 
			//ValidateAddress.validate(address) && ValidatePhone.validate(phone_num) && ValidateEmail.validate(email) && ValidatePassword.validate(password, check_password); 
		}

 }

	
	

