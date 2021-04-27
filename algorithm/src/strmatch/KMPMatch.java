package strmatch;

public class KMPMatch {

    public static void match(String source, String match) {
        int lenSource = source == null ? 0 : source.length();
        int lenMatch = match == null ? 0 : match.length();
        if (lenSource == 0 || lenMatch == 0 || lenSource < lenMatch) {
            return;
        }

        char[] sourceArr = source.toCharArray();
        char[] matchArr = match.toCharArray();
        // 获取子串的next数组
        int[] next = getNextMore(matchArr);

        int i = 0;
        int j = 0;
        while (i < sourceArr.length && j < matchArr.length) {
            // j == -1 表示的是第一个字符
            // 当字符串相同时，继续遍历
            if (j == -1 || sourceArr[i] == matchArr[j]) {
                i++;
                j++;
            } else {
                // 字符串不同时子串索引j开始回溯
                j = next[j];
            }
        }

        // 若子串迭代结束到最后，说明匹配到了
        if (j == matchArr.length) {
            System.out.println("matched, from source index" + (i - j));
        } else {
            System.out.println("not matched");
        }
    }

    // 回溯数组
    private static int[] getNext(char[] match) {
        int size = match == null ? 0 : match.length;
        if (size == 0) {
            return new int[]{0};
        }
        int[] next = new int[size];
        next[0] = -1;
        int k = -1; // k代表前缀
        int j = 0; // j代表后缀
        while (j < size - 1) {
            if (k == -1 || match[k] == match[j]) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
        return next;
    }

    // 回溯数组
    private static int[] getNextMore(char[] match) {
        int size = match == null ? 0 : match.length;
        if (size == 0) {
            return new int[]{0};
        }
        int[] next = new int[size];
        next[0] = -1;
        int k = -1; // k代表前缀
        int j = 0; // j代表后缀
        while (j < size - 1) {
            if (k == -1 || match[k] == match[j]) {
                j++;
                k++;
                if (match[k] != match[j]) {
                    next[j] = k;
                } else {
                    // 前缀和后缀相同情况下，那么当前后缀的回溯==前缀的回溯
                    next[j] = next[k];
                }
            } else {
                k = next[k];
            }
        }
        return next;
    }

    private static int[] getNextMore2(char[] match) {
        int j = 0; // 前缀末尾
        int next[] = new int[match.length];
        // int i// 后缀末尾
        next[0] = 0;
        for (int i = 1; i< next.length ; i++) {
            while (j > 0 && (s[j] != s[i])) {
                j = next[j - 1]; // 回退到前一位next数组的下标
            }

            if (s[j] == s[i]) { //
                j ++;
            }
            next[i] = j;
        }

    }
}
