package project;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.JLabel;

public class RealEnemy extends JLabel {
	private final static Random generator = new Random();
	public BufferedImage enemyjet;
	public BufferedImage enemyjetpatlama;
	public static int dusmanpatlama=0;
	public static int dusmanx;
	public static int dusmany;
	int a=generator.nextInt(3);
	int horizontalthread;
	int verticalthread;
	public RealEnemy(int horizontal, int vertical)
	{
			horizontalthread=horizontal;
			verticalthread=vertical;
	}
	public void LocationofThread(int horizontal, int vertical) {
		this.horizontalthread=horizontal;
		this.verticalthread=vertical;
	}
	public void patlama(int horizontal, int vertical) {
		dusmany=horizontal;
		dusmanx=vertical;
	}
	public void paintComponent(Graphics g) {
		try 
		{
			enemyjet = ImageIO.read(new File("fighter-jet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try 
		{
			enemyjetpatlama = ImageIO.read(new File("patlama.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
		g.drawImage(enemyjet,horizontalthread,verticalthread,100,100, null);
		if(dusmanpatlama==1)
		{	
			dusmanpatlama=0;
			g.drawImage(enemyjetpatlama,dusmany,dusmanx,100,100,null);}
		//g.fillOval(horizontal, vertical, width, height);
	}
	public void run()
	 {
			  verticalthread+=5;
			  LocationofThread(horizontalthread,verticalthread);
			  repaint();
	 }
	public Rectangle collision(int horizontal,int vertical,int size)
	{
		Rectangle r = new Rectangle(horizontal,vertical,size,size);
		return r;
		
	}
}
