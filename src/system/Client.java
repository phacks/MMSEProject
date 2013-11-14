package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
	
	private String name;
	private String surname;
	private ArrayList<Claim> claimsList = new ArrayList<Claim>();
	public static List<Client> allClientsList = new ArrayList<Client>();
	public static int counter = 0;
	
	public Client(String name, String surname){
		this.name = name;
		this.surname = surname;
		allClientsList.add(this);
	}


	public void addClaim(Claim claim){
		this.claimsList.add(claim);
	}
	
	public ArrayList<Claim> getClaimsList(){
		return this.claimsList;
	}
	
	public static ArrayList<Client> searchClient(String name){
		Iterator<Client> it = allClientsList.iterator();
		ArrayList<Client> clientsList = new ArrayList<Client>();
		while (it.hasNext()){
			Client client = it.next();
			if (client.getName().equals(name)){
				clientsList.add(client);
			}
		}
		return clientsList;
	}
	
	public static Client searchClient(String name, String surname){
		Iterator<Client> it = allClientsList.iterator();
		Client client;
		while (it.hasNext()){
			client = it.next();
			if (client.getName().equals(name) && client.getSurname().equals(surname)){
				return client;
			}
		}
		return null;
	}
	
	public String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}

	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
