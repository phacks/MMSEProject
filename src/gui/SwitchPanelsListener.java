package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SwitchPanelsListener implements ActionListener{

	private MainPanel mainPanel;
	private DashboardPanel dashboardPanel;
	private LoginPanel loginPanel;
	
	public SwitchPanelsListener(MainPanel mainPanel){
		this.mainPanel = mainPanel;
	}

	public void setLoginPanel(LoginPanel loginPanel){
		this.loginPanel = loginPanel;
	}
	
	public void setDashboardPanel(DashboardPanel dashboardPanel){
		this.dashboardPanel = dashboardPanel;
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
//		if (arg0.getSource() == loginPanel.getDashboardEmployeeAButton()){
//			
//			mainPanel.setDashboard("EmployeeA");
//		}
//		if (arg0.getSource() == loginPanel.getDashboardEmployeeBButton()){
//			mainPanel.setDashboard("EmployeeB");
//		}
//		if (arg0.getSource() == loginPanel.getDashboardFinancialButton()){
//			mainPanel.setDashboard("Financial");
//		}
		if (arg0.getSource() == dashboardPanel.getLoginButton()){
			mainPanel.setLogin();
		}
	}
}
