package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class MainMenu extends Main  {
	JFrame Menuframe= new JFrame("Main Menu");
	public static int flag44=0;
	public static List<Integer> lines44 = new ArrayList<Integer>();
	public static List<String> lines45 = new ArrayList<String>();
	JTextArea ta;
	JTextArea ta2;
	JTextArea numaralar;
	JTextArea isimler;
	Scanner fileInput;
	JFrame tax=new JFrame("High Scores");
	public MainMenu()
	{
		JButton playbutton = new JButton("Play Game");
	    playbutton.setFont(new Font("Serif",Font.BOLD,20));
	    JButton scoreButton = new JButton("High Scores");
	    scoreButton.setFont(new Font("Serif",Font.BOLD,20));
	    JButton exitButton = new JButton("Exit");
	    exitButton.setFont(new Font("Serif",Font.BOLD,20));
	    Menuframe.setSize(500,400);
	    Menuframe.setLayout(new GridLayout(3,0));
	    Menuframe.add(playbutton);
	    Menuframe.add(scoreButton);
	    Menuframe.add(exitButton);
	    Menuframe.setLocation(550,300);
	    Menuframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    Menuframe.setResizable(false);
	    Menuframe.setVisible(true);
	    File inFile = new File("Scores.txt");
		  try {
			    fileInput = new Scanner(inFile);
			    //Reads file contents
			while (fileInput.hasNext()){
			    lines44.add(fileInput.nextInt()); //Adds the next Double to the ArrayList
			}
			fileInput.close();
			}   
			catch (FileNotFoundException e){
			    System.out.println(e);
			}
		  File file = new File("ScoreNames.txt");
		  BufferedReader reader = null;
		  try {
		      reader = new BufferedReader(new FileReader(file));
		      String text = null;

		      while ((text = reader.readLine()) != null) {
		    	  lines45.add(text);
		      }
		  } catch (FileNotFoundException e) {
		      e.printStackTrace();
		  } catch (IOException e) {
		      e.printStackTrace();
		  } finally {
		      try {
		          if (reader != null) {
		              reader.close(); 
		          }
		      } catch (IOException e) {
		      }
		  }
		  
		  String string =("       Name"+"                 "+"Score"+"\n");
		  String string2="";
		  String string3 ="";
		  String string4="";
		  if(lines45.size()>10) {
			for(int i=0;i<10;i++)
			{
  			string3=string3+lines45.get(i)+"\n";
  			string2=string2+" "+(i+1)+")"+"\n";
  			string4=string4+lines44.get(i)+"\n";
			}
		  }
		  else if(lines44.size()==0)
		  {
			  string2=string2+" "+"1"+")"+"\n";
		  }
		  else
		  {
			  for(int i=0;i<lines44.size();i++)
	  			{
		    			string3=string3+lines45.get(i)+"\n";
		    			string2=string2+" "+(i+1)+")"+"\n";
		    			string4=string4+lines44.get(i)+"\n";
	  			}
		  }
			MyJet.lines46.addAll(lines44);
    		MyJet.lines47.addAll(lines45);
			ta = new JTextArea(string);
			ta2 = new JTextArea(string2);
			numaralar = new JTextArea(string4);
			isimler =new JTextArea(string3);
			isimler.setFont(new Font("Serif", Font.BOLD, 25));
			isimler.setEditable(false);
			numaralar.setFont(new Font("Serif", Font.BOLD, 25));
			numaralar.setEditable(false);
			ta2.setFont(new Font("Serif", Font.BOLD, 25));
		    ta2.setEditable(false);
    		tax.add(ta,BorderLayout.NORTH);
    		tax.add(ta2,BorderLayout.WEST);
   			tax.add(isimler,BorderLayout.CENTER);
   			tax.add(numaralar,BorderLayout.LINE_END);
    		tax.setSize(300,500);
    	    tax.setLocation(400,300);
    	    ta.setFont(new Font("Serif", Font.BOLD, 25));
    	    ta.setEditable(false);
    		string="";
    		string2="";
    		string3="";
    		string4="";
    		lines45.removeAll(lines45);
    		lines44.removeAll(lines44);
	    exitButton.addActionListener(new ActionListener() {

	    	  public void actionPerformed(ActionEvent event) {
	    		  Menuframe.dispose();
	    	  }	
	    	});
	    	scoreButton.addActionListener(new ActionListener() {

		    	  public void actionPerformed(ActionEvent event) {
		    		  tax.setVisible(true);
		    	  }	  
		    	});
	    	while(flag2==0) {
	    playbutton.addActionListener(new ActionListener() {

	    	  public void actionPerformed(ActionEvent event) {
	    		  	Menuframe.dispose();
	    		  	flag2=1;
	    	  }	
	    	});
		}
	}
}
