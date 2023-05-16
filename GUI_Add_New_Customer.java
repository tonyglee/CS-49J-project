import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.TableColumn;

public class GUI_Add_New_Customer {

	private JFrame frame;
	private JPanel addPanel;
	private JPanel mainPanel;
	private JTextField name;
	private JComboBox gender;
	private JTextField age;
	private JTextField phone;
	private JTextField email;
	private JTextField totalpoint;
	private JTextField expiringpoint;
	private JTextArea note;
//	GUI_Login_Page Login = new GUI_Login_Page();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI_Add_New_Customer window = new GUI_Add_New_Customer();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//Reset customer information
	public void clearText() {
		name.setText("");
		gender.setSelectedIndex(0);
		age.setText("");
		phone.setText("");
		email.setText("");
		totalpoint.setText("");
		expiringpoint.setText("");
		note.setText("");
	}
	
	
	/**
	 * Create the application.
	 */
	public GUI_Add_New_Customer() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Customer_database Customer = new Customer_database();
		 
		// Basic frame
		JFrame frame = new JFrame();
		frame.getContentPane().setBounds(new Rectangle(0, 0, 800, 500));
						
		JLabel programL = new JLabel("Point Messanger System");
		programL.setBounds(240, 33, 276, 47);
		frame.getContentPane().setLayout(null);
		
		
		/**
		 * Table Panel: Manage and check Customer information using table 
		 */
		// Generate Table panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 500);
		mainPanel.setLayout(null);
		
		JPanel tablePanel = new JPanel();
		tablePanel.setBounds(12, 45, 790, 325);
		
//		mainPanel.setVisible(false);
		
		JPanel messagePanel = new JPanel();
		messagePanel.setBounds(12, 371, 790, 120);
		messagePanel.setLayout(null);
				
