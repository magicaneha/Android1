package com.example.multithreaddemo;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class StopWatch extends Activity {
	TextView tvCounter;
	Button btnStart;
	MyHandler mhandler;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.secview);
		
		tvCounter=(TextView) findViewById(R.id.tvCounter);
		btnStart=(Button) findViewById(R.id.btnStart);
		
		btnStart.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				mhandler=new MyHandler();
				Mythread mt=new Mythread();
				mt.start();
				Toast.makeText(StopWatch.this, "Counting start", 5).show();
			}
		});
	}
	
	class MyHandler extends Handler
	{
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			
			Bundle bn = msg.getData();
			int i = bn.getInt("val");
			
			tvCounter.setText(i+"");
		}
	}
	
	class Mythread extends Thread
	{
		@Override
		public void run() {
			super.run();
			for(int i=1;i<=100;i++)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				Bundle bn = new Bundle();
				bn.putInt("val", i);
				
				Message msg = new Message();
				msg.setData(bn);
				
				mhandler.sendMessage(msg);
			}
		}
	}
}
