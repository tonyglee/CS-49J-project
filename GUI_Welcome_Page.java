package cs49J_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

//The class extends JFrame to allow access to other JFrame in the package
//The class implements ActionListener to use actionlistener 
public class GUI_Welcome_Page extends JFrame implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	
	public GUI_Welcome_Page() {
		
		//make the frame
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//set panel layout
		panel.setLayout(null);
		
		//add login button
		button = new JButton("Login");
		button.setBounds(275, 170, 150, 50);
		button.addActionListener(this);
		panel.add(button);
		
		//add signup button
		button2 = new JButton("Sign-Up");
		button2.setBounds(275, 220, 150, 50);
		button2.addActionListener(this);
		panel.add(button2);
		frame.setVisible(true);
	}

	//@param ActionEvent e is the button being pressed
	//actionPerformed is where we set what action is done when the button is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//if statement to see which button is being pressed
		//if login button is pressed
		if(e.getSource() == button) {
			//close the welcome GUI
			frame.dispose();
			//open the login GUI
			new GUI_Login_Page();
		}
		//if the signup button is pressed
		else if(e.getSource() == button2) {
			//close the welcome GUI
			frame.dispose();
			//open the signup GUI
			new GUI_Signup_Page();
		}
		
	}
	
	//main to create the windows
	public static void main(String[] args) {
		
		new GUI_Welcome_Page();
	}
}
