package gui;

import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import system.Claim;

public class ClaimPanel extends JPanel {
	
	public ClaimPanel(Claim claim){
	this.setMaximumSize(new Dimension(800, 160));
	
	JPanel claimStatusPanel = new JPanel();
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	
	this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
	
	JLabel claimStatus = new JLabel("Claim status : " + claim.getStatus() + " | ");
	JLabel insurance = new JLabel("Claimant's insurance type : " + claim.getClaimant().getInsuranceType());
	
	claimStatusPanel.add(claimStatus);
	claimStatusPanel.add(insurance);

	this.add(claimStatusPanel);
	
	JLabel estimatedDamages = new JLabel("Estimated damages : " + claim.getEstimatedDamages()+ " | ");
	JLabel priceOfCar = new JLabel("Price of the car : " + claim.getPriceOfCar() + " | ");
	JLabel gravity = new JLabel("Gravity : " + claim.getGravity()+ " | ");
	JLabel estimation = new JLabel("Estimation : " + claim.evaluateSeverity());

	top.add(estimatedDamages);
	top.add(priceOfCar);
	top.add(gravity);
	top.add(estimation);
	
	
	this.add(top);
	
	
	if(claim.isFormFilled()){
		JLabel date = new JLabel("Date : " + claim.getDate() + " | ");
		JLabel licensePlate = new JLabel("License plate : " + claim.getLicensePlate() + " | ");
		JLabel driversLicenseNumber = new JLabel("Driver's license number : " + claim.getDriversLicenseNumber() + " | ");
		JLabel otherVehicles = new JLabel("Others vehicles involved : " + claim.isOtherVehiclesInvolved());
		
		bottom.add(date);
		bottom.add(licensePlate);
		bottom.add(driversLicenseNumber);
		bottom.add(otherVehicles);
		
		this.add(bottom);
	}
	
	
	
	
	}

}
