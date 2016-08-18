package com.example.multipleactivitydemo;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editMessage,editName;
	Button btnNext;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editName= (EditText) findViewById(R.id.editName);
		editMessage = (EditText) findViewById(R.id.editMessage);
		btnNext = (Button) findViewById(R.id.btnNext);
		
		btnNext.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//explicit Intenet
				String msg = editMessage.getText().toString();
				String name = editName.getText().toString();
				
				Intent in = new Intent(MainActivity.this, SecondActivity.class);
				in.putExtra("data", msg);
				in.putExtra("name", name);
				//startActivity(in);
				startActivityForResult(in, 101);
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		
		//if(requestCode==101 && resultCode==RESULT_OK)
		//{
			int retval =  data.getIntExtra("retval", 0);
			Toast.makeText(MainActivity.this, "Updated value is : " +retval, Toast.LENGTH_LONG).show();
		//}
		
	}
}
