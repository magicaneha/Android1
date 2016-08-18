package com.example.filesystemtest;

import java.io.File;
import java.util.Stack;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity{
	ListView lv;
	String[] dirList;
	ArrayAdapter<String> adap;
	File f;
	Stack<File> mystack;
	private void fillList(File path)
	{
		Log.e("fillList", path.getPath());
		
		dirList = path.list();
		adap=new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, dirList);
		lv.setAdapter(adap);
		f=path;
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		lv = getListView();
		
		mystack=new Stack<File>();
		
		File rootFile = Environment.getExternalStorageDirectory();
		f=rootFile;
		mystack.push(f);
		fillList(f);
		
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
				int index = arg2;
				String retpath = adap.getItem(index);
							
				File newpath = new File(f.getPath(), retpath);
				if(newpath.isDirectory())
				{
				Log.e("path", newpath.getPath());
				f=newpath;
				mystack.push(f);
				fillList(f);
				}
			
				else
				{
					Log.e("file",newpath.getName());
					int i = newpath.getName().indexOf(".");
					String ext = newpath.getName().substring(i, newpath.getName().length());
					Log.e("ext", ext);
					if(ext.equals(".jpg"))
					{
						ImageView iv = new ImageView(MainActivity.this);
						Bitmap bm = BitmapFactory.decodeFile(newpath.getPath());
						iv.setImageBitmap(bm);
						
						AlertDialog.Builder build = new AlertDialog.Builder(MainActivity.this);
						build.setTitle("Images");
						build.setView(iv);
						build.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								
							}
						});
						build.show();
					}
					
					
					Toast.makeText(MainActivity.this, "This is file", 5).show();
				}
			}
		});
		
	}
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		
		if(keyCode==KeyEvent.KEYCODE_BACK)
		{
			if(!mystack.empty())
			{
				File poppedFile = mystack.pop();
				Log.e("popped", poppedFile.getPath());
				
				fillList(poppedFile);
				
				return false;
			}
				
		}
		
		return super.onKeyDown(keyCode, event);
	}
	
}
