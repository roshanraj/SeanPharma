package sanepharma;

import java.awt.Color;

import javax.swing.*;

import com.toedter.calendar.JDateChooser;

	
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


	public class purchaseEntry extends JPanel 
{
		JTextField tf,tf2;
		JLabel label1,label2;
		JLabel dateL,productNameL,productCodeL,quantityL,productTypeL;
		
		JButton bu;
		
		public purchaseEntry ()
		{
			
			dateL = new JLabel("Date");
			productNameL = new JLabel("Product Name");
			productCodeL = new JLabel("Product Code");
			quantityL = new JLabel("Quantity");
			productTypeL = new JLabel("Product Type");
			
			
		}
		public void initpurchaseEntry ()
		{
			
			JDateChooser dateChooser = new JDateChooser();
		    
		    add(dateChooser);
		    dateChooser.setBounds(0,0, 100, 20);
		    
		    setBackground(Color.RED);
		    setLayout(new GridLayout(3,3));
			
			
			tf = new JTextField();
			tf2 = new JTextField();
			
			label1 = new JLabel ("dsad");
			label2 = new JLabel ("dsadsad");
			
			bu = new JButton ("post");
			
			add(label1);
			add(tf);
			
			add(label2);
			add(tf2);
			
			
			
			bu.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent arg0) 
				{
					tf.setText(tf2.getText());
					
				}
			});
			
			add(bu);
			
			
			
		

		    
		    
		    
			
			
		}
		
		
		
		
		
		
		
				

}

















