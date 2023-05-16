package cs49J_Project;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class GUI_Welcome_Page extends JFrame implements ActionListener{
	
	private static JFrame frame = new JFrame();
	private static JPanel panel = new JPanel();
	private static JButton button = new JButton();
	private static JButton button2 = new JButton();
	
	public GUI_Welcome_Page() {
		
		frame.setSize(700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(panel);
		
		panel.setLayout(null);
		
		button = new JButton("Login");
		button.setBounds(275, 170, 150, 50);
		button.addActionListener(this);
		panel.add(button);
		
		button2 = new JButton("Sign-Up");
		button2.setBounds(275, 220, 150, 50);
		button2.addActionListener(this);
		panel.add(button2);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			frame.dispose();
			new GUI_Login_Page();
		}
		else if(e.getSource() == button2) {
			frame.dispose();
			new GUI_Signup_Page();
		}
		
	}
	
	public static void main(String[] args) {
		
		new GUI_Welcome_Page();
	}
}
