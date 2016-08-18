package com.example.dynamicfragdemo;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {

	Button frag1BT,frag2BT;
	
	FragmentManager fm;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		frag1BT = (Button) findViewById(R.id.button1);
		frag2BT = (Button) findViewById(R.id.button2);
		
		fm = getFragmentManager();
		
		//  getSupportFragmentManager();
		
		frag1BT.setOnClickListener(new OnClickListener()
		{		
			@Override
			public void onClick(View v) 
			{
			  FragmentTransaction ft = fm.beginTransaction();
			//  ft.add(R.id.mainLL, new Frag1());
			  ft.replace(R.id.mainLL, new Frag1());
			  ft.commit();
			  
			//  ft.remove();
			  
			}
		});
		
		frag2BT.setOnClickListener(new OnClickListener()
		{		
			@Override
			public void onClick(View v) 
			{
			FragmentTransaction ft = fm.beginTransaction();
			//ft.add(R.id.mainLL, new Frag2());
			ft.replace(R.id.mainLL, new Frag2());
			ft.commit();
			}
		});
		
	}	
}
