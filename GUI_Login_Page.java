package cs49J_Project;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

/**
 * This is a class to make the Login page GUI
 * 
 * 
 * @author Ganhee Lee
 * @author Jimin Lee
 */
public class GUI_Login_Page extends JFrame implements ActionListener{
	
	//private static so that other outside classes cannot access these instance variables
	private static GUI_Login_Page instance;
	public String username;
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private static JTextField usernameText = new JTextField();
	private static JLabel passwordLabel = new JLabel();
	private static JPasswordField passwordText = new JPasswordField();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	
	/**
	 * gets the username of the user
	 * 
	 * @return the username of the user
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Private login GUI to make the window for the login page
	 */
	private GUI_Login_Page() {
		
		//making the frame
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//setting a panel layout
		panel.setLayout(null);
		
		//add username label
		label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(250, 150, 80, 25);
		panel.add(label);
		
		//add username textfield
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameText.setBounds(325, 150, 165, 25);
		panel.add(usernameText);
		
		//add password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordLabel.setBounds(250, 200, 80, 25);
		panel.add(passwordLabel);
		
		//add password textfield
		passwordText = new JPasswordField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordText.setBounds(325, 200, 165, 25);
		panel.add(passwordText);
		
		//add login button
		button = new JButton("Login");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(325, 240, 100, 30);
		button.addActionListener(this);
		panel.add(button);
		
		//add back button
		button2 = new JButton("Back");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(450, 240, 100, 30);
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
		//gets the username that the user inputed 
		username = usernameText.getText();
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
					if(line.equals(username+ "\t" + passWord)) {
						//if the username and password match add a pop-up message and go to main GUI
						JFrame complete = new JFrame();
						JOptionPane.showMessageDialog(complete, "Login");
						complete.dispose();
						frame.dispose();
						//add GUI for main page
						GUI_Add_New_Customer.getInstance().showFrame();
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
			GUI_Welcome_Page.getInstance().showFrame();
			//close the login GUI
			frame.dispose();
			
		}
	}
	
	/**
	 * sets the instance of the welcome GUI to be new to be able to use the page
	 * 
	 * @return a new instance of the welcome GUI to be able to use the buttons again
	 */
	public static GUI_Login_Page getInstance() {
		if (instance == null) {
            instance = new GUI_Login_Page();
        }
        return instance;
    }
	
	/**
	 * sets the frame to be visible
	 */
	public static void showFrame() {
		frame.setVisible(true);
	}
}
