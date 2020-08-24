package sort;

public class InsertSort {
    public static void sort0(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }

        for (int i = 1; i < len; i++) { // 从第二位开始
            int j = i;
            int temp = source[j]; //记录当前位置，若移位，当前位置会被覆盖
            for (; j > 0 && source[j - 1] > temp; j--) { // 从后往前遍历，查找插入的位置
                //若前一位值大于当前位置，前一位向后移动一位
                source[j] = source[j - 1];
            }
            if (j != i) {
                source[j] = temp; // 将值插入到合适的位置
            }
            SortHelper.dump(source);
        }
        SortHelper.dump(source);
    }

    public static void sort1(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }

        for (int i = 1; i < len; i++) { // 从第二位开始
            int j = i;
            int temp = source[j];
            // 查找并移位置
            while (j > 0 && source[j - 1] > temp) {
                source[j] = source[j - 1];
                j--;
            }
            // 如果j！=i ，说明移动过了位置
            if (j != i) {
                source[j] = temp;
            }
            SortHelper.dump(source);
        }
        SortHelper.dump(source);
    }
}
