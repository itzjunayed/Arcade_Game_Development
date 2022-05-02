package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class Username {

	private String username;

	public Username(String username) {
		this.username = username;
	}

	public void write() {
		try {

			File file = new File("usernamelist.txt");
			if (!file.exists()) {
				file.createNewFile();
			}

			PrintWriter file_to_write = new PrintWriter(new BufferedWriter(new FileWriter("usernamelist.txt", true)));
			file_to_write.println(this.get());
			file_to_write.close();

		} catch (Exception e) {
			System.out.println("An error occurred listing the username");
			e.printStackTrace();
		}
	}

	public boolean exists() {
		try {
			BufferedReader file_to_read = new BufferedReader(new FileReader("usernamelist.txt"));
			String temp;
			while ((temp = file_to_read.readLine()) != null) {
				if (temp.equals(this.username)) {
					return true;
				}
			}
			file_to_read.close();
		} catch (Exception e) {
			System.out.println("Error Occured reading usernamelist!");
			System.out.println(e.toString());
		}
		return false;
	}

	public String get() {
		return this.username;
	}
}
