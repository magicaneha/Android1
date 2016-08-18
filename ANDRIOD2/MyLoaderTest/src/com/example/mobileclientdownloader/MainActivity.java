package com.example.mobileclientdownloader;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	Button btnImage;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnImage=(Button) findViewById(R.id.btnImage);
		btnImage.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String rssUrl="http://www.bhaskar.com/rss-feed/521/";
				//String url="http://fc02.deviantart.net/fs70/i/2011/259/f/2/pink_flowers_png_by_melissa_tm-d49zfju.png";
				
				new MyTask().execute(rssUrl);
			}
		});
	}

	class MyTask extends AsyncTask<String, Void, Void>
	{

		@Override
		protected Void doInBackground(String... params) {
			
			try{
				String url = params[0];
				HttpGet getRequest=new HttpGet(url);
				HttpClient client = new DefaultHttpClient();
				
				HttpResponse resp=  client.execute(getRequest);
				InputStream is = resp.getEntity().getContent();
		
//				FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "image.png"));
				FileOutputStream fos = new FileOutputStream(new File(Environment.getExternalStorageDirectory(), "news.rss"));
				
				while(true)
				{
					int i = is.read();
					if(i==-1)
						break;
					fos.write(i);
				}
				
				fos.close();
				is.close();
			}
			catch (Exception e) {
				
				Log.e("error", e.toString());
				
			}
			return null;
		}	
		
		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			Toast.makeText(MainActivity.this, "Image has been Downloaded", Toast.LENGTH_LONG).show();
			
			
		}
}
}
