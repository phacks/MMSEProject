package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import system.Claim;

public class ClaimProcessingPanel extends JPanel implements ActionListener{

	// TODO Check if all tasks have been completed

	private JButton complexFormButton = new JButton("Send complex form");
	private JButton simpleFormButton = new JButton("Send simple form");
	private JButton phoneGarageButton = new JButton("Phone garage");
	private JButton checkInsuranceButton = new JButton("Check insurance");
	private JButton historyButton = new JButton("Damage history");
	private JButton checkForClaimsButton = new JButton("Check for claim");
	private boolean formOK = false;
	private boolean insuranceOK = false;
	private boolean historyOK = false;
	private boolean garageOK = false;
	private Claim claim;
	private ClaimPanel claimPanel;

	public ClaimProcessingPanel(){
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(checkForClaimsButton);

		checkForClaimsButton.addActionListener(this);
		simpleFormButton.addActionListener(this);
		complexFormButton.addActionListener(this);
		phoneGarageButton.addActionListener(this);
		checkInsuranceButton.addActionListener(this);
		historyButton.addActionListener(this);

	}

	private void processNewClaim() {
		claim = pickClaim();

		if(claim != null){
			this.remove(checkForClaimsButton);

			String severity = claim.getSeverity();

			claimPanel = new ClaimPanel(claim);
			this.add(claimPanel);

			if(severity.equals("simple")){
				this.add(simpleFormButton);
				historyOK = true;
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
			new FormFrame("simple", claim);
			formOK = true;
			checkCompleteness();
		}
		if(e.getSource() == complexFormButton){
			new FormFrame("complex", claim);
			formOK = true;
			checkCompleteness();
		}
		if(e.getSource() == historyButton){
			new HistoryFrame(claim.getClaimant());
			historyOK = true;
			checkCompleteness();
		}
		if(e.getSource() == checkInsuranceButton){
			new InsuranceFrame(claim);
			insuranceOK = true;
			checkCompleteness();
		}
		if(e.getSource() == phoneGarageButton){
			JOptionPane.showMessageDialog(null, "Garage phoned");
			garageOK = true;
			checkCompleteness();
		}
	}

	private void checkCompleteness() {
		if(formOK && historyOK && insuranceOK && garageOK){
			if(claim.getDecision() != null){
				JOptionPane.showMessageDialog(null, "The claim has been processed, the decision is NotOK. The decision letter can be sent.");
			}
			else{
				JOptionPane.showMessageDialog(null, "The claim has been processed, the decision is pending.");
			}
			claim.setProcessed(true);
			historyOK = false;
			formOK = false;
			insuranceOK = false;
			garageOK = false;
			this.removeAll();
			this.add(checkForClaimsButton);
			this.repaint();
			this.revalidate();
		}
	}



}
