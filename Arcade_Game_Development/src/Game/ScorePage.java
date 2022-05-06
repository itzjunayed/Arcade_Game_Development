package Game;

import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ScorePage extends JFrame implements Serializable {

	private JLabel label;
	private ImageIcon image, background;
	private JButton back;
	private JTable historyTable;
	private JScrollPane scrollPane;
	private Font labelFont, buttonFont, textFont;

	public ScorePage(int x, int y) throws IOException {
		image = new ImageIcon("images/logo.png");
		background = new ImageIcon("images/aboutBack.png");

		labelFont = new Font("Ubuntu", Font.BOLD, 25);
		textFont = new Font("Gotham", Font.BOLD, 15);
		buttonFont = new Font("Roboto", Font.BOLD, 18);

		label = new JLabel();
		label.setText("HIGH SCORES");
		label.setIcon(background);
		label.setHorizontalTextPosition(JLabel.CENTER);
		label.setVerticalTextPosition(JLabel.TOP);
		label.setForeground(new Color(237, 74, 74));
		label.setFont(labelFont);
		label.setIconTextGap(-60);


		File file = new File("usernamelist.txt");
		ArrayList<String> array = new ArrayList<String>();
		HashMap<String, Integer> map = new HashMap<>();
		Scanner scan = new Scanner(file);
		while (scan.hasNext()) {
			String line = scan.next();
			array.add(line);
		}
		scan.close();
		User user;
		for (String i : array) {
			try {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream("users/" + i + ".dat"));
				user = (User) ois.readObject();
				map.put(user.getUsername(), user.getScore());
				ois.close();
			} catch (ClassNotFoundException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}

		LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
		map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
				.forEachOrdered(e -> reverseSortedMap.put(e.getKey(), e.getValue()));

		Object[][] data = new Object[array.size()][3];
		int count = 0;
		Iterator<Entry<String, Integer>> iterator = reverseSortedMap.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<String, Integer> entry = iterator.next();
			data[count][0] = count + 1;
			data[count][1] = entry.getKey();
			data[count][2] = entry.getValue();
			count++;
		}

		String column[] = { "POSITION", "USERNAME", "SCORE" };

		DefaultTableModel model = new DefaultTableModel(data, column);

		historyTable = new JTable(model);
		historyTable.setBounds(30, 40, 200, 300);
		historyTable.setFont(textFont);
		historyTable.setRowHeight(30);
		historyTable.getTableHeader().setFont(new Font("Gotham", Font.BOLD, 18));
		historyTable.getTableHeader().setBackground(Color.cyan);

		scrollPane = new JScrollPane(historyTable);
		scrollPane.setBounds(10, 70, 480, 350);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		this.add(scrollPane);

		back = new JButton("BACK");
		back.setBackground(Color.white);
		back.setForeground(Color.black);
		back.setFont(buttonFont);
		back.setBounds(190, 440, 130, 40);
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
