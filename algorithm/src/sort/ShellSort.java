package sort;

public class ShellSort {
    public static void sort0(int[] source) {
        int len = source.length;
        // 步长循环直到1
        for (int step = len / 2; step >= 1; step /= 2) {
            // 间隔为step的插入排序
            for (int i = step; i < len; i++) {
                int temp = source[i];
                // j表示向前间隔多少位
                int j = i - step;
                // 从小到大排序，前面的数 > 后面的数，向后移动
                while (j >= 0 && source[j] > temp) {
                    source[j + step] = source[j];
                    j -= step;
                }
                //  优化，没有发生移动时，尾部不需要再赋值
                if ( j != i - step) {
                    source[j + step] = temp;
                }
            }
            SortHelper.dump(source);
        }
    }
//    public static void shellSortSmallToBig(int[] data) {
//        int j = 0;
//        int temp = 0;
//        for (int increment = data.length / 2; increment > 0; increment /= 2) {
//            System.out.println("increment:" + increment);
//            for (int i = increment; i < data.length; i++) {
//                // System.out.println("i:" + i);
//                temp = data[i];
//                for (j = i - increment; j >= 0; j -= increment) {
//                    // System.out.println("j:" + j);
//                    // System.out.println("temp:" + temp);
//                    // System.out.println("data[" + j + "]:" + data[j]);
//                    if (temp < data[j]) {
//                        data[j + increment] = data[j];
//                    } else {
//                        break;
//                    }
//                }
//                data[j + increment] = temp;
//            }
//            for (int i = 0; i < data.length; i++){
//                System.out.print(data[i] + " ");
//            }
//        }
//    }
}
