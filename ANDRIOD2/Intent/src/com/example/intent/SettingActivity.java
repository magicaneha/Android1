package com.example.intent;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SettingActivity extends Activity {
	private static final int REQUEST_SELECT_PHONE_NUMBER = 1;
	private static final int REQUEST_SELECT_PHONE_NUMBER2 = 2;
	private static final int REQUEST_SELECT_PHONE_NUMBER3=3;
	private static final int REQUEST_SELECT_PHONE_NUMBER4 = 4;
	EditText e1,e2,e3,e4;
	
	 @Override
		protected void onCreate(Bundle savedInstanceState) {
		 
		 
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_setting);
			e1=(EditText)findViewById(R.id.editText1);
			 e2=(EditText)findViewById(R.id.editText2);
			 e3=(EditText)findViewById(R.id.editText3);
			 e4=(EditText)findViewById(R.id.editText4);
			 
			}
	 
	 public void m1(View v)
	 {
		 DBHelper db=new  DBHelper(this, "mydb.db", null, 2);
		 SQLiteDatabase db1=db.getReadableDatabase();
		 
		 ContentValues cv=new ContentValues();
		 String s1="",s2="",s3="",s4="";
		 try{
		  s1=e1.getEditableText().toString();
		  s2=e2.getEditableText().toString();
		  s3=e3.getEditableText().toString();
		  s4=e4.getEditableText().toString();
	
		 cv.put("userno",s1);
		 cv.put("userno",s2);
		 cv.put("userno",s3);
		 cv.put("userno",s4);
		 
		 db1.insert("user", null, cv);
		 
		 db1.close();
		 Toast.makeText(getApplicationContext(),"content saved",Toast.LENGTH_SHORT ).show();
		 }
		 catch(Exception e)
		 {
			 Toast.makeText(getApplicationContext(),"content not saved updated"+e,Toast.LENGTH_SHORT ).show();
			 //Toast.makeText(getApplicationContext(),"Content is not saved"+e,Toast.LENGTH_SHORT ).show();
		 
			 Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_SHORT ).show();
			 Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_SHORT ).show();
			 Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_SHORT ).show();
		 }
 }
	 public void n1(View v)
	 {
		 Intent intent = new Intent(Intent.ACTION_PICK);
		    intent.setType(CommonDataKinds.Phone.CONTENT_TYPE);
		    if (intent.resolveActivity(getPackageManager()) != null) {
		        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER);
	 }
	}
	 
	 
	 @Override
	 protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	     if ((requestCode == REQUEST_SELECT_PHONE_NUMBER||requestCode == REQUEST_SELECT_PHONE_NUMBER2||requestCode == REQUEST_SELECT_PHONE_NUMBER3||requestCode == REQUEST_SELECT_PHONE_NUMBER4) && resultCode == RESULT_OK) {
	         // Get the URI and query the content provider for the phone number
	         Uri contactUri = data.getData();
	         String[] projection = new String[]{CommonDataKinds.Phone.NUMBER};
	         Cursor cursor = getContentResolver().query(contactUri, projection,
	                 null, null, null);
	         // If the cursor returned is valid, get the phone number
	         if (cursor != null && cursor.moveToFirst()) {
	             int numberIndex = cursor.getColumnIndex(CommonDataKinds.Phone.NUMBER);
	             String number = cursor.getString(numberIndex);
	             // Do something with the phone number
	             if(requestCode == REQUEST_SELECT_PHONE_NUMBER)
	             e1.setText(number);
	             else if(requestCode == REQUEST_SELECT_PHONE_NUMBER2)
	            	 e2.setText(number);
	             else if(requestCode == REQUEST_SELECT_PHONE_NUMBER3)
	            	 e3.setText(number);
	             else if(requestCode == REQUEST_SELECT_PHONE_NUMBER4)
	            	 e4.setText(number);
	             
	             
	     }
	     }
	    
	 }
	 
	 
	 public void n2(View v)
	 {
		 Intent intent = new Intent(Intent.ACTION_PICK);
		    intent.setType(CommonDataKinds.Phone.CONTENT_TYPE);
		    if (intent.resolveActivity(getPackageManager()) != null) {
		        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER2);
	 }
	}
	 
	 public void n3(View v)
	 {
		 Intent intent = new Intent(Intent.ACTION_PICK);
		    intent.setType(CommonDataKinds.Phone.CONTENT_TYPE);
		    if (intent.resolveActivity(getPackageManager()) != null) {
		        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER3);
	 }
	}
	 
	 public void n4(View v)
	 {
		 Intent intent = new Intent(Intent.ACTION_PICK);
		    intent.setType(CommonDataKinds.Phone.CONTENT_TYPE);
		    if (intent.resolveActivity(getPackageManager()) != null) {
		        startActivityForResult(intent, REQUEST_SELECT_PHONE_NUMBER4);
	 }
	}
	 
	 }
