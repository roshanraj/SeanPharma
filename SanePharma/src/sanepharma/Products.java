package sanepharma;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.*;
import java.sql.DriverManager;
import java.util.ArrayList;


public class Products extends JFrame implements ActionListener
{
	JFrame productsF;
	
	JPanel productsP;
	JPanel viewP;
	JPanel searchP;
	
	JLabel insttext;
	
	
	JTable productsTab;
	String[] dfields;
	JScrollPane jsp;
	JScrollPane jsp2;
	JButton save;
	Container pro;
	
	JTextField searchtext;
	JButton searchB;
	
	ArrayList<String> numdata = new ArrayList<String>();
	DefaultTableModel model = new DefaultTableModel()
	{
		@Override
		public boolean isCellEditable(int row, int column)
		{
		 
				return true;
		}	
		
	//	public Component prepareRenderer(TableCellRenderer r, int row, int col)
		{
			//Component c = super.prepareRenderer(r,row,col);
			
			
		}
	};	
	
	
	public Products()
	{
		
		productsF = new JFrame();
		productsP = new JPanel();
		viewP = new JPanel();
		searchP = new JPanel();
		productsTab = new JTable();
		save = new JButton("Save");
		insttext = new JLabel("Fill in the details to save. *Product ID must be unique ");
		searchtext = new JTextField("Enter Product ID or Name to search");
		searchB = new JButton("Search");
		
	}
	
	
	
	public void initProducts()
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
		
		
		pro= productsF.getContentPane();
		productsF.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		//productsF.setResizable(false);
		productsF.setSize(970,290);
		productsF.setLocation(200,200);
		productsF.setLayout(null);
		pro.setBackground(Color.white);
		pro.setLayout(null);
		pro.add(productsP);
		
		productsP.setBounds(0,0,970,290);
		productsP.setLayout(null);
		productsP.setBackground(Color.white);
		//productsP.add(productsTab);
		
		dfields = new String[] {"Product Code","Product Name","Maximum Retail Price (Rs)","Cost" };
		
		model.setColumnIdentifiers(dfields);
		
		model.setNumRows(8);
		
		
		productsTab= new JTable(model);
		
		productsTab.setGridColor(Color.LIGHT_GRAY);
		productsTab.setPreferredScrollableViewportSize(new Dimension(900,300));
		productsTab.getTableHeader().setReorderingAllowed(false);
		
		
		productsTab.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		jsp = new JScrollPane(productsTab);		
		jsp.setBounds(0, 0, productsF.getWidth()+100, productsF.getHeight()-67);
		
		productsP.add(jsp);
		
		//JTable end
		TableColumn column = productsTab.getColumnModel().getColumn(0);
		column.setPreferredWidth(222);
		column = productsTab.getColumnModel().getColumn(1);
		column.setPreferredWidth(222);
		column = productsTab.getColumnModel().getColumn(2);
		column.setPreferredWidth(222);
		column = productsTab.getColumnModel().getColumn(3);
		column.setPreferredWidth(222);
	
		

		 
		
		productsTab.setRowHeight(25);
		productsTab.setFont(new Font("Serif", Font.ITALIC, 18));
		productsTab.getTableHeader().setBackground(Color.BLUE);

		save.setBounds(789,222,178,29);
		save.setBackground(Color.YELLOW);
		
		productsP.add(save);
		insttext.setBounds(5,225,400,25);
		productsP.add(insttext);
		

		viewP.setLayout(null);
		viewP.setBounds(0,0,970,290);
		viewP.setBackground(Color.green);
		
		
		
		
		 ///pro.add(viewP);
		 
		 
		 searchP.setLayout(null);
		 searchP.setBounds(0,0,970,290);
		 searchP.setBackground(new Color(235,235,235));
		 
		 searchtext.setBounds(0,0,200,30);
		 searchtext.setBackground(new Color(225,225,225));
		 searchtext.setFont(new Font("Serif", Font.ITALIC, 11));
		 searchP.add(searchtext);
		 searchB.setBounds(200,0,100,30);
		 searchP.add(searchB);
		 
		 
		productsF.setVisible(true);
		
		
		
