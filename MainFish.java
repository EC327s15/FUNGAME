package FunFish;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Point2D;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.Timer;



public class MainFish implements ActionListener, KeyListener 
{
	public static MainFish mainFish;
	public Point2D.Double fish;
	public FishPanel fishPanel;
	public JFrame jframe;
	public static final int STABLE = 0, LEFT = 1, RIGHT = 2, UP = 3, DOWN = 4, SCALE = 10;
	public int direction, numSmallFish;
	public static int score;
	public static double fishR;
	public static boolean over;
	public boolean eaten;
	public Dimension dim;
	public Timer timer = new Timer(20, this);
	public long startTime;
	
	public MainFish()
	{
		dim = Toolkit.getDefaultToolkit().getScreenSize();
		jframe = new JFrame("Hungry Fish");
		jframe.setVisible(true);
		jframe.setSize(805, 700);
		jframe.setResizable(false);
		jframe.setLocation(dim.width / 2 - jframe.getWidth() / 2, dim.height / 2 - jframe.getHeight() / 2);
		jframe.add(fishPanel = new FishPanel());
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jframe.addKeyListener(this);
		startGame();
	}
	
	public void startGame()
	{
		startTime = System.currentTimeMillis();
		over = false;
		eaten = false;
		fish = new Point2D.Double(38, 60);
		fishR = 5;
		OtherFish.otherFish = new OtherFish(new Point2D.Double(38.0, 1.0), 1.0, 3.0);
		numSmallFish = 0;
		direction = STABLE;
		//otherFish.clear();
		timer.start();
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		fishPanel.repaint();
		if(!over)
		{
			if(!eaten)
			{
				OtherFish.otherFish.otherFishMove();
			}
				
			if(OtherFish.otherFish.oFish.y > 65)
			{
				OtherFish.generateOtherFish();
				if(OtherFish.oFishR < fishR)
				{
					numSmallFish++;
				}
			}
			
			else if(OtherFish.eatOtherFish() && fishR >= OtherFish.oFishR)
			{
				fishR++;
				OtherFish.generateOtherFish();
			}
			
			else if(OtherFish.eatOtherFish() && fishR < OtherFish.oFishR || fishR >= 10)
			{
				over = true;
			}

			if(numSmallFish >= 3)
			{
				fishR--;
				numSmallFish = 0;
				if(fishR <= 2)
				{
					over = true;
				}
			}
			
			if(score >= 2)
			{
				OtherFish.oSpeed += 0.01;
			}
		}
			
//			if(!eaten)
//			{
//				for(int i = 0; i < numOtherFish; i++)
//					otherFish[i].oFish = new Point2D.Double(otherFish[i].oFish.x, otherFish[i].oFish.y + 1);
//			}																			   //generate other fish
//--------------------------------------------------------------------------------------------------------------//		
		if(direction == LEFT && !over)
		{
			if(fish.x >= 1)
			{
				fish = new Point2D.Double(fish.x - 1, fish.y);
				direction = STABLE;
			}
			else
				direction = STABLE;
		}
	
		if(direction == RIGHT && !over)
		{
			if(fish.x <= 78)
			{
				fish = new Point2D.Double(fish.x + 1, fish.y);
				direction = STABLE;
			}
			else
				direction = STABLE;
		}
			
		if(direction == UP && !over)
		{
			if(fish.y >= 1)
			{
				fish = new Point2D.Double(fish.x, fish.y - 1);
				direction = STABLE;
			}
			else
				direction = STABLE;
		}
			
		if(direction == DOWN && !over)
		{
			if(fish.y <= 64)
			{
				fish = new Point2D.Double(fish.x, fish.y + 1);
				direction = STABLE;
			}
			else
				direction = STABLE;
		}	
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int i = e.getKeyCode();
		if (i == KeyEvent.VK_LEFT)
		{
			direction = LEFT;
		}
			
		if (i == KeyEvent.VK_RIGHT)
		{
			direction = RIGHT;
		}
		
		if (i == KeyEvent.VK_UP)
		{
			direction = UP;
		}
		
		if (i == KeyEvent.VK_DOWN)
		{
			direction = DOWN;
		}
		
		if (i == KeyEvent.VK_SPACE)
		{
			startGame();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public double getFishR()
	{
		return fishR;
	}
	
	public double getFishX()
	{
		return fish.x;
	}
	
	public double getFishY()
	{
		return fish.y;
	}
	
/*	private void deleteOtherFish(int index)				//otherFish in array
	{
		numOtherFish--;
		for(int i = index; i < numOtherFish; i++)
		{
			otherFish[i] = otherFish[i+1];
			otherFish[numOtherFish] = null;
		}
	}
	
	private void addOtherFish(OtherFish f)
	{
		otherFish[numOtherFish] = f;
		numOtherFish++;
	}
	
	private void updateOtherFish()		//only contains the eat condition
	{
		for(int i = 0; i < numOtherFish; i++)
		{
			otherFish[i].otherFishMove();
			if(otherFish[i].eatOtherFish(mainFish))
			{
				fishR += 0.5;
				deleteOtherFish(i);
				i--;
			}
		}
	}*/
	
	public static void main(String[] args){
		mainFish = new MainFish();
	}
}
