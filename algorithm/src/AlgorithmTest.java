import sort.MergeSort;

public class AlgorithmTest {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};

//        BubbleSort.sort0(arr);

//        BubbleSort.sort1(arr);

//        BubbleSort.sort2(arr);

//        SelectSort.sort0(arr);

//        InsertSort.sort0(arr);

//        ShellSort.sort0(arr);

        MergeSort.sort0(arr);

//        InsertSort.sort1(arr);

        // -----字符串匹配start------------
//        String source = "abababca";
//        String match = "abcdabd";
//        BFMatch.match(source, match);

//        KMPMatch.match(source, match);

        // -----字符串匹配end--------------
    }
}