		// Generate Table
		String[] headers = new String[] {"Name", "Gender", "Age", "Phone", "E-mail", "Total Point", "Expiring Point", "Note"};
		String[][] data = Customer.getCustomers();
//		String[][] data = { {"Kathy", "Female", "12", "123456789", "1sdcsdec0", "222", "111", "dkksksk"},
//		{"COCO", "Male", "12", "123456789", "1sdcsdec0", "222", "111", "dkksksk"}};
		JTable table = new JTable(data, headers);		
		table.setFillsViewportHeight(true);
		table.setBounds(12, 45, 790, 325);
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.BOLD, 12));
		table.setAlignmentX(0);
		table.setSize(790,325);
		table.setPreferredScrollableViewportSize(new Dimension(790, 325));
		
		TableColumn column = null;
		for (int i = 0; i < 8; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 0 || i == 3 || i == 4 || i == 7) { //Name, Phone, Email, Note
		        column.setPreferredWidth(200); 
		    } else if (i == 2) { // Age
		    	column.setPreferredWidth(40); 
		    } else if (i == 5 || i == 6) { // Total Point, Expiring Point
		    	column.setPreferredWidth(120); 
		    } else {
		        column.setPreferredWidth(80);
		    }
		}
		
		tablePanel.add(new JScrollPane(table));
		mainPanel.add(tablePanel);
		mainPanel.add(messagePanel);
		frame.getContentPane().add(mainPanel);
		
		// Add Button
		JButton addBtn = new JButton("Add Customer");
		addBtn.setBounds(634, 11, 165, 25);
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		mainPanel.add(addBtn);
		
		JLabel headL_table = new JLabel("Customer Information Table");
		headL_table.setHorizontalAlignment(SwingConstants.LEFT);
		headL_table.setVerticalTextPosition(SwingConstants.CENTER);
		headL_table.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		headL_table.setBounds(12, 5, 430, 37);
		mainPanel.add(headL_table);
		
		
			
		
		
		/**
		 * [Panel] Add Panel: Save new customer information to SQL
		 */
		JPanel addPanel = new JPanel();
		addPanel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);
		
		// Create Labels
		JLabel headL_addinfo = new JLabel("Customer Infomation");
		headL_addinfo.setHorizontalTextPosition(SwingConstants.CENTER);
		headL_addinfo.setHorizontalAlignment(SwingConstants.CENTER);
		headL_addinfo.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		headL_addinfo.setBounds(146, 29, 519, 51);
		addPanel.add(headL_addinfo);
				
		JLabel nameL = new JLabel("Name");
		nameL.setHorizontalAlignment(SwingConstants.LEFT);
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameL.setBounds(79, 105, 50, 37);
		addPanel.add(nameL);
				
		JLabel genderL = new JLabel("Gender");
		genderL.setHorizontalAlignment(SwingConstants.LEFT);
		genderL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderL.setBounds(359, 105, 50, 37);
		addPanel.add(genderL);
				
		JLabel ageL= new JLabel("Age");
		ageL.setHorizontalAlignment(SwingConstants.LEFT);
		ageL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ageL.setBounds(579, 105, 40, 37);
		addPanel.add(ageL);
				
		JLabel phoneL = new JLabel("Phone");
		phoneL.setHorizontalAlignment(SwingConstants.LEFT);
		phoneL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneL.setBounds(79, 152, 50, 37);
		addPanel.add(phoneL);
						
		JLabel emailL = new JLabel("E-mail");
		emailL.setHorizontalAlignment(SwingConstants.LEFT);
		emailL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailL.setBounds(359, 152, 60, 37);
		addPanel.add(emailL);
				
		JLabel totalpointL = new JLabel("Total Point");
		totalpointL.setHorizontalAlignment(SwingConstants.LEFT);
		totalpointL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalpointL.setBounds(79, 200, 80, 37);
		addPanel.add(totalpointL);
				
		JLabel expiringpointL = new JLabel("Expiring Point");
		expiringpointL.setHorizontalAlignment(SwingConstants.LEFT);
		expiringpointL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		expiringpointL.setBounds(359, 200, 92, 37);
		addPanel.add(expiringpointL);
				
		JLabel noteL = new JLabel("Note");
		noteL.setHorizontalAlignment(SwingConstants.LEFT);
		noteL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noteL.setBounds(79, 246, 80, 37);
		addPanel.add(noteL);
				
		JButton submitBtn = new JButton("SUBMIT");
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		submitBtn .setBounds(220, 416, 123, 37);
		addPanel.add(submitBtn);
				
		JButton exitBtn = new JButton("EXIT");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitBtn.setBounds(450, 416, 123, 37);
		addPanel.add(exitBtn);
			
				
		//customer info (blank)
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name.setBounds(130, 112, 167, 25);
		addPanel.add(name);
		name.setColumns(10);
				
		gender = new JComboBox(new String[] {"Male", "Female", "Others"});
		gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gender.setBounds(421, 111, 100, 25);
		addPanel.add(gender);
						
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 12));
		age.setColumns(10);
		age.setBounds(617, 111, 100, 25);
		addPanel.add(age);

		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phone.setColumns(10);
		phone.setBounds(130, 158, 167, 25);
		addPanel.add(phone);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setColumns(10);
		email.setBounds(421, 158, 296, 25);
		addPanel.add(email);
				
		totalpoint = new JTextField();
		totalpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalpoint.setColumns(80);
		totalpoint.setBounds(157, 206, 140, 25);
		addPanel.add(totalpoint);
				
		expiringpoint = new JTextField();
		expiringpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		expiringpoint.setColumns(80);
		expiringpoint.setBounds(462, 207, 140, 25);
		addPanel.add(expiringpoint);
				
		note = new JTextArea();
		note.setFont(new Font("Tahoma", Font.PLAIN, 12));
		note.setBounds(130, 257, 587, 114);
		note.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		addPanel.add(note);		
		
		JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 800, 500);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);

				
		// [Add] Button function: 사용자 정보 저장하기
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String nameTxt = name.getText();
				String genderTxt = gender.getSelectedItem().toString();
				String ageTxt = age.getText();
				String phoneTxt = phone.getText();
				String emailTxt = email.getText();
				String totalpointTxt = totalpoint.getText();
				String expiringpointTxt = expiringpoint.getText();				
				String noteTxt = note.getText();
				
				//Save customer information
				Customer.createCustomer(nameTxt, genderTxt, ageTxt, phoneTxt, emailTxt, totalpointTxt, expiringpointTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Data has been saved successfully");
				addPanel.setVisible(false);
				mainPanel.setVisible(true);
				clearText();//reset function
			}
		}); 
		
		// [Add] Button function: 사용사 추가화면에서 나가기
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Leave", "Resume"};
				int choice = JOptionPane.showOptionDialog(null, "If you leave without submission, the data will not be saved\nAre you sure your leaving this page?",
						"Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				
				if (choice==0) { //Leave
					clearText();//reset function
					mainPanel.setVisible(true);
					addPanel.setVisible(false);
					
				}
				else {//Resume
					addPanel.setVisible(true);
				}
			}
		}); 
		
				
		// [Table] Button function
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				addPanel.setVisible(true);
			}
		});

		
		
		/**
		 * [Frame] Frame and Menu Bar
		 */
		// [Add] [Table] 전체 창
		frame.setResizable(false);//창 크기 조절 가능하도록(true), 제한(false)
		frame.setVisible(true); //자동으로 보이게 만듦 (false면 자동으로 보이지 않도록)
		frame.setPreferredSize(new Dimension(800, 500));//화면 크기 설정 (Dimension: 가로, 세로 직사각형)
		frame.setSize(825,558); 
		frame.setLocationRelativeTo(null);//컴퓨터 가운데에 창이 나오도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//꺼도 프로그램이 실행되도록 설정
		
		frame.setJMenuBar(menuBar());
	}
	
	// [Add] [Table] Menu Bar
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu userMenu = new JMenu("User");
		userMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JMenu aboutMenu = new JMenu("About");
		userMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bar.add(userMenu);
		bar.add(aboutMenu);
		
		// User
		JMenuItem logout = new JMenuItem("Log out");
		JMenuItem exit = new JMenuItem("Exit");
		userMenu.add(logout);
		userMenu.addSeparator();
		userMenu.add(exit);
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
//				loginPanel.setVisible(true);				
			}
		});
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		});
		
		//About
		JMenuItem prjInfo = new JMenuItem("Project Info");
		aboutMenu.add(prjInfo);
		prjInfo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String participators = "Participators: Gunhee Lee, Jimin Lee\n";
				String purpose = "Purpose: Making a program managing customer information and writing message automatically about total point";
				JOptionPane.showInternalMessageDialog(frame, participators + purpose, "About Project and Us", JOptionPane.INFORMATION_MESSAGE);	
			}
		});	
		return bar;
	}
}
