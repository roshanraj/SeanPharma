package sanepharma;
import javax.swing.*;

import java.awt.Color;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class About 
{
	
	JFrame about;
	JLabel logo,website,mailto;
	JTextArea desc;
	ImageIcon ic;
	
	public About()
	{
		about = new JFrame("About");
		ic = new ImageIcon("images//logo.png");
		logo = new JLabel(ic);
		desc= new JTextArea();
		website = new JLabel("");
		mailto= new JLabel("");
		ImageIcon img = new ImageIcon("images//icon.png");
		about.setIconImage(img.getImage());
		
	}
	public void initAbout()
	{
		
		Container abo=about.getContentPane();
		about.setVisible(true);
		about.setResizable(false);
		about.setLocation(400,170);
		about.setSize(500,300);
		about.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		abo.setBackground(Color.white);
		abo.setLayout(null);
	
		
		
	
		
		
		
		logo.setBounds(-40,0,200,141);
		//logo.setBounds(0,0,200,141);
		abo.add(logo);
		
		

		desc.setBounds(130,10,374,160);
		desc.setBackground(Color.white);
		
	    desc.setText("\n SanePharma Stock Management\n\n Version 1.0 \n\n Work id : SPJULMD007:13003 \n\n (C)Copyright Specta 2010-2013. All rights reserved.");
	    desc.setEditable(false);
		abo.add(desc);
		desc.setFont( new Font("Serif", Font.PLAIN, 14));
		
		
		
		website.setText("<html> Website : <a href=\"\">www.specta.in</a></html>");
		
		
		website.setBounds(290,180,150,20);
		website.setCursor(new Cursor(Cursor.HAND_CURSOR));
		website.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    try {
                            Desktop.getDesktop().browse(new URI("www.specta.in"));
                    } catch (URISyntaxException | IOException ex) {
                            //It looks like there's a problem
                    }
            }
        });
		
		
		mailto.setText("<html> Mail us at : <a href=\"\">feedback@specta.in</a></html>");
		mailto.setBounds(290,210,200,20);
		mailto.setCursor(new Cursor(Cursor.HAND_CURSOR));
		mailto.addMouseListener(new MouseAdapter(){
			
			public void mouseClicked(MouseEvent e)
			{
				try
				{
					
					Desktop.getDesktop().mail(new URI("mailto:feedback@specta.in?subject=Feedback"));
				}
				catch(URISyntaxException | IOException ex)
				{
					/////
					
				}
				
				
			}
			
		});
		
		
		
		abo.revalidate();
		abo.repaint();
		abo.add(website);
		abo.add(mailto);
		
		
		
		
		
        
       
     
		
		
		
		
	}
	public static void main(String [] args)
	{
		
		About abt = new About();
		abt.initAbout();
		
	}
	
}
