package com.example.baseadaptertest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;

import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	ListView lv;
	ArrayList<Student> slist;
	
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
		
		MyAdapter ma = new MyAdapter();
		lv.setAdapter(ma);
	}
	
	class MyAdapter extends BaseAdapter
	{

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public Object getItem(int arg0) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			
			Student s = slist.get(position);
			
			TextView tvName  = new TextView(MainActivity.this);
			//LayoutParams lp = new LayoutParams(LayoutParams.WRAP_CONTENT,LayoutParams.WRAP_CONTENT);
			//tvName.setLayoutParams(lp);
			tvName.setText(s.getRno()+":"+s.getName());
			
			
			return tvName;
		}
		
	}
}


