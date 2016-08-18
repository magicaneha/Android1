package com.example.intent;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.widget.TextView;
public class SecondActivity extends Activity
{
	Button sm;
	TextView tvadd;
	AppLocationService appLocationService;
	@Override
	 public void startManagingCursor(Cursor c) {
	  if (c == null) {
	   throw new IllegalStateException("cannot manage cursor: cursor == null");
	  }
	  super.startManagingCursor(c);
	 }
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		tvadd = (TextView) findViewById(R.id.textView1);
		 appLocationService = new AppLocationService(SecondActivity.this);
		 sm=(Button)findViewById(R.id.button1); 
		 sm.setOnClickListener(new View.OnClickListener() {
	            @Override
	            public void onClick(View arg0) {
	            	Location location = appLocationService.getLocation();

	                //you can hard-code the lat & long if you have issues with getting it
	                //remove the below if-condition and use the following couple of lines
	                //double latitude = 37.422005;
	                //double longitude = -122.084095

	                if (location != null) {
	                    double latitude = location.getLatitude();
	                    double longitude = location.getLongitude();
	                   // LocationAddress locationAddress = new LocationAddress();
	                    LocationAddress.getAddressFromLocation(latitude, longitude,getApplicationContext(), new GeocoderHandler());
	                    } else {
	                    showSettingsAlert();
	                } 
	            	
	            	 }
	        });
		 
		 try{
		 String location=tvadd.getEditableText().toString();
		 if(location!=null)
		 {
		 DBHelper dbHelper =new DBHelper(this, "mydb.db", null, 2);
  		 SQLiteDatabase db=dbHelper.getWritableDatabase();
         SQLiteDatabase mydb=SQLiteDatabase.openDatabase(db.getPath(), null,SQLiteDatabase.NO_LOCALIZED_COLLATORS);
         
         
         Cursor cursor=mydb.rawQuery("select * from user", null);
         String a[]=new String[4];
  		for(int j=0;j<4;j++)
  		{
  			a[j]="";
  		}
  		int i=0;
  		if(cursor.getCount()!=0)
  		{
  			cursor.moveToFirst();
  		     while(!cursor.isAfterLast())
  		     {
  		    	  String user=cursor.getString(cursor.getColumnIndex("userno"));
  		    	  a[i]=user;
  		    	  i++;
  		    	  cursor.moveToNext();
  		     }
  		}
  		   mydb.close();
         
		 
		
  		 SmsManager smsManager = SmsManager.getDefault();
		 for(int j=0;j<a.length;j++)
		 {
			String msg="i am in this location: "+location;
			smsManager.sendTextMessage(a[j], null, msg, null, null);
		 }
		 }}
	
	 catch(Exception e)
	 {
	 	System.out.println("null pointer exception occured"); 
	 }


}	 

	
	 
	   public void m1(View v)
	   {

			Intent intent = new Intent(this,SettingActivity.class);
			startActivity(intent);
	   }
	
	    public void showSettingsAlert() {
	        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
	                SecondActivity.this);
	        alertDialog.setTitle("SETTINGS");
	        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
	        alertDialog.setPositiveButton("Settings",
	                new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                        Intent intent = new Intent(
	                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
	                        SecondActivity.this.startActivity(intent);
	                    }
	                });
	        alertDialog.setNegativeButton("Cancel",
	                new DialogInterface.OnClickListener() {
	                    public void onClick(DialogInterface dialog, int which) {
	                        dialog.cancel();
	                    }
	                });
	        alertDialog.show();
	    }

	    private class GeocoderHandler extends Handler {
	        @Override
	        public void handleMessage(Message message) {
	            String locationAddress;
	            switch (message.what) {
	                case 1:
	                    Bundle bundle = message.getData();
	                    locationAddress = bundle.getString("address");
	                    break;
	                default:
	                    locationAddress = null;
	            }
	            tvadd.setText(locationAddress);
	            
	        }
	    }

		}

