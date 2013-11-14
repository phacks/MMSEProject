package gui;
import system.Login;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{

	private static final long serialVersionUID = 1L;
	private MainPanel mainPanel;
	private JButton checkButton = new JButton("Go to dashboard");
	private JTextField username = new JTextField("EmployeeA");
	private JPasswordField password = new JPasswordField("pwd");
	private JLabel loginText = new JLabel("Login");
	private JButton dashboardEmployeeAButton = new JButton();
	private JButton dashboardEmployeeBButton = new JButton();
	private JButton dashboardFinancialButton = new JButton();
	private Login login = new Login();
	private SwitchPanelsListener listener;
	
	
	public LoginPanel(MainPanel mainPanel){
		
		this.login.setMainPanel(mainPanel);
		
		this.setPreferredSize(new Dimension(mainPanel.getWidth() - 200, mainPanel.getHeight() - 100));
		this.setLayout(new GridLayout(4, 1));
		
		checkButton.addActionListener(this);
		
		this.add(loginText);
		this.add(username);
		this.add(password);
		this.add(checkButton);
		
	}
	
	public void setSwitchPanelsListener(SwitchPanelsListener listener){
		this.listener = listener;
		
		dashboardEmployeeAButton.addActionListener(this.listener);
		dashboardEmployeeBButton.addActionListener(this.listener);
		dashboardFinancialButton.addActionListener(this.listener);
	}

	public JButton getDashboardEmployeeAButton() {
		// TODO Auto-generated method stub
		return dashboardEmployeeAButton;
	}
	public JButton getDashboardEmployeeBButton() {
		// TODO Auto-generated method stub
		return dashboardEmployeeBButton;
	}
	public JButton getDashboardFinancialButton() {
		// TODO Auto-generated method stub
		return dashboardFinancialButton;
	}

	// Pattern Observer
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == checkButton){
			login.checkCredentials(username.getText(), new String(password.getPassword()));
		}
	}
	

}
