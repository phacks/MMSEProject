package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import system.Login;

public class LoginTest {
	
	Login login = new Login();
	
	@Before
	public void init() {
		
	}

	@Test
	public void wrongUserTest() {
		login.checkCredentials("Albert", "az");
		assertTrue(login.getType().equals("error"));
	}
	
	@Test
	public void EmployeeALoginTest() {
		login.checkCredentials("EmployeeA", "pwd");
		assertTrue(login.getType().equals("EmployeeA"));
	}
	
	@Test
	public void EmployeeBLoginTest() {
		login.checkCredentials("EmployeeB", "pwd");
		assertTrue(login.getType().equals("EmployeeB"));
	}
	
	@Test
	public void FinancialLoginTest() {
		login.checkCredentials("Financial", "pwd");
		assertTrue(login.getType().equals("Financial"));
	}
}
