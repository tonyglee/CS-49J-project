package cs49J_Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

/**
 * This is a class to make the Signup page GUI
 * 
 * 
 * @author Ganhee Lee
 * @author Jimin Lee
 */
public class GUI_Signup_Page implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
	private static GUI_Signup_Page instance;
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
	
	/**
	 * Private signup GUI to make the window for the signup page
	 */
	private GUI_Signup_Page() {
		
		//make the frame
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		// Create a panel
		panel.setLayout(null);
		
		//add username label
		label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(100, 50, 80, 25);
		panel.add(label);
		
		//add username textfield
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameText.setBounds(95, 75, 100, 25);
		panel.add(usernameText);
		
		//add password label
		label8 = new JLabel("Password");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label8.setBounds(225, 50, 80, 25);
		panel.add(label8);
		
		//add password textfield
		passwordText = new JTextField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordText.setBounds(220, 75, 100, 25);
		panel.add(passwordText);
		
		//add first name label
		label2 = new JLabel("First Name");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label2.setBounds(100, 100, 80, 25);
		panel.add(label2);
		
		//add first name textfield
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName.setBounds(95, 125, 100, 25);
		panel.add(firstName);
		
		//add last name label
		label3 = new JLabel("Last Name");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label3.setBounds(225, 100, 80, 25);
		panel.add(label3);
		
		//add last name textfield
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName.setBounds(220, 125, 100, 25);
		panel.add(lastName);
		
		//add address label
		label4 = new JLabel("Address");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4.setBounds(100, 150, 80, 25);
		panel.add(label4);
		
		//add address textfield
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(95, 175, 225, 25);
		panel.add(address);
		
		//add city label
		label5 = new JLabel("City");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5.setBounds(100, 200, 80, 25);
		panel.add(label5);
		
		//add city textfield
		city = new JTextField();
		city.setFont(new Font("Tahoma", Font.PLAIN, 15));
		city.setBounds(95, 225, 100, 25);
		panel.add(city);
		
		//add state label
		label6 = new JLabel("State");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label6.setBounds(220, 200, 80, 25);
		panel.add(label6);
		
		//add state textfield
		state = new JTextField();
		state.setFont(new Font("Tahoma", Font.PLAIN, 15));
		state.setBounds(220, 225, 100, 25);
		panel.add(state);
		
		//add zipcode label
		label7 = new JLabel("Zip Code");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label7.setBounds(100, 250, 80, 25);
		panel.add(label7);
		
		//add zipcode textfield
		zipCode = new JTextField();
		zipCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zipCode.setBounds(95, 275, 100, 25);
		panel.add(zipCode);
		
		//add email label
		label9 = new JLabel("Email Address");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label9.setBounds(100, 300, 100, 25);
		panel.add(label9);
		
		//add email textfield
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(95, 325, 225, 25);
		panel.add(email);
		
		//add signup button
		button = new JButton("Sign-Up");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(425, 175, 150, 30);
		button.addActionListener(this);
		panel.add(button);
		
		//add go back button
		button2 = new JButton("Go Back");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(425, 225, 150, 30);
		button2.addActionListener(this);
		panel.add(button2);
		
		frame.setLocationRelativeTo(null);//컴퓨터 가운데에 창이 나오도록 설정
		frame.setVisible(true);
	}

	/**
	 * Takes action after a button is pressed
	 * 
	 * @param e is the actionevent of the button being pressed
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		//if statement to see which button is being pressed
		if(e.getSource() == button) {
			//if the signup button is pressed use try catch to read and write a txt file
			try {
				//make a new txt file
				FileWriter fw = new FileWriter("Login.txt", true);
				//write in the username and password the user input to the txt file
				fw.write(usernameText.getText() + "\t" + passwordText.getText() + "\n");
				//close the txt file
				fw.close();
				//make a new frame
				JFrame complete = new JFrame();
				//show a complete message on the frame
				JOptionPane.showMessageDialog(complete, "Sign-up Completed");
				//close the frame
				complete.dispose();
			}catch (Exception f) {}
			//open up the login GUI page
			GUI_Login_Page.getInstance().showFrame();
			//close the current frame (the signup GUI)
			frame.dispose();
			//if go back button is pressed
		} else if(e.getSource() == button2) {
			//open the welcome GUI
			GUI_Welcome_Page.getInstance().showFrame();
			//close the current frame (the signup GUI)
			frame.dispose();
		}
	}
	
	/**
	 * sets the instance of the welcome GUI to be new to be able to use the page
	 * 
	 * @return a new instance of the welcome GUI to be able to use the buttons again
	 */
	public static GUI_Signup_Page getInstance() {
		if(instance == null) {
            instance = new GUI_Signup_Page();
        }
        return instance;
	}
	
	/**
	 * sets the frame to be visible
	 */
	public void showFrame() {
        frame.setVisible(true);
    }
}
