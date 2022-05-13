package Game;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class GamePage extends JFrame implements Runnable {
	Thread thread;
	Rocket rocket;
	private ImageIcon image;

	public GamePage(User user) {
		thread = new Thread(this, "Dispose");
		rocket = new Rocket(this, user);
		rocket.start();
		this.add(rocket);

		this.addKeyListener(rocket);
		image = new ImageIcon("images/logo.png");

		this.setTitle("Meteor Dodge");
		this.setResizable(false);
		this.setSize(1200, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setIconImage(image.getImage());

	}

	@Override
	public void run() {
		dispose();
	}

}