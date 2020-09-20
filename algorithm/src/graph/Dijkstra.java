package graph;

import static graph.Constants.INF;

public class Dijkstra {

    public static void minPath(int[][] graph, int v0) {
        int len = graph.length;
        // 算法从0节点开始
        // vex 表示访问过的顶点
        int[] vex = new int[len];
        // path 表示访问这个顶点需要经过的顶点
        int[] path = new int[len];
        // dist 表示访问到顶点最小权值
        int[] dist = new int[len];
        // 初始化的距离从0开始
        for (int i = 0; i < len; i++) {
            dist[i] = graph[v0][i];
        }
        // v0起始顶点
        vex[v0] = 1;
        int k = 0;
        for (int j = 1; j < len; j++) {
            int min = INF;
            for (int i = 0; i < len; i++) {
                if (vex[i] == 0 && dist[i] < min) {
                    min = dist[i];
                    k = i;
                }
            }
            vex[k] = 1;
            for (int i = 0; i < len; i++) {
                // 选中k位后，比较【0->剩余顶点】及【0->k + k->剩余顶点】的距离，
                // 更新到【0->剩余顶点】的最小距离,【0->i的】最小距离是实时更新的
                if (vex[i] == 0 && (min + graph[k][i] < dist[i])) {
                    dist[i] = min + graph[k][i];
                    path[i] = k;
                }
            }
        }

        // [0,0,0,2] 表示的含义为，最短路径中从0节点开始到这个节点的前驱节点
        System.out.println("路径访问的前驱, 默认索引是 0, 1, 2");
        for (int value : path) {
            System.out.print(value + ",");
        }
        System.out.println("\n权值，从0到这个节点的最大权值");
        for (int value : dist) {
            System.out.print(value + ",");
        }
    }
}
