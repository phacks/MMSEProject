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
		this.setEstimatedDamages(estimatedDamages);
		this.setGravity(gravity);
		this.setPriceOfCar(priceOfCar);
		allClaimsList.add(this);
	}

	public int getPriceOfCar() {
		return priceOfCar;
	}

	public void setPriceOfCar(int priceOfCar) {
		this.priceOfCar = priceOfCar;
	}

	public int getEstimatedDamages() {
		return estimatedDamages;
	}

	public void setEstimatedDamages(int estimatedDamages) {
		this.estimatedDamages = estimatedDamages;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	
}
