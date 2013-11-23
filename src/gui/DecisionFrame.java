package gui;

import java.awt.FlowLayout;

import javax.swing.JFrame;


	public class DecisionFrame extends JFrame{
		
		public DecisionFrame(String name, String surname) 
		{
			this.setLocationRelativeTo(null);
			setSize(700, 300);
			
			
	
			FlowLayout flo = new FlowLayout();
			setLayout(flo);
			
			//  instance of the panel
			CreateDecisionPanel createdecisionpanel= new CreateDecisionPanel(name,surname, this);
			add(createdecisionpanel);
			
			
			
			
			this.setContentPane(createdecisionpanel);
			setVisible(true);
			
		}
						
	}


