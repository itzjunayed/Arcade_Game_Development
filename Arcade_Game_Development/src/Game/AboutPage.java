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

public class AboutPage extends JFrame {
	private JLabel label, projectName, courseName, languageName, title, junayed, mahid, rishan, naim;
	private ImageIcon image, background;
	private JButton back;
	private Font labelFont, textFont;

	AboutPage(int x, int y) {
		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/space.gif");

		labelFont = new Font("Roboto", Font.BOLD, 30);
		textFont = new Font("Arial", Font.PLAIN, 18);

		label = new JLabel();
		label.setText("Project");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(Color.red);
		label.setFont(labelFont);
		label.setIconTextGap(-60);

		projectName = new JLabel("Name: Arcade Game Development (METEOR DODGE)");
		projectName.setBounds(40, 60, 700, 50);
		projectName.setForeground(Color.white);
		projectName.setFont(textFont);
		this.add(projectName);

		courseName = new JLabel("Course: CSE215 (Programming Language II)");
		courseName.setBounds(40, 90, 700, 50);
		courseName.setForeground(Color.white);
		courseName.setFont(textFont);
		this.add(courseName);

		languageName = new JLabel("Language Used: Java and Swing for Graphics");
		languageName.setBounds(40, 120, 700, 50);
		languageName.setForeground(Color.white);
		languageName.setFont(textFont);
		this.add(languageName);

		title = new JLabel("DEVELOPERS");
		title.setBounds(190, 160, 700, 50);
		title.setForeground(Color.cyan);
		title.setFont(textFont);
		this.add(title);

		junayed = new JLabel("1. Name: Md. Shakib Shahariar Junayed");
		junayed.setBounds(40, 200, 700, 50);
		junayed.setForeground(Color.white);
		junayed.setFont(textFont);
		this.add(junayed);

		junayed = new JLabel("ID: 2121095642");
		junayed.setBounds(60, 220, 700, 50);
		junayed.setForeground(Color.white);
		junayed.setFont(textFont);
		this.add(junayed);

		mahid = new JLabel("2. Name: Akhond Muftasib Ul Mahid");
		mahid.setBounds(40, 260, 700, 50);
		mahid.setForeground(Color.white);
		mahid.setFont(textFont);
		this.add(mahid);

		mahid = new JLabel("ID: 2122075642");
		mahid.setBounds(60, 280, 700, 50);
		mahid.setForeground(Color.white);
		mahid.setFont(textFont);
		this.add(mahid);

		rishan = new JLabel("3. Name: Golam Ahad Rishan");
		rishan.setBounds(40, 320, 700, 50);
		rishan.setForeground(Color.white);
		rishan.setFont(textFont);
		this.add(rishan);

		rishan = new JLabel("ID: 2122076642");
		rishan.setBounds(60, 340, 700, 50);
		rishan.setForeground(Color.white);
		rishan.setFont(textFont);
		this.add(rishan);

		naim = new JLabel("4. Name: Naim Ibna Nabab");
		naim.setBounds(40, 380, 700, 50);
		naim.setForeground(Color.white);
		naim.setFont(textFont);
		this.add(naim);

		naim = new JLabel("ID: 2122216642");
		naim.setBounds(60, 400, 700, 50);
		naim.setForeground(Color.white);
		naim.setFont(textFont);
		this.add(naim);

		back = new JButton("BACK");
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.setFont(textFont);
		back.setBounds(190, 450, 130, 40);
		back.setFocusable(false);
		this.add(back);

		this.setTitle("Meteor Dodge");
		this.setBounds(x, y, 500, 500);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setIconImage(image.getImage());
		this.add(label);
		this.pack();

		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Point point = getLocation();
				int x = (int) point.getX();
				int y = (int) point.getY();
				MainPage main = new MainPage(x, y);
				main.setVisible(true);
				dispose();
			}
		});

	}
}
