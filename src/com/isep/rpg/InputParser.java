package com.isep.rpg;

import java.util.Scanner;

public class InputParser {
	
	public String parseInputAsString() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
	
	public int parseInputAsInt() {
		Scanner sc = new Scanner(System.in);
		int input = sc.nextInt();
		return input;
	}
	
}
