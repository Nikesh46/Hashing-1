
// TC - O(n)
// SC - O(1) Since each dataset we created can have only 26 characters. 
class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Solution 1: Two HashMaps
        // HashMap<Character, Character> sMap = new HashMap<>();
        // HashMap<Character, Character> tMap = new HashMap<>();
        // for (int i =0; i< s.length(); i++) {
        // char sChar = s.charAt(i);
        // char tChar = t.charAt(i);
        // if(sMap.containsKey(sChar)) {
        // if(sMap.get(sChar) != tChar) {
        // return false;
        // }
        // } else {
        // sMap.put(sChar, tChar);
        // }

        // if(tMap.containsKey(tChar)) {
        // if(tMap.get(tChar) != sChar) {
        // return false;
        // }
        // } else {
        // tMap.put(tChar, sChar);
        // }

        // }

        // return true;

        // Solution 2: One HashMap and Hashset.
        HashMap<Character, Character> sMap = new HashMap<>();
        HashSet<Character> sSet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (!sMap.containsKey(c)) { // Character not present in the map
                if (sSet.contains(t.charAt(i))) { // Character in t already mapped to some other character in s
                    return false;
                }
                sMap.put(c, t.charAt(i)); // adding {s Character: t Character} key value pair
                sSet.add(t.charAt(i)); // adding t Character to the Hashset to indicate that it is already mapped to an
                                       // s character.
            } else {
                if (sMap.get(c) != t.charAt(i)) { // character present but mapped to some other character
                    return false;
                }
            }
        }
        return true;

    }
}