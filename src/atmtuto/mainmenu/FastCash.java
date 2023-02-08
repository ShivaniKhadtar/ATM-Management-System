package atmtuto.mainmenu;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import atmtuto.service.Operations;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FastCash{

	JFrame frame;
	JLabel balanceLbl;
	
	JButton rs100;
	JButton rs500 ;
	JButton rs5000 ;
	JButton rs50 ;
	JButton rs1000 ;
	JButton rs10000;
	
	Operations ops=new Operations();

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FastCash window = new FastCash();
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
	public FastCash(String accNum) {
		initialize(accNum);
	}
	
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String accNum) {
		frame = new JFrame();
		frame.setBounds(100, 100, 550, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 550, 350);
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
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1.setBounds(560, 10, 30, 20);
		panel_1.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("FASTCASH");
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel_1_1_1.setBounds(210, 90, 120, 25);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel balLbl = new JLabel("Balance :");
		balLbl.setHorizontalAlignment(SwingConstants.CENTER);
		balLbl.setForeground(new Color(0, 0, 102));
		balLbl.setFont(new Font("Bell MT", Font.BOLD, 20));
		balLbl.setBounds(140, 125, 110, 25);
		panel.add(balLbl);
		
		balanceLbl = new JLabel(ops.getBalance(accNum)+"");
		balanceLbl.setFont(new Font("Modern No. 20", Font.PLAIN, 22));
		balanceLbl.setBounds(260, 125, 110, 25);
		panel.add(balanceLbl);
		
		rs100 = new JButton("Rs 100");
		rs100.setForeground(new Color(0, 0, 102));
		rs100.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs100.setBounds(60, 160, 120, 30);
		rs100.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 100);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs100);
		
		rs500 = new JButton("Rs 500");
		rs500.setForeground(new Color(0, 0, 102));
		rs500.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs500.setBounds(60, 220, 120, 30);
		rs500.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 500);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs500);
		
		rs5000 = new JButton("Rs 5000");
		rs5000.setForeground(new Color(0, 0, 102));
		rs5000.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs5000.setBounds(60, 280, 120, 30);
		rs5000.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 5000);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs5000);
		
		rs50 = new JButton("Rs 50");
		rs50.setForeground(new Color(0, 0, 102));
		rs50.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs50.setBounds(350, 160, 140, 30);
		rs50.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 50);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs50);
		
		rs1000 = new JButton("Rs 1000");
		rs1000.setForeground(new Color(0, 0, 102));
		rs1000.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs1000.setBounds(350, 220, 140, 30);
		rs1000.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 1000);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs1000);
		
		rs10000 = new JButton("Rs 10000");
		rs10000.setForeground(new Color(0, 0, 102));
		rs10000.setFont(new Font("Bell MT", Font.BOLD, 17));
		rs10000.setBounds(350, 280, 140, 30);
		rs10000.addMouseListener( new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {
				String msg=ops.withDrawCash(accNum, 10000);
				JOptionPane.showMessageDialog(frame, msg);
			}});
		panel.add(rs10000);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("BACK");
		lblNewLabel_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mn=new MainMenu(accNum);
				mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(204, 0, 0));
		lblNewLabel_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(237, 300, 100, 25);
		panel.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 340, 600, 10);
		panel.add(panel_2);
			
	}
}
