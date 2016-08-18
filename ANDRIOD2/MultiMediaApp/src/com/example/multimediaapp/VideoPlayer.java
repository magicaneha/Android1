package com.example.multimediaapp;

import java.io.File;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

public class VideoPlayer extends Activity {
	VideoView vv;
	MediaController controller;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.myview);
		
		vv=(VideoView) findViewById(R.id.videoView1);
		controller=new MediaController(VideoPlayer.this);
		vv.setMediaController(controller);
		
		File myfile = new File(Environment.getExternalStorageDirectory(), "clock.avi");
		//File myfile = new File(Environment.getExternalStorageDirectory(), "waka.mp3");
		vv.setVideoPath(myfile.getPath());
		
		vv.start();
		
		controller.setPrevNextListeners(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(VideoPlayer.this, "Next", 5).show();
			}
		}, new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Toast.makeText(VideoPlayer.this, "Prev", 5).show();
			}
		});
		
	}
}
