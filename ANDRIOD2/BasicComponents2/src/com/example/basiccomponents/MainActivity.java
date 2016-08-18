package com.example.basiccomponents;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity implements OnClickListener {
	Button btnSubmit;
	ToggleButton tglGraduate;
	EditText editUname,editPassword;
	RadioButton rdoMale,rdoFemale;
	CheckBox chkMusic,chkCricket;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editUname = (EditText) findViewById(R.id.editUname);
		editPassword = (EditText) findViewById(R.id.editPassword);
		rdoMale =(RadioButton) findViewById(R.id.rdoMale);
		rdoFemale =(RadioButton) findViewById(R.id.rdoFemale);
		chkCricket = (CheckBox) findViewById(R.id.chkCricket);
		chkMusic= (CheckBox) findViewById(R.id.chkMusic);
		tglGraduate = (ToggleButton) findViewById(R.id.tglGraduate);
		
		btnSubmit=(Button) findViewById(R.id.btnSubmit);
		btnSubmit.setOnClickListener(this);
		
	}
	@Override
	public void onClick(View v) {
		String data="";
		
		data="Username: "+editUname.getText().toString();
		data+="\nPassword: "+editPassword.getText().toString();
		data+="\nGender: ";
		if(rdoFemale.isChecked())
			data+=rdoFemale.getText().toString();
		else
			data+=rdoMale.getText().toString();
		
		data+="\nHobby: ";
		if(chkCricket.isChecked())
			data+=chkCricket.getText().toString();
		if(chkMusic.isChecked())
			data+=chkMusic.getText().toString();
		
		data+="\nGraduate: ";
		if(tglGraduate.isChecked())
			data+=tglGraduate.getTextOn().toString();
		else
			data+=tglGraduate.getTextOff().toString();
		
		
		Toast.makeText(this, data, Toast.LENGTH_LONG).show();
	}

	

}
