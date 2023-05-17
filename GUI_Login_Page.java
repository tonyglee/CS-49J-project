import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

//The class extends JFrame to allow access to other JFrame in the package
//The class implements ActionListener to use actionlistener 
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
	
	// Create a getter method to retrieve the userName
	public String getUsername() {
		return username;
	}
	
	private GUI_Login_Page() {
		
		//making the frame
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		//setting a panel layout
		panel.setLayout(null);
		
		//add username label
		label = new JLabel("Username");
		label.setBounds(250, 150, 80, 25);
		panel.add(label);
		
		//add username textfield
		usernameText = new JTextField();
		usernameText.setBounds(325, 150, 165, 25);
		panel.add(usernameText);
		
		//add password label
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(250, 200, 80, 25);
		panel.add(passwordLabel);
		
		//add password textfield
		passwordText = new JPasswordField();
		passwordText.setBounds(325, 200, 165, 25);
		panel.add(passwordText);
		
		//add login button
		button = new JButton("Login");
		button.setBounds(325, 240, 100, 30);
		button.addActionListener(this);
		panel.add(button);
		
		//add back button
		button2 = new JButton("Back");
		button2.setBounds(450, 240, 100, 30);
		button2.addActionListener(this);
		panel.add(button2);
		
		frame.setLocationRelativeTo(null);//컴퓨터 가운데에 창이 나오도록 설정
		frame.setVisible(true);
	}

	//@param ActionEvent e is the button being pressed
	//actionPerformed is where we set what action is done when the button is pressed
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
	
	// To Use Same Instance during whole process
	public static GUI_Login_Page getInstance() {
		if (instance == null) {
            instance = new GUI_Login_Page();
        }
        return instance;
    }
	
	public static void showFrame() {
		frame.setVisible(true);
	}
}