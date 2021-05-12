package category.string;

import java.util.ArrayList;

public class Solution151 {
    public String reverseWords(String s) {
//        // 除去开头和末尾的空白字符
//        s = s.trim();
//        // 正则匹配连续的空白字符作为分隔符分割
//        List<String> wordList = Arrays.asList(s.split("\\s+"));
//        Collections.reverse(wordList);
//        return String.join(" ", wordList);
//        return new String(arr.);

        int slow = 0;
        int fast = 0;
        String str = s.trim();

        ArrayList<String> builder = new ArrayList<>();
        while (fast < str.length()) {
            if (str.charAt(fast) == ' ') {
                builder.add(str.substring(slow, fast));
                while (fast < str.length() - 1 && str.charAt(fast) == str.charAt(fast + 1)) {
                    fast++;
                }
                slow = fast + 1; // 左闭右开
            }

            if (fast == str.length() - 1) {
                builder.add(str.substring(slow, fast + 1));
            }
            fast++;
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = builder.size() - 1; i >= 0; i--) {
            stringBuilder.append(builder.get(i));
            if (i != 0) {
                stringBuilder.append(' ');
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.print(new Solution151().reverseWords(" hello world "));
        String[] arr = " hello world ".split(" ");

    }
}
