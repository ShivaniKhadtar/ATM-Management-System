package atmtuto.mainmenu;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import atmtuto.service.Operations;


public class MinStatement {

	JFrame frame;
	
	DefaultTableModel model;
	private JTable table;
	
	Operations ops = new Operations();

	/**
	 * Launch the application.
	 */
	
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					MinStatement window = new MinStatement("1001");
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
	public MinStatement(String accNum) {
		initialize(accNum);
		ops.displayTr(table,accNum);
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String accNum) {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 700, 500);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 700, 80);
		panel_1.setLayout(null);
		panel_1.setBackground(new Color(0, 0, 102));
		panel.add(panel_1);
		
		JLabel lblNewLabel_1 = new JLabel(" SBK BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(225, 10, 250, 20);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel(" Transaction Details");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel_1_1.setBounds(162, 45, 375, 25);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("MINI STATEMENT");
		lblNewLabel_1_1_1.setBounds(245, 90, 210, 25);
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 22));
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("BACK");
		lblNewLabel_1_1_1_1.setBounds(300, 460, 100, 19);
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
		panel.add(lblNewLabel_1_1_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 490, 700, 10);
		panel_2.setBackground(new Color(0, 0, 102));
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 126, 680, 323);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setBounds(10, 125, 680, 324);
		table.setForeground(Color.BLACK);
		table.setBackground(Color.LIGHT_GRAY);
		table.setFont(new Font("Bell MT", Font.PLAIN, 11));
		scrollPane.setViewportView(table);
		
	}
}
