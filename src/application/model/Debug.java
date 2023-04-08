package application.model;

import java.util.Vector;

public class Debug {

	public static void printVecContents(Vector<Card> v) {
		System.out.println("\nContents of Vector:");
		for (Card c: v) {
			System.out.println(c);
		}
		System.out.println();
	}
	
}
