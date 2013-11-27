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
	public JRadioButton high = new JRadioButton ("High",false);
	public JRadioButton normal = new JRadioButton ("Normal", true);
	public JRadioButton low= new JRadioButton("low"  , false);
	private DashboardPanel dashboard;
	private JPanel panel;


	public ClaimRegistrationPanel(DashboardPanel dashboardPanel) {
		ButtonGroup bgroup = new ButtonGroup();
		panel = this;
		bgroup.add(high);
		bgroup.add(normal);
		bgroup.add(low);
		this.dashboard = dashboardPanel;
		name = new JTextField("Name",20);
		add(name);
		surname = new JTextField("Surname",20);
		add(surname);
		comments = new JTextField("Comments",20);
		add(comments);
		carPrice = new JTextField("10000",20);
		add(carPrice);
		estimatedDamages = new JTextField("1000",20);
		add(estimatedDamages);
		createClaim = new JButton("Create Claim");
		add(createClaim);
		add (high);
		add (normal);
		add (low);
		thehandler handler_= new thehandler();
		createClaim.addActionListener(handler_);
	}
	private  class thehandler implements ActionListener{
		ClaimRegistrationControl claimregistrationcontrol = new ClaimRegistrationControl(dashboard);
		boolean h,n;
		public void actionPerformed(ActionEvent e) {
			if( claimregistrationcontrol.checkType(carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText()) )
			{
				h=high.isSelected();
				n=normal.isSelected();
				claimregistrationcontrol.clientHandling(h,n,carPrice.getText(),name.getText(),surname.getText(),comments.getText(),estimatedDamages.getText());
				panel.repaint();
				panel.revalidate();
			}
		}
	}
}

