package category.backtracking.array;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Solution017 {

    static HashMap<Character, String> map = new HashMap<>();

    static {
        map.put('0', "");
        map.put('1', "");
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        String[] letterMap = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        int length = digits.length();
        String[] arr = new String[digits.length()];
        for (int i = 0; i < length; i++) {
            arr[i] = letterMap[digits.charAt(i) - '0'];
        }
        // startIndex 表示的是第几组字符串
        dfs(length, 0, "", res, arr);
        return res;
    }

    private void dfs(int length, int startIndex, String path, List<String> res, String[] arr) {
        int size = path.length();
        if (size == length) {
            res.add(path);
            return;
        }
        if (startIndex >= length) {
            return;
        }
        String letter = arr[startIndex];
        int letterLength = letter.length();
        for (int i = 0; i < letterLength; i++) {
            path += letter.charAt(i);
            dfs(length, startIndex + 1, path, res, arr);
            path = path.substring(0, path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> l = new Solution017().letterCombinations("23");
        for (String s : l) {
            System.out.println(s);
        }
    }
}
