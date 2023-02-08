package atmtuto.mainmenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import atmtuto.app.ATMTuto;
import atmtuto.app.Login;


public class MainMenu extends ATMTuto{

	public JFrame frame;
	private JLabel accNumlbl;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainMenu window = new MainMenu("1001");
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
	public MainMenu(String accNum) {
		initialize(accNum);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String accNum) {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 600, 350);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 0, 600, 80);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(" SBK BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(175, 10, 250, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Select Your Transaction Please");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(125, 45, 375, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Account Number:");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(140, 90, 190, 25);
		panel.add(lblNewLabel_1_1_1);
		
		accNumlbl = new JLabel(accNum);
		accNumlbl.setForeground(Color.RED);
		accNumlbl.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		accNumlbl.setBounds(330, 90, 80, 25);
		panel.add(accNumlbl);
		
		JButton depositeBtn = new JButton("DEPOSITE");
		depositeBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Deposite ds=new Deposite(accNum);
				ds.frame.setVisible(true);
				frame.dispose();
			}
		});
		depositeBtn.setForeground(new Color(0, 0, 102));
		depositeBtn.setFont(new Font("Bell MT", Font.BOLD, 17));
		depositeBtn.setBounds(60, 140, 120, 30);
		panel.add(depositeBtn);
		
		JButton fastCash = new JButton("FASTCASH");
		fastCash.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				FastCash fs=new FastCash(accNum);
				fs.frame.setVisible(true);
				frame.dispose();
			}
		});
		fastCash.setForeground(new Color(0, 0, 102));
		fastCash.setFont(new Font("Bell MT", Font.BOLD, 17));
		fastCash.setBounds(60, 200, 120, 30);
		panel.add(fastCash);
		
		JButton balance = new JButton("BALANCE");
		balance.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Balance ba=new Balance(accNum);
				ba.frame.setVisible(true);
				frame.dispose(); 
			}
		});
		balance.setForeground(new Color(0, 0, 102));
		balance.setFont(new Font("Bell MT", Font.BOLD, 17));
		balance.setBounds(60, 260, 120, 30);
		panel.add(balance);
		
		JButton withdrawBtn = new JButton("WITHDRAW");
		withdrawBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				WithDraw wd=new WithDraw(accNum);
				wd.frame.setVisible(true);
				frame.dispose();
			}
		});
		withdrawBtn.setForeground(new Color(0, 0, 102));
		withdrawBtn.setFont(new Font("Bell MT", Font.BOLD, 17));
		withdrawBtn.setBounds(350, 140, 140, 30);
		panel.add(withdrawBtn);
		
		JButton miniState = new JButton("MINI STATEMENT");
		miniState.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MinStatement ms=new MinStatement(accNum);
				ms.frame.setVisible(true);
				frame.dispose();
			}
		});
		miniState.setForeground(new Color(0, 0, 102));
		miniState.setFont(new Font("Bell MT", Font.BOLD, 17));
		miniState.setBounds(350, 200, 190, 30);
		panel.add(miniState);
		
		JButton changePIN = new JButton("CHANGE PIN");
		changePIN.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ChangePIN ch=new ChangePIN(accNum);
				ch.frame.setVisible(true);
				frame.dispose();
			}
		});
		changePIN.setForeground(new Color(0, 0, 102));
		changePIN.setFont(new Font("Bell MT", Font.BOLD, 17));
		changePIN.setBounds(350, 260, 150, 30);
		panel.add(changePIN);
		
		JLabel logOut = new JLabel("LOG OUT");
		logOut.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg=new Login();
				lg.frame.setVisible(true);
				frame.dispose();
			}
		});
		logOut.setHorizontalAlignment(SwingConstants.CENTER);
		logOut.setForeground(new Color(204, 0, 0));
		logOut.setFont(new Font("Bell MT", Font.BOLD, 20));
		logOut.setBounds(250, 300, 100, 25);
		panel.add(logOut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 340, 600, 10);
		panel.add(panel_2);
		
	}
}
