package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import system.Claim;
import system.Client;

public class HistoryFrame extends JFrame implements ActionListener {

	private ArrayList<Claim> claimsList = new ArrayList<Claim>();
	private JPanel panel = new JPanel();
	private Client client;
	private JButton close = new JButton("close");

	public HistoryFrame(Client client){
		this.setSize(400, 400);
		this.setTitle("Damage history");
		this.setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
		this.client = client;
		claimsList = client.getClaimsList();
		Iterator<Claim> it = claimsList.iterator();
		Claim claim;
		while (it.hasNext()){
			claim = it.next();
			panel.add(new ClaimPanel(claim));
		}

		close.addActionListener(this);
		panel.add(close);

		this.setContentPane(panel);
		this.setVisible(true);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == close){
			this.dispose();
		}
	}

}
