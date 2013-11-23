package gui;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import system.Claim;




public class DecisionLetterPanel extends JPanel implements ActionListener {
	private JButton print;
	private JPanel bottomPanel = new JPanel();
	private DashboardPanel dashboard;
	private Claim claim;
	private JButton checkForClaimsButton = new JButton("Check for claims");
	JTextArea textArea;

	public DecisionLetterPanel(DashboardPanel dashboardPanel)
	{
		this.dashboard = dashboardPanel;
		
		
		print = new JButton("Print");
		print.addActionListener(this);
		
		textArea = new JTextArea(
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

		this.add(checkForClaimsButton);
		checkForClaimsButton.addActionListener(this);

	}

	private void processNewClaim() {
		claim = pickClaim();

		if(claim != null){
			this.remove(checkForClaimsButton);

			bottomPanel.setLayout(new FlowLayout());
						
			this.add(bottomPanel, BorderLayout.SOUTH);
			bottomPanel.add(print);
			
			this.add(textArea, BorderLayout.CENTER);

		}

		this.repaint();
		this.revalidate();

	}

	public static Claim pickClaim() {
		Claim claim;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim = it.next();
			if(claim.isProcessed() && claim.getDecision() != null && ! claim.isLetterSent()){
				return claim;
			}
		}
		return null;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == checkForClaimsButton){
			this.setLayout(new BorderLayout());
			processNewClaim();
		}
		
		if(e.getSource() == print){
			claim.setLetterSent(true);
			JOptionPane.showMessageDialog(null, "The letter has been printed, the claim is now classified.");
			this.removeAll();
			this.setLayout(new FlowLayout());
			this.add(checkForClaimsButton);
			dashboard.refreshNotifications();
			this.repaint();
			this.revalidate();
		}
	}			


}

