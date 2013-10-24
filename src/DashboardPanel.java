import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class DashboardPanel extends JPanel{

	private MainPanel mainPanel;
	private JButton loginButton = new JButton("Go to login");
	
	public DashboardPanel(MainPanel mainPanel){
		
		this.mainPanel = mainPanel;
		
		this.setLayout(new BorderLayout());
		
		this.add(loginButton, BorderLayout.SOUTH);
		
	}

	public JButton getLoginButton() {
		// TODO Auto-generated method stub
		return loginButton;
	}
}
