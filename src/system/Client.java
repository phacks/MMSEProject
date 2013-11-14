package system;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Client {
	
	private String name;
	private String surname;
	private static List<Claim> claimsList = new ArrayList<Claim>();
	public static List<Client> allClientsList = new ArrayList<Client>();
	public static int counter = 0;
	


	


	public Client(String name, String surname) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.surname = surname;
		allClientsList.add(this);
	}









	public  void addClaim(Claim claim){ // I added static and removed this
		claimsList.add(claim);
	}
	
	public List<Claim> getClaimsList(){
		return this.claimsList;
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
	
	private String getSurname() {
		// TODO Auto-generated method stub
		return surname;
	}

	private String getName() {
		// TODO Auto-generated method stub
		return name;
	}
	
}
