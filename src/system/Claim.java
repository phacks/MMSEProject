package system;

import java.util.ArrayList;
import java.util.List;

public class Claim {
// I changed the types in String	
	private Client claimant;
	private String priceOfCar;
	private String estimatedDamages;
	private String gravity;
	public static List<Claim> allClaimsList=new ArrayList<Claim>();
	
	public Claim(Client claimant, String priceOfCar, String estimatedDamages, String gravity){
		this.claimant = claimant;
		this.estimatedDamages = estimatedDamages;
		this.gravity = gravity;
		this.priceOfCar = priceOfCar;
		allClaimsList.add(this);
	}
	
}
