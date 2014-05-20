package utility;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is intended to find variations of a string following the edit
 * distance algorithm. The variation could be used for encrypted fuzzy matching
 * 
 * @author Michael Yuan
 * 
 */
//TODO: Add encryption/decryption methods
public class WildCardEditDistance {

	/**
	 * Default empty constructor
	 */
	public WildCardEditDistance() {

	}

	/**
	 * Method used to generate the derivatives of a string given a defined
	 * number of wild cards
	 * 
	 * @param string
	 *            the string desired turn into fuzzy wild card string
	 * @param wildcards
	 *            the desired wild cards
	 * @return an array of variations given the specified parameters
	 */
	public List<String> getVariations(String string, int wildcards) {
		if (wildcards > string.length()) {
			throw new IllegalArgumentException(
					"Wild card input is larger than string length");
		}
		List<String> variations = new ArrayList<String>();
		variations.add(string);
		List<String> previous = variations;
		for (int n = 1; n <= wildcards; n++) {
			List<String> current = new ArrayList<String>();
			for (String object : previous) {
				StringBuilder sb = new StringBuilder(object);
				sb.insert(0, "*");
				current.add(sb.toString());
				char[] charArray = object.toCharArray();
				for (int i = 0; i < object.length(); i++) {
					if (charArray[i] != '*') {
						sb = new StringBuilder(object);
						sb.replace(i, i + 1, "*");
						current.add(sb.toString());
						sb = new StringBuilder(object);
						sb.insert(i + 1, "*");
						current.add(sb.toString());
					}
				}
			}
			variations.addAll(current);
			previous = current;
		}
		return variations;
		// return variations.toArray(new String[] {});
	}

	/**
	 * Calculates the combination of 2 integers: int0 C int1
	 * 
	 * @param int0
	 *            Left number of the C
	 * @param int1
	 *            Right number of the C
	 * @return
	 */
	public int combinations(int int0, int int1) {
		if (int1 > int0) {
			throw new IllegalArgumentException(
					"Right side is larger than left side");
		}
		if (int1 == 0) {
			return 1;
		}
		int temp = 1;
		for (int i = int0; i > int1; i--) {
			temp *= i;
		}
		int div = 1;
		for (int i = 1; i <= int0 - int1; i++) {
			div *= i;
		}
		return temp / div;
	}
}
