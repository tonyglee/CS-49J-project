package cs49J_Project;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;

import javax.swing.*;

public class GUI_Login_Page implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JLabel label = new JLabel();
	private static JTextField usernameText = new JTextField();
	private static JLabel passwordLabel = new JLabel();
	private static JPasswordField passwordText = new JPasswordField();
	private static JButton button = new JButton();
	
	public GUI_Login_Page() {
		
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("Username");
		label.setBounds(200, 150, 80, 25);
		panel.add(label);
		
		usernameText = new JTextField();
		usernameText.setBounds(275, 150, 165, 25);
		panel.add(usernameText);
		
		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(200, 200, 80, 25);
		panel.add(passwordLabel);
		
		passwordText = new JPasswordField();
		passwordText.setBounds(275, 200, 165, 25);
		panel.add(passwordText);
		
		button = new JButton("Login");
		button.setBounds(275, 230, 80, 25);
		button.addActionListener(this);
		panel.add(button);
		
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String userName = usernameText.getText();
		String passWord = String.valueOf(passwordText.getPassword());
		try {
			FileReader fr = new FileReader("Login.txt");
			BufferedReader br = new BufferedReader(fr);
			String line;
			while((line = br.readLine()) != null) {
				if(line.equals(userName+ "\t" + passWord)) {
					JFrame complete = new JFrame();
					JOptionPane.showMessageDialog(complete, "Login");
					complete.dispose();
					frame.dispose();
					break;
				}
			}
			fr.close();
		}catch(Exception f) {}
	}
}
