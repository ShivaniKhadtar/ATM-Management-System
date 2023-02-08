package atmtuto.mainmenu;

import atmtuto.service.Operations;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;


import javax.swing.SwingConstants;

import atmtuto.app.ATMTuto;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Balance extends ATMTuto{

	JFrame frame;
	JLabel accNumLbl;
	JLabel balanceLbl;
	
	Operations ops=new Operations();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Balance window = new Balance("1001");
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public Balance(String accNum) {
		initialize(accNum);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String accNum) {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 450, 300);
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 0, 450, 80);
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(" SBK BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(100, 10, 250, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("ATM MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel.setBounds(45, 40, 360, 30);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("CHECK YOUR BALANCE");
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(105, 90, 240, 25);
		panel.add(lblNewLabel_1_1_1_1_3);
		
		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("Account Num :");
		lblNewLabel_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_3_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(70, 140, 138, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1);
		
		accNumLbl = new JLabel(accNum);
		accNumLbl.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		accNumLbl.setBounds(210, 140, 140, 25);
		panel.add(accNumLbl);
		
		JLabel lblNewLabel_1_1_1_1_3_1_1 = new JLabel("Your Balance :");
		lblNewLabel_1_1_1_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_3_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1_1.setBounds(70, 190, 138, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1_1);
		
		balanceLbl = new JLabel(ops.getBalance(accNum)+"");
		balanceLbl.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		balanceLbl.setBounds(210, 190, 140, 25);
		panel.add(balanceLbl);
		
		JLabel lblNewLabel_1_1_1_1_3_2 = new JLabel("BACK");
		lblNewLabel_1_1_1_1_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mn=new MainMenu(accNum);
				mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_1_1_1_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_2.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_3_2.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_2.setBounds(165, 250, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 290, 450, 10);
		panel.add(panel_2);

	}
}
