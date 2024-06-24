package CollectionsExercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.awt.color.*;

public class CollectionsDemo {

	public static void main(String[] args) {
		String repeatNames = "Rob Rob Kyle Kyler Bob Bobert";
		Set<String> testNoDups = noFirstNameDups(repeatNames);
		System.out.println(testNoDups);
		
		String word = "cook";
		System.out.println(occurencesOfLettersInString(word));
		System.out.println(numOfDupWordsInASentence("The the THE dog is brown BrOwN"));
		
		LinkedList<Integer> example = new LinkedList<>();
		example.add(1);
		example.add(2);
		example.add(3);
		example.add(4);
		System.out.println(reverseLinkedlist(example));

		
	}
	public static Set<String> noFirstNameDups(String names) {
		String[] namesArr = names.split(" ");
		Set<String> noDups = new TreeSet<>();
		for (String name : namesArr) {
			noDups.add(name);
		}
		
		return noDups;
	}
	public static Map<Character, Integer> occurencesOfLettersInString(String word) {
		HashMap<Character, Integer> hm = new HashMap<>();
		for (Character c : word.toCharArray()) {
			hm.put(c, hm.getOrDefault(c, 0) + 1);
		}
		return hm;
	}
	public static int numOfDupWordsInASentence(String sentence) {
		HashMap<String, Integer> hm = new HashMap<>();
		Set<String> duplicateWordCount = new TreeSet<>();
		String[] words = sentence.split(" ");
		for (String word : words) {
			word = word.toLowerCase();
			hm.put(word, hm.getOrDefault(word, 0) + 1);

		}
		 for (Map.Entry<String, Integer> set :
             hm.entrySet()) {
			 if (set.getValue() >= 2) {
					duplicateWordCount.add(set.getKey());
			 }
		 }
		return duplicateWordCount.size();

	}
	public static LinkedList<Integer> reverseLinkedlist(LinkedList<Integer> list) {
		Collections.reverse(list);
		return list;
		
	}

}
