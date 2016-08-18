package com.example.intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
public class MainActivity extends Activity {
     @Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		}
	public void m1(View v)
	{
		Intent intent = new Intent(this,SecondActivity.class);
		startActivity(intent);
		}
	public void callTo(View v)
	{
        Intent intent = new Intent(Intent.ACTION_CALL);
        
        intent.setData(Uri.parse("tel:108"));
       
       startActivity(intent);
       

	}
	public void fire(View v)
	{
		Intent intent = new Intent(this,FireActivity.class);
		startActivity(intent);
	}
	
	public void hospital(View v)
	{
		Intent intent = new Intent(this,HospitalActivity.class);
		startActivity(intent);
	}
	public void callToPolice(View v)
	{
		Intent in=new Intent(this,PoliceActivity.class);
		startActivity(in);
	}
	
	 }
