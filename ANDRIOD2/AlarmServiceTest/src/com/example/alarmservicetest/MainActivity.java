package com.example.alarmservicetest;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;



public class MainActivity extends Activity {
	Button btnStart,btnStop;
	AlarmManager am;
	PendingIntent pi;
	Intent in;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		am = (AlarmManager) getSystemService(ALARM_SERVICE);
	
//		in = new Intent(Intent.ACTION_DIAL);
//		pi = PendingIntent.getActivity(MainActivity.this, 101, in, PendingIntent.FLAG_UPDATE_CURRENT);
		
		in=new Intent("com.myaction2");
		pi = PendingIntent.getService(MainActivity.this, 102, in, PendingIntent.FLAG_UPDATE_CURRENT);
		
		
		btnStart = (Button) findViewById(R.id.btnStart);
		btnStop = (Button) findViewById(R.id.btnStop);
		
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
							
				long currentTime = System.currentTimeMillis();
				long scheduledTime = currentTime + 5000;
				
				am.setRepeating(AlarmManager.RTC_WAKEUP, scheduledTime, 7000, pi);
				Toast.makeText(MainActivity.this, "Alarm Scheduled", 5).show();
			}
		});
		btnStop.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				am.cancel(pi);
			}
		});
	}
}
