package com.example.studentlistapp;

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
	ArrayList<Student> slist;
	ArrayAdapter<Student> adap;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lv=(ListView) findViewById(R.id.lv);
		
		slist=new ArrayList<Student>();
		slist.add(new Student(101, "Jiya", 6541230));
		slist.add(new Student(102, "Jai", 123456));
		slist.add(new Student(103, "Piyush", 100200));
		slist.add(new Student(104, "Ramesh", 300200));
		slist.add(new Student(105, "Suresh", 741258));
		
		adap = new ArrayAdapter<Student>(MainActivity.this, android.R.layout.simple_list_item_1,slist);
		
		lv.setAdapter(adap);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int pos, long arg3) {
				Student s = slist.get(pos);
				String info = s.getRno()+":"+s.getName()+":"+s.getContactno();
				Toast.makeText(MainActivity.this, info, 5).show();
				
			}
		});
	}
}
