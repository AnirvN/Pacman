package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.PacManPanel;

public class TileManager
{
	PacManPanel p;
	public tile[] tiles;
	public int mapTileNum[][];
	
	public TileManager(PacManPanel p)
	{
		this.p = p;
		tiles = new tile[10];
		mapTileNum = new int[p.maxScreenCol][p.maxScreenRow];
		
		getTileImage();
		loadMap("/map/MapArray.txt");
	}
	
	public void getTileImage()
	{
		try
		{
			tiles[0] = new tile();
			tiles[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tempwall (2).png"));
			tiles[0].collision = true;
			
			tiles[1] = new tile();
			tiles[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/blank - Copy.png"));
			

		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void loadMap(String filePath)
	{
		try
		{
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			
			int col = 0;
			int row = 0;
			
			while(col < p.maxScreenCol && row < p.maxScreenRow)
			{
				String line = br.readLine();
				while(col < p.maxScreenCol)
				{
					String numbers[] = line.split(" ");
					
					int num = Integer.parseInt(numbers[col]);
					
					mapTileNum[col][row] = num;
					col++;
				}
				
				if(col == p.maxScreenCol)
				{
					col = 0;
					row++;
				}
			}
			br.close();
		}
		
		catch(Exception e)
		{
			
		}
	}
	
	public void draw(Graphics2D g2)
	{
		int col = 0;
		int row = 0;
		int x = 0;
		int y = 0;
		
		while(col < p.maxScreenCol && row < p.maxScreenRow)
		{
			int tileNum = mapTileNum[col][row];
			
			g2.drawImage(tiles[tileNum].image, x, y, p.tileSize, p.tileSize, null);
			col++;
			x += p.tileSize;
			
			if(col == p.maxScreenCol)
			{
				col = 0;
				x = 0;
				row++;
				y += p.tileSize;
			}
		}
	}

}
