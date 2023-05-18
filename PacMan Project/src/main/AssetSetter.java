package main;

import java.awt.Point;

import object.point;

public class AssetSetter
{
	PacManPanel p;
	
	public AssetSetter(PacManPanel p)
	{
		this.p = p;
	}
	
	public void setObject()
	{
		p.objects[0] = new point();
		p.objects[0].x = 1*p.tileSize;
		p.objects[0].y = 5*p.tileSize;
		
		p.objects[1] = new point();
		p.objects[1].x = 17*p.tileSize;
		p.objects[1].y = 12*p.tileSize;
		
		
	}
	
}
