package project;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Bullet extends JPanel {
	public int vertical;
	public int horizontal;
	public BufferedImage bullet;
	public Bullet(int horizontal,int vertical)
	{
		this.vertical=vertical;
		this.horizontal=horizontal;
	}
	public void openfire()
	{
				vertical-=10;
	}
	public void downfire()
	{
				vertical+=7;
	}
	public void paintComponent(Graphics g) {
		//g.drawImage(image,100,100,800,800, null);
		try {
			bullet = ImageIO.read(new File("Bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.paintComponent(g);
		g.drawImage(bullet,horizontal,vertical,44,44,null);
	}
	public void setLocation(int horizontal2, int vertical2) {
		this.vertical=vertical2;
		this.horizontal=horizontal2;
		
	}
	public Rectangle collision(int horizontal,int vertical,int size)
	{
		Rectangle r = new Rectangle(horizontal,vertical,size,size);
		return r;
		
	}
}
