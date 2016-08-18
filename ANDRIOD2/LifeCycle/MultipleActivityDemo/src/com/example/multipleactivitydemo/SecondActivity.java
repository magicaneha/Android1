package com.example.multipleactivitydemo;

import android.R.integer;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
	TextView tvMessage;
	Button btnBack,btnUpdate;
	int num;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.secondview);
	
		Intent myintent = getIntent();
		String val = myintent.getStringExtra("data");
		String name = myintent.getStringExtra("name");
		
		Toast.makeText(SecondActivity.this, "Hello "+name, Toast.LENGTH_LONG).show();
		
		tvMessage=(TextView) findViewById(R.id.tvMessage);
		tvMessage.setText(val);
		
		btnUpdate=(Button) findViewById(R.id.btnUpdate);
		btnBack=(Button) findViewById(R.id.btnBack);
		btnBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				
				
				finish();
			}
		});
		
		btnUpdate.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				num =Integer.parseInt(tvMessage.getText().toString());
				num++;
				tvMessage.setText(num+"");
			}
		});
		
	}
	
	@Override
	public void finish() {
		// TODO Auto-generated method stub
		
		Intent in  = new Intent();
		in.putExtra("retval", num);				
		setResult(RESULT_OK, in);
		super.finish();
	}
	
}
