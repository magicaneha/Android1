package com.example.basiccomponents;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	EditText editName,editEmail,editPassword;
	RadioButton rdoMale,rdoFemale;
	CheckBox chkMusic,chkCricket,chkDrawing;
	DatePicker dpDOB;
	Button btnSubmit,btnReset;
	ToggleButton tglConfirm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editName = (EditText) findViewById(R.id.editName);
		editEmail = (EditText) findViewById(R.id.editEmail);
		editPassword = (EditText) findViewById(R.id.editPassword);
		rdoMale = (RadioButton) findViewById(R.id.rdoMale);
		rdoFemale = (RadioButton) findViewById(R.id.rdoFemale);
		chkMusic = (CheckBox) findViewById(R.id.chkMusic);
		chkCricket = (CheckBox) findViewById(R.id.chkCricket);
		chkDrawing = (CheckBox) findViewById(R.id.chkDrawing);
		dpDOB = (DatePicker) findViewById(R.id.dpDOB);
		tglConfirm = (ToggleButton) findViewById(R.id.tglConfirm);
		btnSubmit = (Button) findViewById(R.id.btnSubmit);
		btnReset = (Button) findViewById(R.id.btnReset);
		
		btnSubmit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String data="";
				data+="Name: "+editName.getText().toString();
				data+="\nEmail: "+editEmail.getText().toString();
				data+="\nPassword: "+editPassword.getText().toString();
				data+="\nGender: ";
				if(rdoMale.isChecked())
					data+=rdoMale.getText().toString();
				else
					data+=rdoFemale.getText().toString();
				
				data+="\nHobby: ";
				if(chkCricket.isChecked())
					data+=chkCricket.getText();
				if(chkMusic.isChecked())
					data+=chkMusic.getText();
				if(chkDrawing.isChecked())
					data+=chkDrawing.getText();
				
				data+="\nDOB: ";
				data+=dpDOB.getDayOfMonth() +"/"+(dpDOB.getMonth()+1)+"/"+dpDOB.getYear();
				
				data+="\nConfirm status: ";
				if(tglConfirm.isChecked())
					data+=tglConfirm.getTextOn();
				else 
					data+=tglConfirm.getTextOff();
				
				
				Toast.makeText(MainActivity.this, data, Toast.LENGTH_LONG).show();
			}
		});
		
		
	}
}
