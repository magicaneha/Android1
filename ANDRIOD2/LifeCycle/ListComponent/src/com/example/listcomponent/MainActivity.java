package com.example.listcomponent;

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
	ListView lv;
	//String[] fname;
	ArrayList<String> flist;
	ArrayAdapter<String> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.lv);
		
		
		//fname=new String[]{"Raj","Ram","Mohan","Piyush","Kishore","Ashish","Munendra","Gunjan","Kirti","Vishwanath","Riju","Kalpit"};
		flist=new ArrayList<String>();
		flist.add("Nishant");
		flist.add("Manish");
		flist.add("Harshit");
		flist.add("Aditi");
		flist.add("Shikha");
		flist.add("Shweta");
		
		
		//adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, fname);
		adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, flist);
		
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
				int index = pos;
				String name = flist.get(index);
				Toast.makeText(MainActivity.this, "Hello "+name, 5).show();
			}
		});
		
	}
}
