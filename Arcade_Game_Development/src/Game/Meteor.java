package Game;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Meteor extends JLabel implements Runnable {

	private Thread threadMeteor;
	private Rocket rocketCrash;
	private Random random;
	private static int diff = 10;

	public Meteor(Rocket rocket) {
		this.rocketCrash = rocket;

		this.threadMeteor = new Thread(this);
		this.random = new Random();
		this.setIcon(new ImageIcon("icons/meteor.png"));
		this.threadMeteor.start();
	}

	@Override
	public void run() {
		int x = random.nextInt(rocketCrash.getBounds().width - 150) + 50;
		int y = 35;
		int rocketX, boulY;
		try {
			while (rocketCrash.life > 0 && getY() <= rocketCrash.getBounds().height - 20) {
				setBounds(x, y, 100, 100);
				rocketX = rocketCrash.rocket.getX();
				boulY = rocketCrash.rocket.getY();
				if (y + 24 >= boulY && y + 24 <= boulY + 10 && x > rocketX && rocketX + 200 > x + 48) {
					rocketCrash.life--;
					rocketCrash.remove(rocketCrash.labelLife[rocketCrash.life]);
					rocketCrash.labelScore.setText(rocketCrash.score + "");
					break;
				}
				Thread.sleep(80);
				y += diff;
			}
			rocketCrash.remove(this);
			rocketCrash.validate();
			rocketCrash.repaint();
		} catch (Exception ex) {
			System.out.println("Error occured in Line: 47 " + ex.toString());
		}
	}

}
