package strmatch;

/**
 * 朴素匹配算法也称为暴力匹配算法
 */
public class BFMatch {

    public static void match(String source, String match) {
        int lenSource = source == null ? 0 : source.length();
        int lenMatch = match == null ? 0 : match.length();
        if (lenSource == 0 || lenMatch == 0 || lenSource < lenMatch) {
            return;
        }

        char[] sourceArr = source.toCharArray();
        char[] matchArr = match.toCharArray();

        int index = -1;
        for (int i = 0; i < sourceArr.length; i++) {
            // 如果第一位相等了，就迭代里面循环
            if (sourceArr[i] == matchArr[0]) {
                // 开始比较第二位到最后一位
                int j = 1;
                while (j < matchArr.length) {
                    // 当出现不相当的情况时，提前终止循环
                    if (sourceArr[i + j] != matchArr[j]) {
                        break;
                    }
                    j++;
                }
                // 若子串比较到最后，没有提前退出循环，说明匹配成功
                if (j ==  matchArr.length) {
                    index = i;
                    break;
                }
            }
        }

        if (index >= 0) {
            System.out.println("matched, from source index " + index);
        } else {
            System.out.println("not matched ");
        }
    }
}
