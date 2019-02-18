package project;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
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

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
public class LoginScreen extends Main{
	public static String Namestring;
	public static String password;
	public static char[] Passwordstring;
	public static String Screenname;
	public static int flag3=0;
	public static int flag5=0;
	public static int flag6=0;
	ArrayList<String> lines = new ArrayList<String>();
	ArrayList<String> lines2 = new ArrayList<String>();
	ArrayList<String> lines3 = new ArrayList<String>();
	JFrame frame = new JFrame("Login");
	final JDialog dialog = new JDialog();
	final JDialog dialog2=new JDialog();
	public LoginScreen()
	{
		frame.setLayout(new FlowLayout(FlowLayout.CENTER));
	    JLabel nob = new JLabel("Name:  ");
	    JLabel aut = new JLabel("Password: ");
	    JTextField Name = new JTextField(20);
	    JPasswordField Password=new JPasswordField(20);
	    Name.setFont(new Font("Serif",Font.PLAIN,20));
	    Password.setFont(new Font("Serif",Font.PLAIN,20));
	    nob.setFont(new Font("Serif",Font.BOLD,30));
	    aut.setFont(new Font("Serif",Font.BOLD,30));
	    JButton button = new JButton("Login");
	    button.setFont(new Font("Serif",Font.BOLD,20));
	    JButton button2 = new JButton("Signup");
	    button2.setFont(new Font("Serif",Font.BOLD,20));
	    frame.add(nob);
	    frame.add(Name);
	    frame.add(aut);
	    frame.add(Password);
	    frame.add(button);
	    frame.add(button2);
	    frame.setSize(500,200);
	    frame.setLocation(400,400);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setResizable(false);
	    frame.setVisible(true);
	    button2.addActionListener(new ActionListener() {

	    	  public void actionPerformed(ActionEvent event) {
	    		  	JFrame framex=new JFrame("Create Player");
	    		  	JLabel nam = new JLabel("Enter Name");
	    		    JLabel pas = new JLabel("Enter Password");
	    		    JLabel id = new JLabel("Enter Screen Name");
	    		    JTextField namx = new JTextField(30);
	    			JTextField  pasx= new JTextField(30);
	    			JTextField  idx= new JTextField(30);
	    		    framex.setLayout(new FlowLayout(FlowLayout.LEFT));
	    		    nam.setFont(new Font("Serif",Font.BOLD,30));
	    		    pas.setFont(new Font("Serif",Font.BOLD,30));
	    		    id.setFont(new Font("Serif",Font.BOLD,30));
	    		    framex.add(nam);
	    		    framex.add(namx);
	    		    framex.add(pas);
	    		    framex.add(pasx);
	    		    framex.add(id);
	    		    framex.add(idx);
	    		  	JButton button3 = new JButton("Save");
	    		    framex.setSize(400,300);
	    		    framex.setLocation(400,400);
	    			framex.add(button3,BorderLayout.SOUTH);
	    			framex.setResizable(false);
	    			framex.setVisible(true);
	    			button3.addActionListener(new ActionListener() {
	    		    	  public void actionPerformed(ActionEvent event) {
	    		      Namestring=namx.getText();
	    	  		  password=pasx.getText();
	    	  		  Screenname=idx.getText();
	    	  		  flag5=1;
	    	  		  flag3=1;
	    	  		  flag=1;
	    	 		  framex.dispose();
	    	 		  frame.dispose();
	    	 		 dialog2.setAlwaysOnTop(true);
	    	 		  JOptionPane.showMessageDialog(dialog2,"You have signed up successfully","Welcome "+Screenname,JOptionPane.INFORMATION_MESSAGE);
	    	 		  dialog2.setAlwaysOnTop(true);
	    	 		try{    
	    	 	        File file =new File("Players.txt");     
	    	 	        if(!file.exists()){    
	    	 	            file.createNewFile();    
	    	 	        }    
	    	 	        //true = append file    
	    	 	            FileWriter fileWritter = new FileWriter(file,true);        
	    	 	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    	 	            bufferWritter.newLine();
	    	 	            bufferWritter.write(Namestring);
	    	 	            bufferWritter.close();
	    	 	            fileWritter.close();  

	    	 	    }catch(Exception e){    
	    	 	        e.printStackTrace();    
	    	 	    } 
	    	 		try{    
	    	 	        File file =new File("Passwords.txt");     
	    	 	        if(!file.exists()){    
	    	 	            file.createNewFile();    
	    	 	        }    
	    	 	        //true = append file    
	    	 	            FileWriter fileWritter = new FileWriter(file,true);        
	    	 	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    	 	            bufferWritter.newLine();
	    	 	            bufferWritter.write(password);
	    	 	            bufferWritter.close();
	    	 	            fileWritter.close();  

	    	 	    }catch(Exception e){    
	    	 	        e.printStackTrace();    
	    	 	    } 
	    	 		try{    
	    	 	        File file =new File("ScreenNames.txt");     
	    	 	        if(!file.exists()){    
	    	 	            file.createNewFile();    
	    	 	        }    
	    	 	        //true = append file    
	    	 	            FileWriter fileWritter = new FileWriter(file,true);        
	    	 	            BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
	    	 	            bufferWritter.newLine();
	    	 	            bufferWritter.write(Screenname);
	    	 	            bufferWritter.close();
	    	 	            fileWritter.close();  

	    	 	    }catch(Exception e){    
	    	 	        e.printStackTrace();    
	    	 	    }    
	    		    }
	    	 	});
	    	  }
	});
	    while(flag==0) {
	    button.addActionListener(new ActionListener() {

	    	  public void actionPerformed(ActionEvent event) {
	    		  while(flag5==0)
	    		  {
	    		  Namestring=Name.getText();
	    		  Passwordstring=Password.getPassword();
	    		  password = String.copyValueOf(Passwordstring);
	    		  File file = new File("Players.txt");
	    		  BufferedReader reader = null;
	    		  try {
	    		      reader = new BufferedReader(new FileReader(file));
	    		      String text = null;

	    		      while ((text = reader.readLine()) != null) {
	    		    	  lines.add(text);
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
	    		  File file2 = new File("Passwords.txt");
	    		  BufferedReader reader2 = null;
	    		  try {
	    		      reader2 = new BufferedReader(new FileReader(file2));
	    		      String text2 = null;

	    		      while ((text2 = reader2.readLine()) != null) {
	    		    	  lines2.add(text2);
	    		      }
	    		  } catch (FileNotFoundException e) {
	    		      e.printStackTrace();
	    		  } catch (IOException e) {
	    		      e.printStackTrace();
	    		  } finally {
	    		      try {
	    		          if (reader2 != null) {
	    		              reader2.close();
	    		          }
	    		      } catch (IOException e) {
	    		      }
	    		  }
	    		  File file3 = new File("ScreenNames.txt");
	    		  BufferedReader reader3 = null;
	    		  try {
	    		      reader3 = new BufferedReader(new FileReader(file3));
	    		      String text3 = null;

	    		      while ((text3 = reader3.readLine()) != null) {
	    		    	  lines3.add(text3);
	    		      }
	    		  } catch (FileNotFoundException e) {
	    		      e.printStackTrace();
	    		  } catch (IOException e) {
	    		      e.printStackTrace();
	    		  } finally {
	    		      try {
	    		          if (reader3 != null) {
	    		              reader3.close();
	    		              flag5=1;
	    		              frame.setVisible(false);
	    		          }
	    		      } catch (IOException e) {
	    		      }
	    		  }
	    		  }
	    		  for(int i=0;i<lines.size();i++)
	    			{
	    				if(lines.get(i).equals(Namestring))
	    				{
	    					if(lines2.get(i).equals(password))
	    					{
	    						flag3=1;
	    						flag=1;
	    						Screenname=lines3.get(i);
	    						i=lines.size();
	    						frame.dispose();
	    					}
	    			   	}
	   
	    			}
	    		  	if(flag==0)
	    		  	{
	    		  		flag=-1;
	    		  		frame.dispose();
	    		  	}
	    	  }
    	});
	    }
	    
	}
	}

