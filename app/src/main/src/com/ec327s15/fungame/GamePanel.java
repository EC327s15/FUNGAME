package com.ec327s15.fungame;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.content.Context;

public class GamePanel extends SurfaceView implements SurfaceHolder.Callback 
{
	private MainThread thread;
	
	public GamePanel(Context context) 
	{
		super(context);
		getHolder().addCallback(this);
	}
	
	@Override
	public void surfaceChanged(SurfaceHolder holder, int format, int width, int height)
	{
		
	}
	
	@Override
	public void surfaceDestroyed(SurfaceHolder holder)
	{
		
	}
	
	@Override
	public void surfaceCreated(SurfaceHolder holder)
	{
		thread.setrun(true);
		thread.start();
	}
	
	public void update()
	{
		
	}
	

}
