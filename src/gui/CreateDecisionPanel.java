package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;





import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import system.Client;

public class CreateDecisionPanel extends JPanel 
{
	private JLabel decision;
	private JCheckBox create;
	private JCheckBox nocreate;
	private JLabel question;
	private JButton submit;
	private String name;
	private String surname;
	
	CreateDecisionPanel(String text1, String text2)
	{
		setVisible(true);
		question = new JLabel( text1 +" " +text2 +" "+"is not registrated as a client: Do you want to register him?");
		add(question);
		create = new JCheckBox ("Create",true);
	    nocreate = new JCheckBox ("Don't create");
	    add(create);
	    add(nocreate);
		submit = new JButton("Submit");
		add(submit);
		name=text1;
		surname=text2;
		
		
	    
	    handledecision handler= new handledecision();
		submit.addActionListener(handler);
		
	}
	
	private  class handledecision implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(create.isSelected())
			{
				Client client= new Client(name,surname);
				JOptionPane.showMessageDialog(null, "The client is  now inserted: You can fill the claim form");

				
				
			}
			else
			
				JOptionPane.showMessageDialog(null, "Operation Aborted");
		
			setVisible(false);
		}
		
		
		
		
		
	}
	
	
	
	
	
	

}
