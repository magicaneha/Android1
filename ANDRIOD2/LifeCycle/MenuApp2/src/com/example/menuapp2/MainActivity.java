package com.example.menuapp2;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		
		menu.add(1, 101, 4, "Save");
		menu.add(2, 102, 1, "New");
		menu.add(2, 103, 2, "Open");
		menu.add(2, 104, 5, "Exit");
		menu.add(1, 105, 3, "Save As");
		
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getGroupId()) {
		case 1:
				Toast.makeText(MainActivity.this, item.getTitle()+" from group "+item.getGroupId(), 5).show();
			break;
		case 2:
			Toast.makeText(MainActivity.this, item.getTitle()+" from group "+item.getGroupId(), 5).show();
			break;
		default:
			break;
		} 
		
		
		/*
		int id =item.getItemId();
		
		switch (id) {
		case 101:
			Toast.makeText(MainActivity.this, item.getTitle(), 5).show();
			break;
		case 102:
			Toast.makeText(MainActivity.this, "New", 5).show();
			break;
		case 103:
			Toast.makeText(MainActivity.this, "Open", 5).show();
			break;
		case 104:
			finish();
			Toast.makeText(MainActivity.this, "Exit", 5).show();
			break;
		case 105:
			Toast.makeText(MainActivity.this, "Save As", 5).show();
			break;
		default:
			break;
		}
		*/
		return super.onOptionsItemSelected(item);
	}
}
