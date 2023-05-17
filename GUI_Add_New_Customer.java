import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;

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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class GUI_Add_New_Customer extends JFrame{
	private static GUI_Add_New_Customer instance;
	private String username;
	
	private static JFrame frame;
	private static JPanel addPanel;
	private static JPanel mainPanel;
	private static JTable table;
	private static JScrollPane scrollPane;
	private static JTextField name;
	private static JComboBox<?> gender; //change
	private static JTextField age;
	private static JTextField phone;
	private static JTextField email;
	private static JTextField totalpoint;
	private static JTextField expiringpoint;
	private static JTextArea note;
	
	// Content of the table
	private String[] headers = new String[] {"Name", "Gender", "Age", "Phone", "E-mail", "Total Point", "Expiring Point", "Note"};
	private String[][] data = Customer_database.getCustomers();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					GUI_Add_New_Customer window = new GUI_Add_New_Customer();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
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
	private GUI_Add_New_Customer() {
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
						
		JLabel programL = new JLabel("Point Messenger System");
		programL.setBounds(240, 33, 276, 47);
		frame.getContentPane().setLayout(new BorderLayout());
		
		
		/**
		 *  [main Panel] Manage and check Customer information using table 
		 */
		// Generate Table panel
		JPanel mainPanel = new JPanel();
		mainPanel.setBounds(0, 0, 800, 500);
		mainPanel.setLayout(new BorderLayout());
		
		
		/**
		 *  [mainPanel: titlePanel] Put 'title' and 'add button' to titlePanel
		 */
		// Title: Customer Information Table
		JPanel titlePanel = new JPanel(new BorderLayout());
		JLabel headL_table = new JLabel("Customer Information Table");
		headL_table.setHorizontalAlignment(SwingConstants.LEFT);
		headL_table.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		titlePanel.add(headL_table, BorderLayout.WEST);
		
		// Button: Add Customer
		JButton addBtn = new JButton("Add Customer");
		addBtn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		titlePanel.add(addBtn, BorderLayout.EAST);

		// Add the titlePanel to the mainPanel
		mainPanel.add(titlePanel, BorderLayout.PAGE_START);
		
		
		
		/**
		 * [mainPanel: tablePanel] Generate table into the 'CENTER' of the mainPanel
		 */				
		// Generate a Table
		JTable table = new JTable(data, headers);
		table.setFillsViewportHeight(true);  
		table.setRowHeight(20); // row height = 20
		table.setFont(new Font("Tahoma", Font.BOLD, 12)); // font
		
		// Make the table scrollable
		JScrollPane scrollPane = new JScrollPane(table);  
		scrollPane.setPreferredSize(new Dimension(500, 280));// set the preferred size of the scroll pane
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		
		TableColumn column = null; // Set the column size
		for (int i = 0; i < 8; i++) {
		    column = table.getColumnModel().getColumn(i);
		    if (i == 0 || i == 4 || i == 7) { //Name, Email, Note
		        column.setPreferredWidth(200); 
		    } else if (i == 2) { // Age
		    	column.setPreferredWidth(40);
		    } else if (i == 3) { // Phone
		    	column.setPreferredWidth(150);	
		    } else if (i == 5 || i == 6) { // Total Point, Expiring Point
		    	column.setPreferredWidth(100); 
		    } else {
		        column.setPreferredWidth(80);
		    }
		}
		
		mainPanel.add(scrollPane, BorderLayout.CENTER);
		
		
		/**
		 * [mainPanel: messagePanel] Automatically generate message including Name, Total point, Expiring point of the customer
		 */
		// Messenger Panel
		JPanel messagePanel = new JPanel();
		messagePanel.setPreferredSize(new Dimension(500, 125)); // set the preferred size of the bottom panel
		messagePanel.setBackground(Color.WHITE); // set the background color to WHITE
		messagePanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		// Write message
		JTextArea messageInfo = new JTextArea("Select a customer in the table."); // label for displaying information about a selected customer
		messageInfo.setForeground(Color.BLACK); // set the text color to Black
		messageInfo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		messagePanel.add(messageInfo); // add the label to the bottom panel
		mainPanel.add(messagePanel, BorderLayout.SOUTH);
		
		// Summation of mainPanel
		mainPanel.revalidate(); // Changes are reflected in the display after modifying components
		mainPanel.repaint();
		mainPanel.setVisible(true);
		
		/**
		 * [Add Panel] Save new customer information to SQL
		 */
		JPanel addPanel = new JPanel();
		addPanel.setBounds(0, 0, 800, 500);
		
		// Create Labels
		JLabel headL_addinfo = new JLabel("Customer Infomation");
		headL_addinfo.setHorizontalTextPosition(SwingConstants.CENTER);
		headL_addinfo.setHorizontalAlignment(SwingConstants.CENTER);
		headL_addinfo.setFont(new Font("Bahnschrift", Font.PLAIN, 28));
		headL_addinfo.setBounds(140, 17, 519, 51);
		addPanel.add(headL_addinfo);
				
		JLabel nameL = new JLabel("Name");
		nameL.setHorizontalAlignment(SwingConstants.LEFT);
		nameL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		nameL.setBounds(80, 71, 50, 37);
		addPanel.add(nameL);
				
		JLabel genderL = new JLabel("Gender");
		genderL.setHorizontalAlignment(SwingConstants.LEFT);
		genderL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		genderL.setBounds(360, 71, 50, 37);
		addPanel.add(genderL);
				
		JLabel ageL= new JLabel("Age");
		ageL.setHorizontalAlignment(SwingConstants.LEFT);
		ageL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		ageL.setBounds(580, 71, 40, 37);
		addPanel.add(ageL);
				
		JLabel phoneL = new JLabel("Phone");
		phoneL.setHorizontalAlignment(SwingConstants.LEFT);
		phoneL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		phoneL.setBounds(80, 118, 50, 37);
		addPanel.add(phoneL);
						
		JLabel emailL = new JLabel("E-mail");
		emailL.setHorizontalAlignment(SwingConstants.LEFT);
		emailL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		emailL.setBounds(360, 118, 60, 37);
		addPanel.add(emailL);
				
		JLabel totalpointL = new JLabel("Total Point");
		totalpointL.setHorizontalAlignment(SwingConstants.LEFT);
		totalpointL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		totalpointL.setBounds(80, 166, 80, 37);
		addPanel.add(totalpointL);
				
		JLabel expiringpointL = new JLabel("Expiring Point");
		expiringpointL.setHorizontalAlignment(SwingConstants.LEFT);
		expiringpointL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		expiringpointL.setBounds(360, 166, 92, 37);
		addPanel.add(expiringpointL);
				
		JLabel noteL = new JLabel("Note");
		noteL.setHorizontalAlignment(SwingConstants.LEFT);
		noteL.setFont(new Font("Tahoma", Font.PLAIN, 15));
		noteL.setBounds(80, 212, 80, 37);
		addPanel.add(noteL);
				
		JButton submitBtn = new JButton("SUBMIT");
		submitBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		submitBtn .setBounds(220, 371, 123, 37);
		addPanel.add(submitBtn);
				
		JButton exitBtn = new JButton("EXIT");
		exitBtn.setFont(new Font("Tahoma", Font.BOLD, 15));
		exitBtn.setBounds(450, 371, 123, 37);
		addPanel.add(exitBtn);
			
				
		// Create customer info Blank
		name = new JTextField();
		name.setFont(new Font("Tahoma", Font.PLAIN, 12));
		name.setBounds(131, 78, 167, 25);
		addPanel.add(name);
		name.setColumns(10);
				
		gender = new JComboBox(new String[] {"Male", "Female", "Others"});
		gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
		gender.setBounds(422, 77, 100, 25);
		addPanel.add(gender);
						
		age = new JTextField();
		age.setFont(new Font("Tahoma", Font.PLAIN, 12));
		age.setColumns(10);
		age.setBounds(618, 77, 100, 25);
		addPanel.add(age);

		phone = new JTextField();
		phone.setFont(new Font("Tahoma", Font.PLAIN, 12));
		phone.setColumns(10);
		phone.setBounds(131, 124, 167, 25);
		addPanel.add(phone);
		
		email = new JTextField();
		email.setFont(new Font("Tahoma", Font.PLAIN, 12));
		email.setColumns(10);
		email.setBounds(422, 124, 296, 25);
		addPanel.add(email);
				
		totalpoint = new JTextField();
		totalpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		totalpoint.setColumns(80);
		totalpoint.setBounds(158, 172, 140, 25);
		addPanel.add(totalpoint);
				
		expiringpoint = new JTextField();
		expiringpoint.setFont(new Font("Tahoma", Font.PLAIN, 12));
		expiringpoint.setColumns(80);
		expiringpoint.setBounds(463, 173, 140, 25);
		addPanel.add(expiringpoint);
				
		note = new JTextArea();
		note.setFont(new Font("Tahoma", Font.PLAIN, 12));
		note.setBounds(131, 223, 587, 114);
		note.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		addPanel.add(note);		
		
		frame.getContentPane().add(addPanel);
		addPanel.setLayout(null);
		addPanel.setVisible(false);
		
		/**
		 * Button Function		
		 */
		// [mainPanel] Add Customer: change mainPanel to addPanel
		addBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mainPanel.setVisible(false);
				addPanel.setVisible(true);
			}
		});
		
		// [addPanel] Submit the customer information to SQL -> move to mainPanel
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
				Customer_database.createCustomer(nameTxt, genderTxt, ageTxt, phoneTxt, emailTxt, totalpointTxt, expiringpointTxt, noteTxt);
				JOptionPane.showMessageDialog(null, "Data has been saved successfully");
				clearText(); //Clear text
				
				// Change panel to 'mainPanel'
				addPanel.setVisible(false);
				mainPanel.setVisible(true);
				table.updateUI();	
			}
		}); 
		
		// [addPanel] Exit from addPanel to mainPanel
		exitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Object[] options = {"Leave", "Resume"};
				int choice = JOptionPane.showOptionDialog(null, "If you leave without submission, the data will not be saved\nAre you sure your leaving this page?",
						"Warning", JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, options, options[0]);
				if (choice==0) { //Leave
					clearText(); //Clear text
					mainPanel.setVisible(true);
					addPanel.setVisible(false);
				}
				else {//Resume
					addPanel.setVisible(true);
				}
			}
		}); 	
		
		/**
		 * [mainPanel: messengerPanel] Write message automatically
		 */		
		// Add a ListSelectionListener to the table
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
		    	    
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting() && table.getSelectedRow() != -1) {
		        	System.out.println("A row has been selected");
		        	
		        	// Recognize table information
		            String nameInfo = table.getValueAt(table.getSelectedRow(), 0).toString();
		            String totalPointInfo = table.getValueAt(table.getSelectedRow(), 5).toString();
		            String expiringPointInfo = table.getValueAt(table.getSelectedRow(), 6).toString();
		            
		            System.out.println("Selected values: " + nameInfo + "\nTotal Points: " + totalPointInfo + "\nExpiring Points: " + expiringPointInfo);
		            
		            // Update the text of the messageInfo
		            if ( totalPointInfo.trim().isEmpty() || expiringPointInfo.trim().isEmpty() ) {
		            	messageInfo.setText("Insufficient Point Information!");
		            }else {
		            	String username = GUI_Login_Page.getInstance().getUsername();
		            	messageInfo.setText("Hello " + nameInfo + 
			            		",\n\nYou have " + totalPointInfo + " points, but " + expiringPointInfo 
			            		+ " points will expire soon. You can check more information in detail on the site.\n\nSincerely,\n"+ username);
		            }   
		        }
		        else {
		        	System.out.println("No valid row selected.");
		        }
				
			}
		});
		
			
		
		/**
		 * [Frame] Frame form and Menu Bar implement
		 */		
		frame.setResizable(false);//Can resize the window(true), limit(false)
		frame.setPreferredSize(new Dimension(800,500)); 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//꺼도 프로그램이 실행되도록 설정
		frame.setJMenuBar(menuBar());
		frame.getContentPane().add(mainPanel);
		frame.pack();
		frame.setLocationRelativeTo(null);//Center the frame on the screen
		frame.setVisible(true);
		
	}
	
	/**
	 * [Frame] Menu Bar
	 */
	public JMenuBar menuBar() {
		JMenuBar bar = new JMenuBar();
		JMenu userMenu = new JMenu("User");
		userMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		JMenu aboutMenu = new JMenu("About");
		userMenu.setFont(new Font("Tahoma", Font.PLAIN, 15));
		bar.add(userMenu);
		bar.add(aboutMenu);
		
		/**
		 * [Menu Bar] User: Log out, Exit
		 */
		JMenuItem logout = new JMenuItem("Log out");
		JMenuItem exit = new JMenuItem("Exit");
		userMenu.add(logout);
		userMenu.addSeparator();
		userMenu.add(exit);
		// Log out Function
		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				GUI_Welcome_Page.getInstance().showFrame();
				frame.dispose();
				addPanel.setVisible(false); // Close existing panel
				mainPanel.setVisible(false); // Close existing panel
				
			}
		});
		// Exit Function
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);		
			}
		});
		
		/**
		 * [Menu Bar] About: developer info
		 */
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
	
	private GUI_Add_New_Customer(String username) {
		this.username = username;
		initialize();
	}
	
	// To Use Same Instance during whole process
	public static GUI_Add_New_Customer getInstance() {
		if (instance == null) {
			instance = new GUI_Add_New_Customer();
		}
	    return instance;
	}
		
	public static void showFrame() {
		frame.setVisible(true);
	}
}

