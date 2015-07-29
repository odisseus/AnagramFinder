package com.example.anagrams;

import java.nio.file.Paths;
import java.util.Scanner;

public class App {

	public static void main(String[] args) throws Exception {
		System.out.println(Paths.get(".").toAbsolutePath().toString());
		Scanner scn = new Scanner(Paths.get("resources/dictionary.txt"));
		AnagramDictionary dict = new AnagramDictionary(scn);
		System.out.println(dict.getAnagrams("beta"));
	}

}
