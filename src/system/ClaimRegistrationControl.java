package system;

import javax.swing.JOptionPane;

public class ClaimRegistrationControl {
	
	public ClaimRegistrationControl()
	{
	
	}
	
	
	public boolean checkinteger( String imput ) {
	    try {
	        Integer.parseInt(imput );
	        return true;
	    }
	    catch( Exception e ) {
	        return false;
	    }
	
	
    }

	public void checktype(String text, String text2, String text3, String text4, String text5) {
		// TODO Auto-generated method stub
		if( checkinteger(text) && !checkinteger(text2)  && !checkinteger(text3) && !checkinteger(text4) && checkinteger(text5)  )
		{
			
			
		}
		else
			JOptionPane.showMessageDialog(null, "Wrong parameter inserted!!! Try again");
		
		
		
	}

	
	


}
