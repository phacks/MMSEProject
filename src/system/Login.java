package system;

import gui.MainPanel;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Login extends Observable{
	
	String type;
	
	public void checkCredentials(String username, String password){
		
		if (username.equals("EmployeeA") && password.equals("pwd")){
			type = "EmployeeA";
		}
		else if (username.equals("EmployeeB") && password.equals("pwd")){
			type = "EmployeeB";
		}
		else if (username.equals("Financial") && password.equals("pwd")){
			type = "Financial";
		}
		else {
			type = "error";
		}
		
		if (! type.equals("error")){
			super.setChanged();
			super.notifyObservers(type);
		}

	}
	

	public void setMainPanel(MainPanel mainPanel) {
		// TODO Auto-generated method stub
		super.addObserver(mainPanel);
	}
	
	public String getType(){
		return type;
	}

}
