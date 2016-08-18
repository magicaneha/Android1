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
import android.widget.AdapterView.AdapterContextMenuInfo;

public class MainActivity extends Activity {
	ListView lvFriends;
	ArrayList<String> flist;
	ArrayAdapter<String> adap;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		lvFriends=(ListView) findViewById(R.id.lvFriends);
		flist=new ArrayList<String>();
		flist.add("Piyush");flist.add("Yash");flist.add("Kalpit");flist.add("Anup");flist.add("Munendra");flist.add("Amit");
		adap=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,flist);
		
		lvFriends.setAdapter(adap);	
	
		registerForContextMenu(lvFriends);
	}
	
	@Override
	public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
		super.onCreateContextMenu(menu, v, menuInfo);
		
			MenuInflater minf = getMenuInflater();
			minf.inflate(R.menu.menuforlv, menu);
		
	}
	
	@Override
	public boolean onContextItemSelected(MenuItem item) {
		
		//ContextMenuInfo info = item.getMenuInfo();
		AdapterContextMenuInfo info = (AdapterContextMenuInfo) item.getMenuInfo();
		int index = info.position;
		
		switch (item.getItemId()) {
		
		case R.id.mnuView:
			flist.add("Ram");
			adap.notifyDataSetChanged();
			Toast.makeText(MainActivity.this, item.getTitle()+"for "+flist.get(index), 5).show();
			break;
		case R.id.mnuEdit:
			Toast.makeText(MainActivity.this, item.getTitle(), 5).show();
			break;
		case R.id.mnuDelete:
			//String name=flist.get(index);
			//adap.remove(name);

			flist.remove(index);
			adap.notifyDataSetChanged();
			
			Toast.makeText(MainActivity.this, item.getTitle(), 5).show();
			break;
		}
		
		return super.onContextItemSelected(item);
	}
	
}
