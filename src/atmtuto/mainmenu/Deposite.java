package atmtuto.mainmenu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import atmtuto.service.Operations;

public class Deposite {

	JFrame frame;
	private JTextField amount;

	Operations ops = new Operations();

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Deposite window = new Deposite("1001");
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
	public Deposite(String accNum) {
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

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("DEPOSITE");
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(165, 90, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3);

		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("AMOUNT");
		lblNewLabel_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(70, 150, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1);

		amount = new JTextField();
		amount.setFont(new Font("Bell MT", Font.PLAIN, 14));
		amount.setColumns(10);
		amount.setBounds(200, 150, 150, 25);
		panel.add(amount);

		JButton deposite = new JButton("DEPOSITE");
		deposite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (amount.getText().isEmpty() || amount.getText().equals("0")) {
					JOptionPane.showMessageDialog(frame, "Enter valid amount");
				} else {
					try {
						String msg = ops.depositeCash(accNum, Integer.parseInt(amount.getText()));
						JOptionPane.showMessageDialog(frame, msg);

					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(frame, "Enter valid amount");
					}catch (Exception e3) {
						JOptionPane.showMessageDialog(frame, e3);
					}
				}
			}
		});
		deposite.setForeground(new Color(0, 0, 102));
		deposite.setFont(new Font("Bell MT", Font.BOLD, 17));
		deposite.setBounds(165, 210, 120, 30);
		panel.add(deposite);

		JLabel lblNewLabel_1_1_1_1_3_2 = new JLabel("BACK");
		lblNewLabel_1_1_1_1_3_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mn = new MainMenu(accNum);
				mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_1_1_1_1_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_2.setForeground(Color.RED);
		lblNewLabel_1_1_1_1_3_2.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_2.setBounds(165, 250, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(0, 0, 102));
		panel_3.setBounds(0, 290, 450, 10);
		panel.add(panel_3);
	}

}
