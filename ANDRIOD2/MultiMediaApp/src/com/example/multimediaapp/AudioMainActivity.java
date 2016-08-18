package com.example.multimediaapp;

import java.io.IOException;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class AudioMainActivity extends Activity {
	Button btnPlay,btnStop;
	MediaPlayer mp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		
		btnPlay=(Button) findViewById(R.id.btnPlay);
		btnStop=(Button) findViewById(R.id.btnStop);
		
		btnPlay.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mp=MediaPlayer.create(AudioMainActivity.this, R.raw.waka);
				try {
					mp.prepare();
				} catch (IllegalStateException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				mp.start();
				Toast.makeText(AudioMainActivity.this, "Enjoy....", 5).show();
			}
		});
		btnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				if(mp!=null)
				mp.stop();
			}
		});
	}
}