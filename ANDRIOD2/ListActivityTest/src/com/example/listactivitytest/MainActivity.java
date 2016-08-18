package com.example.listactivitytest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ListActivity{
	ListView lv;
	ArrayList<String> slist;
	ArrayAdapter<String> adap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		lv=getListView();
		slist=new ArrayList<String>();
		slist.add("India");
		slist.add("Canada");
		slist.add("America");
		slist.add("Australlia");
		slist.add("England");
		slist.add("China");
		
		//adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,slist);
		//adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice,slist);
		adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_multiple_choice,slist);
		lv.setAdapter(adap);
		//lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lv.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
	}

}
