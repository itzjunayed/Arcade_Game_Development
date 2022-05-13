package Game;

import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Coin extends JLabel implements Runnable {
	private Thread threadCoin;
	private Rocket rocKet;
	private Random random;
	private static int diff = 10;

	public Coin(Rocket rocket) {
		this.rocKet = rocket;
		threadCoin = new Thread(this);
		random = new Random();
		setIcon(new ImageIcon("icons/coin.png"));
		threadCoin.start();
	}

	@Override
	public void run() {
		int x = random.nextInt(rocKet.getBounds().width - 150) + 50;
		int y = 35;
		int rocketX, rocketY;
		try {
			while (rocKet.life > 0 && getY() <= rocKet.getBounds().height - 20) {
				setBounds(x, y, 48, 48);
				rocketX = rocKet.rocket.getX();
				rocketY = rocKet.rocket.getY();
				if (y + 24 >= rocketY && y + 24 <= rocketY + 10 && x > rocketX && rocketX + 200 > x + 48) {
					++rocKet.score;
					rocKet.labelScore.setText(rocKet.score + "");
					break;
				}
				Thread.sleep(90);
				y += diff;
			}
			rocKet.remove(this);
			rocKet.validate();
			rocKet.repaint();
		} catch (Exception ex) {
			System.out.println("Error occured on coin.java Line:44 " + ex.toString());
		}
	}
}