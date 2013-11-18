package gui;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import system.Client;

public class CreateDecisionPanel extends JPanel implements ActionListener
{
	private JLabel decision;
	//private JCheckBox create;
	//private JCheckBox nocreate;
	JRadioButton create = new JRadioButton("Register", true);
	JRadioButton no = new JRadioButton("Don't register", false);

	JRadioButton cheapInsurance = new JRadioButton("Cheap Insurance");
	JRadioButton normalInsurance = new JRadioButton("Normal Insurance");
	JRadioButton expensiveInsurance = new JRadioButton("Expensive Insurance");
	ButtonGroup insuranceGroup = new ButtonGroup();

	private JLabel question;
	private JButton submit;
	private String name;
	private String surname;
	private JLabel horizontalSpace = new JLabel(" ");

	CreateDecisionPanel(String text1, String text2)
	{
		setVisible(true);
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

		question = new JLabel( text1 +" " +text2 +" "+"is not registrated as a client: do you want to register him?");
		add(question);

		name=text1;
		surname=text2;

		ButtonGroup bgroup = new ButtonGroup();
		bgroup.add(create);
		bgroup.add(no);
		add(create);
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
		public void actionPerformed(ActionEvent e) {
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







}
