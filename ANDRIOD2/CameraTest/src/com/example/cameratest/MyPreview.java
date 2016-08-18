package com.example.cameratest;

import java.io.IOException;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MyPreview extends SurfaceView implements SurfaceHolder.Callback{
	Camera _cam;
	SurfaceHolder holder;
	
	public MyPreview(Context context, Camera _cam) {
		super(context);
		this._cam = _cam;
		
		holder=getHolder();
		holder.addCallback(this);
		
		holder.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
	}

	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width,	int height) {
		Parameters cp = _cam.getParameters();
		cp.setPreviewSize(width, height);
		_cam.setParameters(cp);
		_cam.startPreview();
		
				
	}

	@Override
	public void surfaceCreated(SurfaceHolder holder) {
		try {
			_cam.setPreviewDisplay(holder);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void surfaceDestroyed(SurfaceHolder holder) {
		// TODO Auto-generated method stub
		_cam.release();
	}

}
