package main;

import javax.swing.text.html.parser.Entity;

import player.pacman;

public class CollisionDetector
{
		
	PacManPanel p;
	
	public CollisionDetector(PacManPanel p)
	{
		this.p = p;
	}
	
	public void checkTile(pacman pacman)
	{
		int pLeftX = pacman.x + pacman.solidArea.x;
		int pRightX = pacman.x + pacman.solidArea.x + pacman.solidArea.width;
		int pUpY = pacman.y + pacman.solidArea.y;
		int pDownY = pacman.y + pacman.solidArea.y + pacman.solidArea.height;
		
		int pLeftCol = pLeftX/p.tileSize;
		int pRightCol = pRightX/p.tileSize;
		int pTopRow = pUpY/p.tileSize;
		int pDownRow = pDownY/p.tileSize;
		
		int tileNum1;
		int tileNum2;
		
		switch(pacman.direction)
		{
		case "up":
			pTopRow = (pUpY - pacman.speed)/p.tileSize;
			tileNum1 = p.tileM.mapTileNum[pLeftCol][pTopRow];
			tileNum2 = p.tileM.mapTileNum[pRightCol][pTopRow];
			if(p.tileM.tiles[tileNum1].collision == true || p.tileM.tiles[tileNum2].collision == true)
			{
				pacman.collisionOn = true;
			}
			break;
		case "down":
			pDownRow = (pDownY + pacman.speed)/p.tileSize;
			tileNum1 = p.tileM.mapTileNum[pLeftCol][pDownRow];
			tileNum2 = p.tileM.mapTileNum[pRightCol][pDownRow];
			if(p.tileM.tiles[tileNum1].collision == true || p.tileM.tiles[tileNum2].collision == true)
			{
				pacman.collisionOn = true;
			}
			break;
		case "left":
			pLeftCol = (pLeftX - pacman.speed)/p.tileSize;
			tileNum1 = p.tileM.mapTileNum[pLeftCol][pTopRow];
			tileNum2 = p.tileM.mapTileNum[pLeftCol][pDownRow];
			if(p.tileM.tiles[tileNum1].collision == true || p.tileM.tiles[tileNum2].collision == true)
			{
				pacman.collisionOn = true;
			}
			break;
		case "right":
			pRightCol = (pRightX + pacman.speed)/p.tileSize;
			tileNum1 = p.tileM.mapTileNum[pRightCol][pTopRow];
			tileNum2 = p.tileM.mapTileNum[pRightCol][pDownRow];
			if(p.tileM.tiles[tileNum1].collision == true || p.tileM.tiles[tileNum2].collision == true)
			{
				pacman.collisionOn = true;
			}
			break;
		}
		
		
	}
	
	public int checkObject(pacman pm, boolean player)
	{
		 int index = 999; 
		 
		 for(int i = 0; i < p.objects.length; i ++)
		 {
			 if(p.objects[i] != null)
			 {
				 pm.solidArea.x = pm.x + pm.solidArea.x;
				 pm.solidArea.y = pm.y + pm.solidArea.y;
				 
				 p.objects[i].solidArea.x = p.objects[i].x + p.objects[i].solidArea.x;
				 p.objects[i].solidArea.y = p.objects[i].y + p.objects[i].solidArea.y;
				 
				 switch(pm.direction)
				 {
				 case "up":
					 pm.solidArea.y -= pm.speed;
					 if(pm.solidArea.intersects(p.objects[i].solidArea))
					 {
						 if(p.objects[i].collision == true)
						 {
							 pm.collisionOn = true;
						 }
						 if(player == true)
						 {
							 index = i;
						 }
					 }
					 break;
				 case "down":
					 pm.solidArea.y += pm.speed;
					 if(pm.solidArea.intersects(p.objects[i].solidArea))
					 {
						 if(p.objects[i].collision == true)
						 {
							 pm.collisionOn = true;
						 }
						 if(player == true)
						 {
							 index = i;
						 }
					 }
					 break;
				 case "left":
					 pm.solidArea.x -= pm.speed;
					 if(pm.solidArea.intersects(p.objects[i].solidArea))
					 {
						 if(p.objects[i].collision == true)
						 {
							 pm.collisionOn = true;
						 }
						 if(player == true)
						 {
							 index = i;
						 }
					 }
					 break;
				 case "right":
					 pm.solidArea.x += pm.speed;
					 if(pm.solidArea.intersects(p.objects[i].solidArea))
					 {
						 if(p.objects[i].collision == true)
						 {
							 pm.collisionOn = true;
						 }
						 if(player == true)
						 {
							 index = i;
						 }
					 }
					 break;
				 
				 }

				 pm.solidArea.x = pm.sAx;
				 pm.solidArea.y = pm.sAy;
				 p.objects[i].solidArea.x = p.objects[i].sAx;
				 p.objects[i].solidArea.y = p.objects[i].sAy;
				 
				 
			 }
			 
			 
		 }
		 
		 return index;
	}
}
