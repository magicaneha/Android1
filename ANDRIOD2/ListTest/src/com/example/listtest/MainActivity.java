package com.example.listtest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ArrayList<String> slist;
	ListView lv;
	ArrayAdapter<String> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		slist=new ArrayList<String>();
		slist.add("Java");
		slist.add("Ruby");
		slist.add("PHP");
		slist.add(".Net");
		slist.add("Joomla");
		slist.add("WordPress");
		
		lv=(ListView) findViewById(R.id.lv);
		
		//adap= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,slist);
		adap= new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_single_choice,slist);
		
		lv.setAdapter(adap);
		lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
				int index = pos;
				String tech = slist.get(index);
				
				Toast.makeText(MainActivity.this, tech, 5).show();
			}
		});
	}
	
}
