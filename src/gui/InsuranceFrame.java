package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import system.Claim;

public class InsuranceFrame extends JFrame implements ActionListener {

	private JPanel panel = new JPanel();
	private JButton yes = new JButton("Yes");
	private JButton no = new JButton("No");
	private Claim claim;

	public InsuranceFrame(Claim claim) {

		this.claim = claim;

		this.setSize(400, 400);
		this.setTitle("Damage history");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		panel.add(new ClaimPanel(claim));
		JPanel label1 = new JPanel();
		JPanel label2 = new JPanel();
		JPanel buttons = new JPanel();

		label1.add(new JLabel("The client has a " + claim.getClaimant().getInsuranceType() + " insurance."));
		label2.add(new JLabel("Does this insurance supposedly covers the claim ?"));

		buttons.add(yes);
		buttons.add(no);
		
		panel.add(label1);
		panel.add(label2);
		panel.add(buttons);
		
		
		
		yes.addActionListener(this);
		no.addActionListener(this);



		this.setContentPane(panel);
		this.setVisible(true);


	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == yes){
			this.dispose();
		}
		if(e.getSource() == no){
			int value = JOptionPane.showOptionDialog(this, "This action will result in the refusal of the claim. Continue ?", "Confirmation", JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);
			if (value == JOptionPane.OK_OPTION){
				claim.setDecision("NotOK");
				this.dispose();
			}
		}

	}

}
