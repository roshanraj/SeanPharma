package sanepharma;

import javax.swing.*;
import java.awt.*;

public class BugReport 
{

	JFrame bugs;
	//JTextArea
	
	
	
	public BugReport()
	{
	bugs = new JFrame("Sorry for the Bugs !");
	
		
		
	}
	
	public void initBugReport()
	{
	Container bugc = bugs.getContentPane();
	bugs.setSize(500,400);
	bugs.setLocation(300,200);
	bugs.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	bugs.setVisible(true);
	
	
	
		
		
	}
	
	public static void main(String args[])
	{
		
		
		
	}
	
	
	
}
