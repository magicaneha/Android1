package com.example.dynamiccomponent1;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {
	RadioButton rdoCircle,rdoRectangle;
	LinearLayout llChild;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		llChild=(LinearLayout) findViewById(R.id.llchild);
		rdoCircle=(RadioButton) findViewById(R.id.rdoCircle);
		rdoRectangle=(RadioButton) findViewById(R.id.rdoRectangle);
		
		rdoCircle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater linf = getLayoutInflater();
				View vv = linf.inflate(R.layout.circleview, null);
				
				llChild.removeAllViews();
				llChild.addView(vv);
			}
		});
		rdoRectangle.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				LayoutInflater linf = getLayoutInflater();
				View vv = linf.inflate(R.layout.rectview, null);
				
				llChild.removeAllViews();
				llChild.addView(vv);
			}
		});
	}

}
