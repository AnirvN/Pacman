package main;

import java.awt.Point;
import object.point;
import tile.TileManager;

public class AssetSetter
{
	PacManPanel p;
	TileManager t;
	public AssetSetter(PacManPanel p)
	{
		this.p = p;
		this.t = new TileManager(p);
	}
	
	public void setObject()
	{
		
		/*p.objects[0] = new point();
		p.objects[0].x = 1*p.tileSize;
		p.objects[0].y = 5*p.tileSize;
		
		p.objects[1] = new point();
		p.objects[1].x = 17*p.tileSize;
		p.objects[1].y = 12*p.tileSize;
		
		p.objects[2] = new point();
		p.objects[2].x = 3*p.tileSize;
		p.objects[2].y = 5*p.tileSize;
		
		p.objects[3] = new point();
		p.objects[3].x = 20*p.tileSize;
		p.objects[3].y = 10*p.tileSize;*/
		
		
		int k = 0;
		for (int i = 0; i < p.maxScreenCol; i++)
		{
			for (int j = 0; j <p.maxScreenRow; j++)
			{
				if(t.mapTileNum[i][j] == 1) {
					p.objects[k] = new point();
					p.objects[k].x = (i*p.tileSize);
					p.objects[k].y = (j*p.tileSize);
					k++;
				}
			}			
		}
		//p.ghosts[0] = new ghost("red");
//		//p.ghosts[0].x = 9*p.tileSize;
//		//p.ghosts[0].y = 9*p.tileSize;
//		//p.ghosts[1] = new ghost("green");
//		//p.ghosts[1].x = 10*p.tileSize;
//		//p.ghosts[1].y = 8*p.tileSize;
//		p.ghosts[2] = new ghost("blue");
//		p.ghosts[2].x = 10*p.tileSize;
//		p.ghosts[2].y = 9*p.tileSize;
//		p.ghosts[3] = new ghost("orange");
//		p.ghosts[3].x = 11*p.tileSize;
//		p.ghosts[3].y = 9*p.tileSize;
//		
		
		
	}
	
}
