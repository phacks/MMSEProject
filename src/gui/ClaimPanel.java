package gui;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

import system.Claim;

public class ClaimPanel extends JPanel {
	
	public ClaimPanel(Claim claim){
	this.setMaximumSize(new Dimension(800, 100));

	JLabel estimatedDamages = new JLabel("Estimated damages : " + claim.getEstimatedDamages()+ " | ");
	JLabel priceOfCar = new JLabel("Price of the car : " + claim.getPriceOfCar() + " | ");
	JLabel gravity = new JLabel("Gravity : " + claim.getGravity()+ " | ");
	JLabel estimation = new JLabel("Estimation : " + claim.evaluateSeverity());

	this.add(estimatedDamages);
	this.add(priceOfCar);
	this.add(gravity);
	this.add(estimation);
	
	}

}
