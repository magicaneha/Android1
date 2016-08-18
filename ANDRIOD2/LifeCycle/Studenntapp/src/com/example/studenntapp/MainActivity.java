package com.example.studenntapp;

import personal.Student;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editRno,editName,editFees;
	Button btnSave,btnShow;
	Student s;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editRno = (EditText) findViewById(R.id.editrno);
		editName = (EditText) findViewById(R.id.editName);
		editFees = (EditText) findViewById(R.id.editFees);
		btnSave = (Button) findViewById(R.id.btnSave);
		btnShow = (Button) findViewById(R.id.btnShow);
		
		btnSave.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				int rno=Integer.parseInt(editRno.getText().toString());
				String name=editName.getText().toString();
				float fees = Float.parseFloat(editFees.getText().toString());
				
				s = new Student(rno, name, fees);
				Toast.makeText(MainActivity.this, "Student Saved", 5).show();
			}
		});
		
		btnShow.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MainActivity.this,ShowActivity.class);
				in.putExtra("stud", s);
				startActivityForResult(in, 101);	
			}
		});
	}
}
