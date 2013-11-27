package gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;


public class DecisionFrame extends JFrame{
	public  JButton closeFrame;
	public DecisionFrame(String name, String surname) 
	{
		closeFrame= new JButton();
		setSize(700, 300);	
		FlowLayout flo = new FlowLayout();
		setLayout(flo);
		CreateDecisionPanel createdecisionpanel= new CreateDecisionPanel(name,surname, this);
		add(createdecisionpanel);	
		setVisible(true);	
	}	
}



