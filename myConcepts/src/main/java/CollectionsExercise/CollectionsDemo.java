package CollectionsExercise;

import java.util.HashMap;
import java.util.Map;
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

}
