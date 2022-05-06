package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class DeletePage extends JFrame {
	private JLabel label, updateLabelForPassword, oldPassError;
	private JPasswordField passText;
	private JButton deleteButton, backButton;
	private ImageIcon image, background;
	private Font title, textFieldFont, errorUpdateFont, labelFont, buttonFont;

	public DeletePage(User user, int x, int y) {
		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/aboutBack.png");

		title = new Font("Roboto", Font.BOLD, 30);
		textFieldFont = new Font("Gotham", Font.ITALIC, 15);
		errorUpdateFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);
		labelFont = new Font("Gotham", Font.BOLD, 18);
		buttonFont = new Font("Gotham", Font.BOLD, 20);

		label = new JLabel();
		label.setText("DELETE ACCOUNT");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.red);
		label.setFont(title);
		label.setIconTextGap(-65);

		updateLabelForPassword = new JLabel("Enter password to delete your account");
		updateLabelForPassword.setBounds(80, 170, 500, 50);
		updateLabelForPassword.setFont(labelFont);
		updateLabelForPassword.setForeground(Color.white);
		this.add(updateLabelForPassword);

		oldPassError = new JLabel("");
		oldPassError.setBounds(100, 260, 300, 50);
		oldPassError.setFont(errorUpdateFont);
		oldPassError.setForeground(Color.red);
		this.add(oldPassError);

		passText = new JPasswordField();
		passText.setHorizontalAlignment(JTextField.CENTER);
		passText.setFont(textFieldFont);
		passText.setBounds(100, 220, 300, 50);
		this.add(passText);

		deleteButton = new JButton("DELETE");
		deleteButton.setBounds(290, 350, 150, 50);
		deleteButton.setBackground(Color.red);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(buttonFont);
		deleteButton.setFocusable(false);
		this.add(deleteButton);

		backButton = new JButton("Back");
		backButton.setBackground(Color.green);
		backButton.setForeground(Color.black);
		backButton.setFont(buttonFont);
		backButton.setBounds(50, 350, 150, 50);
		backButton.setFocusable(false);
		this.add(backButton);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String password = String.valueOf(passText.getPassword());
				if (user.getPassword().equals(password)) {
					user.deleteAccount();
					JOptionPane.showMessageDialog(null, "Account deleted!", "Delete", -1);
					Point point = getLocation();
					int x = (int) point.getX();
					int y = (int) point.getY();
					MainPage main = new MainPage(x, y);
					main.setVisible(true);
					dispose();
				} else {
					oldPassError.setText("Wrong Password");
					oldPassError.setForeground(Color.RED);
				}
			}
		});

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				PersonalPage back = new PersonalPage(user, x, y);
				back.setVisible(true);
				dispose();
			}
		});
	}
}
