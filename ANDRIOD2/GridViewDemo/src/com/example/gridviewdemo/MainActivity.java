package com.example.gridviewdemo;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class MainActivity extends Activity {
	ArrayList<Integer> imgList;
	GridView gv;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		gv=(GridView) findViewById(R.id.gvImage);
		
		imgList=new ArrayList<Integer>();
		imgList.add(R.drawable.ic_launcher);
		imgList.add(R.drawable.icon_design);
		imgList.add(R.drawable.icon_play);
		imgList.add(R.drawable.icon_search);
		imgList.add(R.drawable.locale);
		imgList.add(R.drawable.new_accessibility);
		
		MyAdapter ma = new MyAdapter(imgList, MainActivity.this);
		gv.setAdapter(ma);
		
	}
}
class MyAdapter extends BaseAdapter
{
	ArrayList<Integer> imgList;
	Context ctx;
	
	

	public MyAdapter(ArrayList<Integer> imgList, Context ctx) {
		super();
		this.imgList = imgList;
		this.ctx = ctx;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return imgList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		
		LayoutInflater linf = (LayoutInflater) ctx.getSystemService(ctx.LAYOUT_INFLATER_SERVICE);
		View v = linf.inflate(R.layout.childview, null);
		
		ImageView iv = (ImageView) v.findViewById(R.id.ivPic);
		iv.setImageResource(imgList.get(position));
		
		
		return v;
	}
	
}
