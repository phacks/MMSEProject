//package test;
//
//import static org.junit.Assert.*;
//
//import org.junit.Before;
//import org.junit.Test;
//
//import system.Login;
//
//public class LoginTest {
//	
//	Login login = new Login();
//	
//	@Before
//	public void init() {
//		
//	}
//
//	@Test
//	public void wrongUserTest() {
//		assertTrue(login.checkCredentials("Albert", "az").equals("error"));
//	}
//	
//	@Test
//	public void EmployeeALoginTest() {
//		assertTrue(login.checkCredentials("EmployeeA", "pwd").equals("EmployeeA"));
//	}
//	
//	@Test
//	public void EmployeeBLoginTest() {
//		assertTrue(login.checkCredentials("EmployeeB", "pwd").equals("EmployeeB"));
//	}
//	
//	@Test
//	public void FinancialLoginTest() {
//		assertTrue(login.checkCredentials("Financial", "pwd").equals("Financial"));
//	}
//}
