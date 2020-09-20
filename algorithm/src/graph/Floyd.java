package graph;

import static graph.Constants.INF;

public class Floyd {

    public static void minPath(int[][] graph) {
        int len = graph.length;

        int[][] path = new int[len][len];
        // path 表示i，j直接的最短距离的中点。
        // 初始化
        for (int i = 0; i <len; i++) {
            for (int j = 0; j < len; j++) {
                // 有2种方式
                // 1."顶点i"到"顶点j"的最短路径是经过顶点j
                // 2.-1 表示直接连接
                path[i][j] = -1;
            }
        }

        // u 表示i,j中间顶点的索引
        for (int u = 0; u < len; u++) {
            for (int i = 0; i < len; i++) {
                for (int j = 0; j < len; j++) {
                    // 顶点不能首尾相接 && 中间点不能和头尾相同，比如 i=1,j=2,u=2，此时
                    // graph [1][2] > graph[1][2] + graph[2][2]
                    if (i == j || u == j || u == i) {
                        continue;
                    }
                    //比较时若后面出现无穷值时，前后是不能比较的，取最大值为INF
                    int tmp = (graph[i][u] == INF || graph[u][j] == INF) ? INF : graph[i][u] + graph[u][j];
                    if (graph[i][j] > tmp) {
                        // i j 间的最小距离
                        graph[i][j] = tmp;
                        // i j要经过的点
                        path[i][j] = u;
                    }
                }
            }
        }

        System.out.println("=== graph ======");
        printGraph(graph);
        System.out.println("=== path ======");
        printGraph(path);
    }

    private static void printGraph(int[][] graph) {
        int len = graph.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                System.out.print(graph[i][j] + ",");
            }
            System.out.println("");
        }
    }
}
