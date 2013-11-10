package system;

public class Claim {
	
	Claimant claimant;
	int priceOfCar;
	int estimatedDamages;
	String gravity;
	
	public Claim(Claimant claimant, int priceOfCar, int estimatedDamages, String gravity){
		this.claimant = claimant;
		this.estimatedDamages = estimatedDamages;
		this.gravity = gravity;
		this.priceOfCar = priceOfCar;
	}
	
}
