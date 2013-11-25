package system;

import java.util.ArrayList;
import java.util.List;

public class Claim {
// I changed the types in String	
	private Client claimant;
	private String priceOfCar;
	private String estimatedDamages;
	private String gravity;
	private String severity;
	private String decision = "";
	private boolean processed = false;
	private boolean letterSent = false;
	public static List<Claim> allClaimsList=new ArrayList<Claim>();
	
	public Claim(Client claimant, String priceOfCar, String estimatedDamages, String gravity){
		this.claimant = claimant;
		this.setEstimatedDamages(estimatedDamages);
		this.setGravity(gravity);
		this.setPriceOfCar(priceOfCar);
		claimant.addClaim(this);
		this.setSeverity(this.evaluateSeverity());
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
	
	public String evaluateSeverity(){
		// The severity is evaluated based on the price of the car, the cost of damages, 
		// the previous history of accidents and the claim handler's personal opinion
		
		// Formula : (Cost of damage / price of car) + personalOpinion( = 0, 0.15 or 0.3) + (0.1 * number of previous accidents) 
		// If >= 0.5, complex claim
		// If < 0.5, simple claim
		
		int previousAccidents = this.claimant.getClaimsList().size() - 1;
		double personalOpinion = 0.0;
		if (gravity.equals("high")){
			personalOpinion = 0.30;
		}
		else if(gravity.equals("normal")){
			personalOpinion = 0.15;
		}
		else if(gravity.equals("low")){
			personalOpinion = 0.0;
		}
		
		double result = Double.parseDouble(estimatedDamages) / Double.parseDouble(priceOfCar) + personalOpinion +  0.1 * previousAccidents;
		
		if (result >= 0.5){
			return "complex";
		}
		else{
			return "simple";
		}
		
	}

	public String getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = severity;
	}

	public boolean isProcessed() {
		return processed;
	}

	public void setProcessed(boolean processed) {
		this.processed = processed;
	}

	public boolean isLetterSent() {
		return letterSent;
	}

	public void setLetterSent(boolean letterSent) {
		this.letterSent = letterSent;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}
	
	public Client getClient() {
		return claimant;
	}
	
}
