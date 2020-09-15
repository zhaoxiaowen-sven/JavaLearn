package graph;

import java.lang.reflect.Array;

public class Prim {
    public static final int INF = 65535;
    public static void miniTree(int[][] graph) {
        int n = graph.length;
        // 边的集合,访问过的顶点标记为0
        // 初始化为第0行的数组
        int[] lowCost = new int[n];
        for (int i = 0; i < n; i++) {
            lowCost[i] = graph[0][i];
        }
        // 记录访问的节点顺序
        int[] path = new int[n];
        // 路径长度
        int sum = 0;
        // 默认从第一个顶点开始查找
        int k = 0;
        // 记录查找到的顶点
        lowCost[k] = 0;
        path[k] = 0;
        for (int i = 1; i < n; i++) {
            int min = INF;
            // 查找当前lowest中的最小值即最短边
            for (int j = 1; j < n; j++) {
                if (lowCost[j] != 0 && lowCost[j] < min) {
                    min = lowCost[j];
                    k = j;
                }
            }
            //标记节点为已访问
            lowCost[k] = 0;
            path[i] = k;
            // 节点路径权值和
            sum += min;
            // 更新最短路径的边，[k,j] 新加入的节点到其余未访问节点的权值
            for (int j = 1; j < n; j++) {
                if (lowCost[j] != 0 && graph[k][j] < lowCost[j]) {
                    lowCost[j] = graph[k][j];
                }
            }
        }
        System.out.println(sum);
        for (int i : path) {
            System.out.print(i + "_");
        }
        System.out.print("\n");
    }
}
