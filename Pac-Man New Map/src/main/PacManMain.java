package main;

import javax.swing.JFrame;

public class PacManMain 
{

	public static void main(String[] args)
	{
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setTitle("Pac-Man");
		
		PacManPanel pmPanel =  new PacManPanel();
		frame.add(pmPanel);

		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
		pmPanel.setupGame();
		pmPanel.startThread();
	}

}
