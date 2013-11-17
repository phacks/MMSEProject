package gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;


public class DashboardPanel extends JPanel{

	private MainPanel mainPanel;
	private JButton loginButton = new JButton("Go to login");
	private SwitchPanelsListener listener;
	private JPanel southPanel = new JPanel();
	private JTabbedPane menu = new JTabbedPane();
	
	
	public DashboardPanel(MainPanel mainPanel, String type){
		
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
			menu.addTab("Claim Registration", new ClaimRegistrationPanel());
			menu.addTab("Claim Processing", new ClaimProcessingPanel());
			menu.addTab("Claim Decision", new ClaimDecisionPanel());
			menu.addTab("Decision Letter", new JPanel());
			menu.addTab("Search Client", new ClientSearchPanel());
		}
		if (type.equals("EmployeeB")){
			menu.addTab("Claim Registration", new JPanel());
			menu.addTab("Claim Processing", new ClaimProcessingPanel());
			menu.addTab("Decision Letter", new JPanel());
			menu.addTab("Search Client", new JPanel());
		}
		if (type.equals("Financial")){
			menu.addTab("Payment Order", new JPanel());
			menu.addTab("Search Payments", new JPanel());
			menu.addTab("Search Client", new JPanel());
		}
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
