package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ClaimProcessingPanel extends JPanel {

	// TODO Browse all claims to pick one that has not been processed
	// TODO According to the severity, display the relevant tasks
	// TODO For the form : pop-up to be filled by the client. When submitted, check if completed.
	// TODO For the garage : pop-up with just a button
	// TODO For the insurance : Pop-up to check if the client is insured ?
	
	public ClaimProcessingPanel(){
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		processNewClaim();
		
	}

	private void processNewClaim() {
		//Claim claim = pickClaim();
		//String severity = claim.getSeverity();
		
		this.add(new JButton("Send forms"));
		this.add(new JButton("Check insurance"));
		this.add(new JButton("Phone Garage"));
		
		
	}
	
}
