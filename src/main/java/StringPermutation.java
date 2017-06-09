import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.TimeUnit;

public class StringPermutation {
	/**
	 * List permutation of a string
	 * 
	 * @param s
	 *            the input string
	 * @return the list of permutation
	 */
	public static ArrayList<String> permutation(String s) {
		// The result
		ArrayList<String> res = new ArrayList<String>();
		// If input string's length is 1, return {s}
		if (s.length() == 1) {
			res.add(s);
		} else if (s.length() > 1) {
			int lastIndex = s.length() - 1;
			// Find out the last character
			String last = s.substring(lastIndex);
			// Rest of the string
			String rest = s.substring(0, lastIndex);
			// Perform permutation on the rest string and
			// merge with the last character
			res = merge(permutation(rest), last);
		}
		return res;
	}

	/**
	 * @param list
	 *            a result of permutation, e.g. {"ab", "ba"}
	 * @param c
	 *            the last character
	 * @return a merged new list, e.g. {"cab", "acb" ... }
	 */
	public static ArrayList<String> merge(ArrayList<String> list, String c) {
		ArrayList<String> res = new ArrayList<String>();
		// Loop through all the string in the list
		for (String s : list) {
			// For each string, insert the last character to all possible
			// postions
			// and add them to the new list
			for (int i = 0; i <= s.length(); ++i) {
				String ps = new StringBuffer(s).insert(i, c).toString();
				res.add(ps);
			}
		}
		return res;
	}

	/**
	 * permutation function
	 * 
	 * @param str
	 *            string to calculate permutation for
	 * @param l
	 *            starting index
	 * @param r
	 *            end index
	 */
	private void permute(String str, int l, int r) {
		if (l == r) {
			// System.out.println(str);
		} else {
			for (int i = l; i <= r; i++) {
				str = swap(str, l, i);
				permute(str, l + 1, r);
				str = swap(str, l, i);
			}
		}
	}

	/**
	 * Swap Characters at position
	 * 
	 * @param a
	 *            string value
	 * @param i
	 *            position 1
	 * @param j
	 *            position 2
	 * @return swapped string
	 */
	public String swap(String a, int i, int j) {
		char temp;
		char[] charArray = a.toCharArray();
		temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
		return String.valueOf(charArray);
	}

	public List<String> permute(char input[]) {
		Map<Character, Integer> countMap = new TreeMap<>();
		for (char ch : input) {
			countMap.compute(ch, (key, val) -> {
				if (val == null) {
					return 1;
				} else {
					return val + 1;
				}
			});
		}
		char str[] = new char[countMap.size()];
		int count[] = new int[countMap.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
		List<String> resultList = new ArrayList<>();
		char result[] = new char[input.length];
		permuteUtil(str, count, result, 0, resultList);
		return resultList;
	}

	public void permuteUtil(char str[], int count[], char result[], int level, List<String> resultList) {
		if (level == result.length) {
			resultList.add(new String(result));
			return;
		}

		for (int i = 0; i < str.length; i++) {
			if (count[i] == 0) {
				continue;
			}
			result[level] = str[i];
			count[i]--;
			permuteUtil(str, count, result, level + 1, resultList);
			count[i]++;
		}
	}

	private void printArray(char input[]) {
		for (char ch : input) {
			System.out.print(ch);
		}
		System.out.println();
	}

	public static void main(String args[]) {
		// StringPermutation sp = new StringPermutation();
		// sp.permute("abcdefghijklmnopqrstuvwxyz".toCharArray()).forEach(s ->
		// System.out.println(s));

		String str = "abcdefghijklmnopqrstuvwxyz";
		int n = str.length();
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
		permutation(str);
		System.out.println(TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()));
	}

}