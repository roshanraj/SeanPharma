package sanepharma;
import javax.swing.*;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;



public class BodyFrame extends JFrame implements ActionListener,MouseListener
{

	JFrame body;
	JMenuBar mb;
	JMenu products,retailer,help;
	JSeparator s1,s2,s3,s4;
	Sales s = new Sales();
	purchaseEntry pe = new purchaseEntry();
	salesReturn sr = new salesReturn();
	outstandings o = new outstandings();
	stock st = new stock();
	ledger l = new ledger();
	backup bck = new backup();
	paymentRecevied pr = new paymentRecevied();
	update u = new update();
	settings set = new settings();
	DateTime dt = new DateTime();
	
	JButton homeicons,homeiconu;
	
    
	
	JMenuItem fmenu1,fmenu2,fmenu3,fmenu4,fmenu5,fmenu6,emenu1,emenu2,emenu3,emenu4,emenu5,hmenu1,hmenu2;
	
	
	JLabel footertext;
	
	
	////////////panels/////////
	JPanel controls;
	JPanel display;
	JPanel footer;
	
	/////////////////////sub-panels///////////////
	JPanel purchaseEntryP,salesP,salesReturnP,outstandingsP,stockP,ledgerP,backupP,paymentReceivedP,updateP,settingsP;
	JPanel home;
	//////////////////////////////////////////////
	
	JTabbedPane tb;
	/////////////////Panel ////////////////
	JPanel panel;
	

	
	/////////////calendar items////////////
	
	 
	
	
	
	/////////////////control options///////////
	JButton purchaseEntry,sales,salesReturn,outstandings,stock,ledger,backup,paymentReceived,update,settings; 
	
	
	//////////////////////Items for display(Home Pane)/////////////////
	JLabel welcomenote;
	JLabel lastupdated;
	JLabel lastbackup;
	JLabel stockworth;
	JLabel pendingworth;
	//JLabel currenttime;
	Font font;
	/////////////////////////////////////////////////////////////////
	
	
	
	
	
	
	public BodyFrame()
	{

		
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    // If Nimbus is not available, you can set the GUI to another look and feel.
		}
		
		body = new JFrame("Sane Pharma Home");
		mb = new JMenuBar();
	    products= new JMenu("Products");
	    retailer= new JMenu("Account Name");
	    help= new JMenu("Help");
	    fmenu1 = new JMenuItem("Add Product");
	    fmenu2 = new JMenuItem("Update/Delete Products");
	    fmenu3 = new JMenuItem("Search Products");
	    fmenu4 = new JMenuItem("Exit");
	    //fmenu5 = new JMenuItem("Exit");
	    emenu1 = new JMenuItem("Add Retailer");
	    emenu2 = new JMenuItem("Add Distributor");
	    emenu3 = new JMenuItem("Add Manufacturer ");
	    emenu4 = new JMenuItem("Search Retailers");
		hmenu1 = new JMenuItem("Bug? Send Report");
		hmenu2 = new JMenuItem("About");
		
		////////////////////////
		font = new Font("Serif", Font.PLAIN, 16);
		
		
		/////////////////item for home//////////////
		welcomenote = new JLabel("Welcome !");
		lastupdated = new JLabel("Last Updated on  :");
		lastbackup = new JLabel("Last backed up on :");
		stockworth = new JLabel("Stock worth :");
		pendingworth = new JLabel("Pending Worth :");
		
		
		/////////////////////////////////////////////
		
		
		homeiconu = new JButton(new ImageIcon("images//homeu.png"));
		homeicons = new JButton(new ImageIcon("images//homes.png"));
		
		
		
		
		///////////////////////////////////////////////
		
		
		
		
		
		
		
		
		s1 = new JSeparator();
 		s2 = new JSeparator();
		s3 = new JSeparator();
		
		
		
		controls = new JPanel();
		display = new JPanel();
		footer = new JPanel();
		
		
		//purchaseEntryP= new JPanel();
		//salesP = new JPanel();
		salesReturnP = new JPanel();
		outstandingsP = new JPanel();
		stockP = new JPanel();
		ledgerP = new JPanel();
		backupP = new JPanel();
		paymentReceivedP= new JPanel();
		updateP= new JPanel();
		settingsP= new JPanel();
		
		home = new JPanel();
		
		footertext = new JLabel("(C)Copyright Specta 2010-2013. All rights reserved.");
		
