/**
 * 
 */
package sanepharma;

/**
 * @author Vishal
 *
 */

import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener 
{

	JFrame login;
	JLabel welcome,usertext,passtext;
	JTextField username;
	JButton submit;
	JPasswordField password;
	JComboBox usercomb;
	String[] userOptions = {"Administrator","Operator"};
	String pass ="";
	String opass = "admin";
	//Create the combo box, select item at index 4.
	//Indices start at 0, so 4 specifies the pig.
	
	
	public Login()
	{
		
		login = new JFrame("Sane Pharma");
		username = new JTextField(20);
		password = new JPasswordField("");
		usercomb = new JComboBox(userOptions);
		welcome = new JLabel("Welcome !");
		submit = new JButton("Go");
		usertext= new JLabel("User");
		passtext = new JLabel("Password");
		
		
		
	}
	public void init()
	{
		
	
		try 
		{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
		catch (ClassNotFoundException ex) 
		{
        }
		catch (InstantiationException ex) 
		{
        }
		catch (IllegalAccessException ex) 
		{
        }
		catch (UnsupportedLookAndFeelException ex) 
		{
        }
		Container c= login.getContentPane();
		login.setSize(600,400);
		login.setLocation(300,200);
		//login.setUndecorated(true);
		login.setVisible(true);
	    login.setLayout(null); 
	    login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    login.setResizable(false);
	    c.setBackground(Color.white);
	    //c.add(username);
	    //username.setBounds(100,100,100,30);
	    c.add(usertext);
	    usertext.setBounds(220,120,100,30);
	    
	    c.add(usercomb);
	    usercomb.setBounds(220,150,150,30);
	    usercomb.setBackground(Color.white);
	    usercomb.setForeground(Color.black);
	    
	    if(usercomb.getSelectedIndex()==0)
	    {
	    	usercomb.setToolTipText("Login as Administrator");
	    	login.revalidate();
	    }
	    if(usercomb.getSelectedIndex()==1)
	    {
	    	usercomb.setToolTipText("Login as Operator");
	    	login.revalidate();
	    }
	    
	    c.add(passtext);
	    passtext.setBounds(220,180,100,30);
	    
	    c.add(password);
	    password.setBounds(220,210,150,30);
	    password.setToolTipText("Enter Password");
	    
	    c.add(welcome);
	    welcome.setBounds(10,10,500,50);
	    welcome.setFont(new Font("Serif", Font.PLAIN, 32));
	    c.add(submit);
	    
	    submit.setBounds(320,250,50,30);		
		submit.setBackground(Color.white);
		submit.setToolTipText("Login");
		
		
		submit.addActionListener(this);
		
		
		pass = password.getText();
		
		
	}
	
	
	
	
	public static void main(String args[])
	{
		Login log = new Login();
		log.init();
	}	
	
	
	
	
	
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==submit)
		{
			System.out.println("Here");
			
			if(usercomb.getSelectedItem()=="Administrator"  )//&& password.getText()=="admin")
			{
				System.out.println("Here too");
				System.out.println(password.getText());
				login.setVisible(false);
				BodyFrame bf = new BodyFrame();
				bf.init();
				
			}
			
			
		}
		
	}
	
	
	
	
	


		
	}
