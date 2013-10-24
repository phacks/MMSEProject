import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwitchPanelsListener implements ActionListener{

	private MainPanel mainPanel;
	private DashboardPanel dashboardPanel;
	private LoginPanel loginPanel;
	
	public SwitchPanelsListener(MainPanel mainPanel, DashboardPanel dashboardPanel, LoginPanel loginPanel){
		
		this.mainPanel = mainPanel; 
		this.dashboardPanel = dashboardPanel;
		this.loginPanel = loginPanel;
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getSource() == loginPanel.getDashboardButton()){
			mainPanel.setDashboard();
		}
		if (arg0.getSource() == dashboardPanel.getLoginButton()){
			mainPanel.setLogin();
		}
	}
}
