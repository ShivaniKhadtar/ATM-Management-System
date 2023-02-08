package atmtuto.mainmenu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import atmtuto.service.Operations;

public class WithDraw {

	JFrame frame;
	JLabel balancelbl;
	private JTextField amt;

	Operations ops = new Operations();

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WithDraw window = new WithDraw("1001");
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
	public WithDraw(String accNum) {
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

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("WITHDRAW");
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(160, 90, 130, 25);
		panel.add(lblNewLabel_1_1_1_1_3);

		JLabel lblNewLabel_1_1_1_1_3_1_1 = new JLabel("Your Balance :");
		lblNewLabel_1_1_1_1_3_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1_1.setBounds(80, 124, 140, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1_1);

		balancelbl = new JLabel(ops.getBalance(accNum) + "");
		balancelbl.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		balancelbl.setForeground(new Color(255, 0, 0));
		balancelbl.setBounds(220, 124, 130, 25);
		panel.add(balancelbl);

		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("AMOUNT");
		lblNewLabel_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(70, 160, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1);

		amt = new JTextField();
		amt.setFont(new Font("Bell MT", Font.PLAIN, 14));
		amt.setColumns(10);
		amt.setBounds(200, 160, 150, 25);
		panel.add(amt);

		JButton withDraw = new JButton("WITHDRAW");
		withDraw.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					if (amt.getText().isEmpty() || amt.getText().equals("0")) {
						JOptionPane.showMessageDialog(frame, "Enter valid amount");
					} else if (Integer.valueOf(balancelbl.getText()) < Integer.valueOf(amt.getText())) {
						JOptionPane.showMessageDialog(frame, "Not enough balance");
					} else {

						String msg = ops.withDrawCash(accNum, Integer.valueOf(amt.getText()));
						balancelbl.setText(ops.getBalance(accNum)+"");
						JOptionPane.showMessageDialog(frame, msg);
					}
				} catch (NumberFormatException e2) {
					JOptionPane.showMessageDialog(frame, "Enter valid Amount!!");
				} catch (Exception e3) {
					JOptionPane.showMessageDialog(frame, e3);
				}

			}
		});
		withDraw.setForeground(new Color(0, 0, 102));
		withDraw.setFont(new Font("Bell MT", Font.BOLD, 17));
		withDraw.setBounds(155, 210, 140, 30);
		panel.add(withDraw);

		JLabel back = new JLabel("BACK");
		back.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				MainMenu mn = new MainMenu(accNum);
				mn.frame.setVisible(true);
				frame.dispose();
			}
		});
		back.setHorizontalAlignment(SwingConstants.CENTER);
		back.setForeground(Color.RED);
		back.setFont(new Font("Bell MT", Font.BOLD, 20));
		back.setBounds(165, 250, 120, 25);
		panel.add(back);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 102));
		panel_2.setBounds(0, 290, 450, 10);
		panel.add(panel_2);

	}
}
