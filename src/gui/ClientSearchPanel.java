package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.Claim;
import system.Client;

public class ClientSearchPanel extends JPanel implements ActionListener {

	private JTextField name = new JTextField("Samama", 20);
	private JButton submit = new JButton("Search");
	private JPanel searchPanel = new JPanel();
	private JPanel resultsPanel = new JPanel();
	private ArrayList<Client> clientsList;

	public ClientSearchPanel(){

		// Creation of fake clients accounts, for the purpose of GUI tests
		Client marion = new Client("Samama", "Marion");
		marion.addClaim(new Claim(marion, "10000", "2000", "SEVERE"));
		marion.addClaim(new Claim(marion, "10000", "2000", "SEVERE"));
		
		Client marion2 = new Client("Samama", "Marion");
		marion2.addClaim(new Claim(marion, "10000", "2000", "SEVERE"));
		
		Client marion3 = new Client("Samama", "Marion");
		marion3.addClaim(new Claim(marion, "10000", "2000", "SEVERE"));



		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		searchPanel.add(name);
		searchPanel.add(submit);
		this.submit.addActionListener(this);
		this.add(searchPanel);
		
		resultsPanel.setLayout(new BoxLayout(resultsPanel, BoxLayout.PAGE_AXIS));
		
		this.add(resultsPanel);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		if(arg0.getSource() == submit){
			resultsPanel.removeAll();
			clientsList = Client.searchClient(name.getText());
			System.out.println(clientsList);
			Iterator<Client> it = clientsList.iterator();
			Client client;
			while(it.hasNext()){
				client = it.next();
				resultsPanel.add(createClientPanel(client));
			}
			resultsPanel.repaint();
			resultsPanel.revalidate();
		}
	}

	private JPanel createClientPanel(Client client){
		JPanel clientPanel = new JPanel();
		
		clientPanel.setBorder(BorderFactory.createLineBorder(Color.gray));
		
		JLabel clientName = new JLabel("Name : " + client.getName());
		JLabel clientSurname = new JLabel("Surname : " + client.getSurname());
		
		clientPanel.setLayout(new BoxLayout(clientPanel, BoxLayout.PAGE_AXIS));
		
		clientPanel.add(clientName);
		clientPanel.add(clientSurname);
		
		JLabel newClaim = new JLabel("Claim :");
		JLabel estimatedDamages;
		JLabel gravity;
		JLabel priceOfCar;
		
		ArrayList<Claim> claimsList = client.getClaimsList();
		
		Iterator<Claim> it = claimsList.iterator();
		Claim claim;
		
		while (it.hasNext()){
			claim = it.next();
			
			estimatedDamages = new JLabel("Estimated damages : " + claim.getEstimatedDamages());
			gravity = new JLabel("Gravity : " + claim.getGravity());
			priceOfCar = new JLabel("Price of the car : " + claim.getPriceOfCar());
			
			clientPanel.add(newClaim);
			clientPanel.add(estimatedDamages);
			clientPanel.add(gravity);
			clientPanel.add(priceOfCar);
		}
		
		

		return clientPanel;

	}


}
