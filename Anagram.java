/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  

	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		String clean1 = preProcess(str1);
		String clean2 = preProcess(str2);
		clean1 = clean1.replaceAll("\\s+", "");
		clean2 = clean2.replaceAll("\\s+", "");
		if (clean1.length() != clean2.length()) {
			return false;
		}
		boolean[] used = new boolean[clean2.length()];
		for (int i = 0; i < clean1.length(); i++) {
			char c = clean1.charAt(i);
			boolean found = false;
			for (int j = 0; j < clean2.length(); j++) {
				if (!used[j] && clean2.charAt(j) == c) {
					used[j] = true;
					found = true;
					break;
				}
			}
			if (!found) {
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted.
	// For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		char[] buf = new char[str.length()];
		int idx = 0;
		for (int i = 0; i < str.length(); i++) {
			char c = str.charAt(i);
			if (Character.isLetter(c)) {
				buf[idx++] = Character.toLowerCase(c);
			} else if (Character.isWhitespace(c)) {
				buf[idx++] = c;
			}
		}
		return new String(buf, 0, idx);
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		if (str == null) return null;
		char[] chars = str.toCharArray();
		for (int i = chars.length - 1; i > 0; i--) {
			int r = (int) (Math.random() * (i + 1));
			char tmp = chars[i];
			chars[i] = chars[r];
			chars[r] = tmp;
		}
		return new String(chars);
	}
}
