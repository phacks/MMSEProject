package gui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import system.Client;

public class CreateDecisionPanel extends JPanel 
{
	private JLabel decision;
	JRadioButton create=new JRadioButton("Create",true);
	JRadioButton No=new JRadioButton("Don't create",false);
	private JLabel question;
	private JButton submit;
	private String name;
	private String surname;
	CreateDecisionPanel(String text1, String text2)
	{
		setVisible(true);
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(create);
		bgroup.add(No);
		add(create);
		add(No);
		question = new JLabel( text1 +" " +text2 +" "+"is not registrated as a client: Do you want to register him?");
		add(question);
		submit = new JButton("Submit");
		add(submit);
		name=text1;
		surname=text2;
		HandleDecision handler= new HandleDecision();
		submit.addActionListener(handler);
	}

	private  class HandleDecision implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			DecisionFrame a = null;
			if(create.isSelected())
			{
				Client client= new Client(name,surname);
				JOptionPane.showMessageDialog(null, "The client is  now inserted: You can fill the claim form");
			}
			else
				JOptionPane.showMessageDialog(null, "Operation Aborted");
			// how to close j panel
			setVisible(false); 

		}
	}
}
