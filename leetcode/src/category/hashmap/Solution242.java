package category.hashmap;

public class Solution242 {
    public boolean isAnagram(String s, String t) {
        int[] arr = new int[26];
        for (char c : s.toCharArray()) {
            int times = arr[c - 'a'];
            arr[c - 'a'] = ++ times;
        }

        for (char c : t.toCharArray()) {
            arr[c - 'a'] = arr[c - 'a'] - 1;
        }

        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
