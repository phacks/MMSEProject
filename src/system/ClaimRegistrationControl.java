package system;

import gui.DecisionFrame;

import javax.swing.JOptionPane;

import system.Claim;
import system.Client;


public class ClaimRegistrationControl {
	
	public ClaimRegistrationControl()
	{
	
	}
	
	
	
	
	public void clienthandling(boolean h,boolean n,String price, String name, String surname, String comments, String estimateddamages){
		Client client;
		client=Client.searchClient(name,surname);
		if ( client != null){
			
			if(h)
			{
				
				Claim claim=new	Claim(client,price,estimateddamages,"high");
				client.addClaim(claim);
				
			}
			else if (n)
			{
				Claim claim=new	Claim(client,price,estimateddamages,"normal");
				client.addClaim(claim);
				
				
			}
			else
			{
				Claim claim=new	Claim(client,price,estimateddamages,"low");
				client.addClaim(claim);
			}
		
			JOptionPane.showMessageDialog(null,"Claim registered"+" "+"for"+name+" " +surname);
		}
		else
	
			
			 createdecision(name,surname);
			 
		
		
	}
	
	
	public boolean checkinteger( String imput ) {
	    try {
	        Integer.parseInt(imput );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	
	
    }

	public boolean checktype(String text, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated method stub
		if( checkinteger(text) && !checkinteger(text2)  && !checkinteger(text3) && !checkinteger(text4) && checkinteger(text5)  )
		{
			return true;
			
			
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong parameter inserted!!! Try again");
			return false;
		}
		
		
	}
	
	public void createdecision(String name,String surname)
	{
		DecisionFrame decisionframe= new DecisionFrame(name,surname);

	}
	
	


}// end class
