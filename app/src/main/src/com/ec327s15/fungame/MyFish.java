package com.ec327s15.fungame;

import android.content.Context;
import android.hardware.SensorManager;
import android.view.OrientationEventListener;

public class MyFish extends OrientationEventListener 
{
	//data field for MyFish position
	
	OrientationEventListener orientationEL;
	
	OrientationEventListener(Context context, int rate)
	{
		
	}
	
	@Override
	public boolean canDetectOrientation()
	{
		return super.canDetectOrientation();
	}
	
	@Override
	public void enable()
	{
		
	}
	
	@Override
	public abstract void onOrientationChanged(int orient)		//only consider screen towards up
	{
		if (orient >= 0 && orient <= 90)
		{
			//towards right
		}
		
		else if (orient >= 270 && orient <= 359)
		{
			//towards left
		}
	}

}
