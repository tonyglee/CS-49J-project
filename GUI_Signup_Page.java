import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import javax.swing.*;

public class GUI_Signup_Page implements ActionListener{
	
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
	
	
	private GUI_Signup_Page() {
		
		frame.setSize(800, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		label = new JLabel("Username");
		label.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label.setBounds(100, 50, 80, 25);
		panel.add(label);
		
		usernameText = new JTextField();
		usernameText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		usernameText.setBounds(95, 75, 100, 25);
		panel.add(usernameText);
		
		label8 = new JLabel("Password");
		label8.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label8.setBounds(225, 50, 80, 25);
		panel.add(label8);
		
		passwordText = new JTextField();
		passwordText.setFont(new Font("Tahoma", Font.PLAIN, 15));
		passwordText.setBounds(220, 75, 100, 25);
		panel.add(passwordText);
		
		label2 = new JLabel("First Name");
		label2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label2.setBounds(100, 100, 80, 25);
		panel.add(label2);
		
		firstName = new JTextField();
		firstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		firstName.setBounds(95, 125, 100, 25);
		panel.add(firstName);
		
		label3 = new JLabel("Last Name");
		label3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label3.setBounds(225, 100, 80, 25);
		panel.add(label3);
		
		lastName = new JTextField();
		lastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lastName.setBounds(220, 125, 100, 25);
		panel.add(lastName);
		
		label4 = new JLabel("Address");
		label4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label4.setBounds(100, 150, 80, 25);
		panel.add(label4);
		
		address = new JTextField();
		address.setFont(new Font("Tahoma", Font.PLAIN, 15));
		address.setBounds(95, 175, 225, 25);
		panel.add(address);
		
		label5 = new JLabel("City");
		label5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label5.setBounds(100, 200, 80, 25);
		panel.add(label5);
		
		city = new JTextField();
		city.setFont(new Font("Tahoma", Font.PLAIN, 15));
		city.setBounds(95, 225, 100, 25);
		panel.add(city);
		
		label6 = new JLabel("State");
		label6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label6.setBounds(220, 200, 80, 25);
		panel.add(label6);
		
		state = new JTextField();
		state.setFont(new Font("Tahoma", Font.PLAIN, 15));
		state.setBounds(220, 225, 100, 25);
		panel.add(state);
		
		label7 = new JLabel("Zip Code");
		label7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label7.setBounds(100, 250, 80, 25);
		panel.add(label7);
		
		zipCode = new JTextField();
		zipCode.setFont(new Font("Tahoma", Font.PLAIN, 15));
		zipCode.setBounds(95, 275, 100, 25);
		panel.add(zipCode);
		
		label9 = new JLabel("Email Address");
		label9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		label9.setBounds(100, 300, 100, 25);
		panel.add(label9);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 15));
		email.setBounds(95, 325, 225, 25);
		panel.add(email);
		
		button = new JButton("Sign-Up");
		button.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button.setBounds(425, 175, 150, 30);
		button.addActionListener(this);
		panel.add(button);
		
		button2 = new JButton("Go Back");
		button2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		button2.setBounds(425, 225, 150, 30);
		button2.addActionListener(this);
		panel.add(button2);
		
		frame.setLocationRelativeTo(null);//컴퓨터 가운데에 창이 나오도록 설정
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			try {
				FileWriter fw = new FileWriter("Login.txt", true);
				fw.write(usernameText.getText() + "\t" + passwordText.getText() + "\n");
				fw.close();
				JFrame complete = new JFrame();
				JOptionPane.showMessageDialog(complete, "Sign-up Completed");
				complete.dispose();
			}catch (Exception f) {}
			
			GUI_Login_Page.getInstance().showFrame();
			frame.dispose();
		} else if(e.getSource() == button2) {
			GUI_Welcome_Page.getInstance().showFrame();
			frame.dispose();
		}
	}
	
	public static GUI_Signup_Page getInstance() {
		if(instance == null) {
            instance = new GUI_Signup_Page();
        }
        return instance;
	}
	
	public void showFrame() {
        frame.setVisible(true);
    }
}
