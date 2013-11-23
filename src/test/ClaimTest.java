package test;

import static org.junit.Assert.assertTrue;
import gui.ClaimDecisionPanel;
import gui.ClaimProcessingPanel;
import gui.DecisionLetterPanel;

import org.junit.Test;

import system.Claim;
import system.Client;

public class ClaimTest {
	
	Claim claimComplex = new Claim(new Client("Miles", "Davis", "normal"), "10000", "2000", "high");
	Client client = new Client("John", "Coltrane", "normal");
	Claim claimSimple = new Claim(client, "10000", "1000", "normal");
	Claim claimComplexHistory = new Claim(client, "10000", "1000", "high");
	
	@Test
	public void newClaimTest(){
		assertTrue(Claim.allClaimsList.contains(claimComplex));
	}
	
	@Test
	public void claimEvaluationTest(){
		assertTrue(claimComplex.evaluateSeverity().equals("complex"));
		assertTrue(claimSimple.evaluateSeverity().equals("simple"));
		assertTrue(claimComplexHistory.evaluateSeverity().equals("complex"));
	}

	@Test
	public void pickDecisionClaimOKTest() {
		Claim claim = new Claim(new Client("Paul", "McCartney", "normal"), "10000", "2000", "high");
		claim.setProcessed(true);
		Claim result = ClaimDecisionPanel.pickClaim();
		assertTrue(result.isProcessed() && result.getDecision() == null);
	}
	
	@Test
	public void pickProcessingClaimOKTest() {
		Claim claim = new Claim(new Client("Ringo", "Starr", "normal"), "10000", "2000", "high");
		Claim result = ClaimProcessingPanel.pickClaim();
		assertTrue(! result.isProcessed());
	}
	
	@Test
	public void pickLetterClaimOKTest() {
		Claim claim = new Claim(new Client("John", "Lennon", "normal"), "10000", "2000", "high");
		claim.setProcessed(true);
		claim.setDecision("OK");
		Claim result = DecisionLetterPanel.pickClaim();
		assertTrue(result.isProcessed() && result.getDecision() == null);
	}
}
