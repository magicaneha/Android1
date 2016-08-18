package com.example.listcomponent2;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Spinner;

public class MainActivity extends Activity {

	ArrayList<String> clist;
	ArrayAdapter<String> adap;
	Spinner spinCountry;
	AutoCompleteTextView actvCountry;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		spinCountry=(Spinner) findViewById(R.id.spinCountry);
		actvCountry=(AutoCompleteTextView) findViewById(R.id.actvCountry);
		
		clist=new ArrayList<String>();
		clist.add("India");
		clist.add("Canada");
		clist.add("Australlia");
		clist.add("England");
		clist.add("China");
		clist.add("Indonesia");
		clist.add("Iran");
		clist.add("Iraq");
		clist.add("Europe");
		
		
		//adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,clist);
		adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_item,clist);
		
		spinCountry.setAdapter(adap);
		actvCountry.setAdapter(adap);
		actvCountry.setThreshold(1);
	}
}
