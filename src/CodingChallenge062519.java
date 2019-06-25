
/**
 * cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the first and last element of that pair.
 *
 * For example, car(cons(3, 4)) returns 3, and cdr(cons(3, 4)) returns 4.
 */
public class CodingChallenge062519 {

    public static void main(String[] args) {
        String s = "heeellooo";
        String[] words = {"hello", "hi", "helo"};

        CodingChallenge062519 challenge = new CodingChallenge062519();
        int result = challenge.expressiveWords(s, words);
        System.out.println(result);
    }


    public int expressiveWords(String s, String[] words) {
        if (s == null || words.length < 1) {
            return 0;
        }

        int count = 0;
        for (String word : words) {
            if (stretchy(s, word)) {
                count++;
            }
        }
        return count;
    }

    public boolean stretchy(String s, String word) {
        if (word == null) {
            return false;
        }

        int i=0;
        int j=0;
        while (i < s.length() && j < word.length()) {
            if (s.charAt(i) == word.charAt(j)) {
                int len1 = getRepeatedLength(s, i);
                int len2 = getRepeatedLength(word, j);
                // fails if the target word continuous letter length is < 3 and the 2 lengths don't match
                // or the target length is greater than or equal to 3 and the target length is less than the word length
                if (len1 < 3 && len1 != len2 || len1 >= 3 && len1 < len2) {
                    return false;
                }
                // update the index of each word and target
                i += len1;
                j += len2;
            }
            else {
                return false;
            }
        }
        return i == s.length() && j == word.length();
    }

    // count the continuous letters
    private int getRepeatedLength(String str, int i) {
        // start at the current index of the word
        int j = i;
        // increase letter count if the letter continues to be the same
        while (j < str.length() && str.charAt(j) == str.charAt(i)) {
            j++;
        }
        // continuous letter count will be the count minus the index
        return j-i;
    }


}
