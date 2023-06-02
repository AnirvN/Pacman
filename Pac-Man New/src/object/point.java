package object;

import java.io.IOException;

import javax.imageio.ImageIO;

public class point extends object 
{
	public point()
	{
		name = "point";
		
		try
		{
			image = ImageIO.read(getClass().getResourceAsStream("/objects/EnergyPoin.png"));
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}
