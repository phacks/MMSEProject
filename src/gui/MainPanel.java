package gui;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;

public class MainPanel extends JPanel implements Observer{

	private DashboardPanel dashboardPanel;
	private LoginPanel loginPanel;
	public SwitchPanelsListener switchPanelsListener;

	
	
	public MainPanel(int width, int height){
		this.setSize(width, height);
		this.setBackground(Color.white);

		
		switchPanelsListener = new SwitchPanelsListener(this);
		
		setLogin();

	}

	public void setDashboard(String type){
		dashboardPanel = new DashboardPanel(this, type); 
		switchPanelsListener.setDashboardPanel(dashboardPanel);
		dashboardPanel.setSwitchPanelsListener(switchPanelsListener);
		this.removeAll();
		this.add(dashboardPanel);
		this.repaint();
		this.revalidate();
	}

	public void setLogin(){
		loginPanel = new LoginPanel(this);
		switchPanelsListener.setLoginPanel(loginPanel);
		loginPanel.setSwitchPanelsListener(switchPanelsListener);
		this.removeAll();
		this.add(loginPanel);
		this.repaint();
		this.revalidate();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		setDashboard((String) arg1);
	}


}
