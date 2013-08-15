package sanepharma;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.WindowConstants;
import javax.swing.UIManager.LookAndFeelInfo;



public class ProductsMenu extends JFrame implements ActionListener 
{

	JFrame productsF;
	JPanel productsP;
	JPanel viewP;
	JPanel searchP;
	
	
	/////////////////add products panel Jlabels////////////////////////
	
	JLabel productcode,productname,packing,company,priorityorder,
	salestaxas,purchaseas,purchasedisc,boxsize,purchasebonus,
	mfgby,incluse,dealstarts,dealduring,dupto,dthisperiod,
	giftfrom,giftduring,gupto,gthisperiod,salesac,purchaseac;
	
	
	///////////////////////////////////////////////////////////////////
	
	//////////////////////textfields///////////////////////////////////
	JTextField productcodeT,productnameT,packingT,companyT,priorityorderT,
	salestaxasT,purchaseasT,purchasediscT,boxsizeT,purchasebonusT,
	mfgbyT,incluseT,dealstartsT,dealduringT,duptoT,dthisperiodT,
	giftfromT,giftduringT,guptoT,gthisperiodT,salesacT,purchaseacT;
	
	
	
	///////////////////////////////////////////////////////////////////
	
	
	
	JLabel insttext;
	
	
	JTable productsTab;
	String[] dfields;
	JScrollPane jsp;
	JScrollPane jsp2;
	JButton save;
	Container pro;
	
	JTextField searchtext;
	JButton searchB;
	
		
		
		public ProductsMenu()
		{
			
			productsF = new JFrame("Add Product");
			productsP = new JPanel();
			viewP = new JPanel();
			searchP = new JPanel();
			productsTab = new JTable();
			save = new JButton("Save");
			insttext = new JLabel("Fill in the details to save. *Product Code must be unique ");
			searchtext = new JTextField("Enter Product ID or Name to search");
			searchB = new JButton("Search");
			
			
			productcode = new JLabel("Product Code");
			productname = new JLabel("Product Name");
			packing = new JLabel("Packing");
			company = new JLabel("Company");
			priorityorder = new JLabel("Priority Order");
			salestaxas = new JLabel("Sales Tax As");
			purchaseas = new JLabel("Purchase As");
			purchasedisc = new JLabel("Purchase Disc.");
			boxsize = new JLabel("Box/Case Size");
			purchasebonus = new JLabel("Purchase Bonus");
			mfgby = new JLabel("Manufactured By");
			incluse = new JLabel("Inclusive");
			dealstarts = new JLabel("Deal Starts From");
			dealduring = new JLabel("Deal Duting");
			dupto = new JLabel("Upto");
			dthisperiod = new JLabel("This Period");
			giftfrom = new JLabel("Gift From");
			giftduring = new JLabel("Gift During");
			gupto = new JLabel("This Period");
			gthisperiod = new JLabel("Upto");
			salesac = new JLabel("Sale A/C");
			purchaseac= new JLabel("Purchase A/C");
			
		
			
			productcodeT= new JTextField(20);
			productnameT= new JTextField(20);
			packingT= new JTextField(20);
			companyT= new JTextField(20);
			priorityorderT= new JTextField(20);
			salestaxasT= new JTextField(20);
			purchaseasT= new JTextField(20);
			purchasediscT= new JTextField(20);
			boxsizeT= new JTextField(20);
			purchasebonusT= new JTextField(20);
			mfgbyT= new JTextField(20);
			incluseT= new JTextField(20);
			dealstartsT= new JTextField(20);
			dealduringT= new JTextField();
			duptoT= new JTextField();
			dthisperiodT= new JTextField();
			giftfromT= new JTextField();
			giftduringT= new JTextField();
			guptoT= new JTextField();
			gthisperiodT= new JTextField();
			salesacT= new JTextField();
			purchaseacT= new JTextField();
		
			
			
			
			
			
		}
		
		public void initProductsMenu()
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
			
			
			pro= productsF.getContentPane();
			productsF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			//productsF.setResizable(false);
			productsF.setSize(970,500);
			productsF.setLocation(200,100);
			productsF.setLayout(null);
			pro.setBackground(Color.white);
			pro.setLayout(null);
			pro.add(productsP);
			
