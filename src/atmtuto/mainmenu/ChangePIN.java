package atmtuto.mainmenu;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import atmtuto.service.Operations;

public class ChangePIN {

	JFrame frame;
	private JTextField newPIN;
	private JTextField confirmPIN;

	Operations ops = new Operations();

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				ChangePIN window = new ChangePIN("1001");
//				window.frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//  }

	/**
	 * Create the application.
	 */

	public ChangePIN(String accNum) {
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

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("Change PIN");
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(165, 90, 120, 25);
		panel.add(lblNewLabel_1_1_1_1_3);

		JLabel lblNewLabel_1_1_1_1_3_1 = new JLabel("New PIN       :");
		lblNewLabel_1_1_1_1_3_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_3_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1.setBounds(60, 126, 131, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1);

		newPIN = new JTextField();
		newPIN.setFont(new Font("Bell MT", Font.PLAIN, 14));
		newPIN.setColumns(10);
		newPIN.setBounds(200, 126, 150, 25);
		panel.add(newPIN);

		JLabel lblNewLabel_1_1_1_1_3_1_1 = new JLabel("Confirm PIN :");
		lblNewLabel_1_1_1_1_3_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_3_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3_1_1.setBounds(60, 175, 131, 25);
		panel.add(lblNewLabel_1_1_1_1_3_1_1);

		confirmPIN = new JTextField();
		confirmPIN.setFont(new Font("Bell MT", Font.PLAIN, 14));
		confirmPIN.setColumns(10);
		confirmPIN.setBounds(200, 175, 150, 25);
		panel.add(confirmPIN);

		JButton change = new JButton("CHANGE");
		change.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (newPIN.getText().isEmpty() || confirmPIN.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Missing information");
				} else if (!newPIN.getText().equals(confirmPIN.getText())) {
					JOptionPane.showMessageDialog(frame, "New PIN and Confirm PIN are not same");
				} else if (newPIN.getText().length() != 4) {
					JOptionPane.showMessageDialog(frame, "size of PIN should be 4");
				} else {
					try {
						Integer.parseInt(newPIN.getText());
						String msg = ops.changePin(confirmPIN.getText(), accNum);
						JOptionPane.showMessageDialog(frame, msg);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(frame, "PIN only includes 4 numbers");
					} catch (Exception e3) {
						JOptionPane.showMessageDialog(frame, e3);
					}
				}
			}
		});
		change.setForeground(new Color(0, 0, 102));
		change.setFont(new Font("Bell MT", Font.BOLD, 17));
		change.setBounds(165, 210, 120, 30);
		panel.add(change);

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
