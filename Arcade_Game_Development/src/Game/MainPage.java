package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MainPage extends JFrame {

	private ImageIcon image, background;
	private JLabel label;
	private JButton createButton, loginButton, aboutButton, highScoresButton, exitButton;
	private Font titleFont, buttonFont;
	private Color title;

	public MainPage(int x, int y) {

		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");

		title = new Color(237, 74, 74);

		titleFont = new Font("Roboto", Font.BOLD, 30);
		buttonFont = new Font("Roboto", Font.BOLD, 15);

		label = new JLabel();
		label.setText("METEOR DODGE");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(title);
		label.setFont(titleFont);
		label.setIconTextGap(-100);

		createButton = new JButton();
		createButton.setBounds(150, 170, 200, 50);
		createButton.setText("CREATE ACCOUNT");
		createButton.setFont(buttonFont);
		createButton.setFocusable(false);
		createButton.setForeground(Color.white);
		createButton.setBackground(Color.darkGray);

		loginButton = new JButton();
		loginButton.setBounds(200, 250, 100, 50);
		loginButton.setText("LOGIN");
		loginButton.setFont(buttonFont);
		loginButton.setFocusable(false);
		loginButton.setForeground(Color.white);
		loginButton.setBackground(Color.darkGray);

		highScoresButton = new JButton();
		highScoresButton.setBounds(180, 340, 150, 50);
		highScoresButton.setText("HIGH SCORES");
		highScoresButton.setFont(buttonFont);
		highScoresButton.setFocusable(false);
		highScoresButton.setForeground(Color.black);
		highScoresButton.setBackground(Color.white);

		aboutButton = new JButton();
		aboutButton.setBounds(70, 340, 100, 50);
		aboutButton.setText("ABOUT");
		aboutButton.setFont(buttonFont);
		aboutButton.setFocusable(false);
		aboutButton.setForeground(Color.black);
		aboutButton.setBackground(Color.white);

		exitButton = new JButton();
		exitButton.setBounds(340, 340, 100, 50);
		exitButton.setText("EXIT");
		exitButton.setFont(buttonFont);
		exitButton.setFocusable(false);
		exitButton.setForeground(Color.black);
		exitButton.setBackground(Color.white);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(createButton);
		this.add(loginButton);
		this.add(highScoresButton);
		this.add(aboutButton);
		this.add(exitButton);
		this.add(label);
		this.pack();

		createButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				SignupPage signup = new SignupPage(x, y);
				signup.setVisible(true);
				dispose();
			}
		});

		loginButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				LoginPage login = new LoginPage(x, y);
				login.setVisible(true);
				dispose();
			}
		});

		aboutButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				AboutPage about = new AboutPage(x, y);
				about.setVisible(true);
				dispose();
			}
		});

		highScoresButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				ScorePage score = null;

				try {
					score = new ScorePage(x, y);
				} catch (IOException e1) {
					System.out.println("MainPage.java Line: 142 " + e1.toString());
				}

				score.setVisible(true);
				dispose();
			}
		});

		exitButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

	}

}
