package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.ClaimRegistrationControl;

public class ClaimRegistrationPanel extends JPanel {
	private JTextField name;
	private JTextField surname;
	private JTextField comments;
<<<<<<< HEAD
	private JTextField carPrice;
	private JTextField estimatedDamages;
	private JButton createClaim;
	public JRadioButton high = new JRadioButton ("High",false);;
	public JRadioButton normal = new JRadioButton ("Normal", true);;
	public JRadioButton low= new JRadioButton("low"  , false);;  

	public ClaimRegistrationPanel()
	{
=======
	private JTextField priceofthecar;
	private JTextField estimateddamages;
	private JButton createclaim;
	public JRadioButton high = new JRadioButton ("High",false);
	public JRadioButton normal = new JRadioButton ("Normal", true);
	public JRadioButton low= new JRadioButton("low"  , false);
	private DashboardPanel dashboard;
	private JPanel panel;
	
		
	public ClaimRegistrationPanel(DashboardPanel dashboardPanel) {
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
		ButtonGroup bgroup = new ButtonGroup();
		panel = this;
		bgroup.add(high);
		bgroup.add(normal);
		bgroup.add(low);
<<<<<<< HEAD
=======
		this.dashboard = dashboardPanel;
		
		//------------text field-----------------
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
		name = new JTextField("Name",20);
		add(name);
		surname = new JTextField("Surname",20);
		add(surname);
		comments = new JTextField("Comments",20);
		add(comments);
<<<<<<< HEAD
		carPrice = new JTextField("Price of the car",20);
		add(carPrice);
		estimatedDamages = new JTextField("Estimated damages",20);
		add(estimatedDamages);
		createClaim = new JButton("Create Claim");
		add(createClaim);
		add (high);
		add (normal);
		add (low);
		TheHandler handler= new TheHandler();
		createClaim.addActionListener(handler);
	}
	private  class TheHandler implements ActionListener{
		ClaimRegistrationControl claimRegistrationControl = new ClaimRegistrationControl();
=======
		priceofthecar = new JTextField("10000",20);
		add(priceofthecar);
		estimateddamages = new JTextField("1000",20);
		add(estimateddamages);
		//-----------------button-----------------
		createclaim = new JButton("Create Claim");
		add(createclaim);
		//---------------check boxes----------------------
	
	    
	    add (high);
	    add (normal);
	    add (low);
	    
		
		
		thehandler handler_= new thehandler();
		createclaim.addActionListener(handler_);
		
	}



	// method that handles the events
	private  class thehandler implements ActionListener{
		ClaimRegistrationControl claimregistrationcontrol = new ClaimRegistrationControl(dashboard);
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
		boolean h,n;
		public void actionPerformed(ActionEvent e) {
			if( claimRegistrationControl.checkType(carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText()) )
			{
				h=high.isSelected();
				n=normal.isSelected();
<<<<<<< HEAD
				claimRegistrationControl.clientHandling(h,n,carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText());
=======
	
				claimregistrationcontrol.clienthandling(h,n,priceofthecar.getText(),name.getText(),surname.getText(),comments.getText(),estimateddamages.getText());
				panel.repaint();
				panel.revalidate();
			 }
				 
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
			}
		}
	}
}

