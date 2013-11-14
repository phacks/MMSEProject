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

	public String getPriceOfCar() {
		return priceOfCar;
	}

	public void setPriceOfCar(String priceOfCar) {
		this.priceOfCar = priceOfCar;
	}

	public String getEstimatedDamages() {
		return estimatedDamages;
	}

	public void setEstimatedDamages(String estimatedDamages2) {
		this.estimatedDamages = estimatedDamages2;
	}

	public String getGravity() {
		return gravity;
	}

	public void setGravity(String gravity) {
		this.gravity = gravity;
	}
	
}
