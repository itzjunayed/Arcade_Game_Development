package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class EditPage extends JFrame {

	private JLabel label, userNameLabel, emailUpdateLabel, passwordUpdatelabel, updateLabelForPassword;
	private JLabel userNameError, emailErrorLabel, passErrorLabel, oldPassError;
	private JTextField updateEmailText;
	private JPasswordField updatePasswordText, passText;
	private JButton updateButton, backButton;
	private ImageIcon image, background;
	private Font updateFont, errorUpdateFont, labelFont, buttonFont;

	EditPage(User user, int x, int y) {
		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/aboutBack.png");

		label = new JLabel();
		label.setText("UPDATE");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(237, 74, 74));
		label.setFont(new Font("Roboto", Font.BOLD, 30));
		label.setIconTextGap(-65);

		updateFont = new Font("Gotham", Font.BOLD, 18);
		errorUpdateFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);
		labelFont = new Font("Gotham", Font.ITALIC, 15);
		buttonFont = new Font("Gotham", Font.BOLD, 20);

		userNameLabel = new JLabel("Username:      " + user.getUsername());
		userNameLabel.setBounds(10, 60, 250, 50);
		userNameLabel.setFont(updateFont);
		userNameLabel.setForeground(Color.white);
		this.add(userNameLabel);

		userNameError = new JLabel("Username cannot be changed");
		userNameError.setBounds(10, 100, 200, 25);
		userNameError.setFont(errorUpdateFont);
		userNameError.setForeground(Color.red);
		this.add(userNameError);

		emailUpdateLabel = new JLabel("Change Email:");
		emailUpdateLabel.setBounds(10, 130, 200, 50);
		emailUpdateLabel.setFont(updateFont);
		emailUpdateLabel.setForeground(Color.white);
		this.add(emailUpdateLabel);

		emailErrorLabel = new JLabel("");
		emailErrorLabel.setBounds(190, 180, 200, 25);
		emailErrorLabel.setFont(errorUpdateFont);
		emailErrorLabel.setForeground(Color.red);
		this.add(emailErrorLabel);

		updateEmailText = new JTextField(user.getEmail());
		updateEmailText.setHorizontalAlignment(JTextField.CENTER);
		updateEmailText.setBounds(190, 140, 300, 40);
		updateEmailText.setFont(labelFont);
		this.add(updateEmailText);

		passwordUpdatelabel = new JLabel("Change Password:");
		passwordUpdatelabel.setBounds(10, 200, 200, 50);
		passwordUpdatelabel.setFont(updateFont);
		passwordUpdatelabel.setForeground(Color.white);
		this.add(passwordUpdatelabel);

		passErrorLabel = new JLabel("");
		passErrorLabel.setBounds(190, 250, 300, 25);
		passErrorLabel.setFont(errorUpdateFont);
		passErrorLabel.setForeground(Color.red);
		this.add(passErrorLabel);

		updatePasswordText = new JPasswordField(user.getPassword());
		updatePasswordText.setHorizontalAlignment(JTextField.CENTER);
		updatePasswordText.setBounds(190, 210, 300, 40);
		updatePasswordText.setFont(labelFont);
		this.add(updatePasswordText);

		updateLabelForPassword = new JLabel("Current password:");
		updateLabelForPassword.setBounds(10, 270, 200, 50);
		updateLabelForPassword.setFont(updateFont);
		updateLabelForPassword.setForeground(Color.white);
		this.add(updateLabelForPassword);

		oldPassError = new JLabel("");
		oldPassError.setBounds(190, 320, 300, 50);
		oldPassError.setFont(errorUpdateFont);
		oldPassError.setForeground(Color.red);
		this.add(oldPassError);

		passText = new JPasswordField();
		passText.setHorizontalAlignment(JTextField.CENTER);
		passText.setFont(labelFont);
		passText.setBounds(190, 280, 300, 50);
		this.add(passText);

		updateButton = new JButton("UPDATE");
		updateButton.setBounds(250, 400, 150, 50);
		updateButton.setBackground(new Color(153, 76, 0));
		updateButton.setForeground(Color.WHITE);
		updateButton.setFont(buttonFont);
		updateButton.setFocusable(false);
		this.add(updateButton);

		backButton = new JButton("Back");
		backButton.setBackground(Color.orange);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(buttonFont);
		backButton.setBounds(30, 400, 150, 50);
		backButton.setFocusable(false);
		this.add(backButton);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		updateButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Color greenColor = new Color(0, 153, 0);
				Color redColor = new Color(204, 0, 0);

				String userName = user.getUsername();
				String email = updateEmailText.getText();
				Matcher matcher = (Pattern.compile("^(.+)@(.+)$")).matcher(email);
				String newPassword = String.valueOf(updatePasswordText.getPassword());
				String password = String.valueOf(passText.getPassword());
				passText.setText("");

				if ((user.getEmail()).equals(email) && (user.getPassword()).equals(newPassword)
						&& (user.getPassword()).equals(password)) {
					oldPassError.setText("");
					emailErrorLabel.setText("");
					passErrorLabel.setText("");
					JOptionPane.showMessageDialog(null, "Nothing has been changed!", "Not updated", -1);
				} else {

					if (!(email.equals("")) && !(password.equals("")) && password.length() >= 8 && matcher.matches()) {
						if ((user.getPassword()).equals(password)) {
							oldPassError.setText("");

							if ((user.getEmail()).equals(email)) {
								emailErrorLabel.setText("");
							} else {
								user.setEmail(email);
								emailErrorLabel.setText("Email updated");
								emailErrorLabel.setForeground(greenColor);
							}
							if ((user.getPassword()).equals(newPassword)) {
								passErrorLabel.setText("");
							} else {
								user.setPassword(newPassword);
								passErrorLabel.setText("Password updated");
								passErrorLabel.setForeground(greenColor);
							}

							JOptionPane.showMessageDialog(null, "Account successfully updated!", "Updated", -1);
							int score = user.getScore();

							User user = new User(userName, email, newPassword, score);
							user.saveFile();

						} else {
							oldPassError.setText("Wrong Password");
						}
					} else {

						if (email.equals("")) {
							emailErrorLabel.setText("Empty email");
							emailErrorLabel.setForeground(redColor);
						} else if (!(matcher.matches())) {
							emailErrorLabel.setText("Invalid Email format");
							emailErrorLabel.setForeground(redColor);
						} else {
							emailErrorLabel.setText("");
						}
						if (newPassword.equals("")) {
							passErrorLabel.setText("Empty Password");
							passErrorLabel.setForeground(redColor);
						} else if (newPassword.length() < 8) {
							passErrorLabel.setText("Password should have at least 8 characters");
							passErrorLabel.setForeground(redColor);
						} else {
							passErrorLabel.setText("");
						}
						if (password.equals("") || !(user.getPassword()).equals(password)) {
							oldPassError.setText("Wrong Password");
							oldPassError.setForeground(redColor);
						} else {
							oldPassError.setText("");
						}

					}

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
