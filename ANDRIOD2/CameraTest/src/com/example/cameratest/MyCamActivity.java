package com.example.cameratest;

import java.io.File;
import java.io.FileOutputStream;

import android.app.Activity;
import android.hardware.Camera;
import android.hardware.Camera.PictureCallback;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MyCamActivity extends Activity {
	Camera cam;
	FrameLayout myFrame;
	Button btnCapture;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mypreview);
		
		myFrame=(FrameLayout) findViewById(R.id.myFrame);
		btnCapture=(Button) findViewById(R.id.btnCapture);
		
		btnCapture.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				cam.takePicture(null, null, new PictureCallback() {
					
					@Override
					public void onPictureTaken(byte[] data, Camera camera) {
						try{
							File file = new File(Environment.getExternalStorageDirectory(), "mypic.jpg");
							FileOutputStream fos  = new FileOutputStream(file);
							
							fos.write(data);
							fos.close();
							Toast.makeText(MyCamActivity.this, "Image Captured", 5).show();
						}
						catch (Exception e) {
							Log.e("error", e.toString());
						}
					}
				});
			}
		});
	}
	
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
		
		cam=Camera.open();
		MyPreview mp = new MyPreview(this, cam);
		myFrame.addView(mp);
		Toast.makeText(this, "Camera Started", 5).show();
		
	}
	
	@Override
	protected void onStop() {
		// TODO Auto-generated method stub
		super.onStop();
		cam.release();
		Toast.makeText(this, "Camera Released", 5).show();
	}
}
