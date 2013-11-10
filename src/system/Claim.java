package system;

import java.util.List;

public class Claim {
	
	Client claimant;
	int priceOfCar;
	int estimatedDamages;
	String gravity;
	public static List<Claim> allClaimsList;
	
	public Claim(Client claimant, int priceOfCar, int estimatedDamages, String gravity){
		this.claimant = claimant;
		this.estimatedDamages = estimatedDamages;
		this.gravity = gravity;
		this.priceOfCar = priceOfCar;
		allClaimsList.add(this);
	}
	
}
