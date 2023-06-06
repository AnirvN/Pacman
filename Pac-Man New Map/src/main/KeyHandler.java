package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener
{
	public boolean wPressed;
	public boolean aPressed;
	public boolean sPressed;
	public boolean dPressed;


	@Override
	public void keyTyped(KeyEvent e)
	{
		
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		int code = e.getKeyCode();
		
		if (code == KeyEvent.VK_W)
		{
		
			aPressed = false;
			sPressed = false;
			dPressed = false;
			wPressed = true;
		}
		
		if (code == KeyEvent.VK_A)
		{
			wPressed = false;
			sPressed = false;
			dPressed = false;
			aPressed = true;
		}
		
		if (code == KeyEvent.VK_S)
		{
			wPressed = false;
			aPressed = false;
			dPressed = false;
			sPressed = true;}
		
		if (code == KeyEvent.VK_D)
		{
			wPressed = false;
			aPressed = false;
			sPressed = false;
			dPressed = true;
		}
		
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	
		
	}

}
