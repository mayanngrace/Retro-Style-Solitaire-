package application.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;
import java.util.Vector;

public class HighScoreSystem {

	public Vector<Player> database = new Vector<Player>();
	
	private void exportDB() throws FileNotFoundException, UnsupportedEncodingException {
		String s = "";
		for (int i=0; i<10; i++) {
			if (i == database.size()) {
				break;
			}
			s += database.elementAt(i).getName() + "=" + Integer.toString(database.elementAt(i).getScore()) + "\n";
		}
		PrintWriter pw = new PrintWriter("highscores.txt", "UTF-8");
		pw.print(s);
		pw.close();
	}
	
	public void newEntry(String name, int score) throws FileNotFoundException, UnsupportedEncodingException {
		database.clear();
		readHS();
		database.add(new Player(name, score));
		sortDB();
		exportDB();
	}

	@SuppressWarnings("unused")
	private void printDB() {
		for (Player p: database) {
			System.out.println(p.getName() + ": " + p.getScore());
		}
	}
	
	public void readHS() {
		BufferedReader bf = null;
		try {
			bf = new BufferedReader(new FileReader("highscores.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Cannot access file highscores.txt");
		}
		String line;
		try {
			while ( (line = bf.readLine()) != null ) {
				String[] tmpArr = line.split("=");
				Player tmp = new Player(tmpArr[0], Integer.parseInt(tmpArr[1]));
				database.add(tmp);
			}
			bf.close();
		} catch (IOException e) {
			System.out.println("Cannot read line.");
		}
	}
	
	public void sortDB() {
		Collections.sort(database, Comparator.comparing(Player::getScore).reversed());
	}
	
}
