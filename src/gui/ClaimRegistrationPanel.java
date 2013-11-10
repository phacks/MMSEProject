package gui;


import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ClaimRegistrationPanel extends JPanel {
	private JTextField name;
	private JTextField surname;
	private JTextField comments;
	private JTextField priceofthecar;
	private JTextField estimateddamages;
	private JButton createclaim;
	private JCheckBox high;
	private JCheckBox normal;
	private JCheckBox low; 
//	private JLabel gravity;
	
	


	
	public ClaimRegistrationPanel()
	{
		//------------text field-----------------
		name = new JTextField("Name",20);
		add(name);
		surname = new JTextField("Surname",20);
		add(surname);
		comments = new JTextField("Comments",20);
		add(comments);
		priceofthecar = new JTextField("Price of the car",20);
		add(priceofthecar);
		estimateddamages = new JTextField("Estimated damages",20);
		add(estimateddamages);
		//-----------------button-----------------
		createclaim = new JButton("Create Claim");
		add(createclaim);
		//---------------check boxes----------------------
		high = new JCheckBox ("High");
	    normal = new JCheckBox ("Normal", true);
	    low = new JCheckBox ("Low");
	    
	    add (high);
	    add (normal);
	    add (low);
	    
	    
	    //-----------------Label-----------------------
		//gravity= new JLabel("Gravity claim");
		//add(gravity);
	    
		
		
		//-----------------------------------------------
		
		
		thehandler handler= new thehandler();
		createclaim.addActionListener(handler);
		
	}
	
	
	
	// method that handles the events
	private  class thehandler implements ActionListener{
		
		ClaimRegistrationControl claimregistrationcontrol = new ClaimRegistrationControl();
		
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			 claimregistrationcontrol.checktype(priceofthecar.getText(),name.getText(),surname.getText(),comments.getText(),estimateddamages.getText());
			 
//			 if (client registered){
//				 create claim
//			 }
//			 else (ask if create client){
//				 if not -> abort operation 
//				 if so -> create a new client (name, surname)
//				 	   -> create claim and assign client to the claim
//			 }
			 
			 
			 
		}
		
		
	}
}
		
