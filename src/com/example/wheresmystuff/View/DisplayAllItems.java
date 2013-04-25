package com.example.wheresmystuff.View;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.DatePickerDialog.OnDateSetListener;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.wheresmystuff.R;
import com.example.wheresmystuff.Adapter.ItemAdapter;
import com.example.wheresmystuff.Model.DB;
import com.example.wheresmystuff.Model.Item.Item;
import com.example.wheresmystuff.Presenter.advancedSearchPresenter;

public class DisplayAllItems extends Activity implements
		OnItemSelectedListener, IItemView2 {
	private String search_criteria;
	private String search_criteria_radio;

	private Spinner spinner;
	private Spinner spinner2;
	private advancedSearchPresenter presenter;
	private ListView list_of_items;
	private Item[] items;
	private Button dp;
	private RadioGroup status_radio;
	private int year;
	private int month;
	private int day;
	private String refined_search;
	private boolean date = true;
	private boolean category = false;
	private boolean status = false;
	private boolean item_name = false;
	private boolean item_location = false;
	private ListView l_view;
	private ItemAdapter adapter;
	private AutoCompleteTextView zip_code;
	private OnDateSetListener date_listener;
	private AutoCompleteTextView autotext;

	public void onCreate(Bundle savedInstanceState) {

		search_criteria_radio = "Lost";
		super.onCreate(savedInstanceState);
		setContentView(R.layout.displayallitems);

		spinner = (Spinner) findViewById(R.id.search_by);
		spinner2 = (Spinner) findViewById(R.id.search_category);
		autotext = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
		ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.SearchByList));
		spinnerAdapter
				.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

		ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_dropdown_item, getResources()
						.getStringArray(R.array.RefineSearch));
		spinner.setAdapter(spinnerAdapter);
		spinner2.setAdapter(spinnerAdapter2);

		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
				this, R.array.Category, android.R.layout.simple_spinner_item);
		// Specify the layout to use when the list of choices appears
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// Apply the adapter to the spinner
		;
		dp = (Button) findViewById(R.id.date_btn);
		setUPPickers();
		setUpRadios();

		date_listener = new OnDateSetListener() {

			@Override
			public void onDateSet(DatePicker view, int myear, int monthOfYear,
					int dayOfMonth) {
				// TODO Auto-generated method stub
				year = myear;
				month = monthOfYear;
				day = dayOfMonth;
				date = true;
				category = false;
				status = false;
				refined_search = getDate().toString();

			}

		};

		presenter = new advancedSearchPresenter(new DB(this), this);

		l_view = (ListView) findViewById(R.id.list_of_many_items);

		zip_code = (AutoCompleteTextView) findViewById(R.id.zip);

	}

	private void setUPPickers() {
		// TODO Auto-generated method stub
		Calendar c = new GregorianCalendar();
		year = c.get(Calendar.YEAR);
		month = c.get(Calendar.MONTH);
		day = c.get(Calendar.DAY_OF_MONTH);

		// DatePickerDialog.OnDateSetListener

		refined_search = getDate().toString();
	}

	void setUpRadios() {
		// TODO Auto-generated method stub
		RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
		radioGroup
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {
						l_view.setAdapter(null);
						RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
						search_criteria_radio = checkedRadioButton.getText()
								.toString();

					}
				});

		status_radio = (RadioGroup) findViewById(R.id.status_radio);
		status_radio
				.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup group, int checkedId) {

						RadioButton checkedRadioButton = (RadioButton) findViewById(checkedId);
						refined_search = checkedRadioButton.getText()
								.toString();
						date = false;
						category = false;
						status = true;

					}
				});

	}

	public void onRadioButtonStatusClicked(View v) {

		if (((RadioButton) v).isChecked()) {
			refined_search = ((RadioButton) v).getText().toString();

		}

	}

	protected void onResume() {
		super.onResume();
		spinner.setOnItemSelectedListener(this);
		spinner2.setOnItemSelectedListener(this);

	}

	public void makeInvisibleSpinner() {
		spinner2.setVisibility(View.GONE);

	}

	public void setAdapter() {
		if (items != null) {
			adapter = new ItemAdapter(this, items);
			l_view.setAdapter(adapter);
			items = null;
			Log.d("items", "items is not null");
		}else{
			l_view.setAdapter(null);
		}
			

	}

	/*
	 * Button handler for date picker
	 */
	public void datePicker(View v) {
		DatePickerDialog date_picker = new DatePickerDialog(this,
				date_listener, year, month, day);
		date_picker.show();
	}

	@Override
	public <T> void call_intent(Class<T> c) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeToast(String string) {
		// TODO Auto-generated method stub

	}

	@Override
	public void notify_of_error(String error_message, String title) {
		// TODO Auto-generated method stub

		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setMessage(error_message);
		builder.setTitle(title);
		builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

			public void onClick(DialogInterface dialog, int id) {
				return;

			}

		});

		builder.create().show();

	}

	@Override
	public void confirm(String string, String string2) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setItem(Item[] i) {
		// TODO Auto-generated method stub
		items = i;
	}

	@Override
	public void setItem(List<String> accounts) {
		// TODO Auto-generated method stub

	}

	@Override
	public void makeSpinnerVisible() {
		// TODO Auto-generated method stub
		spinner2.setVisibility(View.VISIBLE);
	}

	@Override
	// presenter gets the criteria. Either it does a search or displays more
	// buttons
	public void onItemSelected(AdapterView<?> parent, View arg1, int pos,
			long arg3) {

		if (parent.getId() == R.id.search_by) {
			l_view.setAdapter(null);
			search_criteria = parent.getItemAtPosition(pos).toString();
			Log.d("Search_criteria is", search_criteria);
			presenter.getCriteria(search_criteria);
			// display next spinner if needed
			presenter.displayCategory();

		}

		else if (parent.getId() == R.id.search_category) {
			l_view.setAdapter(null);

			date = false;
			category = true;
			status = false;
			refined_search = parent.getItemAtPosition(pos).toString();

		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}

	public void search_btn(View v) {
		l_view.setAdapter(null);

		presenter.search(presenter.check(search_criteria_radio,
				search_criteria, refined_search), date, category, status);

	}

	@Override
	public void makeDatePickerInvisible() {
		// TODO Auto-generated method stub
		dp.setVisibility(View.GONE);

	}

	@Override
	public void makeDatePickerVisible() {
		// TODO Auto-generated method stub
		dp.setVisibility(View.VISIBLE);
	}

	@Override
	public void makeRadioInvisible() {
		// TODO Auto-generated method stub

		status_radio.setVisibility(View.GONE);

	}

	@Override
	public void makeRadioVisible() {
		// TODO Auto-generated method stub

		status_radio.setVisibility(View.VISIBLE);

	}

	@Override
	public Long getDate() {
		Calendar cal = new GregorianCalendar();
		cal.set(year, month, day);
		return cal.getTimeInMillis();

	}

	public void makeNameVisible() {
		autotext.setVisibility(View.VISIBLE);
	}

	public void makeZipVisible() {
		zip_code.setVisibility(View.VISIBLE);
	}

	@Override
	public void makeAutoCompleteTextViewVisible() {
		makeNameVisible();
		makeZipVisible();

	}

	@Override
	public void makeAutoCompleteTextViewInvisible() {
		makeNameInVisible();
		makeZipInVisible();
	}

	@Override
	public void makeNameInVisible() {
		autotext.setVisibility(View.GONE);
	}

	@Override
	public void makeZipInVisible() {
		zip_code.setVisibility(View.GONE);
	}

	@Override
	public void setHint(String string) {
		// TODO Auto-generated method stub
		autotext.setHint(string);

	}

	@Override
	public String[] getNameLocation() {

		String[] array = { autotext.getText().toString(),
				zip_code.getText().toString() };
		return array;
	}

	@Override
	public void setTextToNull() {
		// TODO Auto-generated method stub
		autotext.setText("");
	}

}