package graph;

public class Constants {
    public static final int INF = 65535;
    public static int[][] GRAPH = new int[][]{
            //A,B, C, D,  E,  F
            {0, 6, 1, 5, INF, INF},
            {6, 0, 5, INF, 3, INF},
            {1, 5, 0, 5, 6, 4},
            {5, INF, 5, 0, INF, 2},
            {INF, 3, 6, INF, 0, 6},
            {INF, INF, 4, 2, 6, 0},
    };

    public static int[][] GRAPH2 = new int[][]{
            //A,B, C, D,
            {0, 2, 3, INF},
            {2, 0, INF, 3},
            {3, INF, 0, 1},
            {INF, 3, 1, 0},
    };
}
