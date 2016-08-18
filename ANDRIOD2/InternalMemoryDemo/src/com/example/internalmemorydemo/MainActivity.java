package com.example.internalmemorydemo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {
	EditText editMessage;
	Button btnSave,btnRead;
	TextView tvResult;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editMessage=(EditText) findViewById(R.id.editMessage);
		tvResult=(TextView) findViewById(R.id.tvResult);
		btnRead=(Button) findViewById(R.id.btnRead);
		btnSave= (Button) findViewById(R.id.btnSave);
		
		btnRead.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					FileInputStream fis = openFileInput("sample.txt");
					String data="";
					while(true)
					{
						int  i = fis.read();
						if(i==-1)
							break;
						
						data+=(char)i;
					}
						
					tvResult.setText(data);
					
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnSave.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				try {
					String data = editMessage.getText().toString();
					
					FileOutputStream fos =openFileOutput("sample.txt", MODE_PRIVATE);
					fos.write(data.getBytes());
					fos.close();
					Toast.makeText(MainActivity.this, "File Saved", 5).show();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}

}
