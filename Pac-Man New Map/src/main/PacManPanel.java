package main;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;
import object.object;
import player.pacman;
import tile.TileManager;

public class PacManPanel extends JPanel implements Runnable
{
	final int originalTileSize = 12;
	final int scale = 3;
	public final int tileSize = originalTileSize*scale;
	
	public final int maxScreenCol = 21;
	public final int maxScreenRow = 21;
	public final int screenWidth = tileSize * maxScreenCol;
	public final int screenHeight = tileSize * maxScreenRow;
	
	int fps = 60;
	
	Thread pmThread;
	public CollisionDetector cD = new CollisionDetector(this);
	public AssetSetter aS = new AssetSetter(this);
	KeyHandler keyH = new KeyHandler();
	TileManager tileM = new TileManager(this);
	public pacman pm = new pacman(this,keyH);
	public object objects[] = new object[screenWidth * screenHeight];
	public object ghosts[] = new object[4]; 
	
	int playerX = 500;
	int playerY = 500;
	int playerSpeed = 8;
	
	public PacManPanel()
	{
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame()
	{
		aS.setObject();
	}

	public void startThread()
	{
		pmThread = new Thread(this);
		pmThread.start();
	}
	
	public void run() 
	{
		double drawInterval = 1000000000/fps;
		double nextDrawTime = System.nanoTime() + drawInterval;

		
		while(pmThread != null)
		{
			update();
			repaint();
			try
			{
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime /= 1000000;
				
				if(remainingTime < 0)
				{
					remainingTime = 0;
				}
				
				Thread.sleep((long)remainingTime);
				nextDrawTime += drawInterval;
			}
			
			catch(InterruptedException e)
			{
				e.printStackTrace();
			}
			
			}
			
	}
	
	public void update()
	{
		pm.update();
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		Graphics2D g2 = (Graphics2D)g;
		
		tileM.draw(g2);
		
		for(int i = 0; i < objects.length; i++)
		{
			if(objects[i] != null)
			{
				objects[i].draw(g2, this);
			}
		}
		for(int i = 0; i<4; i++) {
			if(ghosts[i] != null)
			{
				ghosts[i].draw(g2, this);
			}
		}
		pm.draw(g2);
		
		g2.dispose();
	}
	
	
}
