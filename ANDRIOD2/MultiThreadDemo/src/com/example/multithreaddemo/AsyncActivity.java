package com.example.multithreaddemo;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class AsyncActivity extends Activity {
	TextView tvCounter;
	Button btnStart;
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
				MyTask mt = new MyTask();
				mt.execute();
				
			}
		});
		
	}
	
	class MyTask extends AsyncTask<Void, Void, String>
	{

		@Override
		protected String doInBackground(Void... params) {
			int i;
			
			for(i=1;i<=100;i++)
			{
				Log.e("counting", i+"");
			}
			return i+"";
		}
		
		@Override
		protected void onPostExecute(String result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(AsyncActivity.this, result, 5).show()	;
		}
		
	}
}
