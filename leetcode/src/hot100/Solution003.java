package hot100;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution003 {

    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        int left = 0;
        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) { // 如果已经包含了的情况下，从
                left = Math.max(map.get(s.charAt(j)) + 1, left);//下标 + 1 代表 i 要移动的下个位置
            }
            map.put(s.charAt(j), j); // put 进去的时候会把重复元素索引更新掉
            ret = Math.max(ret, j - left + 1);
        }
        return ret;
    }

    public int lengthOfLongestSubstring5(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int ret = 0;
        int left = 0;

        for (int j = 0; j < s.length(); j++) {
            if (map.containsKey(s.charAt(j))) { // 如果已经包含了的情况下，从
                left = Math.max(map.get(s.charAt(j)) + 1, left);//下标 + 1 代表 i 要移动的下个位置
            } else {
                map.put(s.charAt(j), j);
                ret = Math.max(ret, j - left + 1);
            }
        }
        return ret;
    }

    public int lengthOfLongestSubstring2(String s) {
        Set<Character> characters = new HashSet<>();
        int i = 0;
        int j = 0;
        int ret = 0;
        int n = s.length();
        while (i < n && j < n) {
            if (!characters.contains(s.charAt(j))) {
                characters.add(s.charAt(j));
                j++;
                ret = Math.max(ret, j - i);
            } else {
                characters.remove(s.charAt(i));
                i++;
            }
        }
        return ret;
    }

    public int lengthOfLongestSubstringX(String s) {
        int count = 0;
        int left = 0;
        int right = 0;
        Set<Character> set = new HashSet<>();
        int n = s.length();
        while (left < n && right < n) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right ++;
                count = Math.max(count, right - left);
            } else {
                set.remove(s.charAt(left));
                left ++;
            }
        }
        return count;
    }


    public int lengthOfLongestSubstring1(String s) {
        int n = s.length();
        int ans = 0;//保存当前得到满足条件的子串的最大值
        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++) //之所以 j<= n，是因为我们子串是 [i,j),左闭右开
                if (allUnique(s, i, j)) {
                    ans = Math.max(ans, j - i); //更新 ans
                }
        return ans;
    }

    // 判断是否有重复
    public boolean allUnique(String s, int start, int end) {
        Set<Character> set = new HashSet<>();//初始化 hash set
        for (int i = start; i < end; i++) {//遍历每个字符
            Character ch = s.charAt(i);
            if (set.contains(ch)) {
                return false; //判断字符在不在 set 中
            }
            set.add(ch);//不在的话将该字符添加到 set 里边
        }
        return true;
    }



    public static void main(String[] args) {
        System.out.println(new Solution003().lengthOfLongestSubstring2("pwwkew"));
//        System.out.println(new Solution003().lengthOfLongestSubstringx("pwwkew"));
//        System.out.println(new Solution003().lengthOfLongestSubstringx("abcabcbb"));
    }

    public void test() {
        System.out.println(lengthOfLongestSubstringX("abba"));
//        System.out.println(lengthOfLongestSubstring("a"));
//        System.out.println(lengthOfLongestSubstring(""));
//        System.out.println(lengthOfLongestSubstring("au"));
//        System.out.println(lengthOfLongestSubstring(" "));
//        System.out.println(lengthOfLongestSubstring("bbbbb"));
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
