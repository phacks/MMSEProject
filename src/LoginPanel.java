import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JPanel implements ActionListener{
	
	private MainPanel mainPanel;
	private JButton checkButton = new JButton("Go to dashboard");
	private JTextField username = new JTextField("Username");
	private JTextField password = new JTextField("Password");
	private JLabel loginText = new JLabel("Login");
	private JButton dashboardButton = new JButton();
	
	
	public LoginPanel(MainPanel mainPanel){
		this.mainPanel = mainPanel;
		
		this.setPreferredSize(new Dimension(mainPanel.getWidth() - 200, mainPanel.getHeight() - 200));
		this.setLayout(new GridLayout(4, 1));
		
		checkButton.addActionListener(this);
		
		this.add(loginText);
		this.add(username);
		this.add(password);
		this.add(checkButton);
		
	}


	public JButton getDashboardButton() {
		// TODO Auto-generated method stub
		return dashboardButton;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == checkButton){
			if (username.getText().equals("user") && password.getText().equals("pwd")){
				dashboardButton.doClick();
			}
		}
	}

}
