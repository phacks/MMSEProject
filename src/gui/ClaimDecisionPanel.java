package gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.peer.ButtonPeer;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import system.Claim;

public class ClaimDecisionPanel extends JPanel implements ActionListener {

	private JButton checkForClaimsButton = new JButton("Check for claims"); 
	private Claim claim;
	private ClaimPanel claimPanel;
	private JPanel buttonPanel = new JPanel();
	private JButton ok = new JButton("OK");
	private JButton notOk = new JButton("Not OK");
	private DashboardPanel dashboard;

	public ClaimDecisionPanel(DashboardPanel dashboardPanel){
		this.dashboard = dashboardPanel;
				
		this.setAlignmentX(CENTER_ALIGNMENT);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		this.add(checkForClaimsButton);
		checkForClaimsButton.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkForClaimsButton){
			processNewClaim();
		}
		if(e.getSource() == ok){
			int value = JOptionPane.showOptionDialog(this, "This action will result in the acceptance of the claim. Continue ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (value == JOptionPane.OK_OPTION){
				claim.setDecision("OK");
				JOptionPane.showMessageDialog(null, "The decision is OK. The decision letter can be sent.");
				this.removeAll();
				this.add(checkForClaimsButton);
				dashboard.refreshNotifications();
				this.repaint();
				this.revalidate();
			}
		}
		if(e.getSource() == notOk){
			int value = JOptionPane.showOptionDialog(this, "This action will result in the refusal of the claim. Continue ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (value == JOptionPane.OK_OPTION){
				claim.setDecision("NotOK");
				JOptionPane.showMessageDialog(null, "The decision is NotOK. The decision letter can be sent.");
				this.removeAll();
				this.add(checkForClaimsButton);
				dashboard.refreshNotifications();
				this.repaint();
				this.revalidate();
			}
			
		}
	}

	private void processNewClaim() {
		claim = pickClaim();

		if(claim != null){
			this.remove(checkForClaimsButton);
			claimPanel = new ClaimPanel(claim);
			this.add(claimPanel);
			
			buttonPanel.add(ok);
			buttonPanel.add(notOk);
			
			ok.addActionListener(this);
			notOk.addActionListener(this);
			this.add(buttonPanel);
			


		}

		this.repaint();
		this.revalidate();

	}

	public static Claim pickClaim() {
		Claim claim;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if(claim.isProcessed() && claim.getDecision() == null){
				return claim;
			}
		}
		return null;

	}

}
