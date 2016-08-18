package com.example.animationapplication;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ImageView iv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		iv=(ImageView) findViewById(R.id.imageView1);
		
		//Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myscale);
		//Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myrotate);
//		Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.mytranslate);
//		Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myalpha);
		Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myset);
		iv.setAnimation(anim);
	}
}
