package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LoginPage extends JFrame {

	private ImageIcon image, background;
	private JLabel label, usernameLabel, passwordLabel, errorLabel;
	private JButton loginButton, homeButton;
	private JTextField usernameText;
	private JPasswordField passwordText;
	private Font titleFont, labelFont, textFont, errorFont;
	private Color title, login, home;

	LoginPage(int x, int y) {
		titleFont = new Font("Roboto", Font.BOLD, 30);
		labelFont = new Font("Gotham", Font.BOLD, 20);
		textFont = new Font("Gotham", Font.PLAIN, 20);
		errorFont = new Font("Ariel", Font.ITALIC + Font.BOLD, 12);

		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");

		title = new Color(237, 74, 74);
		login = new Color(0, 153, 0);
		home = new Color(212, 23, 23);

		label = new JLabel();
		label.setText("USER LOGIN");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(title);
		label.setFont(titleFont);
		label.setIconTextGap(-85);

		usernameLabel = new JLabel("USERNAME");
		usernameLabel.setBounds(60, 150, 150, 50);
		usernameLabel.setFont(labelFont);
		usernameLabel.setForeground(Color.white);
		this.add(usernameLabel);

		usernameText = new JTextField("");
		usernameText.setFont(textFont);
		usernameText.setBounds(60, 200, 350, 40);
		usernameText.setHorizontalAlignment(JTextField.CENTER);
		this.add(usernameText);

		passwordLabel = new JLabel("PASSWORD");
		passwordLabel.setBounds(60, 250, 150, 50);
		passwordLabel.setFont(labelFont);
		passwordLabel.setForeground(Color.white);
		this.add(passwordLabel);

		passwordText = new JPasswordField("");
		passwordText.setFont(textFont);
		passwordText.setBounds(60, 300, 350, 40);
		passwordText.setHorizontalAlignment(JTextField.CENTER);
		this.add(passwordText);

		errorLabel = new JLabel("");
		errorLabel.setBounds(60, 350, 300, 25);
		errorLabel.setForeground(Color.RED);
		errorLabel.setFont(errorFont);
		this.add(errorLabel);

		loginButton = new JButton("LOGIN");
		loginButton.setBackground(login);
		loginButton.setForeground(Color.WHITE);
		loginButton.setFont(labelFont);
		loginButton.setBounds(60, 400, 150, 50);
		loginButton.setFocusable(false);
		this.add(loginButton);

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

		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Username username = new Username(usernameText.getText());
				if (username.exists()) {
					String password = String.valueOf(passwordText.getPassword());
					User user;
					try {
						ObjectInputStream ois = new ObjectInputStream(
								new FileInputStream("users/" + username.get() + ".dat"));
						user = (User) ois.readObject();
						ois.close();
						if (password.equals(user.getPassword())) {
							Point point = getLocation();
							int x = (int) point.getX();
							int y = (int) point.getY();
							UserPage userpage = new UserPage(user, x, y);
							userpage.setVisible(true);
							dispose();
						} else {
							errorLabel.setText("Username or password not matched");
						}

					} catch (IOException | ClassNotFoundException ex) {
						System.out.println("An error occured during login line 129");
						System.out.println(ex.toString());
					}
				} else {
					errorLabel.setText("Username or password not matched");
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
