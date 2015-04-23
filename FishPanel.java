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

		g.setColor(Color.BLACK);
		g.fillOval((int)otherFish.oFish.x * MainFish.SCALE, (int)otherFish.oFish.y * MainFish.SCALE, (int)otherFish.oFishR * MainFish.SCALE, (int)otherFish.oFishR * MainFish.SCALE);
		if(MainFish.over)
		{
			String gameOver = "Game Over! Your are so delicious!";
			g.setColor(Color.RED);
			g.drawString(gameOver, (int)(getWidth() / 2 - gameOver.length() * 2.5f), 50);
		}
	}
}
