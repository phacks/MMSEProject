package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.Claim;


public class FormFrame extends JFrame implements ActionListener {

	private JTextField dateField = new JTextField("Date", 20);
	private JTextField licensePlateField = new JTextField("License plate", 20);
	private JTextField driversLicenseNumberField = new JTextField("Driver's license number", 20);
	private JLabel othersVehicleLabel = new JLabel("Are others vehicles involved ?");
	private JRadioButton othersVehicleTrue = new JRadioButton("Yes");
	private JRadioButton othersVehicleFalse = new JRadioButton("No");
	private JButton submit = new JButton("Submit");
	private JLabel incompleteLabel = new JLabel("");
	private Claim claim;
	
	ButtonGroup group = new ButtonGroup();
	
	private JPanel panel = new JPanel();

	public FormFrame(String type, Claim claim){
		
		this.claim = claim;
		
		this.setSize(400, 400);
		this.setTitle(type + " form");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		
		othersVehicleFalse.setSelected(true);
		group.add(othersVehicleTrue);
		group.add(othersVehicleFalse);

		panel.add(incompleteLabel);
		panel.add(dateField);
		panel.add(licensePlateField);
		panel.add(driversLicenseNumberField);
		panel.add(othersVehicleLabel);
		panel.add(othersVehicleTrue);
		panel.add(othersVehicleFalse);
		panel.add(submit);
		
		submit.addActionListener(this);

		this.setContentPane(panel);
		this.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == submit){
			if(    ! (dateField.getText().equals("") || dateField.getText().equals("Date")
				||  licensePlateField.getText().equals("") || licensePlateField.getText().equals("License plate")
				||  driversLicenseNumberField.getText().equals("") || driversLicenseNumberField.getText().equals("Driver's license number"))
				){
				claim.setFormFilled(true);
				claim.setDate(dateField.getText());
				claim.setLicensePlate(licensePlateField.getText());
				claim.setDriversLicenseNumber(driversLicenseNumberField.getText());
				claim.setOtherVehiclesInvolved(othersVehicleTrue.isSelected());
				this.dispose();
			}
			else{
				incompleteLabel.setText("Error : incomplete form. Please try again.");
				this.repaint();
				this.revalidate();
			}
		}
	}

}
