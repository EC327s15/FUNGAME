package FunFish;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

public class OtherFish 
{
	public static OtherFish otherFish;
	public static Point2D.Double oFish;
	public static double oSpeed, oFishR;
	
	public OtherFish(Double oFish, double oSpeed, double oFishR)
	{
		this.oFish = oFish;
		double p = (int) Math.ceil(Math.random()*85);
		oFish.x = p;
		this.oSpeed = oSpeed;
		double q = (int) Math.ceil(Math.random()*8);
		oFishR = q;
		this.oFishR = oFishR;
	}

	public void otherFishMove()
	{
		oFish.y += oSpeed;
	}
	
	public static boolean eatOtherFish()
	{
		if(Math.pow(oFishR + MainFish.mainFish.getFishR(), 2) > Math.pow(MainFish.mainFish.getFishX() - oFish.x, 2) + Math.pow(MainFish.mainFish.getFishY() - oFish.y, 2))
		{
			MainFish.mainFish.eaten = true;
			return true;
		}
		else
		{
			MainFish.mainFish.eaten = false;
			return false;
		}
	}
	
	public static OtherFish generateOtherFish()
	{
		otherFish = new OtherFish(new Point2D.Double(50, 1.0), 1.0, 3.0);
		return otherFish;
	}
}
