package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Rocket extends JPanel implements Runnable, KeyListener {
	JLabel rocket;
	Rectangle area;
	JLabel labelScore, labelLife[];
	private Thread threadOne, threadTwo;
	private Coin coin;
	private Meteor meteor;
	private GamePage main;
	private User user;
	public static int score = 0;
	public static int life = 5;

	public Rocket(GamePage main, User user) {
		this.main = main;
		this.user = user;
		setLayout(null);
		setBackground(Color.white);
		setSize(1200, 700);
		area = getBounds();

		rocket = new JLabel(new ImageIcon("icons/rocket.png"));
		rocket.setBounds(20, 450, 100, 100);
		add(rocket);

		labelLife = new JLabel[5];
		for (int i = 0; i < 5; i++) {
			labelLife[i] = new JLabel(new ImageIcon("icons/heart.png"));
			labelLife[i].setBounds(i * 40, 2, 30, 30);
			add(labelLife[i]);
		}

		labelScore = new JLabel("0");
		labelScore.setBounds(getBounds().width - 70, 2, 150, 30);
		labelScore.setFont(new Font("Arial", Font.BOLD, 32));
		add(labelScore);

		threadOne = new Thread(this, "Coin");

		threadTwo = new Thread(this, "Meteor");
	}

	public void start() {
		threadOne.start();
	}

	@Override
	public void run() {
		try {
			while (life > 0) {
				coin = new Coin(this);
				add(coin);
				meteor = new Meteor(this);
				add(meteor);
				Thread.sleep(3000);
			}

		} catch (Exception ex) {
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Something Wrong");
		}
		JOptionPane.showMessageDialog(null, "Your Score : " + score, "Game Over", -1);
		user.setScore(score);
		main.thread.start();
	}

	public void keyTyped(KeyEvent evt) {
	}

	public void keyPressed(KeyEvent evt) {
		int x = rocket.getX();
		int y = rocket.getY();
		if (evt.getKeyCode() == 37 && x - 25 >= 0)
			rocket.setBounds(x - 25, y, 100, 100);
		else if (evt.getKeyCode() == 39 && x + 25 < area.width - 103)
			rocket.setBounds(x + 25, y, 100, 100);
	}

	public void keyReleased(KeyEvent evt) {
	}
}