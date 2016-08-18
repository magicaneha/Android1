package com.example.menuapp;

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
		
		MenuItem mnuNew = menu.add("New");
		menu.add("Open");
		menu.add("Save");
		MenuItem mnuDelete = menu.add("Delete");
		menu.add("Exit");
		menu.add("Edit");
		menu.add("Save As");
		menu.add("Print");
		
		
		mnuDelete.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(MainActivity.this,"Delete Presessd",6).show();
				return false;
			}
		});
		
		mnuNew.setOnMenuItemClickListener(new OnMenuItemClickListener() {
			
			@Override
			public boolean onMenuItemClick(MenuItem item) {
				Toast.makeText(MainActivity.this, "New Pressed", 5).show();
				return false;
			}
		});
		
		
		
		return true;
	}

}
