package com.example.wheresmystuff.validation;

public class CheckNameLocation extends CheckDisplayAll {

	private String[] array;

	public CheckNameLocation() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Constructor. Sets the Name or Location array to argument.
	 * 
	 * @param String [] array
	 */
	public CheckNameLocation(String[] array) {
		this.array = array;
	}

	@Override
	/**
	 * Sees if there are two non-empty strings in the array
	 * Returns true if there is. False otherwise
	 * @return boolean
	 */
	public boolean check() {
		for (String a : array) {
			if ("".compareTo(a) == 0)
				return false;
		}
		return true;
	}

	@Override
	/**
	 * Gets either name or location. This method assumes that there is only one non-empty
	 * string in array.
	 * 
	 * @param String 
	 */
	public String getNameOrlocation() {
		String str = null;
		for (String a : array) {
			if ("".compareTo(a) == 0)
				continue;
			else
				str = a;
		}
		return str;
	}

}
