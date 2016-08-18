package com.example.filesystemtest;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BasicMainActivity extends Activity {
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
				File myfile = new File(Environment.getExternalStorageDirectory(),"microsoft.txt");
				try {
					FileReader fr = new FileReader(myfile);
					BufferedReader br = new BufferedReader(fr);
					String data="";
					while(true)
					{
						String str = br.readLine();
						if(str==null)
							break;
						data+=str;
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
				String data=editMessage.getText().toString();
				
				File sdpath =	Environment.getExternalStorageDirectory();
				File mydir = new File(sdpath, "TATA");
				if(!mydir.exists())
					mydir.mkdir();
				
				File myfile = new File(mydir, "Ratan.txt");
				
				try {
					FileWriter fw = new FileWriter(myfile);
					fw.write(data);
					fw.close();
					Toast.makeText(getApplicationContext(), "File Saved", 5).show();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		});
	}

}
