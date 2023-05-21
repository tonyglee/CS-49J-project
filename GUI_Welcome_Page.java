package cs49J_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


/**
 * This is a class to make the Welcome page GUI
 * 
 * 
 * @author Ganhee Lee
 * @author Jimin Lee
 */
public class GUI_Welcome_Page extends JFrame implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
	private static GUI_Welcome_Page instance;
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	
	/**
	 * Private welcome GUI to make the window for the welcome page
	 */
	private GUI_Welcome_Page() {
	
		//make the frame
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create a new JPanel with BorderLayout
		panel = new JPanel(new BorderLayout());
		JPanel buttonPanel = new JPanel(new GridBagLayout()); // panel to hold the buttons
		
		// Create a GridBagConstraints instance
	    GridBagConstraints gbc = new GridBagConstraints();
	    gbc.insets = new Insets(10, 10, 10, 10);

	    
		//Add login button
		button = new JButton("Login");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setPreferredSize(new Dimension(200, 50));
		gbc.gridx = 0;
		gbc.gridy = 0;
		button.addActionListener(this);
		buttonPanel.add(button, gbc);
		
		//Add sign-up button
		button2 = new JButton("Sign-Up");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setPreferredSize(new Dimension(200, 50));
		gbc.gridx = 0;
		gbc.gridy = 1;
		button2.addActionListener(this);
		buttonPanel.add(button2, gbc);
		
		// Add the buttonPanel to the center of the panel
		panel.add(buttonPanel, BorderLayout.CENTER);
 		frame.add(panel);
 		
 		// Make the frame pops up on the screen
		frame.setLocationRelativeTo(null); // Center the frame on the screen
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
		//if login button is pressed
		if(e.getSource() == button) {
			//close the welcome GUI
			frame.dispose();
			//open the login GUI
			GUI_Login_Page.getInstance().showFrame();
		}
		//if the sign-up button is pressed
		else if(e.getSource() == button2) {
			//close the welcome GUI
			frame.dispose();
			//open the sign-up GUI
			GUI_Signup_Page.getInstance().showFrame();
		}
		
	}
	
	/**
	 * sets the instance of the welcome GUI to be new to be able to use the page
	 * 
	 * @return a new instance of the welcome GUI to be able to use the buttons again
	 */
	public static GUI_Welcome_Page getInstance() {
		if (instance == null) {
			instance = new GUI_Welcome_Page();
		}
		return instance;
	}
	
	/**
	 * sets the frame to be visible
	 */
	public void showFrame() {
		frame.setVisible(true);
	}
	
	/**
	 * Main method to make the welcome window
	 * @param args the command line argument
	 */
	public static void main(String[] args) {
		getInstance().showFrame();
	}
}
