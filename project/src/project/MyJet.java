package project;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class MyJet extends JPanel implements KeyListener{
	static JLabel Jet=new JLabel();
	public BufferedImage image;
	public BufferedImage ourjet;
	public static Player Myplayer;
	public static ArrayList<Bullet> balýt;
	public static ArrayList<RealEnemy> enemy;
	public static ArrayList<Bullet> enemybalýt;
	public static int Health=3;
	public static int Score=0;
	private final static Random generator = new Random();
	private final static Random generator2 = new Random();
	private final static Random generator3 = new Random();
	public static String ScreenName;
	public static String Level="1";
	public static boolean start;
	public static boolean gameover;
	public static int dusmanbalýt=-1;
	public static List<Integer> lines46 = new ArrayList<Integer>();
	public static List<String> lines47 = new ArrayList<String>();
	Timer timer = new Timer();
	Timer timer2=new Timer();
	Timer timer3=new Timer();
	Timer timer4=new Timer();
	public static int counter=0;
	public boolean[]keys=new boolean[65536];
	public MyJet()
	{
		try {
			image = ImageIO.read(new File("night.jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setLayout(new FlowLayout(FlowLayout.LEFT));
		balýt=new ArrayList<>();
		enemy=new ArrayList<>();
		enemybalýt=new ArrayList<>();
		Myplayer=new Player(695,400);
		setSize(800,800);	
		setFocusable(true);
		addKeyListener(this);
		ScreenName=LoginScreen.Screenname;
		timer.schedule(new TimerTask() {
			  public void run() {
				  if(counter==0) {
					  try {
							TimeUnit.SECONDS.sleep(5);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				  }
				 if(counter<28) {
					 try {
							TimeUnit.SECONDS.sleep(1);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
				 }
				  dusman();
				  counter++;
				  if(Health==0)
				  {
					  timer.cancel();
					  counter=0;
				  }
				  if(counter==30)
					{
						timer.cancel();
						try        
						{
						    Thread.sleep(5000);
						} 
						catch(InterruptedException ex) 
						{
						    Thread.currentThread().interrupt();
						}
						Gameplay.frame.setVisible(false);
						Level="2";
						try        
						{
						    Thread.sleep(5000);
						} 
						catch(InterruptedException ex) 
						{
						    Thread.currentThread().interrupt();
						}
						Gameplay.frame.setVisible(true);
						if(Health!=0)
						{
							counter=0;
							timer2.schedule(new TimerTask() {
								  public void run() {
									  if(counter<38) {
											 try {
												 TimeUnit.SECONDS.sleep(1);
												} catch (InterruptedException e) {
													// TODO Auto-generated catch block
													e.printStackTrace();
												}
										 }
									  dusman2();
									  if(Health==0)
									  {
										  timer2.cancel();
										  counter=0;
									  }
									  counter++;
									  if(counter==30)
										{
											timer2.cancel();
											try        
											{
											    Thread.sleep(5000);
											} 
											catch(InterruptedException ex) 
											{
											    Thread.currentThread().interrupt();
											}
											Gameplay.frame.setVisible(false);
											Level="3";
											try        
											{
											    Thread.sleep(5000);
											} 
											catch(InterruptedException ex) 
											{
											    Thread.currentThread().interrupt();
											}
											Gameplay.frame.setVisible(true);
											if(Health!=0) {
												counter=0;
											timer3.schedule(new TimerTask() {
												  public void run() {
													  if(counter<48) {
														  try {
																TimeUnit.MILLISECONDS.sleep(500);
															} catch (InterruptedException e) {
																// TODO Auto-generated catch block
																e.printStackTrace();
															}			
														 }
													  dusman3();
													  if(Health==0)
													  {
														  timer3.cancel();
														  counter=0;
													  }
													  counter++;
													  if(counter==30)
														{
															timer3.cancel();
															try        
															{
															    Thread.sleep(5000);
															} 
															catch(InterruptedException ex) 
															{
															    Thread.currentThread().interrupt();
															}
															Gameplay.frame.setVisible(false);
															try        
															{
															    Thread.sleep(5000);
															} 
															catch(InterruptedException ex) 
															{
															    Thread.currentThread().interrupt();
															}
															Gameplay.frame.setVisible(true);
															if(Health!=0){
															Level="Infýnýte";
															timer4.schedule(new TimerTask() {
																  public void run() {
																	  dusman2();
																	  if(Health==0) {
																		  timer4.cancel();
																		  counter=0;
																	  }
																  }
																},1000,1000);
														}	}
												  }
												},2000,1000);
											}
											
										}
								  }
								},3000,500);
						}
					}
			  }
			},4000,1000);
	}
	public void paintComponent(Graphics g) {
		if(start==true)
		{
		super.paintComponent(g);
		g.drawImage(image,0,0,800,800, null);
		for(int i=0;i<enemy.size();i++)
		{
			if(enemy.get(i).verticalthread>775)
			{
				enemy.remove(i);
			}
			else
			{
				enemy.get(i).paintComponent(g);
			}
		}
		for(int i=0;i<balýt.size();i++)
		{
			//balýt.get(i).paintComponent(g);
			if(balýt.get(i).vertical<0)
			{
				balýt.remove(i);
			}
			else
			{
				balýt.get(i).paintComponent(g);
			}
		}
		for(int i=0;i<enemybalýt.size();i++)
		{
			if(enemybalýt.get(i).vertical>780)
			{
				enemybalýt.remove(i);
			}
			else
			{
				enemybalýt.get(i).paintComponent(g);
			}
		}
		Myplayer.paintComponent(g);
		g.setColor(Color.RED);
		g.setFont(new Font("Serif",Font.BOLD,40));
		g.drawString("Health: "+Health,800,400);
		g.setColor(Color.ORANGE);
		g.setFont(new Font("Serif",Font.BOLD,40));
		g.drawString("Score: "+Score,800,450);
		g.setColor(Color.BLACK);
		g.setFont(new Font("Serif",Font.BOLD,40));
		g.drawString(ScreenName,800,300);
		g.setColor(Color.BLUE);
		g.setFont(new Font("Serif",Font.BOLD,40));
		g.drawString("Level: "+Level,800,350);
		}
		else {
			if(Health==0)
			{
				g.setColor(Color.RED);
				g.setFont(new Font("Serif",Font.BOLD,40));
				g.setColor(Color.RED);
				g.setFont(new Font("Serif",Font.BOLD,100));
				g.drawString("Wasted",275,400);
			}
			else
			{
				g.setColor(Color.DARK_GRAY);
				g.setFont(new Font("Serif",Font.BOLD,50));
				g.drawString("Press Enter to Start",280,400);
			}
		}
	}
	public void keyPressed(KeyEvent event) {
		//String whichKey=KeyEvent.getKeyText(event.getKeyCode());
		/*if(whichKey.compareTo("Left")==0)
		{
			if(Myplayer.horizontal > 0)
			{
				Myplayer.changeLayoutLeft();
				
			}
		}else if(whichKey.compareTo("Right")==0){
			if(Myplayer.horizontal <700)
			{
					Myplayer.changeLayoutRight();
			}
		}else if(whichKey.compareTo("Up")==0){
			if(Myplayer.vertical >0)
			{
				Myplayer.changeLayoutUp();
			}
		}else if(whichKey.compareTo("Down")==0){
			if(Myplayer.vertical <695)
			{
				Myplayer.changeLayoutDown();
			}
				
		}*/ 
		keys[event.getKeyCode()]=true;
	}
	public void fire() {
		MyJet.balýt.add(new Bullet(Myplayer.horizontal+25,Myplayer.vertical));
	}
	public void dusman()
	{
		int a=generator.nextInt(700);
		MyJet.enemy.add(new RealEnemy(a,-100));
		int b=generator2.nextInt(enemy.size());
		dusmanfire(b);
		if(Level.equals("1")){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(enemy.size()!=0) {
			dusmanfire(0);}
		}
	}
	public void dusman2() 
	{
		int a=generator.nextInt(200);
		int c=generator.nextInt(250)+250;
		int d=generator.nextInt(150)+550;
		MyJet.enemy.add(new RealEnemy(a,-100));
		MyJet.enemy.add(new RealEnemy(c,-100));
		MyJet.enemy.add(new RealEnemy(d,-100));
		int b=generator2.nextInt(enemy.size());
		dusmanfire(b);
		if(Level.equals("2")){
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
		}
		if(Level.equals("Infinite")){
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
				dusmanfire(b);}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
				dusmanfire(b);}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
				dusmanfire(b);}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
				dusmanfire(b);}
		}
		}
	public void dusman3() {
		int a=generator.nextInt(200);
		int c=generator.nextInt(250)+250;
		int d=generator.nextInt(150)+550;
		MyJet.enemy.add(new RealEnemy(a,-100));
		MyJet.enemy.add(new RealEnemy(c,-100));
		MyJet.enemy.add(new RealEnemy(d,-100));
		int b=generator2.nextInt(enemy.size());
		dusmanfire(b);
		if(Level.equals("3")){
			 try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
			 try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
			 try {
					TimeUnit.MILLISECONDS.sleep(500);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			if(enemy.size()!=0) {
				b=generator3.nextInt(enemy.size());
			dusmanfire(b);}
			try {
				TimeUnit.MILLISECONDS.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				if(enemy.size()!=0) {
					b=generator3.nextInt(enemy.size());
				dusmanfire(b);}
			}			
		}

	}
	public void dusmanfire(int i) {
		if(enemy.size()!=0) {
			MyJet.enemybalýt.add(new Bullet(enemy.get(i).horizontalthread+18,enemy.get(i).verticalthread+100));}
	}
	void firefire2()
	{
		if(start==true) {
		for(int i=0;i<enemy.size();i++)
		{
			enemy.get(i).run();
			Rectangle r=enemy.get(i).collision(enemy.get(i).horizontalthread,enemy.get(i).verticalthread,50);
			Rectangle pla = new Rectangle(Myplayer.horizontal,Myplayer.vertical,80,80);
			if(pla.intersects(r))
			{
				Health--;
				enemy.get(i).dusmanpatlama=1;
				enemy.get(i).patlama(enemy.get(i).horizontalthread,enemy.get(i).verticalthread);
				enemy.remove(i);
				if(Health==0)
				{	
					start=false;
					gameover();
				}
			}
		}
	}
	}
	void firefire3()
	{
		if(start==true)
		{
		for(int i=0;i<enemybalýt.size();i++)
		{
			enemybalýt.get(i).downfire();
			Rectangle r=enemybalýt.get(i).collision(enemybalýt.get(i).horizontal,enemybalýt.get(i). vertical,30);
			Rectangle pla = new Rectangle(Myplayer.horizontal,Myplayer.vertical,80,80);
			if(pla.intersects(r))
			{
				Health--;
				enemybalýt.remove(i);
				if(Health==0)
				{
					start=false;
					gameover();
				}
			}
		}
		}
	}
	void firefire()
	 {
		if(start==true) {
		for(int i=0;i<balýt.size();i++)
		{
			balýt.get(i).openfire();
			Rectangle r=balýt.get(i).collision(balýt.get(i).horizontal,balýt.get(i).vertical,44);
			for(int j=0;j<enemy.size();j++)
			{
				Rectangle ra=enemy.get(j).collision(enemy.get(j).horizontalthread,enemy.get(j).verticalthread,100);
				if(r.intersects(ra))
				{
					enemy.get(j).dusmanpatlama=1;
					enemy.get(j).patlama(enemy.get(j).horizontalthread,enemy.get(j).verticalthread);
					enemy.remove(j);
					balýt.remove(i);
					if(Level.equals("1")){
					Score+=5;}
					if(Level.equals("2")){
					Score+=10;}
					if(Level.equals("3")){
					Score+=20;}
					if(Level.equals("Infýnýte")){
					Score+=30;}
				}
			}
		}
		}
	 }
	public void gameover()
	{
		lines46.add(Score);
		Collections.sort(lines46,Collections.reverseOrder());
		int j=0;
		for(int i=0;i<lines46.size();i++)
		{
			if(lines46.get(i).equals(Score))
			{
				break;
			}
			j++;
		}
		lines47.add(j,ScreenName);
		try{    
 	        File file =new File("ScoreNames.txt");  
 	        file.delete();
 	        if(!file.exists()){    
 	            file.createNewFile();    
 	        }    
 	        //true = append file    
 	            FileWriter fileWritter = new FileWriter(file,true);        
 	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
 	            for(int i=0;i<lines47.size();i++) {
 	            bufferWritter.write(lines47.get(i));
 	            bufferWritter.newLine();
 	            }
 	            bufferWritter.close();
 	            fileWritter.close();

 	    }catch(Exception e){    
 	        e.printStackTrace();    
 	    } 
		try{    
 	        File file =new File("Scores.txt"); 
 	       file.delete();
 	        if(!file.exists()){    
 	            file.createNewFile();    
 	        }    
 	        //true = append file    
 	           FileWriter fileWritter = new FileWriter(file,true);        
 	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
 	           for(int i=0;i<lines46.size();i++) {
 	        	   	String string=Integer.toString(lines46.get(i));
 	 	            bufferWritter.write(string);
 	 	            bufferWritter.newLine();
 	 	            }
 	            bufferWritter.close();
 	            fileWritter.close(); 
 	    }catch(Exception e){    
 	        e.printStackTrace();    
 	    }
		lines47.removeAll(lines47);
		lines46.removeAll(lines46);
	}
	@Override
	public void keyReleased(KeyEvent event) {
		String whichKey=KeyEvent.getKeyText(event.getKeyCode());
		keys[event.getKeyCode()]=false;
		if(whichKey.compareTo("Space")==0) {
			fire();
	}
		else if (whichKey.compareTo("Enter")==0)
		{
				start=true;
		}
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	public int getHealth()
	{
		return Health;
	}
	public void run() {
    	if(keys[KeyEvent.VK_LEFT])
		{
			if(Myplayer.horizontal > 0)
			{
				Myplayer.changeLayoutLeft();
				
			}
		}else if(keys[KeyEvent.VK_RIGHT]){
			if(Myplayer.horizontal <710)
			{
				Myplayer.changeLayoutRight();
			}
		}else if(keys[KeyEvent.VK_UP]){
			if(Myplayer.vertical >0)
			{
				Myplayer.changeLayoutUp();
			}
		}else if(keys[KeyEvent.VK_DOWN]){
			if(Myplayer.vertical <695)
			{
				Myplayer.changeLayoutDown();
			}
		}

	 	}
}
