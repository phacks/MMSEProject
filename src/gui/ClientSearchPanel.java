package gui;

import java.awt.Color;
import java.awt.Component;
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

	private static final JLabel noResultsLabel = new JLabel("No results found");
	private JTextField name = new JTextField("Samama", 20);
	private JTextField surname = new JTextField("", 20);
	private JButton submit = new JButton("Search");
	private JPanel searchPanel = new JPanel();
	private JPanel resultsPanel = new JPanel();

	public ClientSearchPanel(){

		// Creation of fake clients accounts, for the purpose of GUI tests
		Client marion = new Client("Samama", "Marion");
		new Claim(marion, "10000", "2000", "high");
		new Claim(marion, "10000", "2000", "low");

		Client celine = new Client("Samama", "Céline");
		new Claim(celine, "10000", "2000", "normal");



		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		searchPanel.add(name);
		searchPanel.add(surname);
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
			if (surname.getText().equals("")){
				ArrayList<Client> clientsList;
				clientsList = Client.searchClient(name.getText());
				if(clientsList.size() == 0){
					resultsPanel.add(noResultsLabel);
				}
				else{
					Iterator<Client> it = clientsList.iterator();

					Client client;
					while(it.hasNext()){
						client = it.next();
						resultsPanel.add(createClientPanel(client));
					}
				}
			}
			else{
				Client client;
				client = Client.searchClient(name.getText(), surname.getText());
				if(client == null){
					resultsPanel.add(noResultsLabel);
				}
				else{
					resultsPanel.add(createClientPanel(client));
				}
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

		ArrayList<Claim> claimsList = client.getClaimsList();

		Iterator<Claim> it = claimsList.iterator();
		Claim claim;

		while (it.hasNext()){
			claim = it.next();
			clientPanel.add(createClaimPanel(claim));
		}

		return clientPanel;

	}

	private JPanel createClaimPanel(Claim claim) {
		// TODO Auto-generated method stub
		JPanel claimPanel = new JPanel();
		claimPanel.setMaximumSize(new Dimension(800, 100));

		JLabel estimatedDamages = new JLabel("Estimated damages : " + claim.getEstimatedDamages()+ " | ");
		JLabel priceOfCar = new JLabel("Price of the car : " + claim.getPriceOfCar() + " | ");
		JLabel gravity = new JLabel("Gravity : " + claim.getGravity()+ " | ");
		JLabel estimation = new JLabel("Estimation : " + claim.evaluateSeverity());

		claimPanel.add(estimatedDamages);
		claimPanel.add(priceOfCar);
		claimPanel.add(gravity);
		claimPanel.add(estimation);

		return claimPanel;
	}


}
