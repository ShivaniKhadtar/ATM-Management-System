package atmtuto.app;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;

public class Splash {

	JFrame frame;
	JProgressBar progressBar;

	public Splash() {
		initialize();
	}

	
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 300, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setUndecorated(true);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(new Color(0, 102, 102));
		panel.setBounds(0, 0, 300, 250);
		frame.getContentPane().add(panel);

		JLabel lblNewLabel_1 = new JLabel(" SBK BANK");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(new Color(0, 204, 255));
		lblNewLabel_1.setFont(new Font("Bell MT", Font.BOLD, 25));
		lblNewLabel_1.setBounds(40, 11, 220, 50);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("./img/icon.png"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(80, 80, 140, 100);
		panel.add(lblNewLabel);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Modern No. 20", Font.PLAIN, 12));
		progressBar.setForeground(Color.RED);
		progressBar.setBackground(Color.WHITE);
		progressBar.setBounds(0, 245, 300, 5);
		panel.add(progressBar);

	}

	void fill() {
		int counter = 0;
		while (counter <= 100) {
			progressBar.setValue(counter);
			try {
				Thread.sleep(50);
			} catch (Exception e) {

			}
			counter += 10;
		}
		Login lg = new Login();
		lg.frame.setVisible(true);
		frame.dispose();
	}

}
