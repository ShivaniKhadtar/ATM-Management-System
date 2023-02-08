package atmtuto.app;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import atmtuto.mainmenu.MainMenu;
import atmtuto.service.Operations;


public class Login extends ATMTuto {

	public JFrame frame;

	private JTextField accNum;
	private JPasswordField password;

	Operations ops = new Operations();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Login() {
		initialize();
	}

	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 350);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 450, 350);
		frame.getContentPane().add(panel_1);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 450, 80);
		panel_1.add(panel);

		JLabel lblNewLabel = new JLabel("ATM MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel.setBounds(45, 30, 360, 30);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("X");
		lblNewLabel_1_1_1_1_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ops.closeResources();
			}
		});
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1.setBounds(410, 11, 30, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("LOGIN HERE");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(160, 90, 130, 25);
		panel_1.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("ACC NUM.");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(100, 140, 100, 25);
		panel_1.add(lblNewLabel_1_1_1_1_1);

		accNum = new JTextField();
		accNum.setFont(new Font("Bell MT", Font.PLAIN, 14));
		accNum.setColumns(10);
		accNum.setBounds(220, 140, 150, 25);
		panel_1.add(accNum);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("PIN");
		lblNewLabel_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_2.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2.setBounds(100, 190, 100, 25);
		panel_1.add(lblNewLabel_1_1_1_1_2);

		password = new JPasswordField();
		password.setBounds(220, 190, 150, 25);
		panel_1.add(password);

		JButton loginBtn = new JButton("LOGIN");
		loginBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (accNum.getText().isEmpty() || password.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Enter valid Account number and PIN");
				} else {
					if (ops.loginUser(accNum.getText(), password.getText())) {
						MainMenu mn = new MainMenu(accNum.getText());
						mn.frame.setVisible(true);
						frame.dispose();
					} else {
						JOptionPane.showMessageDialog(frame, "Wrong Account Number or PIN");
					}
				}
			}
		});
		loginBtn.setForeground(new Color(0, 0, 102));
		loginBtn.setFont(new Font("Bell MT", Font.BOLD, 17));
		loginBtn.setBounds(175, 250, 100, 30);
		panel_1.add(loginBtn);

		JLabel signUp = new JLabel("SIGN UP");
		signUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				SignUp sp = new SignUp();
				sp.frame.setVisible(true);
				frame.dispose();
			}
		});
		signUp.setHorizontalAlignment(SwingConstants.CENTER);
		signUp.setForeground(new Color(0, 0, 102));
		signUp.setFont(new Font("Bell MT", Font.BOLD, 20));
		signUp.setBounds(175, 300, 100, 25);
		panel_1.add(signUp);

	}
}
