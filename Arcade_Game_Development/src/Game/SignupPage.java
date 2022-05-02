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

public class SignupPage extends JFrame {

	private ImageIcon image, background;
	private JLabel label, usernameLabel, emailLabel, passwordLabel;
	private JLabel usernameError, emailError, passwordError;
	private JButton createButton, homeButton;
	private Font titleFont, labelFont, textFont, errorFont;
	private Color title, create, home;
	private JTextField usernameText, emailText;
	private JPasswordField passText;

	public SignupPage(int x, int y) {
		titleFont = new Font("Roboto", Font.BOLD, 30);
		labelFont = new Font("Gotham", Font.BOLD, 20);
		textFont = new Font("Gotham", Font.PLAIN, 20);
		errorFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);

		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");

		title = new Color(237, 74, 74);
		create = new Color(0, 153, 0);
		home = new Color(212, 23, 23);

		label = new JLabel();
		label.setText("Create an Account");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(title);
		label.setFont(titleFont);
		label.setIconTextGap(-75);

		usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(60, 80, 150, 50);
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Color.white);
		this.add(usernameLabel);

		usernameError = new JLabel("");
		usernameError.setBounds(60, 170, 200, 25);
		usernameError.setForeground(Color.RED);
		usernameError.setFont(errorFont);
		this.add(usernameError);

		usernameText = new JTextField("");
		usernameText.setFont(textFont);
		usernameText.setBounds(60, 130, 350, 40);
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		this.add(usernameText);

		emailLabel = new JLabel("EMAIL ADDRESS");
		emailLabel.setBounds(60, 180, 200, 50);
		emailLabel.setFont(labelFont);
		emailLabel.setForeground(Color.white);
		this.add(emailLabel);

		emailError = new JLabel("");
		emailError.setBounds(60, 270, 300, 25);
		emailError.setForeground(Color.RED);
		emailError.setFont(errorFont);
		this.add(emailError);

		emailText = new JTextField("");
		emailText.setFont(textFont);
		emailText.setHorizontalAlignment(JTextField.CENTER);
		emailText.setBounds(60, 230, 350, 40);
		this.add(emailText);

		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(60, 280, 150, 50);
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Color.white);
		this.add(passwordLabel);

		passwordError = new JLabel("");
		passwordError.setBounds(60, 370, 300, 25);
		passwordError.setForeground(Color.RED);
		passwordError.setFont(errorFont);
		this.add(passwordError);

		passText = new JPasswordField("");
		passText.setFont(textFont);
		passText.setBounds(60, 330, 350, 40);
		passText.setHorizontalAlignment(JTextField.CENTER);
		this.add(passText);

		createButton = new JButton("CREATE");
		createButton.setBackground(create);
		createButton.setForeground(Color.WHITE);
		createButton.setFont(labelFont);
		createButton.setBounds(60, 400, 150, 50);
		createButton.setFocusable(false);
		this.add(createButton);

		homeButton = new JButton("HOME");
		homeButton.setBackground(home);
		homeButton.setForeground(Color.WHITE);
		homeButton.setFont(labelFont);
		homeButton.setBounds(260, 400, 150, 50);
		homeButton.setFocusable(false);
		this.add(homeButton);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		createButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Username username = new Username(usernameText.getText());
				String email = emailText.getText();
				Matcher matcher = (Pattern.compile("^(.+)@(.+)$")).matcher(email);
				String password = String.valueOf(passText.getPassword());
				int score = 0;

				if (!(username.get()).equals("") && !(email.equals("")) && !(password.equals(""))
						&& password.length() >= 8 && matcher.matches()) {
					if (!(username.exists())) {
						User user = new User(username.get(), email, password, score);
						user.saveFile();
						username.write();
						JOptionPane.showMessageDialog(null, "Account successfully created\nNow you can login",
								"Signup successful", -1);
						Point point = getLocation();
						int x = (int) point.getX();
						int y = (int) point.getY();
						MainPage main = new MainPage(x, y);
						main.setVisible(true);
						dispose();
					} else {
						usernameError.setText("Username already exists");
					}
				}

				else {
					if (username.exists()) {
						usernameError.setText("Username already exists");
					} else if ((username.get()).equals("")) {
						usernameError.setText("Empty username");
					} else {
						usernameError.setText("");
					}

					if (email.equals("")) {
						emailError.setText("Empty email");
					} else if (!(matcher.matches())) {
						emailError.setText("Invalid Email format");
					} else {
						emailError.setText("");
					}

					if (password.equals("")) {
						passwordError.setText("Empty Password");
					} else if (password.length() < 8) {
						passwordError.setText("Password should have at least 8 characters");
					} else {
						passwordError.setText("");
					}
				}

			}
		});

		homeButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				MainPage home = new MainPage(x, y);
				home.setVisible(true);
				dispose();
			}
		});

	}
}
