package system;

import java.util.List;

public class Claimant {
	
	private String name;
	private List<Claim> claimsList;
	
	public Claimant(String name, List<Claim> claimsList){
		this.name = name;
		this.claimsList = claimsList;
	}
	
	public void addClaim(Claim claim){
		this.claimsList.add(claim);
	}
	
	public List<Claim> getClaimsList(){
		return this.claimsList;
	}

}
