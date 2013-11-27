package system;

import gui.DashboardPanel;
import gui.DecisionFrame;

import javax.swing.JOptionPane;


public class ClaimRegistrationControl {

	private DashboardPanel dashboard;
	
	public ClaimRegistrationControl(DashboardPanel dashboard)
	{
		this.dashboard = dashboard;
	}
	public void clientHandling(boolean h,boolean n,String price, String name, String surname, String comments, String estimatedDamages){
		Client client;
		client=Client.searchClient(name,surname);
		if ( client != null){
			if(h)
			{
				Claim claim=new	Claim(client,price,estimatedDamages,"high");
			}
			else if (n)
			{
				Claim claim=new	Claim(client,price,estimatedDamages,"normal");
			}
			else
			{
				Claim claim=new	Claim(client,price,estimatedDamages,"low");
			}

			JOptionPane.showMessageDialog(null,"Claim registered"+" "+"for"+" "+name+" " +surname);
			dashboard.refreshNotifications();
		}
		else
			createDecision(name,surname);
	}
	public boolean checkInteger( String imput ) {
		try {
			Integer.parseInt(imput );
			return true;
		}
		catch( Exception e ) {
			return false;
		}
	}
	public boolean checkType(String text, String text2, String text3, String text4, String text5) {
		if( checkInteger(text) && !checkInteger(text2)  && !checkInteger(text3) && !checkInteger(text4) && checkInteger(text5)  )
		{
			return true;
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Wrong parameter inserted!!! Try again");
			return false;
		}
	}
	public void createDecision(String name,String surname)
	{
		DecisionFrame decisionFrame= new DecisionFrame(name,surname);
	}
}
