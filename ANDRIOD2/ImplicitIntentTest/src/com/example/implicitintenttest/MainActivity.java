package com.example.implicitintenttest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button btnMove,btnDial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnMove=(Button) findViewById(R.id.btnMove);
		btnDial=(Button) findViewById(R.id.btnDial);
		btnMove.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent in =new Intent("com.myaction");
				startActivity(in);	
			}
		});
		btnDial.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//Intent in = new Intent(Intent.ACTION_DIAL);
				Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				
				startActivity(in);
			}
		});
	}


}
 