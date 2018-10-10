package com.company;

public class Main {

	public static void main(String[] args) {
		String input = "Ahoj ako sa mas ? Ja sa mam, velmi dobre a ty.";
		TextPreprocessor textPreprocessor = new TextPreprocessor();
		textPreprocessor.Process(input);
		textPreprocessor.Print();
	}
}
