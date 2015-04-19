package com.ec327s15.fungame;

import android.graphics.Canvas;
import android.view.SurfaceHolder;

public class MainThread 
{
	private SurfaceHolder surfaceHolder;
	private GamePanel gamePanel;
	private boolean run;
	public static Canvas canvas;
	
	public MainThread(SurfaceHolder sufaceHolder, GamePanel gamePanel)
	{
		super();
		this.surfaceHolder = surfaceHolder;
		this.gamePanel = gamePanel;
	}
	
	@Override
	public void run()
	{
		long startTime;
		long showTime;
		long waitTime;
		long recordTime;
		
		while(run)
		{
			startTime = System.nanoTime();
			canvas = null;
			
			try
			{
				canvas = this.surfaceholder.lockCanvas();
				synchronized (surfaceHolder)
				{
					this.gamePanel.update();
					this.gamePanel.draw(canvas);
				}
			}catch(Exception e){
				
			}
			finally{
				if(canvas != null){
					try{
						surfaceHolder.unlockCanvasAndPost(canvas);		//Finish editing pixels in the surface.
					}
					catch(Exception e){
						e.printStackTrace();
					}
				}
			}
			
			showTime = System.nanoTiem() - startTime;		//diveded by 1000000 ???
			waitTime = 1;		//change depends on level
			try{
	                this.sleep(waitTime);
	            }catch(Exception e){}
			
			recordTime += System.nanoTime() - startTime;
			
			public void setrun(boolean b)
			{
				run = b;
			}
			
			...
		}	
	}
}
