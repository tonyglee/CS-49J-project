package cs49J_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

//The class extends JFrame to allow access to other JFrame in the package
//The class implements ActionListener to use actionlistener 
public class GUI_Login_Page extends JFrame implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private static JTextField usernameText = new JTextField();
	private static JLabel passwordLabel = new JLabel();
	private static JPasswordField passwordText = new JPasswordField();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	
	public GUI_Login_Page() {
		
		//making the frame
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//setting a panel layout
		panel.setLayout(null);
		
		//add username label
		label = new JLabel("Username");
		label.setBounds(200, 150, 80, 25);
		panel.add(label);
		
		//add username textfield
		usernameText = new JTextField();
		usernameText.setBounds(275, 150, 165, 25);
		panel.add(usernameText);
		
		//add password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(200, 200, 80, 25);
		panel.add(passwordLabel);
		
		//add password textfield
		passwordText = new JPasswordField();
		passwordText.setBounds(275, 200, 165, 25);
		panel.add(passwordText);
		
		//add login button
		button = new JButton("Login");
		button.setBounds(275, 230, 80, 25);
		button.addActionListener(this);
		panel.add(button);
		
		//add back button
		button2 = new JButton("Back");
		button2.setBounds(425, 230, 80, 25);
		button2.addActionListener(this);
		panel.add(button2);
		frame.setVisible(true);
	}

	//@param ActionEvent e is the button being pressed
	//actionPerformed is where we set what action is done when the button is pressed
	@Override
	public void actionPerformed(ActionEvent e) {
		//gets the username that the user inputed 
		String userName = usernameText.getText();
		//gets the password that the user inputed
		String passWord = String.valueOf(passwordText.getPassword());
		//if statement to see which button is being pressed
		if(e.getSource() == button) {
			//if the login button is pressed use a try catch to read and write in txt file
			try {
				//making a txt file
				FileReader fr = new FileReader("Login.txt");
				//allows to reading the text
				BufferedReader br = new BufferedReader(fr);
				//empty string 
				String line;
				//while loop that reads the txt files until there is nothing to be read
				while((line = br.readLine()) != null) {
					//if statement to see if the username and password match with what is stored
					if(line.equals(userName+ "\t" + passWord)) {
						//if the username and password match add a pop-up message and go to main GUI
						JFrame complete = new JFrame();
						JOptionPane.showMessageDialog(complete, "Login");
						complete.dispose();
						frame.dispose();
						//add GUI for main page
						break;
					}
				}
				//close the file
				fr.close();
			}catch(Exception f) {}
		}
		//if the back button is pressed
		else if(e.getSource() == button2) {
			//go back to Welcome GUI
			new GUI_Welcome_Page();
			//close the login GUI
			frame.dispose();
			
		}
	}
}