			productsP.setBounds(0,0,970,500);
			productsP.setLayout(null);
			productsP.setBackground(Color.black);
			
			
			productcode.setBounds(0,10,100,30);
			productcode.setForeground(Color.white);
			productsP.add(productcode);
			
			productcodeT.setBounds(100,15,100,20);
			productsP.add(productcodeT);
			
			productname.setBounds(0,60,100,30);
			productname.setForeground(Color.white);
			productsP.add(productname);
			
			productnameT.setBounds(100,65,100,20);
			productsP.add(productnameT);

			packing.setBounds(0,110,100,30);
			packing.setForeground(Color.white);
			productsP.add(packing);
			
			packingT.setBounds(100,115,100,20);
			productsP.add(packingT);
			
			company.setBounds(0,160,100,30);
			company.setForeground(Color.white);
			productsP.add(company);
			
			companyT.setBounds(100,165,100,20);
			productsP.add(companyT);
			
			priorityorder.setBounds(0,210,100,30);
			priorityorder.setForeground(Color.white);
			productsP.add(priorityorder);
			
			priorityorderT.setBounds(100,215,100,20);
			productsP.add(priorityorderT);
			
			salestaxas.setBounds(250,10,100,30);
			salestaxas.setForeground(Color.white);
			productsP.add(salestaxas);
	
			salestaxasT.setBounds(350,15,100,20);
			productsP.add(salestaxasT);
	
			purchaseas.setBounds(500,10,100,30);
			purchaseas.setForeground(Color.white);
			productsP.add(purchaseas);
			
			purchaseasT.setBounds(600,15,100,20);
			productsP.add(purchaseasT);
			
			purchasedisc.setBounds(250,60,100,30);
			purchasedisc.setForeground(Color.white);
			productsP.add(purchasedisc);
			
			purchasediscT.setBounds(350,65,100,20);
			productsP.add(purchasediscT);
			
			boxsize.setBounds(250,110,100,30);
			boxsize.setForeground(Color.white);
			productsP.add(boxsize);
			
			boxsizeT.setBounds(350,110,100,20);
			productsP.add(boxsizeT);
			
			
			save.setBounds(794,430,160,29);
			save.setBackground(Color.YELLOW);
			
			productsP.add(save);
			insttext.setBounds(5,440,400,25);
			insttext.setForeground(Color.white);
			productsP.add(insttext);
			
			
			productsF.setVisible(true);
			
			
			
			
			save.addActionListener(this);
			
		}
		
		
		public  void saveValues()
		{
		
			try 
			{

		       Class.forName("com.mysql.jdbc.Driver").newInstance();
		       java.sql.Connection  db = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanepharma","root","");
		        java.sql.Statement stmt = db.createStatement();
		             java.sql.ResultSet rst=null;
		             
		             System.out.println("Connected");
		             try
		             {
		            	 
		           
		            	
		            		
		        stmt.execute(" insert into products (ProductCode,ProductName,Packing,Company,PriorityOrder,SalesTax,Purchase,PurchaseDisc,BoxSize)"
		                         + " values " +
		            "('"+productcodeT.getText()+"','"+productnameT.getText()+"','"+packingT.getText()+"','"+companyT.getText()+"','"+priorityorderT.getText()+"','"+salestaxasT.getText()+"','"+purchaseasT.getText()+"','"+purchasediscT.getText()+"','"+boxsizeT.getText()+"')");
		            	
		             
		    	     JOptionPane.showMessageDialog(null, "Entries saved sucessfully !");
		    	     
		             }
		             catch(Exception w)
		             {
		            	 w.printStackTrace();
		            	 
		             }
		            
		             
		             db.close();
			} 
		catch (Exception ew)
		        {
				     JOptionPane.showMessageDialog(null, "Wrong Entries");
				     ew.printStackTrace();
		        }   

			

		}  


		
		
		
		
		
		public static void main(String [] args)
		{
			
			ProductsMenu pm = new ProductsMenu();
			pm.initProductsMenu();
			
			
		}

		
		public void actionPerformed(ActionEvent a) 
		{
			if(a.getSource()==save)
			{
				
				saveValues();
			}
			
			
		}
		
		
		
	
}

	

