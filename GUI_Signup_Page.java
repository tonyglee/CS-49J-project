package cs49J_Project;

import javax.swing.*;

public class GUI_Signup_Page {
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private static JLabel label2 = new JLabel();
	private static JLabel label3 = new JLabel();
	private static JLabel label4 = new JLabel();
	private static JLabel label5 = new JLabel();
	private static JLabel label6 = new JLabel();
	private static JLabel label7 = new JLabel();
	private static JLabel label8 = new JLabel();
	private static JLabel label9 = new JLabel();
	private static JTextField usernameText = new JTextField();
	private static JTextField passwordText = new JTextField();
	private static JTextField firstName = new JTextField();
	private static JTextField lastName = new JTextField();
	private static JTextField address = new JTextField();
	private static JTextField city = new JTextField();
	private static JTextField state = new JTextField();
	private static JTextField zipCode = new JTextField();
	private static JTextField email = new JTextField();
	private static JButton button = new JButton();
	
	public GUI_Signup_Page() {
		
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("Username");
		label.setBounds(100, 50, 80, 25);
		panel.add(label);
		
		usernameText = new JTextField();
		usernameText.setBounds(95, 75, 100, 25);
		panel.add(usernameText);
		
		label8 = new JLabel("Password");
		label8.setBounds(225, 50, 80, 25);
		panel.add(label8);
		
		passwordText = new JTextField();
		passwordText.setBounds(220, 75, 100, 25);
		panel.add(passwordText);
		
		label2 = new JLabel("First Name");
		label2.setBounds(100, 100, 80, 25);
		panel.add(label2);
		
		firstName = new JTextField();
		firstName.setBounds(95, 125, 100, 25);
		panel.add(firstName);
		
		label3 = new JLabel("Last Name");
		label3.setBounds(225, 100, 80, 25);
		panel.add(label3);
		
		lastName = new JTextField();
		lastName.setBounds(220, 125, 100, 25);
		panel.add(lastName);
		
		label4 = new JLabel("Address");
		label4.setBounds(100, 150, 80, 25);
		panel.add(label4);
		
		address = new JTextField();
		address.setBounds(95, 175, 225, 25);
		panel.add(address);
		
		label5 = new JLabel("City");
		label5.setBounds(100, 200, 80, 25);
		panel.add(label5);
		
		city = new JTextField();
		city.setBounds(95, 225, 100, 25);
		panel.add(city);
		
		label6 = new JLabel("State");
		label6.setBounds(220, 200, 80, 25);
		panel.add(label6);
		
		state = new JTextField();
		state.setBounds(220, 225, 100, 25);
		panel.add(state);
		
		label7 = new JLabel("Zip Code");
		label7.setBounds(100, 250, 80, 25);
		panel.add(label7);
		
		zipCode = new JTextField();
		zipCode.setBounds(95, 275, 100, 25);
		panel.add(zipCode);
		
		label9 = new JLabel("Email Address");
		label9.setBounds(100, 300, 100, 25);
		panel.add(label9);
		
		email = new JTextField();
		email.setBounds(95, 325, 225, 25);
		panel.add(email);
		
		button = new JButton("Sign-Up");
		button.setBounds(425, 175, 150, 50);
		panel.add(button);
		
		frame.setVisible(true);
	}
}
