package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import system.Claim;


public class DashboardPanel extends JPanel{

	private MainPanel mainPanel;
	private JButton loginButton = new JButton("Go to login");
	private SwitchPanelsListener listener;
	private JPanel southPanel = new JPanel();
	private JTabbedPane menu = new JTabbedPane();
	private String type;


	public DashboardPanel(MainPanel mainPanel, String type){

		this.type = type;
		this.mainPanel = mainPanel;

		this.setPreferredSize(new Dimension(mainPanel.getWidth() - 200, mainPanel.getHeight() - 100));

		this.setLayout(new BorderLayout());

		southPanel.setLayout(new FlowLayout());
		loginButton.setSize(200, 100);

		this.add(southPanel, BorderLayout.SOUTH);
		southPanel.add(loginButton);

		setMenu(type);

		this.add(menu, BorderLayout.CENTER);

	}


	private void setMenu(String type) {
		// TODO Auto-generated method stub
		if (type.equals("EmployeeA")){
			menu.addTab("Claim Registration", new ClaimRegistrationPanel(this));
			menu.addTab("Claim Processing (" + numberOfUnprocessedClaims() + ")", new ClaimProcessingPanel(this));
			menu.addTab("Claim Decision (" + numberOfUndecidedClaims() + ")", new ClaimDecisionPanel(this));
			menu.addTab("Decision Letter (" + numberOfUnsentLetters() + ")", new DecisionLetterPanel(this));
			menu.addTab("Search Client", new ClientSearchPanel());
		}
		if (type.equals("EmployeeB")){
			menu.addTab("Claim Registration", new JPanel());
			menu.addTab("Claim Processing (" + numberOfUnprocessedClaims() + ")", new ClaimProcessingPanel(this));
			menu.addTab("Decision Letter (" + numberOfUnsentLetters() + ")", new DecisionLetterPanel(this));
			menu.addTab("Search Client", new JPanel());
		}
		if (type.equals("Financial")){
			menu.addTab("Payment Order", new JPanel());
			menu.addTab("Search Payments", new JPanel());
			menu.addTab("Search Client", new JPanel());
		}
	}

	private int numberOfUnprocessedClaims(){
		Claim claim;
		int c = 0;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if( !claim.isProcessed()){
				c++;
			}
		}
		return c;
	}

	private int numberOfUndecidedClaims(){
		Claim claim;
		int c = 0;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if( claim.isProcessed() && claim.getDecision() == null){
				c++;
			}
		}
		return c;
	}

	private int numberOfUnsentLetters(){
		Claim claim;
		int c = 0;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if( claim.isProcessed() && (claim.getDecision() != null) && ! claim.isLetterSent()){
				c++;
			}
		}
		return c;
	}

	public void refreshNotifications(){
		menu.setTitleAt(1, "Claim Processing (" + numberOfUnprocessedClaims() + ")");
		if(type.equals("EmployeeA")){
			menu.setTitleAt(2, "Claim Decision (" + numberOfUndecidedClaims() + ")");
			menu.setTitleAt(3, "Decision Letter (" + numberOfUnsentLetters() + ")");
		}
		else if(type.equals("EmployeeB")){
			menu.setTitleAt(2, "Decision Letter (" + numberOfUnsentLetters() + ")");
		}
		this.repaint();
		this.revalidate();
	}

	public JButton getLoginButton() {
		// TODO Auto-generated method stub
		return loginButton;
	}

	public void setSwitchPanelsListener(SwitchPanelsListener listener) {
		// TODO Auto-generated method stub
		this.listener = listener;
		loginButton.addActionListener(this.listener);
	}
}
