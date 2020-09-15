package graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Kruskal {
    public static final int INF = 65535;


    public static void miniTree(int[][] arr) {
        int len = arr.length;
        ArrayList<Edge> edgeList = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len - 1; j++) {
                if (arr[i][j] != INF) {
                    edgeList.add(new Edge(i, j, arr[i][j]));
                }
            }
        }

        Collections.sort(edgeList, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.weight - o2.weight;
            }
        });

        System.out.println(edgeList);
        int[] parent = new int[len];


    }

    static class Edge {
        public Edge(int form, int to, int weight) {
            this.form = form;
            this.to = to;
            this.weight = weight;
        }

        int form;
        int to;
        int weight;
    }
}
