package com.sbbic.graph;

/**
 * Created by God on 2016/3/10.
 */
public class TestGraph {
    public static void main(String[] args) {
        int n=4;
        int e=4;

        String labels[] = {"v1", "v2", "v3", "v4"};
        Graph graph = new Graph(n);

        for (String label : labels) {
            graph.insertVertex(label);//插入顶点
        }

        graph.insertEdge(0, 1, 2);
        graph.insertEdge(0, 2, 5);
        graph.insertEdge(2, 3, 8);
        graph.insertEdge(3, 0, 7);

        System.out.println("结点个数" + graph.getNumOfVertex());
        System.out.println("边的数目" + graph.getNumOfEdges());


    }
}
