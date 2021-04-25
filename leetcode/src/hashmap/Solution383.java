package hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class Solution383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            int value = map.get(c) == null ? 0 : map.get(c);
            map.put(c, ++value);
        }

        for (char c : ransomNote.toCharArray()) {
            int value = map.get(c) == null ? 0 : map.get(c);
            if (value <= 0 ) {
                return false;
            } else {
                map.put(c, --value);
            }
        }
        return true;
    }
}
