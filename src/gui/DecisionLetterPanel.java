package gui;



import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;




public class DecisionLetterPanel extends JPanel {
	private JTextField email;
	private JButton send;
	private JPanel bottomPanel = new JPanel();
	private DashboardPanel dashboard;

	public DecisionLetterPanel(DashboardPanel dashboardPanel)
	{
		this.dashboard = dashboardPanel;
		this.setLayout(new BorderLayout());
		email = new JTextField("email@domain.se",20);
		send = new JButton("Send");
		JTextArea textArea = new JTextArea(
			    "This is an editable JTextArea. " +
			    "A text area is a \"plain\" text component, " +
			    "which means that although it can display text " +
			    "in any font, all of the text is in the same font."
			);
		
		
		JScrollPane areaScrollPane = new JScrollPane(textArea);
		areaScrollPane.setVerticalScrollBarPolicy(
		                JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		areaScrollPane.setPreferredSize(new Dimension(30, 30));
		
			textArea.setFont(new Font("Serif", Font.ITALIC, 16));
			textArea.setLineWrap(true);
			textArea.setWrapStyleWord(true);
			
			
			
			bottomPanel.setLayout(new FlowLayout());
			//send.setSize(200, 100);
			
			this.add(bottomPanel, BorderLayout.SOUTH);
			bottomPanel.add(email);
			bottomPanel.add(send);
			
			
			
			
			
			this.add(textArea, BorderLayout.CENTER);
			
			
		

	}			
   
		
}
	
