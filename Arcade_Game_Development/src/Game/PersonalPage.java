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

public class PersonalPage extends JFrame {
	private Font buttonFont, labelFont, textFont;
	private ImageIcon image, background, icon;
	private JLabel label, iconLabel, userLabel, emailLabel, scoreLabel;
	private JButton editButton, deleteButton, backButton;

	public PersonalPage(User user, int x, int y) {
		labelFont = new Font("Roboto", Font.BOLD, 30);
		buttonFont = new Font("Gotham", Font.BOLD, 20);
		textFont = new Font("Roboto", Font.PLAIN, 20);
		
		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");
		icon = new ImageIcon("icons/profileIcon.png");

		label = new JLabel();
		label.setText("My Profile");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(237, 74, 74));
		label.setFont(labelFont);
		label.setIconTextGap(-65);

		userLabel = new JLabel(user.getUsername());
		userLabel.setForeground(Color.white);
		userLabel.setFont(textFont);
		userLabel.setBounds(60, 100, 150, 40);
		this.add(userLabel);

		iconLabel = new JLabel();
		iconLabel.setIcon(icon);
		iconLabel.setBounds(10, 100, 40, 40);
		this.add(iconLabel);

		emailLabel = new JLabel("Email: " + user.getEmail());
		emailLabel.setForeground(Color.white);
		emailLabel.setFont(textFont);
		emailLabel.setBounds(10, 150, 500, 40);
		this.add(emailLabel);

		scoreLabel = new JLabel("High Score: " + user.getScore());
		scoreLabel.setForeground(Color.white);
		scoreLabel.setFont(textFont);
		scoreLabel.setBounds(10, 200, 500, 40);
		this.add(scoreLabel);

		editButton = new JButton("Edit Account");
		editButton.setBackground(Color.green);
		editButton.setForeground(Color.WHITE);
		editButton.setFont(buttonFont);
		editButton.setBounds(30, 300, 200, 50);
		editButton.setFocusable(false);
		this.add(editButton);

		deleteButton = new JButton("Delete Account");
		deleteButton.setBackground(Color.red);
		deleteButton.setForeground(Color.WHITE);
		deleteButton.setFont(buttonFont);
		deleteButton.setBounds(260, 300, 200, 50);
		deleteButton.setFocusable(false);
		this.add(deleteButton);

		backButton = new JButton("Back");
		backButton.setBackground(Color.orange);
		backButton.setForeground(Color.WHITE);
		backButton.setFont(buttonFont);
		backButton.setBounds(170, 400, 150, 50);
		backButton.setFocusable(false);
		this.add(backButton);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		editButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				EditPage edit = new EditPage(user, x, y);
				edit.setVisible(true);
				dispose();
			}
		});

		deleteButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				DeletePage detele = new DeletePage(user, x, y);
				detele.setVisible(true);
				dispose();
			}
		});

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				UserPage back = new UserPage(user, x, y);
				back.setVisible(true);
				dispose();
			}
		});

	}
}
