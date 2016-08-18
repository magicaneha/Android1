package com.example.contextmenutest;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends Activity {

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
		adap=new ArrayAdapter<String>(MainActivity2.this,android.R.layout.simple_list_item_1,flist);
		
		lvFriends.setAdapter(adap);	
		
		registerForContextMenu(tvMessage);
		registerForContextMenu(lvFriends);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		if(v.equals(tvMessage))
		{
			MenuInflater minf = getMenuInflater();
			minf.inflate(R.menu.menufortv, menu);
		}
		else if(v.equals(lvFriends))
		{
			MenuInflater minf = getMenuInflater();
			minf.inflate(R.menu.menuforlv, menu);
		}
			
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		switch (item.getItemId()) {
		case R.id.mnuNew:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuOpen:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuSave:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuView:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuEdit:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuDelete:
			Toast.makeText(MainActivity2.this, item.getTitle(), 5).show();
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	
}
