package category.backtracking.string;

import java.util.ArrayList;
import java.util.List;

public class Solution093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(0, s, "", res, 0);
        return res;
    }

    private void dfs(int startIndex, String s, String path, List<String> res, int pointNum) {
        int size = s.length();
        // 第一种判断方式，index 走到了最后，并且有4个点
//        if (path.split("\\.").length == 4 && startIndex == size) {
//            res.add(path.substring(0, size + 3));
//            return;
//        }

        // 对上面的优化
//        if (pointNum == 4 && startIndex == size ) {
//            res.add(path.substring(0, path.length() -1));
//            return;
//        }
        // 再次优化
        if (pointNum == 3) {
            if (isValid(s, startIndex, size - 1)) {
//                System.out.println(path);
                res.add(path + s.substring(startIndex, size));
            }
            return;
        }
        for (int i = startIndex; i < size; i++) {
            if (isValid(s, startIndex, i)) {
//                path += s.substring(startIndex, i + 1)+ "."; // 增加的长度是 i + 1 - startIndex + 1（.）
                pointNum++;
                dfs(i + 1, s, path + s.substring(startIndex, i + 1) + ".", res, pointNum);
                pointNum--;
//                path = path.substring(0, path.length() - (i + 2 - startIndex)); // 剪掉上面增加的长度
            } else {
                break;
            }
        }
    }

    boolean isValid(String s, int start, int end) {
        if (start > end) {
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for (int i = start; i <= end; i++) {
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到非数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果大于255了不合法
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        List<String> res = new Solution093().restoreIpAddresses("25525511135");
        for (String s : res) {
            System.out.println(s);
        }
    }

}
