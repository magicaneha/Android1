package com.example.dialogdemo;

import java.util.ArrayList;



import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class DialogActivity extends Activity {
	Button btnPDialog,btnAlert;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myview);	
		
		btnPDialog = (Button) findViewById(R.id.btnPDialog);
		btnAlert = (Button) findViewById(R.id.btnAlert);
		btnPDialog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				ProgressDialog pd = new ProgressDialog(DialogActivity.this);
				pd.setTitle("Wait");
				pd.show();
			}
		});
		
		btnAlert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder build = new AlertDialog.Builder(DialogActivity.this);
				build.setTitle("Registration");
				build.setIcon(R.drawable.ic_launcher);
					
				ListView lv = new ListView(DialogActivity.this);
				ArrayList<String> flist=new ArrayList<String>();
				flist.add("Nishant");
				flist.add("Manish");
				flist.add("Harshit");
				flist.add("Aditi");
				flist.add("Shikha");
				flist.add("Shweta");
				ArrayAdapter<String> adap=new ArrayAdapter<String>(DialogActivity.this, android.R.layout.simple_list_item_1, flist);
					
				lv.setAdapter(adap);
				
				build.setView(lv);
				
				build.setPositiveButton("Save", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						Toast.makeText(getApplicationContext(), "OK", 5).show();
					}
				});
				build.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						
					}
				});
				build.show();
			}
		});
	}
}

