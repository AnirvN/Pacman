package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.PacManPanel;

public class object
{
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int x;
	public int y;
	
	public Rectangle solidArea = new Rectangle(0,0, 48, 48);
	public int sAx = 0;
	public int sAy = 0;
	
	public void draw(Graphics2D g2, PacManPanel p)
	{
		g2.drawImage(image, x, y, p.tileSize, p.tileSize, null);
	}
	
	
	
}
