package FunFish;

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
		//double p = (int) Math.ceil(Math.random()*80);
		//oFish.x = p;
		this.oSpeed = oSpeed;
		double q = (int) Math.ceil(Math.random()*8);
		oFishR = q;
		this.oFishR = oFishR;
	}

	public void otherFishMove()
	{
		if(MainFish.level == 1)
			oFish.y += oSpeed;
		
		else if(MainFish.level == 2)
			oFish.x += oSpeed;
		
		else if(MainFish.level == 3)
		{
			if(MainFish.numSmallFish % 2 == 0)
			{
				oFish.y += oSpeed;
			}
			if(MainFish.numSmallFish % 2 == 1)
			{
				oFish.x += oSpeed;
			}
		}
		
		else if(MainFish.level == 4)
		{
			if(MainFish.numSmallFish % 4 == 0)
			{
				oFish.y += oSpeed;
			}
			else if(MainFish.numSmallFish % 4 == 1)
			{
				oFish.x += oSpeed;
			}
			else if(MainFish.numSmallFish % 4 == 2)
			{
				oFish.y -= oSpeed;
			}
			else if(MainFish.numSmallFish % 4 == 3)
			{
				oFish.x -= oSpeed;
			}
		}
			
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
		if(MainFish.level == 1)
		{
			otherFish = new OtherFish(new Point2D.Double(Math.ceil(Math.random()*80), 1.0), 1.0, 3.0);
			return otherFish;
		}
		
		else if(MainFish.level == 2)
		{
			otherFish = new OtherFish(new Point2D.Double(1, Math.ceil(Math.random()*65)), 1.0, 3.0);
			return otherFish;
		}
		
		else if(MainFish.level == 3)
		{
			if(MainFish.numSmallFish % 2 == 0)
			{
				otherFish = new OtherFish(new Point2D.Double(1, Math.ceil(Math.random()*65)), 1.0, 3.0);
				return otherFish;
			}
			else if(MainFish.numSmallFish % 2 == 1)
			{
				otherFish = new OtherFish(new Point2D.Double(Math.ceil(Math.random()*80), 1.0), 1.0, 3.0);
				return otherFish;
			}
		}
		
		else if(MainFish.level == 4)
		{
			if(MainFish.numSmallFish % 4 == 0)
			{
				otherFish = new OtherFish(new Point2D.Double(Math.ceil(Math.random()*80), 1), 1.0, 3.0);
				return otherFish;
			}
			else if(MainFish.numSmallFish % 4 == 1)
			{
				otherFish = new OtherFish(new Point2D.Double(1, Math.ceil(Math.random()*65)), 1.0, 3.0);
				return otherFish;
			}
			else if(MainFish.numSmallFish % 4 == 2)
			{
				otherFish = new OtherFish(new Point2D.Double(Math.ceil(Math.random()*80), 65), 1.0, 3.0);
				return otherFish;
			}
			else if(MainFish.numSmallFish % 4 == 3)
			{
				otherFish = new OtherFish(new Point2D.Double(80, Math.ceil(Math.random()*65)), 1.0, 3.0);
				return otherFish;
			}
		}
		return otherFish;
	}
}
