package Game;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.io.Serializable;

public class User implements Serializable {
	private String username;
	private String email;
	private String password;
	private int score;

	User(String username, String email, String password, int score) {
		this.username = username;
		this.email = email;
		this.password = password;
		this.score = score;
	}

	public void saveFile() {
		try {
			ObjectOutputStream file = new ObjectOutputStream(
					new FileOutputStream("users/" + this.getUsername() + ".dat"));
			file.writeObject(this);
			file.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}
	}

	public void deleteAccount() {
		this.removeUsernameFromList();
		try {
			File userFile = new File("users/" + this.getUsername() + ".dat");

			if (!userFile.delete()) {
				System.out.println("Couldn't delete file [User.java: 43]");
			}

		} catch (Exception e) {
			System.out.println(e.toString());
		}

	}

	private void removeUsernameFromList() {
		String username = this.getUsername();
		try {

			PrintWriter file_to_write = new PrintWriter(new BufferedWriter(new FileWriter("temp.txt")));
			BufferedReader file_to_read = new BufferedReader(new FileReader("usernamelist.txt"));
			String temp;
			while ((temp = file_to_read.readLine()) != null) {
				if (!(temp.equals(username))) {
					file_to_write.println(temp);
				}
			}

			file_to_read.close();
			file_to_write.close();
		} catch (Exception e) {
			System.out.println("User.java Line 68: " + e.toString());
		}

		try {
			File userFile = new File("usernamelist.txt");
			userFile.delete();
		} catch (Exception e) {
			System.out.println("User.java Line 75: " + e.toString());
		}

		try {

			File oldfile = new File("temp.txt");
			File newfile = new File("usernamelist.txt");
			oldfile.renameTo(newfile);
		} catch (Exception e) {
			System.out.println("User.java Line 84: " + e.toString());
		}
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setScore(int score) {
		if (score > this.score) {
			this.score = score;
			saveFile();
		} else {
			this.score = this.score;
			saveFile();
		}
	}

	public String getUsername() {
		return this.username;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public int getScore() {
		return this.score;
	}

}
