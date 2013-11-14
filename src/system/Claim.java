package system;

import java.util.ArrayList;

public class Claim {
	
	Client claimant;
	private int priceOfCar;
	private int estimatedDamages;
	private String gravity;
	public static ArrayList<Claim> allClaimsList = new ArrayList<Claim>();
	
	public Claim(Client claimant, int priceOfCar, int estimatedDamages, String gravity){
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
