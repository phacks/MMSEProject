//package test;
//
//import static org.junit.Assert.assertTrue;
//
//import org.junit.Test;
//
//import system.Claim;
//import system.Client;
//
//public class ClientTest {
//
//	@Test
//	public void newClient(){
//		Client client = new Client("john", "doe");
//		assertTrue(Client.allClientsList != null);
//		
//	}
//	
//	@Test
//	public void searchExistingClient(){
//		Client client2 = new Client("Jane", "Doe");
//		assertTrue((Client.searchClient("Jane", "Doe")).equals(client2));
//	}
//	
//	@Test
//	public void searchNonExistingClient(){
//		assertTrue(Client.searchClient("Edgar", "Poe") == null);
//	}
//	
//	@Test
//	public void searchClientsClaim(){
//		Client client3 = new Client("Rocky", "Balboa");
//		Claim claim = new Claim(client3, "10000", "10000", "Normal");
//		client3.addClaim(claim);
//		assertTrue(Client.searchClient("Rocky", "Balboa").getClaimsList().get(0).equals(claim));
//	}
//
//}
