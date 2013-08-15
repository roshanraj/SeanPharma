package sanepharma;

import java.awt.*;

import javax.swing.*;

public class settings extends JPanel
{

	
	JPanel navisett;
	
	
	//////////navigationPane Buttons///////////
	JButton chngpwd;
	JButton chngInvoiceFormat;
	//JButton chngPersonaldetails;
	
	
	
	
	
	
	
	//JLabel chngpwd;
	
	
	JPasswordField oldpwd,newpwd,confirmpwd;
	public settings()
	{
	
	//	chngpwd = new JLabel("Change Password");
		oldpwd = new JPasswordField(20);
		newpwd = new JPasswordField(20);
		confirmpwd = new JPasswordField(20);
		navisett = new JPanel();
		chngpwd = new JButton("Change Password");
		chngInvoiceFormat= new JButton("Change Format");
		
	}
	public void initsettings()
	{
		
		
		setBackground(Color.cyan);
	    setLayout(null);
		add(navisett);
	    
		setBounds(0,0,125,600);
		
	
		setBackground(Color.black);
		
		add(chngpwd);
		chngpwd.setBackground(Color.green);
		
		chngpwd.setFont(new Font("Serif", Font.PLAIN, 12));
		add(chngInvoiceFormat);
		chngInvoiceFormat.setFont(new Font("Serif", Font.PLAIN, 12));
		chngInvoiceFormat.setBackground(Color.green);
		
		//settingsP.add(chngpwd);
		//chngpwd.setBounds(10,10,100,30);
		//chngpwd.setFont(new Font("Serif", Font.PLAIN, 12));
		
		
		
		
	}
	
}
