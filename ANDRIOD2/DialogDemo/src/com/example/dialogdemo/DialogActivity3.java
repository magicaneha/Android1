package com.example.dialogdemo;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class DialogActivity3 extends Activity {
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
				ProgressDialog pd = new ProgressDialog(DialogActivity3.this);
				pd.setTitle("Wait");
				pd.setMessage("Prcess is in progress");
				pd.show();
			}
		});
		
		btnAlert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				AlertDialog.Builder build = new AlertDialog.Builder(DialogActivity3.this);
				build.setTitle("Registration");
				build.setIcon(R.drawable.ic_launcher);
				
				LayoutInflater linf = getLayoutInflater();
				View vv = linf.inflate(R.layout.newstud, null);
				build.setView(vv);				
				
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

