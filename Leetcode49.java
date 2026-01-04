// TC : O(n)
// SC : O(n)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Solution 1: Checking the anagrams by sorting.
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String curr = strs[i];
            // sort
            char[] charArr = curr.toCharArray();
            Arrays.sort(charArr);
            String sorted = String.valueOf(charArr);

            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            List<String> li = map.get(sorted);
            li.add(curr);
        }
        return new ArrayList<>(map.values());

    }
}