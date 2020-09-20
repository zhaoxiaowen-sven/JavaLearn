package graph;

import java.util.ArrayList;
import java.util.Comparator;

import static graph.Constants.INF;

public class Kruskal {

    public static void miniTree(int[][] graph) {
        int len = graph.length;
        //1.生成边的列表
        ArrayList<Edge> edgeList = getEdges(graph, len);
        //2.对边进行排序
        sortEdge(edgeList);
        //3.初始化的parent数组值都为0，理解为顶点都是根节点
        // parent 数组用来查找节点的根节点
        int[] parent = new int[len];

        //3.对边进行遍历，权值从低到高
        int edgeCount = 0;
        for (Edge edge : edgeList) {
            int root1 = findRoot(parent, edge.from);
            int root2 = findRoot(parent, edge.to);
            if (root1 != root2) { // 判断是否形成了环，如果不同就可以合并2个节点或者树，让他们有相同的根
                parent[root2] = root1; // 两个顶点组成树
                System.out.println("edge from = " + edge.from + ", to = " + edge.to + ", weight = " + edge.weight);
                edgeCount++;
            }
            if (edgeCount == len - 1) {// 当边的个数 = 顶点数 - 1时，构造完成
                break;
            }
        }
    }

    private static int findRoot(int[] parent, int n) {
        while (parent[n] > 0) { // 查找根节点的过程
            n = parent[n];
        }
        return n;
    }

    private static ArrayList<Edge> getEdges(int[][] arr, int len) {
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i][j] != INF) {
                    edgeList.add(new Edge(i, j, arr[i][j]));
                }
            }
        }
        return edgeList;
    }

    private static void sortEdge(ArrayList<Edge> edgeList) {
        edgeList.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

    //for (Edge edge : edgeList) {
    //      System.out.println(edge);
    //    }
    }

    static class Edge {
        int from;
        int to;
        int weight;

        public Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "from=" + from +
                    ", to=" + to +
                    ", weight=" + weight +
                    '}';
        }
    }
}
