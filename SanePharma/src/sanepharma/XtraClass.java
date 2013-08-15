package sanepharma;

import java.awt.Container;

import javax.swing.*;

public class XtraClass 
{
	
	JFrame frame;
	JLabel label;
	Container c;
	public XtraClass()
	{
		
		frame = new JFrame("trying");
		label = new JLabel("started");
		
		
	}
	
	public void initx()
	{
		 c = frame.getContentPane();
		frame.setSize(500,500);
		frame.setLocation(300,200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		c.setLayout(null);
		label.setBounds(0,0,100,20);
		c.add(label);
		
		
		
	}

	public static void main(String args[])
	{
		
		XtraClass xc = new XtraClass();
		xc.initx();
		
		Thread t1 = new Thread(new DateTime());
		t1.start();
	}


}
