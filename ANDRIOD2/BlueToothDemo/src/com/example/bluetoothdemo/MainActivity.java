package com.example.bluetoothdemo;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.UUID;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity 
{
    TextView tv;
    ListView lv;
    
    BluetoothAdapter adp;
    
    ArrayList<BluetoothDevice> devlist;
    ArrayList<String>  devnamelist;
    ArrayAdapter<String> devadp;
    
    @Override
    protected void onDestroy() 
    {
      unregisterReceiver(mReceiver);
    	super.onDestroy();
    }
    
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// ServerService Start		
		Intent sin = new Intent(MainActivity.this,BluetoothServerService.class);
		startService(sin);		
		// End
		
		// Register the BroadcastReceiver
		IntentFilter filter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
		registerReceiver(mReceiver, filter); 
		// Don't forget to unregister during onDestroy
		
		tv = (TextView) findViewById(R.id.textView1);
		lv = (ListView) findViewById(R.id.listView1);
		
		devlist  = new ArrayList<BluetoothDevice>();
		devnamelist = new ArrayList<String>();
		devadp = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,devnamelist);
		lv.setAdapter(devadp);
		
		
		adp = BluetoothAdapter.getDefaultAdapter();		
		
		
		if(adp==null)
		{
			Toast.makeText(this,"No Device Found !", 2).show();
			finish();
		}
		
		if(!adp.isEnabled())
		{
			Intent in = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
			startActivityForResult(in, 11);
		}	
		else{adp.startDiscovery();}
		
		lv.setOnItemClickListener(new OnItemClickListener()
		{
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) 
			{
			   BluetoothDevice dev = devlist.get(arg2);
			   new DeviceConnectThread(dev).start();
			}
		});
	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) 
	{
	    if(requestCode==11 && resultCode==RESULT_CANCELED)
	    {
	    	Toast.makeText(this,"Please On Your BlueTooth !",2).show();
	    	finish();
	    }
	    if(requestCode==11 && resultCode==RESULT_OK)
	    {
	    	adp.startDiscovery();
	    }
		super.onActivityResult(requestCode, resultCode, data);
	}
	
	// Create a BroadcastReceiver for ACTION_FOUND
private final BroadcastReceiver mReceiver = new BroadcastReceiver() 
{
    public void onReceive(Context context, Intent intent) 
    {
	       String action = intent.getAction();
	       
	        // When discovery finds a device
	        if (BluetoothDevice.ACTION_FOUND.equals(action)) 
	        {
	            // Get the BluetoothDevice object from the Intent
	            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
	            devlist.add(device);
	            devnamelist.add(device.getName());
	            devadp.notifyDataSetChanged();
	        }
	    }
};
	

class DeviceConnectThread extends Thread
{
  private BluetoothDevice device;
  private BluetoothSocket soc;
  private UUID uuid =UUID.fromString("00000000-0000-0000-0000-0123456789AB");
   
  public DeviceConnectThread(BluetoothDevice device)  
  {
	  this.device = device;  
	  
	  try {
		soc = device.createRfcommSocketToServiceRecord(uuid);
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  
  @Override
  public void run() 
  {
	try {
		soc.connect();		
		
		new DataSend(soc).start();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		try {
			soc.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		e.printStackTrace();
	}
	super.run();
  }	
}


class DataSend extends Thread
{
   private BluetoothSocket soc;

  public DataSend(BluetoothSocket soc) 
  {
	super();
	this.soc = soc;
  }
  
  @Override
  public void run() 
  {
	try {
		OutputStream os  = soc.getOutputStream();
		
		String str = "Hello";
		
		OutputStreamWriter osw = new OutputStreamWriter(os);
		osw.write(str);
		osw.close();
		os.close();		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 super.run();
  }   
}
}
