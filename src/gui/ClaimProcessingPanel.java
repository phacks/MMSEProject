package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import system.Claim;

public class ClaimProcessingPanel extends JPanel implements ActionListener{

	// TODO Browse all claims to pick one that has not been processed
	// TODO According to the severity, display the relevant tasks
	// TODO For the form : pop-up to be filled by the client. When submitted, check if completed.
	// TODO For the garage : pop-up with just a button
	// TODO For the insurance : Pop-up to check if the client is insured ?

	private JButton complexFormButton = new JButton("Send complex form");
	private JButton simpleFormButton = new JButton("Send simple form");
	private JButton phoneGarageButton = new JButton("Phone garage");
	private JButton checkInsuranceButton = new JButton("Check insurance");
	private JButton historyButton = new JButton("Damage history");
	private JButton checkForClaimsButton = new JButton("Check for claim");
	private boolean formOK = false;
	private boolean insuranceOK = false;
	private boolean garageOK = false;
	private boolean damageOK = false;

	public ClaimProcessingPanel(){
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(checkForClaimsButton);

		checkForClaimsButton.addActionListener(this);



	}

	private void processNewClaim() {
		Claim claim = pickClaim();

		if(claim != null){
			this.remove(checkForClaimsButton);

			String severity = claim.getSeverity();

			this.add(new ClaimPanel(claim));

			if(severity.equals("simple")){
				this.add(simpleFormButton);
			}
			else if(severity.equals("complex")){
				this.add(complexFormButton);
				this.add(historyButton);
			}
			this.add(checkInsuranceButton);
			this.add(phoneGarageButton);
		}

		this.repaint();
		this.revalidate();

	}

	private Claim pickClaim(){
		Claim claim;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if( !claim.isProcessed()){
				return claim;
			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == checkForClaimsButton){
			processNewClaim();
		}
		if(e.getSource() == simpleFormButton){

		}
		if(e.getSource() == complexFormButton){

		}
		if(e.getSource() == historyButton){

		}
		if(e.getSource() == checkInsuranceButton){

		}
		if(e.getSource() == phoneGarageButton){

		}
	}



}
