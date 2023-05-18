package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import main.KeyHandler;
import main.PacManPanel;

public class pacman extends entity
{
		PacManPanel p;
		KeyHandler h;
		
		public pacman(PacManPanel p, KeyHandler h)
		{
			this.p = p;
			this.h = h;
			
			solidArea = new Rectangle(0, 0, p.tileSize-5, p.tileSize-5);
			sAx = solidArea.x;
			sAy = solidArea.y;
			setDefaultValues();
			getPlayerImage();
			
			
		}
		
		public void setDefaultValues()
		{
			x = p.tileSize;
			y = p.tileSize;
			speed = 5;
			direction = "left";
		}
		
		public void getPlayerImage()
		{
			try
			{
				up1 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Up1.png"));
				up2 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Up2.png"));
				up3 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Up3.png"));
				down1 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Down1.png"));
				down2 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Down2.png"));
				down3 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Down3.png"));
				left1 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Left1.png"));
				left2 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Left2.png"));
				left3 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Left3.png"));
				right1 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Right1.png"));
				right2 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Right2.png"));
				right3 = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Right3.png"));
				still = ImageIO.read(getClass().getResourceAsStream("/player/PacMan-Static.png"));
				
			}
			
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
		private Object getResourceAsStream(String string) {
			// TODO Auto-generated method stub
			return null;
		}

		public void update()
		{
			
			if(h.wPressed == true || h.aPressed == true || h.sPressed == true || h.dPressed == true)
			{
				if(h.wPressed == true)
				{
					direction = "up";
				}
				
				else if(h.aPressed == true)
				{
					direction = "left";
				}
				else if(h.sPressed == true)
				{
					direction = "down";
				}
				else if(h.dPressed == true)
				{
					direction = "right";
				}
				
				collisionOn = false;
				p.cD.checkTile(this);
				int objIndex = p.cD.checkObject(this, true);
				pickUpObject(objIndex);
				
				
				
				if(collisionOn == false)
				{
					switch(direction)
					{
					case "up":
						y -= speed;
						break;
					case "down":
						y += speed;
						break;
					case "left":
						x -= speed;
						break;
					case "right":
						x += speed;
						break;
						
					}
				}
				
				spriteCounter++;
				if(spriteCounter > 6)
				{
					if(spriteNum == 1)
					{
						spriteNum = 2;
					}
					else if(spriteNum == 2)
					{
						spriteNum = 3;
					}
					else if(spriteNum == 3)
					{
						spriteNum = 4;
					}
					else if(spriteNum == 4)
					{
						spriteNum = 1;
					}
					spriteCounter = 0;
				}
			}
			
			
		}
		
		public void pickUpObject(int i)
		{
			if(i != 999)
			{
				p.objects[i] = null;
			}
		}
		
		public void draw(Graphics2D g2)
		{		
			BufferedImage image = null;
			switch(direction)
			{
			case "up":
				if(spriteNum == 1)
				{
					image = still;
				}
				if(spriteNum == 2)
				{
					image = up1;
				}
				if(spriteNum == 3)
				{
					image = up2;
				}
				if(spriteNum == 4)
				{
					image = up3;
				}
				
				break;
			case "down":
				if(spriteNum == 1)
				{
					image = still;
				}
				if(spriteNum == 2)
				{
					image = down1;
				}
				if(spriteNum == 3)
				{
					image = down2;
				}
				if(spriteNum == 4)
				{
					image = down3;
				}
				
				break;
			case "right":
				if(spriteNum == 1)
				{
					image = still;
				}
				if(spriteNum == 2)
				{
					image = right1;
				}
				if(spriteNum == 3)
				{
					image = right2;
				}
				if(spriteNum == 4)
				{
					image = right3;
				}
				
				break;
			case "left":
				if(spriteNum == 1)
				{
					image = still;
				}
				if(spriteNum == 2)
				{
					image = left1;
				}
				if(spriteNum == 3)
				{
					image = left2;
				}
				if(spriteNum == 4)
				{
					image = left3;
				}
				
				break;
			}
			
			g2.drawImage(image,x,y, p.tileSize, p.tileSize, null);
			
		}
}
	