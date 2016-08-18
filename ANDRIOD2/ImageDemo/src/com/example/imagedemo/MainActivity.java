package com.example.imagedemo;

import java.io.File;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	Button btnLoad1,btnLoad2;
	ImageView iv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		btnLoad1= (Button) findViewById(R.id.btnLoad1);
		btnLoad2= (Button) findViewById(R.id.btnLoad2);
		iv=(ImageView) findViewById(R.id.iv);
		
		btnLoad1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				iv.setImageResource(R.drawable.sunset);
			}
		});
		btnLoad2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				File mypic = new File(Environment.getExternalStorageDirectory(), "Images/Winter.jpg");
				Bitmap bm = BitmapFactory.decodeFile(mypic.getPath());
				
				iv.setImageBitmap(bm);
			}
		});

	}


}
