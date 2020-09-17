package graph;

import static graph.Constants.INF;

public class Dijkstra {

    public static void minPath(int[][] graph) {
        int len = graph.length;

        int[] vex = new int[len];
        int[] weights = new int[len];

        for (int i = 0; i < len; i++) {
            weights[i] = graph[0][i];
        }

        vex[0] = 1;
        int k = 0;
        for (int j = 1; j < len; j++) {
            int min = INF;
            for (int i = 0; i < len; i++) {
                if (vex[i] == 0 && weights[i] < min) {
                    min = weights[i];
                    k = i;
                }
            }
            vex[k] = 1;
            for (int i = 0; i < len; i++) {
                // 选中k位后，比较【0->剩余顶点】及【0->k + k+ 剩余顶点】的距离，
                // 更新到【0->剩余顶点】的最小距离
                if (vex[i] == 0 && (min + graph[k][i] < weights[i])) {
                    weights[i] = min + graph[k][i];
                }
            }
        }


        for (int value : weights) {
            System.out.println(value);
        }
    }
}
