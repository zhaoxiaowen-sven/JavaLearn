import graph.Kruskal;
import graph.Prim;

import static graph.Prim.INF;

public class AlgorithmTest {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 1, 5, 8, 3, 7, 4, 6, 2};

//        BubbleSort.sort0(arr);

//        BubbleSort.sort1(arr);

//        BubbleSort.sort2(arr);

//        SelectSort.sort0(arr);

//        InsertSort.sort0(arr);

//        ShellSort.sort0(arr);

//        MergeSort.sort0(arr);

//        QuickSort.sort0(arr2);

//        HeapSort.sort0(arr);

//        InsertSort.sort1(arr);

        // -----字符串匹配start------------
//        String source = "abababca";
//        String match = "abcdabd";
//        BFMatch.match(source, match);

//        KMPMatch.match(source, match);

        // -----字符串匹配end--------------

        int[][] graph = new int[][]{
                //A,B, C, D,  E,  F
                {0, 6, 1, 5, INF, INF},
                {6, 0, 5, INF, 3, INF},
                {1, 5, 0, 5, 6, 4},
                {5, INF, 5, 0, INF, 2},
                {INF, 3, 6, INF, 0, 6},
                {INF, INF, 4, 2, 6, 0},
        };
//        Prim.miniTree(graph);

        Kruskal.miniTree(graph);
    }
}
