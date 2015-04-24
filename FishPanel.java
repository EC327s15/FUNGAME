package FunFish;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class FishPanel extends JPanel 
{
	public static Color seaBlue = new Color(49151);

	@Override
	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		g.setColor(seaBlue);
		g.fillRect(0, 0, 800, 700); 
		MainFish mainFish = MainFish.mainFish;
		OtherFish otherFish = OtherFish.otherFish;
		g.setColor(Color.blue);
		g.fillOval((int)mainFish.fish.x * MainFish.SCALE, (int)mainFish.fish.y * MainFish.SCALE, (int)mainFish.fishR * MainFish.SCALE, (int)mainFish.fishR * MainFish.SCALE);
		//for(Point point: mainFish.otherFish)
			//g.fillOval(point.x * MainFish.SCALE, point.y * MainFish.SCALE, mainFish.oFishR * MainFish.SCALE, mainFish.oFishR *MainFish.SCALE);
		//g.fillOval(mainFish.oFish.x * MainFish.SCALE, mainFish.oFish.y * MainFish.SCALE, mainFish.oFishR * MainFish.SCALE, mainFish.oFishR *MainFish.SCALE);
		//for(OtherFish f : MainFish.otherFish)
		//{
		//	f.draw(g);
		//}
		//otherFish.draw(g);
		g.setColor(Color.BLACK);
		g.fillOval((int)otherFish.oFish.x * MainFish.SCALE, (int)otherFish.oFish.y * MainFish.SCALE, (int)otherFish.oFishR * MainFish.SCALE, (int)otherFish.oFishR * MainFish.SCALE);
		String record = "Score: " + MainFish.score;
		g.setColor(Color.RED);
		g.drawString(record, (int) (getWidth() / 2 - record.length() * 2.5f), 10);
		if(MainFish.over && OtherFish.eatOtherFish())
		{
			String gameOver = "Game Over! Your are so delicious!";
			g.setColor(Color.black);
			g.drawString(gameOver, (int)(getWidth() / 2 - gameOver.length() * 2.5f), 80);
		}
		
		else if(MainFish.over && MainFish.fishR <= 2)
		{
			String gameOver = "Game Over! I'am hungry to die!";
			g.setColor(Color.black);
			g.drawString(gameOver, (int)(getWidth() / 2 - gameOver.length() * 2.5f), 80);
		}
		
		else if(MainFish.over && MainFish.fishR >= 10)
		{
			String gameOver = "Game Over! You feed me too much bro!";
			g.setColor(Color.black);
			g.drawString(gameOver, (int)(getWidth() / 2 - gameOver.length() * 2.5f), 80);
		}
	}
}
