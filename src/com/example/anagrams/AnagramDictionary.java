package com.example.anagrams;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class AnagramDictionary {

	private Map<ArrayList<Integer>, Set<String>> anagramMap = new HashMap<ArrayList<Integer>, Set<String>>();

	public AnagramDictionary(Scanner input) {
		try {
			while (input.hasNextLine()) {
				String word = input.nextLine().trim();
				addWord(word);
			}
		} finally {
			input.close();
		}
	}

	private ArrayList<Integer> toLetterCountsList(String word) {
		int offset = 'a';
		int[] counts = new int[26];
		for (char letter : word.toCharArray()) {
			int index = letter - offset;
			++counts[index];
		}

		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int c : counts){
			result.add(c);
		}
		return result;
	}

	private void addWord(String word) {
		ArrayList<Integer> key = toLetterCountsList(word);
		Set<String> values = anagramMap.get(key);
		if (values == null) {
			values = new HashSet<String>();
			anagramMap.put(key, values);
		}
		values.add(word);
	}
	
	public Set<String> getAnagrams(String word){
		Set<String> results = anagramMap.get(toLetterCountsList(word.trim()));
		return results == null ? Collections.emptySet() : Collections.unmodifiableSet(results);
	}
}
