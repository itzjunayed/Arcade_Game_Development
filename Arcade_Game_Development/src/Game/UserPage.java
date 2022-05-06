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

public class UserPage extends JFrame {

	private JLabel label;
	private JButton playButton, signoutButton, viewProfileButton;
	private ImageIcon image, background;
	private Font labelFont, textFont;

	public UserPage(User user, int x, int y) {
		labelFont = new Font("Roboto", Font.BOLD, 30);
		textFont = new Font("Gotham", Font.PLAIN, 20);

		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");

		label = new JLabel();
		label.setText("WELCOME");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(237, 74, 74));
		label.setFont(labelFont);
		label.setIconTextGap(-85);

		playButton = new JButton("PLAY");
		playButton.setBackground(Color.white);
		playButton.setForeground(Color.black);
		playButton.setFont(textFont);
		playButton.setBounds(170, 170, 150, 50);
		playButton.setFocusable(false);
		this.add(playButton);

		viewProfileButton = new JButton("View Profile");
		viewProfileButton.setBackground(Color.white);
		viewProfileButton.setForeground(Color.black);
		viewProfileButton.setFont(textFont);
		viewProfileButton.setBounds(170, 240, 150, 50);
		viewProfileButton.setFocusable(false);
		this.add(viewProfileButton);

		signoutButton = new JButton("Sign Out");
		signoutButton.setBackground(Color.red);
		signoutButton.setForeground(Color.white);
		signoutButton.setFont(textFont);
		signoutButton.setBounds(170, 310, 150, 50);
		signoutButton.setFocusable(false);
		this.add(signoutButton);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		playButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				GamePage game = new GamePage(user);
				game.setVisible(true);
				dispose();
			}
		});

		viewProfileButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				PersonalPage personal = new PersonalPage(user, x, y);
				personal.setVisible(true);
				dispose();
			}
		});

		signoutButton.addActionListener(new ActionListener() {

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
