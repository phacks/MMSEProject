package test;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import system.Claim;
import system.Client;

public class ClaimTest {
	
	Claim claimComplex = new Claim(new Client("Miles", "Davis"), "10000", "2000", "high");
	Client client = new Client("John", "Coltrane");
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

}
