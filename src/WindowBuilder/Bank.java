package WindowBuilder;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;

public class Bank {

	private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	JPanel HomePage;
	JPanel CreatePage;
	JPanel DepositPage;
	JPanel WithdrawPage;
	JPanel StatementPage;
	JLabel lblSuccessfullyAdded;
	JLabel lblBalance_1;
	private JTextField textField_14;
	private JTextArea textArea;
	private JTextArea textArea_1;
	private JTextField textField_13;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bank window = new Bank();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Bank() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @return 
	 */
	
	public int calcDeposit(String id1) {
		
		Connection con2 = null;
		Statement stmnt2 = null;
		int store = 0;
		int d_money = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmnt2 = con2.createStatement();
			ResultSet R = stmnt2.executeQuery("SELECT amount FROM bank.deposit where account_id = '" + id1 + "'");
//			ResultSet R2 = stmnt2.executeQuery("SELECT amount FROM bank.withdrawal where account_id = '" + id1 + "'");
			
			while (R.next()) {
				
				d_money = R.getInt("amount");
//				String w_money = R2.getString("amount");
				
				store = store + d_money; //uses while loop to add the list of amount!!!

			}
			
			
			R.close();
//			R2.close();
			stmnt2.close();
			con2.close();
	
		}
		
		catch(Exception se) {
			
		}
		return store;
	}
	
	
	
	public int calcWithdrawal(String id1) {
		
		Connection con2 = null;
		Statement stmnt2 = null;
		int store = 0;
		int w_money = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
			stmnt2 = con2.createStatement();
			ResultSet R = stmnt2.executeQuery("SELECT amount FROM bank.withdrawal where account_id = '" + id1 + "'");
			
			while (R.next()) {
				
				w_money = R.getInt("amount");
				
				store = store + w_money; //uses while loop to add the list of amount!!!

			}
			
			
			R.close();
			stmnt2.close();
			con2.close();
	
		}
		
		catch(Exception se) {
			
		}
		return store;
	}
	
	public int calcBalance(String id1) {
		return calcDeposit(id1) - calcWithdrawal(id1);
	}
	
	
	
	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new CardLayout(0, 0));
		
		HomePage = new JPanel();
		HomePage.setBackground(new Color(135, 206, 250));
		frame.getContentPane().add(HomePage, "name_3184680428345538");
		
		JButton btnNewButton = new JButton("Create Account");
		btnNewButton.setBounds(90, 75, 128, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		HomePage.setLayout(null);
		HomePage.add(btnNewButton);
		
		JButton btnDepositMoney = new JButton("Deposit Money");
		btnDepositMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DepositPage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		btnDepositMoney.setBounds(126, 109, 128, 23);
		HomePage.add(btnDepositMoney);
		
		JButton btnWithdrawMoney = new JButton("Withdraw Money");
		btnWithdrawMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				WithdrawPage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		btnWithdrawMoney.setBounds(168, 143, 137, 23);
		HomePage.add(btnWithdrawMoney);
		
		JButton btnShowStatement = new JButton("Show Statement");
		btnShowStatement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StatementPage.setVisible(true);
				HomePage.setVisible(false);
			}
		});
		btnShowStatement.setBounds(207, 177, 137, 23);
		HomePage.add(btnShowStatement);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 55);
		panel.setBackground(Color.DARK_GRAY);
		HomePage.add(panel);
		panel.setLayout(null);
		
		JLabel lblBankOfVinu = new JLabel("Bank of Vinu \u2122");
		lblBankOfVinu.setBackground(SystemColor.textHighlight);
		lblBankOfVinu.setBounds(155, 11, 145, 33);
		lblBankOfVinu.setForeground(new Color(224, 255, 255));
		lblBankOfVinu.setFont(new Font("Calibri", Font.BOLD | Font.ITALIC, 21));
		panel.add(lblBankOfVinu);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 227, 434, 34);
		panel_1.setLayout(null);
		panel_1.setBackground(Color.DARK_GRAY);
		HomePage.add(panel_1);
		
		CreatePage = new JPanel();
		frame.getContentPane().add(CreatePage, "name_3184682949509317");
		CreatePage.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create account");
		lblNewLabel.setBounds(37, 11, 105, 43);
		lblNewLabel.setForeground(new Color(0, 204, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		CreatePage.add(lblNewLabel);
		
		JLabel lb2NewLabel = new JLabel("Name:");
		lb2NewLabel.setBounds(37, 79, 105, 14);
		lb2NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CreatePage.add(lb2NewLabel);
		
		JLabel lb3NewLabel = new JLabel("Address:");
		lb3NewLabel.setBounds(37, 104, 105, 14);
		lb3NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CreatePage.add(lb3NewLabel);
		
		JLabel lb4NewLabel = new JLabel("Account Number:");
		lb4NewLabel.setBounds(37, 129, 105, 14);
		lb4NewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CreatePage.add(lb4NewLabel);
		
		JButton btnaddAcc = new JButton("Add Account");
		btnaddAcc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String name = textField.getText();
				String address = textField_1.getText();
				String NAME = name.toUpperCase();
				String acno = address.charAt(0) + NAME + address.charAt(1);
				textField_2.setText(acno);
				lblSuccessfullyAdded.setVisible(true);
				
				Connection con = null;
				Statement stmnt = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "password");
					stmnt = con.createStatement();
					stmnt.executeUpdate("INSERT INTO bank.account values('" + acno + "', '" + name + "' , '" + address +  "')");
					
					stmnt.close();
					con.close();
				}
				
				catch(Exception se) {
					
				}
				
			}
		});
		
		btnaddAcc.setBounds(37, 158, 133, 23);
		CreatePage.add(btnaddAcc);
		
		textField = new JTextField();
		textField.setBounds(84, 77, 86, 20);
		CreatePage.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(94, 104, 86, 20);
		CreatePage.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(143, 127, 105, 20);
		CreatePage.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 0, 434, 61);
		CreatePage.add(panel_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(361, 11, 63, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				CreatePage.setVisible(false);
			}
		});
		panel_2.setLayout(null);
		panel_2.add(btnBack);
		
		lblSuccessfullyAdded = new JLabel("** SUCCESSFULLY ADDED **");
		lblSuccessfullyAdded.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblSuccessfullyAdded.setForeground(new Color(0, 128, 0));
		lblSuccessfullyAdded.setBounds(199, 162, 193, 14);
		CreatePage.add(lblSuccessfullyAdded);
		lblSuccessfullyAdded.setVisible(false);
		
		DepositPage = new JPanel();
		frame.getContentPane().add(DepositPage, "name_3184686803375412");
		DepositPage.setLayout(null);
		
		JLabel label = new JLabel("Deposit Money");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(37, 34, 105, 20);
		label.setBounds(37, 11, 105, 43);
		label.setForeground(new Color(0, 204, 255));
		DepositPage.add(label);
		
		JLabel lblEnterAccountNumber = new JLabel("Enter account number: ");
		lblEnterAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterAccountNumber.setBounds(37, 80, 143, 14);
		DepositPage.add(lblEnterAccountNumber);
		
		textField_3 = new JTextField();
		textField_3.setBounds(178, 78, 143, 20);
		DepositPage.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(240, 170, 62, 14);
		DepositPage.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(240, 194, 62, 14);
		DepositPage.add(lblAddress);
		
		JLabel lblBalance = new JLabel("Balance:");
		lblBalance.setBounds(240, 219, 62, 14);
		DepositPage.add(lblBalance);
		
		textField_4 = new JTextField();
		textField_4.setBounds(312, 167, 112, 20);
		DepositPage.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(312, 191, 112, 20);
		DepositPage.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(312, 216, 112, 20);
		DepositPage.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button = new JButton("...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Connection con = null;
				Statement stmnt = null;
				
				String getid = textField_3.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
					stmnt = con.createStatement();
					ResultSet R = stmnt.executeQuery("SELECT * FROM bank.account where account_id = '" + getid + "'"); 
					
					while (R.next()) {
						
						String id = R.getString("account_id");
						String fname = R.getString("name");
						String address1 = R.getString("address");
						
						textField_4.setText(fname);
						textField_5.setText(address1);
					
						String displayDep = Integer.toString(calcBalance(getid));
						
						textField_6.setText(displayDep);
					}
					
					R.close();
					stmnt.close();
					con.close();
				}
				
				catch(Exception se) {
					
				}
			}
		});
		button.setBounds(331, 77, 37, 23);
		DepositPage.add(button);
		
		JLabel lblEnterAmountTo = new JLabel("Enter amount to deposit: ");
		lblEnterAmountTo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterAmountTo.setBounds(37, 110, 152, 14);
		DepositPage.add(lblEnterAmountTo);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(188, 109, 133, 20);
		DepositPage.add(textField_7);
		
		JButton button_1 = new JButton("...");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Date date = new Date();
				Timestamp ts = new Timestamp(date.getTime());
				String time1 = ts.toString();
				
				int id2 = (int) (Math.random()*1000);
				String iid2 = Integer.toString(id2);
				
				String id1 = textField_3.getText();
				String amount1 = textField_7.getText();
				int Amount1 = Integer.parseInt(amount1);
				
				
				Connection con = null;
				Statement stmnt = null;
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "password");
					stmnt = con.createStatement();
					stmnt.executeUpdate("INSERT INTO bank.deposit values('" + id1 + iid2 + "', '" + id1 + "', " + Amount1 + " , '" + time1 +  "')");
					
					String displayDep = Integer.toString(calcBalance(id1));
					textField_6.setText(displayDep);
					
					stmnt.close();
					con.close();
				}
				
				catch(Exception se) {
					
				}
		
			}
		});
		button_1.setBounds(331, 107, 37, 23);
		DepositPage.add(button_1);
		
		JPanel panel_24 = new JPanel();
		panel_24.setBackground(Color.DARK_GRAY);
		panel_24.setBounds(0, 0, 434, 61);
		DepositPage.add(panel_24);
		
		JButton btnnBack = new JButton("Back");
		btnnBack.setBounds(361, 11, 63, 23);
		btnnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				DepositPage.setVisible(false);
			}
		});
		panel_24.setLayout(null);
		panel_24.add(btnnBack);
		
		WithdrawPage = new JPanel();
		frame.getContentPane().add(WithdrawPage, "name_3184688992482971");
		WithdrawPage.setLayout(null);
		
		JLabel label_1 = new JLabel("Withdraw Money");
		label_1.setBounds(37, 11, 133, 43);
		label_1.setForeground(new Color(0, 204, 255));
		label_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		WithdrawPage.add(label_1);
		
		JLabel label_2 = new JLabel("Enter account number: ");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		label_2.setBounds(37, 80, 143, 14);
		WithdrawPage.add(label_2);
		
		textField_8 = new JTextField();
		textField_8.setBounds(178, 78, 176, 20);
		WithdrawPage.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_3 = new JLabel("Name:");
		label_3.setBounds(240, 170, 62, 14);
		WithdrawPage.add(label_3);
		
		JLabel label_4 = new JLabel("Address:");
		label_4.setBounds(240, 194, 62, 14);
		WithdrawPage.add(label_4);
		
		JLabel label_5 = new JLabel("Balance:");
		label_5.setBounds(240, 219, 62, 14);
		WithdrawPage.add(label_5);
		
		textField_9 = new JTextField();
		textField_9.setBounds(312, 167, 112, 20);
		WithdrawPage.add(textField_9);
		textField_9.setColumns(10);
		
		textField_10 = new JTextField();
		textField_10.setBounds(312, 191, 112, 20);
		WithdrawPage.add(textField_10);
		textField_10.setColumns(10);
		
		textField_11 = new JTextField();
		textField_11.setBounds(312, 216, 112, 20);
		WithdrawPage.add(textField_11);
		textField_11.setColumns(10);
		
		JButton button_2 = new JButton("...");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				Statement stmnt = null;
				
				String getid = textField_8.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
					stmnt = con.createStatement();
					ResultSet R = stmnt.executeQuery("SELECT * FROM bank.account where account_id = '" + getid + "'"); 
					
					while (R.next()) {
						
						String id = R.getString("account_id");
						String fname = R.getString("name");
						String address1 = R.getString("address");
						
						textField_9.setText(fname);
						textField_10.setText(address1);
						
						String displayDep = Integer.toString(calcBalance(getid));
						textField_11.setText(displayDep);
					}
					
					R.close();
					stmnt.close();
					con.close();
				}
				
				catch(Exception se) {
					
				}
			}
		});
		button_2.setBounds(369, 77, 37, 23);
		WithdrawPage.add(button_2);
		
		JLabel lblEnterAmountTo_1 = new JLabel("Enter amount to withdraw: ");
		lblEnterAmountTo_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblEnterAmountTo_1.setBounds(25, 110, 164, 14);
		WithdrawPage.add(lblEnterAmountTo_1);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(188, 109, 166, 20);
		WithdrawPage.add(textField_12);
		
		JButton button_3 = new JButton("...");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date datee = new Date();
				Timestamp tss = new Timestamp(datee.getTime());
				String time2 = tss.toString();
				
				int id3 = (int) (Math.random()*1000);
				String iid3 = Integer.toString(id3);
				
				String id4 = textField_8.getText();
				String amount2 = textField_12.getText();
				int Amount2 = Integer.parseInt(amount2);
				
				
				Connection con = null;
				Statement stmnt = null;
				int bal = Integer.parseInt(textField_11.getText());
				
				try {
					
					if (bal<Amount2) {
						textField_12.setText("** INSUFFICIENT FUNDS **");
					}
					else {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/?useSSL=false", "root", "password");
					stmnt = con.createStatement();
					stmnt.executeUpdate("INSERT INTO bank.withdrawal values('" + id4 + iid3 + "', '" + id4 + "', " + Amount2 + " , '" + time2 +  "')");
					
					stmnt.close();
					con.close();
					
					String displayDep = Integer.toString(calcBalance(id4));
					textField_11.setText(displayDep);
					}
				}
				
				catch(Exception se) {
					
				}
			}
		});
		button_3.setBounds(369, 107, 37, 23);

		WithdrawPage.add(button_3);
		
		JPanel panel_25 = new JPanel();
		panel_25.setBackground(Color.DARK_GRAY);
		panel_25.setBounds(0, 0, 434, 61);
		WithdrawPage.add(panel_25);
		
		JButton btnnnBack = new JButton("Back");
		btnnnBack.setBounds(361, 11, 63, 23);
		btnnnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				WithdrawPage.setVisible(false);
			}
		});
		panel_25.setLayout(null);
		panel_25.add(btnnnBack);
		
		StatementPage = new JPanel();
		frame.getContentPane().add(StatementPage, "name_3189999307491140");
		StatementPage.setLayout(null);
		
		JPanel panel_26 = new JPanel();
		panel_26.setBackground(Color.DARK_GRAY);
		panel_26.setBounds(0, 0, 434, 69);
		StatementPage.add(panel_26);
		
		JButton btnnnnBack = new JButton("Back");
		btnnnnBack.setBounds(357, 11, 67, 20);
		btnnnnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				HomePage.setVisible(true);
				StatementPage.setVisible(false);
			}
		});
		panel_26.setLayout(null);
		panel_26.setLayout(null);
		panel_26.add(btnnnnBack);
		
		textField_14 = new JTextField();
		textField_14.setBounds(298, 38, 77, 20);
		panel_26.add(textField_14);
		textField_14.setColumns(10);
		
		JButton button_4 = new JButton("...");
		button_4.setBounds(385, 38, 39, 20);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = null;
				Statement stmnt = null;
				String inc="";
				String inc1="";
				
				String getid = textField_14.getText();
				textField_13.setVisible(true);
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bank", "root", "password");
					stmnt = con.createStatement();
					ResultSet R = stmnt.executeQuery("SELECT * FROM bank.deposit where account_id = '" + getid + "'"); 
					
					
					while (R.next()) {
						
						int amount = R.getInt("amount");
						String date = R.getString("date");
						
						
						String displayDep = Integer.toString(calcBalance(getid));
						textField_13.setText(displayDep);

						
						inc = inc + "|| " + amount + " || " + date + " ||" + "\n";

					}
					
					textArea.setText("|| Amount || Date & Time ||" + "\n" + inc);
					
			
					
					R.close();
					
					
					
					ResultSet R2 = stmnt.executeQuery("SELECT * FROM bank.withdrawal where account_id = '" + getid + "'"); 
					
					while (R2.next()) {
						
						int amount1 = R2.getInt("amount");
						String date1 = R2.getString("date");
						
						
//						String displayDep1 = Integer.toString(calcBalance(getid));
//						textField_11.setText(displayDep1);
						
						inc1 = inc1 + "|| " + amount1 + " || " + date1 + " ||" + "\n";
						
					}
					
					textArea_1.setText("|| Amount || Date & Time ||" + "\n" + inc1);
					
					
					R2.close();
					stmnt.close();
					con.close();
					
					
				}
				
				catch(Exception se) {
					
				}
				
				
			}
		});
		panel_26.add(button_4);
		
		JLabel lblEnterAccountNumber_1 = new JLabel("Enter ID:");
		lblEnterAccountNumber_1.setBounds(231, 41, 59, 14);
		panel_26.add(lblEnterAccountNumber_1);
		lblEnterAccountNumber_1.setForeground(Color.WHITE);
		lblEnterAccountNumber_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		JLabel label_23 = new JLabel("Your Statement");
		label_23.setBounds(20, 5, 133, 29);
		label_23.setForeground(new Color(0, 204, 255));
		panel_26.add(label_23);
		label_23.setForeground(SystemColor.textHighlight);
		label_23.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(104, 38, 77, 20);
		panel_26.add(textField_13);
		textField_13.setVisible(false);
		
		JLabel lblBalance_1 = new JLabel("Balance:");
		lblBalance_1.setForeground(Color.WHITE);
		lblBalance_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblBalance_1.setBounds(46, 41, 59, 14);
		panel_26.add(lblBalance_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 80, 215, 170);
		StatementPage.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(198, 0, 17, 170);
		panel_3.add(scrollBar);
		
		textArea = new JTextArea();
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 9));
		textArea.setBounds(0, 24, 193, 146);
		panel_3.add(textArea);
		
		JLabel label_7 = new JLabel("Money In");
		label_7.setForeground(SystemColor.textHighlight);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_7.setBounds(66, 0, 64, 14);
		panel_3.add(label_7);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(225, 80, 209, 170);
		StatementPage.add(panel_4);
		
		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(192, 0, 17, 170);
		panel_4.add(scrollBar_1);
		
		JLabel lblMoneyOut = new JLabel("Money Out");
		lblMoneyOut.setForeground(SystemColor.textHighlight);
		lblMoneyOut.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMoneyOut.setBounds(62, 0, 68, 14);
		panel_4.add(lblMoneyOut);
		
		textArea_1 = new JTextArea();
		textArea_1.setFont(new Font("Monospaced", Font.PLAIN, 9));
		textArea_1.setBounds(0, 23, 187, 147);
		panel_4.add(textArea_1);
	}
}
