package com.example.bluetoothdemo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.UUID;

import android.app.Service;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothServerSocket;
import android.bluetooth.BluetoothSocket;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class BluetoothServerService extends Service
{
	BluetoothAdapter adp;
	
	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		adp = BluetoothAdapter.getDefaultAdapter();
		super.onCreate();
	}
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) 
	{
	    
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	class DeviceAcceptThread extends Thread
	{
		BluetoothServerSocket ssoc;
		 private UUID uuid =UUID.fromString("00000000-0000-0000-0000-0123456789AB");
		
		public DeviceAcceptThread() 
		{
			while(true)
			{
		  try {
			ssoc =  adp.listenUsingRfcommWithServiceRecord("gourav", uuid);
			
			BluetoothSocket soc = ssoc.accept();
			new DataReceive(soc).start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
		}
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			super.run();
		}
	} 
	class DataReceive extends Thread
	{
		BluetoothSocket soc;
		
		
		public DataReceive(BluetoothSocket soc) {
			super();
			this.soc = soc;
		}


		@Override
		public void run() {
		
			try {
				InputStream is = soc.getInputStream();
				
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				String str = br.readLine();
				Toast.makeText(BluetoothServerService.this,str, 2).show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			super.run();
		}
	} 
	
}