		save.addActionListener(this);
		searchtext.addActionListener(this);
		searchB.addActionListener(this);
		
		
	}
	public static void main(String args [])
	{
		
		Products prod = new Products();
		prod.initProducts();
		
		
		
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
	            	 
	            for(int i=0;i<8;i++)
	            {
	            	
	            		
	            	stmt.execute(" insert into products (ProductID,ProductName,MRP,Cost)"
	                         + " values " +
				      "('"+model.getValueAt(i, 0)+"','"+model.getValueAt(i,1 )+"','"+model.getValueAt(i, 2)+"','"+model.getValueAt(i, 3)+"')");
	            	
	            }
	             
	             
	    	     JOptionPane.showMessageDialog(null, "Entries saved sucessfully !");
	    	     
	             }
	             catch(com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException ex)
	             {
	            	 JOptionPane.showMessageDialog(null, "Cannot Save, ProductID already exists !");
	            	 
	             }
	             catch(java.sql.SQLException ex)
	             {
	            	 JOptionPane.showMessageDialog(null, "Enter MRP/Cost in digits only!");
	            	 ex.printStackTrace();
	             }
	              catch(java.lang.NullPointerException ex)
	             {
	            	 
	            	 
	             }
	            
	             
	             db.close();
		} 
	catch (Exception ew)
	        {
			     JOptionPane.showMessageDialog(null, "Wrong Entries");
			     ew.printStackTrace();
	        }   

		

/*		
		
		System.out.println(model.getValueAt(0, 0).toString());
		System.out.println(model.getValueAt(0, 1).toString());
		System.out.println(model.getValueAt(0, 2).toString());
		System.out.println(model.getValueAt(0, 3).toString());
	*/	
	}  

	public void searchEntries()
	{
		
		try 
		{

	       Class.forName("com.mysql.jdbc.Driver").newInstance();
	       java.sql.Connection  db = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanepharma","root","");
	       java.sql.Statement stmt = db.createStatement();
	       java.sql.ResultSet rst=null;
	       System.out.println("Connected");
	       
	       String searchS=searchtext.getText();
	       if(searchtext.getText().equals("all"))
	       {
	    	   rst = stmt.executeQuery("Select count(*) from products");
	    	   rst.next();
	    	   int count = Integer.parseInt(rst.getString(1));
	    	   System.out.println("sdas"+count);
	    	   model.setNumRows(count);
	    	   rst=stmt.executeQuery("Select * from products");
	  			for(int i=0;i<count;i++)
	  			{
	  			
		       	rst.next();
		             
			       model.setValueAt(rst.getString(1), i, 0); 
			       model.setValueAt(rst.getString(2), i, 1);
			       model.setValueAt(rst.getString(3), i, 2);
			       model.setValueAt(rst.getString(4), i, 3);

	  			
	  			}
	       }
	       else
	       {   
	       rst=stmt.executeQuery("Select * from products where ProductID='"+searchS+"'");
	       rst.next();
	       System.out.println(rst.getString(1));
	       System.out.println(rst.getString(2));
	       System.out.println(rst.getString(3));
	       System.out.println(rst.getString(4));
	             
	       model.setValueAt(rst.getString(1), 0, 0); 
	       model.setValueAt(rst.getString(2), 0, 1);
	       model.setValueAt(rst.getString(3), 0, 2);
	       model.setValueAt(rst.getString(4), 0, 3);
	       
	       }
	        db.close();
	             
	             
	             
		}   
	catch (Exception ew)
	        {
			     JOptionPane.showMessageDialog(null, "No Result Found");
			     ew.printStackTrace();
	        }   

		

		
		
	}
	
	
	public void viewAll()
	{
		try 
		{

	       Class.forName("com.mysql.jdbc.Driver").newInstance();
	       java.sql.Connection  db = DriverManager.getConnection("jdbc:mysql://localhost:3306/sanepharma","root","");
	       java.sql.Statement stmt = db.createStatement();
	       java.sql.ResultSet rst=null;
	       System.out.println("Connected");
	       
	       	   rst = stmt.executeQuery("Select count(*) from products");
	    	   rst.next();
	    	   int count = Integer.parseInt(rst.getString(1));
	    	   //System.out.println("sdas"+count);
	    	   model.setNumRows(count);
	    	   rst=stmt.executeQuery("Select * from products");
	  			for(int i=0;i<count;i++)
	  			{
	  			
		       	rst.next();
		             
			       model.setValueAt(rst.getString(1), i, 0); 
			       model.setValueAt(rst.getString(2), i, 1);
			       model.setValueAt(rst.getString(3), i, 2);
			       model.setValueAt(rst.getString(4), i, 3);

	  			
	  			}
	       
		}
		catch(Exception ew)
		{
			
		}
		
	
	
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent a) 
	{      
		if(a.getSource()==save)
		{
			productsTab.getCellEditor().stopCellEditing();
			saveValues();			
		}		
	/*	else if(a.getSource()==searchtext);
		{
			System.out.println("sdsfsdfd");
			searchtext.setText("");
			searchP.repaint();
		
		}		
	*/
		if(a.getSource()==searchB)
		{
			searchEntries();
		}
		
	
		
		
	}
	
	
	
	
	
	
	
}
