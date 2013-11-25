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
	private JTextField carPrice;
	private JTextField estimatedDamages;
	private JButton createClaim;
	public JRadioButton high = new JRadioButton ("High",false);;
	public JRadioButton normal = new JRadioButton ("Normal", true);;
	public JRadioButton low= new JRadioButton("low"  , false);;  

	public ClaimRegistrationPanel()
	{
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(high);
		bgroup.add(normal);
		bgroup.add(low);
		name = new JTextField("Name",20);
		add(name);
		surname = new JTextField("Surname",20);
		add(surname);
		comments = new JTextField("Comments",20);
		add(comments);
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
		boolean h,n;
		public void actionPerformed(ActionEvent e) {
			if( claimRegistrationControl.checkType(carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText()) )
			{
				h=high.isSelected();
				n=normal.isSelected();
				claimRegistrationControl.clientHandling(h,n,carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText());
			}
		}
	}
}

