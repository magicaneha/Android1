package com.example.broadcastsender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText editMessage;
	Button btnSend;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		editMessage=(EditText) findViewById(R.id.editMsg);
		btnSend=(Button) findViewById(R.id.btnSend);
		btnSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent in = new Intent("com.mysignal");
				in.putExtra("msg", editMessage.getText().toString());
				sendBroadcast(in);
				Toast.makeText(MainActivity.this, "Data Broadcasted", 5).show();
			}
		});
	}
}
