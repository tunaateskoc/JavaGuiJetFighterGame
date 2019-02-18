package project;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Gameplay  {
	public static int Health=3;
	public static int flag=0;
	public static int framecounter=0;
	public static JFrame frame=new JFrame("Jet Fighter Game");
	 public Gameplay()
	{
		int fps=200;
		double timer=1000000000/fps;
		double delta=0;
		frame.setTitle("Jet Fighter Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1100,830);
		frame.setLocation(400,150);
		frame.setLayout(new GridLayout());
		MyJet jet=new MyJet();
		frame.add(jet);
		frame.setVisible(true);
		frame.setResizable(false);
		int i=0;
		long now=System.nanoTime();
		while(true) {
		delta=delta+(System.nanoTime()-now)/timer;
		if(delta>=1)
		{
		jet.run();
		jet.firefire();
		jet.firefire2();
		jet.firefire3();
		jet.repaint();
		try {
			  // put thread to sleep for 0-499 milliseconds
			  Thread.sleep(10);
		  } // end try
		  catch (InterruptedException ex) {
			  ex.printStackTrace();
		  } // end catch*/
		delta--;
		}
		Health=jet.getHealth();
		if(Health==0)
		{
			Main.flag2=0;
			break;
		}
		now=System.nanoTime();
		}
		try        
		{
		    Thread.sleep(10000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		frame.remove(jet);
		frame.dispose();
	}
}

