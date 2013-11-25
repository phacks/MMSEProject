package gui;



import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;


import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import system.Claim;
import system.Client;

public class DecisionLetterPanel extends JPanel {
	private JButton checkLetter;
	private Claim claim;
	private JButton print= new JButton("Print");
	private JButton refresh= new JButton("Refresh");
	private DashboardPanel dashboard;
	public DecisionLetterPanel(DashboardPanel dashboardPanel)
	{
		checkLetter = new JButton("Check for letters");
		add(checkLetter);
		this.dashboard = dashboardPanel;

		TheHandler handler= new TheHandler();
		checkLetter.addActionListener(handler);
		refresh.addActionListener(handler);
		LetterSent handleSet= new LetterSent();
		print.addActionListener(handleSet);
	}


	private  class TheHandler implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			claim=exploreClaims();
			if(claim==null)
			{
				JOptionPane.showMessageDialog(null, "There are no letters to fill");
				removeAll();
				add(checkLetter);
				repaint();
			}
			else	
			{
				JTextArea textArea = new JTextArea("Hello"+" " +claim.getClient().getName()+" " +claim.getClient().getSurname()  +"\n"
						+"the decision about your claim have been" +claim.getDecision() 
						);
				JScrollPane areaScrollPane = new JScrollPane(textArea);
				areaScrollPane.setVerticalScrollBarPolicy(
						JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				areaScrollPane.setPreferredSize(new Dimension(30, 30));
				textArea.setFont(new Font("Serif", Font.ITALIC, 16));
				textArea.setLineWrap(true);
				textArea.setWrapStyleWord(true);
				removeAll();
				setLayout(new FlowLayout());
				add(textArea,BorderLayout.CENTER);
				add(print, BorderLayout.SOUTH);
				repaint();		
			}
		}
	}
	private  class LetterSent implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			claim.setLetterSent(true);
			JOptionPane.showMessageDialog(null, "Letter sent");
			refresh.doClick();
		}
	}

	

	public Claim exploreClaims() {
		Claim claim;
		Iterator<Claim> it = Claim.allClaimsList.iterator();
		while(it.hasNext()){
			claim= it.next();
			if( claim.isLetterSent() == false && claim.isProcessed() == false)
			{
				return claim;
			}
		}
		return null;
	}


}

