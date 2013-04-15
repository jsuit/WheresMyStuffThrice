package com.example.wheresmystuff.View;

public interface IItemView2 extends IItemView {

	public void makeSpinnerVisible();

	void makeDatePickerVisible();

	void makeRadioVisible();

	void makeRadioInvisible();

	void makeDatePickerInvisible();

	public void makeInvisibleSpinner();

	Long getDate();

	public void setAdapter();

	public void makeAutoCompleteTextViewVisible();

	public void setHint(String string);

	public void makeAutoCompleteTextViewInvisible();

	public String[] getNameLocation();

	public void setTextToNull();

	public void makeNameInVisible();

	public void makeNameVisible();

	public void makeZipVisible();

	public void makeZipInVisible();

	

}
