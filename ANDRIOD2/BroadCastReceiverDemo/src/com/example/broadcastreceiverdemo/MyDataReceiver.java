package com.example.broadcastreceiverdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyDataReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		String data = intent.getStringExtra("msg");
		Toast.makeText(context, "Data Received at Receiver : "+data, Toast.LENGTH_LONG).show();
		
	}

}
