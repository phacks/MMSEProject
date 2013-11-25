package gui;
<<<<<<< HEAD
=======

import java.awt.Component;
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

<<<<<<< HEAD
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
=======
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import system.Client;

public class CreateDecisionPanel extends JPanel implements ActionListener
{
	private JLabel decision;
<<<<<<< HEAD
	JRadioButton create=new JRadioButton("Create",true);
	JRadioButton No=new JRadioButton("Don't create",false);
=======
	//private JCheckBox create;
	//private JCheckBox nocreate;
	JRadioButton create = new JRadioButton("Register", true);
	JRadioButton no = new JRadioButton("Don't register", false);

	JRadioButton cheapInsurance = new JRadioButton("Cheap Insurance");
	JRadioButton normalInsurance = new JRadioButton("Normal Insurance");
	JRadioButton expensiveInsurance = new JRadioButton("Expensive Insurance");
	ButtonGroup insuranceGroup = new ButtonGroup();

>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
	private JLabel question;
	private JButton submit;
	private String name;
	private String surname;
<<<<<<< HEAD
	CreateDecisionPanel(String text1, String text2)
	{
		setVisible(true);
=======
	private JLabel horizontalSpace = new JLabel(" ");
	private DecisionFrame frame;

	CreateDecisionPanel(String text1, String text2, DecisionFrame frame)
	{
		setVisible(true);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		this.frame = frame;

		question = new JLabel( text1 +" " +text2 +" "+"is not registrated as a client: do you want to register him?");
		add(question);

		name=text1;
		surname=text2;

>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(create);
		bgroup.add(no);
		add(create);
<<<<<<< HEAD
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
=======
		add(no);

		create.addActionListener(this);
		no.addActionListener(this);

		normalInsurance.setSelected(true);

		insuranceGroup.add(cheapInsurance);
		insuranceGroup.add(normalInsurance);
		insuranceGroup.add(expensiveInsurance);

		this.add(horizontalSpace);

		this.add(cheapInsurance);
		this.add(normalInsurance);
		this.add(expensiveInsurance);

		submit = new JButton("Submit");
		add(submit);



		handledecision handler= new handledecision();
		submit.addActionListener(handler);

	}

	private  class handledecision implements ActionListener{
>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
		public void actionPerformed(ActionEvent e) {
			DecisionFrame a = null;
			if(create.isSelected())
			{
				if(cheapInsurance.isSelected()){
					Client client= new Client(name,surname,"cheap");
				}
				else if(normalInsurance.isSelected()){
					Client client= new Client(name,surname,"normal");
				}
				else if(expensiveInsurance.isSelected()){
					Client client= new Client(name,surname,"expensive");
				}
				JOptionPane.showMessageDialog(null, "The client is  now inserted: You can fill the claim form");
<<<<<<< HEAD
			}
			else
				JOptionPane.showMessageDialog(null, "Operation Aborted");
			// how to close j panel
			setVisible(false); 

		}
	}
=======
				
				frame.dispose();
			
				

			}
			else

				JOptionPane.showMessageDialog(null, "Operation Aborted");

			setVisible(false);

		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == create){

			this.remove(submit);
			this.add(horizontalSpace );

			this.add(cheapInsurance);
			this.add(normalInsurance);
			this.add(expensiveInsurance);

			this.add(submit);

			this.repaint();
			this.revalidate();
		}

		if(e.getSource() == no){
			this.remove(horizontalSpace);
			this.remove(cheapInsurance);
			this.remove(normalInsurance);
			this.remove(expensiveInsurance);

			this.repaint();
			this.revalidate();
		}
	}







>>>>>>> f82eeaade0e19dd7a74f6d4848bc1b606906191e
}
