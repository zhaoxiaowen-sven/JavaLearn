package sort;

public class BubbleSort {

    // 初级版，严格意义上非冒泡排序，只是将最小值或最大值放到第一位，更准确的描述应该是交换排序
    public static void sort0(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }

        // 最后一位不需要进行排序
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                // 当前元素大于后续的元素，则进行交换，
                // 这样的结果就是每轮结束时，会找到当前轮最小的元素放到当前轮的第一位
                if (source[i] > source[j]) {
                    int temp = source[i];
                    source[i] = source[j];
                    source[j] = temp;
                }
            }
            dump(source);
        }
        dump(source);
    }

    // 冒泡排序，两两相邻比较并交换
    public static void sort1(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }

        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) { // 从后往前遍历
                // 比较前后的元素大小，前>后时交换
                if (source[j - 1] > source[j]) {
                    int temp = source[j];
                    source[j] = source[j - 1];
                    source[j - 1] = temp;
                }
            }
            dump(source);
        }
        dump(source);
    }


    // 优化2
    public static void sort2(int[] source) {
        int len = source == null ? 0 : source.length;
        if (len == 0 || len == 1) {
            System.out.println("element less 1");
            return;
        }
        for (int i = 0; i < len; i++) {
            boolean flag = false;
            for (int j = len - 1; j > i; j--) { // 从后往前遍历
                // 前 > 后时，交换元素
                if (source[j - 1] > source[j]) {
                    int temp = source[j];
                    source[j] = source[j - 1];
                    source[j - 1] = temp;
                    flag = true;
                }
            }

            // 如果某一轮没有发生元素交换，说明已经排好序了
            if (!flag) {
                break;
            }
            dump(source);
        }
        dump(source);
    }


    private static void dump(int[] source) {
        StringBuilder builder = new StringBuilder();
        for (int element : source) {
            builder.append(element).append(", ");
        }
        System.out.println(builder.toString());
    }
}
