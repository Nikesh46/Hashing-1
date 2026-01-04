TC: O(n)
SC: O(1) Since max of 26 characters can be there in the pattern and each word can be mapped to only one character.
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split("\\s");
        if (words.length != pattern.length())
            return false; // check if each word can be associated with a character or not. If not, return
                          // false since there's no 1:1 mapping possible.

        HashMap<Character, String> charMap = new HashMap<>();
        HashMap<String, Character> stringMap = new HashMap<>();
        int k = 0;
        for (int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            if (charMap.get(c) == null) { // Character not present in the charMap
                if (stringMap.get(words[i]) == null) { // String not present in the stringMap
                    charMap.put(c, words[i]); // Add {char: string} key value pair
                    stringMap.put(words[i], c);// Add {string: char} key value pair
                } else { // String already mapped to some other character
                    return false;
                }

            } else {
                if (!charMap.get(c).equals(words[i])) { // Character present but mapped to some other string
                    return false;
                }
            }
        }
        return true;
    }
}