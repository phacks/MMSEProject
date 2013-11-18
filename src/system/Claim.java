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
	private String decision;
	private String date;
	private String licensePlate;
	private String DriversLicenseNumber;
	private boolean otherVehiclesInvolved;
	private boolean formFilled = false;
	private boolean processed = false;
	private boolean letterSent = false;
	private String status = "received";
	public static List<Claim> allClaimsList=new ArrayList<Claim>();
	
	public Claim(Client claimant, String priceOfCar, String estimatedDamages, String gravity){
		this.setClaimant(claimant);
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
		
		int previousAccidents = this.getClaimant().getClaimsList().size() - 1;
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
		this.status = "processed";
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
		this.status = decision;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getLicensePlate() {
		return licensePlate;
	}

	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}

	public String getDriversLicenseNumber() {
		return DriversLicenseNumber;
	}

	public void setDriversLicenseNumber(String driversLicenseNumber) {
		DriversLicenseNumber = driversLicenseNumber;
	}

	public boolean isOtherVehiclesInvolved() {
		return otherVehiclesInvolved;
	}

	public void setOtherVehiclesInvolved(boolean otherVehiclesInvolved) {
		this.otherVehiclesInvolved = otherVehiclesInvolved;
	}

	public boolean isFormFilled() {
		return formFilled;
	}

	public void setFormFilled(boolean formFilled) {
		this.formFilled = formFilled;
	}

	public Client getClaimant() {
		return claimant;
	}

	public void setClaimant(Client claimant) {
		this.claimant = claimant;
	}

	public String getStatus() {
		// TODO Auto-generated method stub
		return status;
	}
	
}
