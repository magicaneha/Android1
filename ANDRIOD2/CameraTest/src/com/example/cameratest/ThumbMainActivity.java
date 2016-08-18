package com.example.cameratest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class ThumbMainActivity extends Activity {
	Button btnCamera;
	ImageView ivPic;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		ivPic=(ImageView) findViewById(R.id.ivPic);		
		btnCamera=(Button) findViewById(R.id.btnCamera);
		btnCamera.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(in, 101);
			}
		});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		
		//if(resultCode==101)
		//{
			Log.e("hhhh", "yes");
			Bitmap bmp = (Bitmap) data.getExtras().get("data");
			ivPic.setImageBitmap(bmp);
		//}
		
	}

}
