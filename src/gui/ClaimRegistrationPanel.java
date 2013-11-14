package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.ClaimRegistrationControl;

public class ClaimRegistrationPanel extends JPanel {
	private JTextField name;
	private JTextField surname;
	private JTextField comments;
	private JTextField priceofthecar;
	private JTextField estimateddamages;
	private JButton createclaim;
	public JCheckBox high;
	public JCheckBox normal;
	public JCheckBox low; 
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
	    
		
		
		thehandler handler_= new thehandler();
		createclaim.addActionListener(handler_);
		
	}
	
	
	
	// method that handles the events
	private  class thehandler implements ActionListener{
		ClaimRegistrationControl claimregistrationcontrol = new ClaimRegistrationControl();
		boolean h,n;
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if( claimregistrationcontrol.checktype(priceofthecar.getText(),name.getText(),surname.getText(),comments.getText(),estimateddamages.getText()) )
			{
				h=high.isSelected();
				n=normal.isSelected();
	
				claimregistrationcontrol.clienthandling(h,n,priceofthecar.getText(),name.getText(),surname.getText(),comments.getText(),estimateddamages.getText());
			 
			 }
				 
			}
		
		
	}
}
	