		purchaseEntry= new JButton("Purchase Entry");
		sales = new JButton("Sales");
		salesReturn = new JButton("Sales Return");
		outstandings = new JButton("Outstandings");
		stock = new JButton("Stock");
		ledger = new JButton("Ledger");
		backup = new JButton("Backup");
		paymentReceived= new JButton("Payment Received");
		update= new JButton("Update");
		settings= new JButton("Settings");
		ImageIcon img = new ImageIcon("images//icon.png");
		body.setIconImage(img.getImage());
		///////////////calendar button/////////
		
		
		
		
		
	}
	
	public void init()
	{
		
		
		Container b=body.getContentPane();
		body.setVisible(true);
		body.setSize(1250,700);
		body.setLocation(50,20);
		body.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b.setBackground(Color.white);
	//	b.setLayout(null);
		
		
		body.setJMenuBar(mb);
		
		mb.add(products);
		products.add(fmenu1);
		products.add(s1);
		products.add(fmenu2);
		products.add(fmenu3);
		products.add(s2);
		products.add(fmenu4);
		
		
		mb.add(retailer);
		retailer.add(emenu1);
		//retailer.add(s3);
		retailer.add(emenu2);
		retailer.add(emenu3);
		retailer.add(emenu4);
		mb.add(help);
		help.add(hmenu1);
		help.add(hmenu2);
		
		
		
		
	
		
		
		
		
		
		
		
		tb = new JTabbedPane();
		
		panel = new JPanel();
		tb.addTab("Home",panel);
		
		
		pe.initpurchaseEntry();
		tb.addTab("Purchase Entry",new ImageIcon("homeu.png"),pe);
		
		
		s.initsales();
		tb.addTab("Sales", s);
		
		
		sr.initsalesReturn();
		tb.addTab("Sales Return", sr);
		
		o.initoutstandings();
		tb.addTab("Outstandings", o);
		
		st.initstock();
		tb.addTab("Stock", st);
		
		l.initledger();
		tb.addTab("Ledger", l);
		
		pr.initpaymentRecevied();
		tb.addTab("Payment Recevied", pr);
		
		bck.initbackup();
		tb.addTab("Backup", bck);
		
		set.initsettings();
		tb.addTab("Settings", set);
		
		
		body.add(tb,BorderLayout.CENTER);
		
		
		
		
		
		b.add(footer,BorderLayout.PAGE_END);
		footer.setPreferredSize(new Dimension(200,30));
		//footer.setBackground(new Color(54,54,54));
		footer.setBackground(new Color(235,235,235));
		
		footer.setLayout(new BorderLayout());
		
		
		
		footer.add(footertext,BorderLayout.LINE_END);
		
		footertext.setPreferredSize(new Dimension(270,20));
		
		
		
		
		
		
		
		
		
		//footer.add(dt.datetimeL,BorderLayout.CENTER);
		
		
		
		
		
		
		//homeiconu.setBounds(10,5,20,20);
		homeiconu.setFocusPainted(false);
        homeiconu.setMargin(new Insets(0, 0, 0, 0));
        homeiconu.setContentAreaFilled(false);
        homeiconu.setBorderPainted(false);
        homeiconu.setOpaque(false);
        homeiconu.setToolTipText("Home");
		footer.add(homeiconu,BorderLayout.LINE_START);
		//homeiconu.setVisible(false);
		
		
		
		
		

		
		
		
		//footertext.setBounds(540,5,270,20);
		////////////////////adding date and time JLabel/////////////////////
		
		
		
		
	
		fmenu1.addActionListener(this);
		fmenu2.addActionListener(this);
		fmenu3.addActionListener(this);
		fmenu4.addActionListener(this);
		fmenu5.addActionListener(this);
		hmenu1.addActionListener(this);
		hmenu2.addActionListener(this);
		
		homeicons.addMouseListener(this);
		homeiconu.addMouseListener(this);
		homeicons.addActionListener(this);
		homeiconu.addActionListener(this);
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	public static void main(String args[])
	{
		BodyFrame bf = new BodyFrame();
		
		
	
		bf.init();
	}
	
		
	public void actionPerformed(ActionEvent a) 
	{
		
		 if(a.getSource()==fmenu1)
		{
			//fmenu1.removeActionListener(this);
			ProductsMenu pm = new ProductsMenu();
			pm.initProductsMenu();
			
		}
		else if(a.getSource()==fmenu4)
		{
			Products prod = new Products();
			prod.initProducts();
			prod.pro.remove(prod.productsP);
			prod.productsF.setTitle("Search Product(s)");
			prod.pro.add(prod.searchP);
			prod.searchP.add(prod.jsp);
			prod.jsp.setBounds(0, 30, prod.productsF.getWidth()+100, prod.productsF.getHeight()-67);
			
		}
		else if(a.getSource()==fmenu2)
		{
			
			Products prod = new Products();
			prod.initProducts();
			prod.viewAll();
			prod.pro.remove(prod.productsP);
			prod.productsF.setTitle("View All Products");
			prod.pro.add(prod.viewP);
			prod.viewP.add(prod.jsp);
			
			prod.jsp.setBounds(0, 0, prod.productsF.getWidth()+100, prod.productsF.getHeight());
				
			
			
			
			
			
		}
		
		
		else if(a.getSource()==fmenu5)
		{
			System.exit(0);
			
		}

		
		else if(a.getSource()==hmenu2)
		{
			About abt = new About();
			abt.initAbout();
			
		}

	
	}

	
	public void mouseClicked(MouseEvent a)
	{
		
		if(a.getSource()==homeiconu)
		{
			homeiconu.setVisible(false);
			homeicons.setVisible(true);
			display.removeAll();
			display.add(home);
			body.setTitle("SanePharma-Home");
			display.repaint();
			display.revalidate();
			
			
		}
		
		
	}

	
	public void mouseEntered(MouseEvent a) 
	{
		if(a.getSource()==homeiconu)
		{
			homeiconu.setBounds(2,2,20,20);
			
		}
		else if(a.getSource()==homeicons)
		{
			
			homeicons.setBounds(2,2,20,20);
			
		}
		
		
	}

	
	public void mouseExited(MouseEvent a) 
	{
		if(a.getSource()==homeiconu)
		{
			homeiconu.setBounds(2,5,20,20);
			
		}
		else if(a.getSource()==homeicons)
		{
			homeicons.setBounds(2,5,20,20);
			
		}

		
		
	}

	
	public void mousePressed(MouseEvent a) 
	{
		// TODO Auto-generated method stub
		
	}

	
	public void mouseReleased(MouseEvent a) 
	{
		// TODO Auto-generated method stub
		
	}

	
	
	
}
