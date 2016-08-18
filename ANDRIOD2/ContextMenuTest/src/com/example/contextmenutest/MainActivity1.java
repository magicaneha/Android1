package com.example.contextmenutest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity1 extends Activity {

	TextView tvMessage;
	ListView lvFriends;
	ArrayList<String> flist;
	ArrayAdapter<String> adap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		tvMessage=(TextView) findViewById(R.id.tvMessage);
		lvFriends=(ListView) findViewById(R.id.lvFriends);
		flist=new ArrayList<String>();
		flist.add("Piyush");flist.add("Yash");flist.add("Kalpit");flist.add("Anup");flist.add("Munendra");flist.add("Amit");
		adap=new ArrayAdapter<String>(MainActivity1.this,android.R.layout.simple_list_item_1,flist);
		
		lvFriends.setAdapter(adap);	
		
		registerForContextMenu(tvMessage);
		registerForContextMenu(lvFriends);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.equals(tvMessage))
		{
			menu.add("New");
			menu.add("Open");
			menu.add("Save");
		}
		else if(v.equals(lvFriends))
		{
			menu.add("Edit");
			menu.add("Delete");
			menu.add("View");
		}
			
	}
	
}
