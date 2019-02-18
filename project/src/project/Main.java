package project;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class Main {
	/*public static String Namestring;
	public static char[] Passwordstring;
	public static String id;*/
	public static int flag=0;
	public static int flag2=0;
	static LoginScreen Login;
	final static JDialog dialog = new JDialog();
	public static void main(String[] args) {
		Login=new LoginScreen();
		String xyz="Name or Password is wrong";
		if(flag==-1)
		{
		JOptionPane.showMessageDialog(dialog,xyz,"ERROR",JOptionPane.ERROR_MESSAGE);
		System.exit(0);
		}
		if(flag==1)
		{
			MainMenu newmenu=new MainMenu();
			while(flag2==1)
			{
				Gameplay Game=new Gameplay();
				if(flag2==0)
				{
					MainMenu newmenu2=new MainMenu();
					if(flag2==1)
					{
						MyJet.start=false;
						MyJet.Health=3;
						MyJet.gameover=false;
						MyJet.Score=0;
						MyJet.Level="1";
					}
				}
			}
		}
		
	}
}