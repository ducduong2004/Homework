package lab8_map;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.Map.Entry;


public class TextAnalyzer {
	// <word, its positions>
	private Map<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

	// load words in the text file given by fileName and store into map by using add
	// method in Task 2.1.
	// Using BufferedReader reffered in file TextFileUtils.java
	public void load(String fileName) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(fileName));
		Scanner reader = new Scanner(br);
		int pos = 1;
		while(reader.hasNextLine()) {
			String line = reader.nextLine();
			StringTokenizer tokenizer = new StringTokenizer(line, " ");
			while(tokenizer.hasMoreTokens()) {
				String word = tokenizer.nextToken();
				if(tokenizer.hasMoreTokens()) add(word, pos);
				else add(word, -pos);
				pos++;
			}
		}
		reader.close();
	}
	// In the following method, if the word is not in the map, then adding that word
	// to the map containing the position of the word in the file. If the word is
	// already in the map, then its word position is added to the list of word
	// positions for this word.
	// Remember to negate the word position if the word is at the end of a line in
	// the text file

	public void add(String word, int position) {
		// TODO
		if(!map.containsKey(word)) {
			map.put(word, new ArrayList<Integer>());
			map.get(word).add(position);
		} else map.get(word).add(position);


	}

	public void display() {
		for(Map.Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue() );
		}

	}

	// This method should display the words of the text file along with the
	// positions of each word, one word per line, in alphabetical order
	public void displayWords() {
		Map<String, ArrayList<Integer>> sortedMap = new TreeMap<>(map);
		for(Entry<String, ArrayList<Integer>> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}

	}


	// This method will display the content of the text file stored in the map
	public void displayText() {
		int count = 1;
		int limit = this.limitCal();
		
		
		while(count <= limit) {
			for(Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
				ArrayList<Integer> arrL = entry.getValue();
				if(arrL.contains(count)) System.out.print(entry.getKey() + " ");
				if(arrL.contains(-count)) System.out.println(entry.getKey());
			}
			count++;
			
			
		}
	}
	
	public int limitCal() {
		int limit = 0;
		for(Entry<String, ArrayList<Integer>> entry : map.entrySet()) limit += entry.getValue().size();
		return limit;
	}

	// This method will return the word that occurs most frequently in the text file
	public String mostFrequentWord() {
		String max = "";
		int maxLen = 0;
		for(Entry<String, ArrayList<Integer>> entry : map.entrySet()) {
			int otherSize = entry.getValue().size();
			if(maxLen < otherSize) {
				maxLen = otherSize;
				max = entry.getKey();
			}
		}
		return max;
	}

}
