package Game;

import java.io.File;
import java.io.IOException;

public class Main {

	public static void main(String[] args) {
		try {
			createDependency();
		} catch (IOException e) {
			System.out.println("Error creating dependency");
		}
		MainPage main = new MainPage(600, 250);
		main.setVisible(true);
	}

	public static void createDependency() throws IOException {
		File directory = new File("users");
		if (!directory.exists()) {
			directory.mkdir();
		}

		File file = new File("usernamelist.txt");
		if (!file.exists()) {
			file.createNewFile();
		}
	}

}