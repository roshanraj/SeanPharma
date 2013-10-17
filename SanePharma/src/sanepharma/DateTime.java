package sanepharma;

import java.awt.BorderLayout;
import java.awt.Font;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class DateTime implements Runnable 
{
//jlkj
	JLabel datetimeL;
	static String datetime;
	static String datetimec;
	String format ="hh:mm:ss    |     DD:MM:YYYY";
	
	
	
	public DateTime()
	{
		
		datetimeL = new JLabel(format);
		datetimeL.setFont(new Font("Serif", Font.PLAIN, 12));

	 }
	

	
	
	
	
	public void run()
	{
		try
		{
		
			while(true)
			{	
			Thread.sleep(500);	
			datetime = new SimpleDateFormat(" hh:mm:ss").format(Calendar.getInstance().getTime());
			System.out.println(datetime);
			datetimeL.setText(datetime);
			XtraClass xc = new XtraClass();
			//xc.initx();
			xc.label.setText(datetime);
			xc.frame.validate();
			xc.frame.repaint();
			//JOptionPane.showMessageDialog(null,datetime);
			
				
			//datetimec=change(datetime);
			}
		
		}
		catch(InterruptedException ie)
		{
			
		}
	}
	
	
}
