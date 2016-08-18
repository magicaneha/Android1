package com.example.additionapp;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editNum1,editNum2;
	Button btnSum;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editNum1 = (EditText) findViewById(R.id.editNum1);
		editNum2 = (EditText) findViewById(R.id.editNum2);
		btnSum = (Button) findViewById(R.id.btnSum);
		
		btnSum.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int num1 = Integer.parseInt(editNum1.getText().toString());
				int num2 = Integer.parseInt(editNum2.getText().toString());
				
				int num3 = num1+num2;
				
//				Toast t = Toast.makeText(MainActivity.this, "Sum is " +num3, Toast.LENGTH_LONG);
//				t.show();
				Toast.makeText(MainActivity.this, "Sum is " +num3, Toast.LENGTH_LONG).show();
			}
		});
		
	}

}
