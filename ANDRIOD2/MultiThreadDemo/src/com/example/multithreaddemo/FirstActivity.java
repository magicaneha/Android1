package com.example.multithreaddemo;
import android.app.Activity;
import android.os.Bundle;
import android.widget.ProgressBar;

public class FirstActivity extends Activity {
	ProgressBar pb1;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.firstview);
		
		pb1=(ProgressBar) findViewById(R.id.pb1);
		
		MyThread mt = new MyThread();
		mt.start();
	}
	
	class MyThread extends Thread
	{
		@Override
		public void run() {
		
			super.run();
			
			for(int i=1;i<=100;i++)
			{
			
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				pb1.setProgress(i);
			}
			
		}
	}
}
