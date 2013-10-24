import java.awt.Color;

import javax.swing.JPanel;

public class MainPanel extends JPanel{

	private DashboardPanel dashboardPanel;
	private LoginPanel loginPanel;
	public SwitchPanelsListener switchPanelsListener;

	// Comment to show Git commit
	
	public MainPanel(int width, int height){
		this.setSize(width, height);
		this.setBackground(Color.white);

		loginPanel = new LoginPanel(this);
		dashboardPanel = new DashboardPanel(this); 
		switchPanelsListener = new SwitchPanelsListener(this, dashboardPanel, loginPanel);
		
		dashboardPanel.getLoginButton().addActionListener(switchPanelsListener);
		loginPanel.getDashboardButton().addActionListener(switchPanelsListener);

		setLogin();

	}

	public void setDashboard(){
		this.removeAll();
		this.add(dashboardPanel);
		this.repaint();
		this.revalidate();
	}

	public void setLogin(){
		this.removeAll();
		this.add(loginPanel);
		this.repaint();
		this.revalidate();
	}


}
