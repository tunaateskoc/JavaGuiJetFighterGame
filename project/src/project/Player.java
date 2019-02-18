package project;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class Player extends JLabel {
	public int vertical;
	public int horizontal;
	public BufferedImage ourjet;
	public BufferedImage wasted;
	public Player(int vertical,int horizontal)
	{
		try 
		{
			ourjet = ImageIO.read(new File("jetlendin.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try
		{
			wasted = ImageIO.read(new File("patlama.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.vertical=vertical;
		this.horizontal=horizontal;
	}
	public void setHorizontalAndVertical(int horizontal, int vertical) {
		this.horizontal = horizontal;
		this.vertical = vertical;
	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(ourjet,horizontal,vertical,100,100, null);
		if(MyJet.Health==0)
		{
			g.drawImage(wasted,horizontal,vertical,100,100, null);
			MyJet.start=false;
		}
	}
	public void changeLayoutLeft()
	{
		horizontal-=5;
		setHorizontalAndVertical(horizontal,vertical);
		repaint();
		
	}
	public void changeLayoutRight()
	{
		horizontal+=5;
		setHorizontalAndVertical(horizontal,vertical);
		repaint();
	}
	public void changeLayoutUp()
	{
		vertical-=5;
		setHorizontalAndVertical(horizontal,vertical);
		repaint();
	}
	public void changeLayoutDown()
	{
		vertical+=5;
		setHorizontalAndVertical(horizontal,vertical);
		repaint();
	}
}
