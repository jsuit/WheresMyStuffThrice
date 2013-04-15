package com.example.wheresmystuff.validation;

public class ValidatePassword {

public static String validate(String password, String check_password){

		//user didn't enter password (inclusive) or check_password 
		if (password == null || check_password == null || "".compareTo(password) == 0 || "".compareTo(check_password) == 0) {
			return "Invalid Password. Need a Password\n";
		}
		//two passwords don't match up
		if(password.compareTo(check_password) != 0){
			return "Invalid Password. Passwords don't match.\n";
		}
		//from here on we can assume the two passwords are ==
		if(password.length() < 6){
			return "Invalid Password. Need 7 characters with at least one number\n";
		}
		//too long
		if(password.length()>99){
			return "Invalid Password. Too Long.\n";
		}
		//count the numbers in passwords
		int numbers = 0;
		for (int i = 0; i < password.length(); i++) {
			if(Character.isDigit(password.charAt(i))){
				numbers++;
			}
		}
		//if the numbers are are greater than 1 and less than length then we are good to go
		//This is the only method that should return null
		if(numbers < password.length() && numbers >= 1){
			return null;

		}
		//if numbers are the entire password: error
		if(numbers == password.length()){
			return "Invalid Password. Can't be all numbers.\n";
		}
		//if no numbers, error
		if(numbers == 0 ){
			return "Invalid Password. No Numbers.\n";
		}
		//anything else is an error
		else return "Invalid Password.\n";

	}
}