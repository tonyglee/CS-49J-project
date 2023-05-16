package cs49J_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

//The class extends JFrame to allow access to other JFrame in the package
//The class implements ActionListener to use actionlistener 
public class GUI_Signup_Page extends JFrame implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
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
	private static JButton button2 = new JButton();
	
	public GUI_Signup_Page() {
		
		//make the frame
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//set panel layout 
		panel.setLayout(null);
		
		//add username label
		label = new JLabel("Username");
		label.setBounds(100, 50, 80, 25);
		panel.add(label);
		
		//add usernmae textfield
		usernameText = new JTextField();
		usernameText.setBounds(95, 75, 100, 25);
		panel.add(usernameText);
		
		//add password label
		label8 = new JLabel("Password");
		label8.setBounds(225, 50, 80, 25);
		panel.add(label8);
		
		//add password textfield
		passwordText = new JTextField();
		passwordText.setBounds(220, 75, 100, 25);
		panel.add(passwordText);
		
		//add first name label
		label2 = new JLabel("First Name");
		label2.setBounds(100, 100, 80, 25);
		panel.add(label2);
		
		//add first name textfield
		firstName = new JTextField();
		firstName.setBounds(95, 125, 100, 25);
		panel.add(firstName);
		
		//add last name label
		label3 = new JLabel("Last Name");
		label3.setBounds(225, 100, 80, 25);
		panel.add(label3);
		
		//add last name textfield
		lastName = new JTextField();
		lastName.setBounds(220, 125, 100, 25);
		panel.add(lastName);
		
		//add address label
		label4 = new JLabel("Address");
		label4.setBounds(100, 150, 80, 25);
		panel.add(label4);
		
		//add address textfield
		address = new JTextField();
		address.setBounds(95, 175, 225, 25);
		panel.add(address);
		
		//add city label
		label5 = new JLabel("City");
		label5.setBounds(100, 200, 80, 25);
		panel.add(label5);
		
		//add city textfield
		city = new JTextField();
		city.setBounds(95, 225, 100, 25);
		panel.add(city);
		
		//add state label
		label6 = new JLabel("State");
		label6.setBounds(220, 200, 80, 25);
		panel.add(label6);
		
		//add state textfield
		state = new JTextField();
		state.setBounds(220, 225, 100, 25);
		panel.add(state);
		
		//add zipcode label
		label7 = new JLabel("Zip Code");
		label7.setBounds(100, 250, 80, 25);
		panel.add(label7);
		
		//add zipcode textfield
		zipCode = new JTextField();
		zipCode.setBounds(95, 275, 100, 25);
		panel.add(zipCode);
		
		//add email label
		label9 = new JLabel("Email Address");
		label9.setBounds(100, 300, 100, 25);
		panel.add(label9);
		
		//add email textfield
		email = new JTextField();
		email.setBounds(95, 325, 225, 25);
		panel.add(email);
		
		//add signup button
		button = new JButton("Sign-Up");
		button.setBounds(425, 175, 150, 50);
		button.addActionListener(this);
		panel.add(button);
		
		//add back button
		button2 = new JButton("Back");
		button2.setBounds(425, 225, 150, 50);
		button2.addActionListener(this);
		panel.add(button2);
		
		frame.setVisible(true);
	}
	

	//@param ActionEvent e is the button being pressed
	//actionPerformed is where we set what action is done when the button is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//if statement to see which button is being pressed
		if(e.getSource() == button) {
			//if the login button is pressed use a try catch to read and write in txt file
			try {
				//making a txt file
				FileWriter fw = new FileWriter("Login.txt", true);
				//writes all the information from the user to the txt file
				fw.write(usernameText.getText() + "\t" + passwordText.getText() + 
						//"\t" + firstName.getText() + "\t" + lastName.getText() + 
						//"\t" + address.getText() + "\t" + city.getText() + 
						//"\t" + state.getText() + "\t" + zipCode.getText() + 
						//"\t" + email.getText() + 
						"\n");
				//close the file
				fw.close();
				//make a pop-up message
				JFrame complete = new JFrame();
				JOptionPane.showMessageDialog(complete, "Sign-up Completed");
				complete.dispose();
			}catch (Exception f) {}
			
			//opens the login GUI
			new GUI_Login_Page();
			//closes the signup GUI
			frame.dispose();
		}
		//if the back button is pressed
		if(e.getSource() == button2) {
			//close the signup GUI
			frame.dispose();
			//opens the welcome GUI
			new GUI_Welcome_Page();
		}
	}
}
