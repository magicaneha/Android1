package com.example.filesystemtest;

import java.io.File;
import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListMainActivity extends ListActivity{
	ListView lv;
	ArrayList<File> flist;
	ArrayAdapter<String> adap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		lv=getListView();
		
		File sdpath = Environment.getExternalStorageDirectory();
		File[] list = sdpath.listFiles();
		
		String[] list2 = sdpath.list();
		adap=new ArrayAdapter<String>(ListMainActivity.this, android.R.layout.simple_list_item_1,list2);
		
		lv.setAdapter(adap);
		
	}
}
