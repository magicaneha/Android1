package com.example.studenntapp;

import personal.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class ShowActivity extends Activity {
	TextView tvRno,tvName,tvFees;
	Button btnSave,btnBack;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.showlayout);
		
		Intent in = getIntent();
		
		
		Student s = (Student) in.getSerializableExtra("stud");
		
		tvRno = (TextView) findViewById(R.id.tvRno);
		tvName= (TextView) findViewById(R.id.tvName);
		tvFees=(TextView) findViewById(R.id.tvFees);
		btnBack=(Button) findViewById(R.id.btnBack);
		btnSave=(Button) findViewById(R.id.btnSave);
		
		tvRno.setText(s.getRno()+"");
		tvName.setText(s.getName());
		tvFees.setText(s.getFees()+"");
		
	}
}
