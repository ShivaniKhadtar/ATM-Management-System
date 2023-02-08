package atmtuto.app;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import com.toedter.calendar.JDateChooser;

import atmtuto.service.Operations;

public class SignUp extends ATMTuto {

	JFrame frame;
	private JTextField accNum;
	private JTextField firstName;
	private JTextField lastName;
	private JTextField PIN;
	private JTextField occupation;
	private JTextField phoneNo;

	Operations ops = new Operations();

	/**
	 * Launch the application.
	 */

//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SignUp window = new SignUp();
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
	public SignUp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 700, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(0, 0, 700, 500);
		frame.getContentPane().add(panel_2);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setForeground(Color.BLACK);
		panel.setBackground(new Color(0, 0, 102));
		panel.setBounds(0, 0, 700, 100);
		panel_2.add(panel);

		JLabel lblNewLabel = new JLabel("ATM MANAGEMENT SYSTEM");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Bell MT", Font.BOLD, 22));
		lblNewLabel.setBounds(170, 30, 360, 30);
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1_1_1_1_1_1_2 = new JLabel("X");
		lblNewLabel_1_1_1_1_1_1_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ops.closeResources();
			}
		});
		lblNewLabel_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_1_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_1_1_1_1_1_2.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_2.setBounds(660, 10, 30, 20);
		panel.add(lblNewLabel_1_1_1_1_1_1_2);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("SIGN UP FORM");
		lblNewLabel_1_1_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1.setForeground(Color.RED);
		lblNewLabel_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(275, 105, 150, 25);
		panel_2.add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Acc Num");
		lblNewLabel_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1.setBounds(10, 140, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1);

		accNum = new JTextField();
		accNum.setToolTipText("only 4 digit number eg., 1001");
		accNum.setFont(new Font("Bell MT", Font.PLAIN, 14));
		accNum.setColumns(10);
		accNum.setBounds(130, 142, 180, 20);
		panel_2.add(accNum);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("First Name");
		lblNewLabel_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 190, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1);

		firstName = new JTextField();
		firstName.setFont(new Font("Bell MT", Font.PLAIN, 14));
		firstName.setColumns(10);
		firstName.setBounds(130, 192, 180, 20);
		panel_2.add(firstName);

		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Last Name");
		lblNewLabel_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 240, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1);

		lastName = new JTextField();
		lastName.setFont(new Font("Bell MT", Font.PLAIN, 14));
		lastName.setColumns(10);
		lastName.setBounds(130, 242, 180, 20);
		panel_2.add(lastName);

		JLabel lblNewLabel_1_1_1_1_1_1_1_2 = new JLabel("Address");
		lblNewLabel_1_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_2.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_2.setBounds(10, 290, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 290, 180, 80);
		panel_2.add(scrollPane);

		JTextArea address = new JTextArea();
		scrollPane.setViewportView(address);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("PIN");
		lblNewLabel_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(410, 140, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_1);

		PIN = new JTextField();
		PIN.setToolTipText("Only 4 digit numbers eg., 1234");
		PIN.setFont(new Font("Bell MT", Font.PLAIN, 14));
		PIN.setColumns(10);
		PIN.setBounds(530, 140, 140, 20);
		panel_2.add(PIN);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_1 = new JLabel("Education");
		lblNewLabel_1_1_1_1_1_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_1_1.setBounds(410, 190, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_1_1);

		JComboBox<String> education = new JComboBox<String>();
		education.setModel(new DefaultComboBoxModel<String>(
				new String[] { "Uneducated", "SSC", "HSC", "DIPLOMA", "Graduate", "PHD" }));
		education.setFont(new Font("Bell MT", Font.PLAIN, 17));
		education.setEditable(true);
		education.setBounds(530, 190, 140, 20);
		panel_2.add(education);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2 = new JLabel("Occupation");
		lblNewLabel_1_1_1_1_1_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_1_2.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_1_2.setBounds(410, 240, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_1_2);

		occupation = new JTextField();
		occupation.setFont(new Font("Bell MT", Font.PLAIN, 14));
		occupation.setColumns(10);
		occupation.setBounds(530, 240, 140, 20);
		panel_2.add(occupation);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1 = new JLabel("Phone");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1.setBounds(410, 290, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_1_2_1);

		phoneNo = new JTextField();
		phoneNo.setFont(new Font("Bell MT", Font.PLAIN, 14));
		phoneNo.setColumns(10);
		phoneNo.setBounds(530, 290, 140, 20);
		panel_2.add(phoneNo);

		JLabel lblNewLabel_1_1_1_1_1_1_1_1_2_1_1 = new JLabel("DOB");
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setFont(new Font("Bell MT", Font.BOLD, 17));
		lblNewLabel_1_1_1_1_1_1_1_1_2_1_1.setBounds(410, 340, 100, 25);
		panel_2.add(lblNewLabel_1_1_1_1_1_1_1_1_2_1_1);

		JDateChooser dob = new JDateChooser();
		dob.getCalendarButton().setFont(new Font("Bell MT", Font.PLAIN, 17));
		dob.setBounds(530, 340, 140, 20);
		panel_2.add(dob);

		JButton SubmitBtn = new JButton("SUBMIT");
		SubmitBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent evt) {

				if (accNum.getText().isEmpty() || firstName.getText().isEmpty() || lastName.getText().isEmpty()
						|| address.getText().isEmpty() || PIN.getText().isEmpty() || occupation.getText().isEmpty()) {
					JOptionPane.showMessageDialog(frame, "Missing information");
				} else if (phoneNo.getText().length() > 10 || phoneNo.getText().length() <= 0) {
					JOptionPane.showMessageDialog(frame, "Enter valid phone no");
				} else if (accNum.getText().length() != 4 && PIN.getText().length() != 4) {
					JOptionPane.showMessageDialog(frame, "size of PIN and Acc Num should be 4");
				} else {
					try {
						Integer.parseInt(accNum.getText());
						Integer.parseInt(PIN.getText());

						String msg;
						if (!ops.isUserPresent(accNum.getText())) {
							msg = ops.registerUser(accNum.getText(), firstName.getText(), lastName.getText(),
									dob.getDate().toString(), phoneNo.getText(), address.getText(),
									education.getSelectedItem().toString(), occupation.getText(), PIN.getText());
						} else {
							msg = "User with Acc num:" + accNum.getText() + " is already present";
						}
						JOptionPane.showMessageDialog(frame, msg);
					} catch (NumberFormatException e2) {
						JOptionPane.showMessageDialog(frame, "Acc Num and PIN only contain 4 numbers");
					} catch (NullPointerException e3) {
						JOptionPane.showMessageDialog(frame, "Enter DOB");
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frame, e);
					}
				}
			}
		});
		SubmitBtn.setForeground(new Color(0, 0, 102));
		SubmitBtn.setFont(new Font("Bell MT", Font.BOLD, 17));
		SubmitBtn.setBounds(290, 400, 120, 30);
		panel_2.add(SubmitBtn);

		JLabel lblNewLabel_1_1_1_1_3 = new JLabel("LOGIN");
		lblNewLabel_1_1_1_1_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login lg = new Login();
				lg.frame.setVisible(true);
				frame.dispose();
			}
		});
		lblNewLabel_1_1_1_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1_1_1_3.setForeground(new Color(0, 0, 102));
		lblNewLabel_1_1_1_1_3.setFont(new Font("Bell MT", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_3.setBounds(290, 450, 120, 25);
		panel_2.add(lblNewLabel_1_1_1_1_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 0, 102));
		panel_1.setBounds(0, 490, 700, 10);
		panel_2.add(panel_1);

	}
}
