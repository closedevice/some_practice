package com.sbbic.graph;

import javax.sound.midi.Soundbank;

/**
 * Created by God on 2016/3/10.
 */
public class TestSearch {
    public static void main(String[] args) {
        int n=8;
        int e=9;

        String labels[] = {"1","2","3","4","5","6","7","8"};
        Graph graph = new Graph(n);

        for (String label : labels) {
            graph.insertVertex(label);//插入顶点
        }

        //插入九条边
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);
        graph.insertEdge(3, 7, 1);
        graph.insertEdge(4, 7, 1);
        graph.insertEdge(2, 5, 1);
        graph.insertEdge(2, 6, 1);
        graph.insertEdge(5, 6, 1);
        graph.insertEdge(1, 0, 1);
        graph.insertEdge(2, 0, 1);
        graph.insertEdge(3, 1, 1);
        graph.insertEdge(4, 1, 1);
        graph.insertEdge(7, 3, 1);
        graph.insertEdge(7, 4, 1);
        graph.insertEdge(4, 2, 1);
        graph.insertEdge(5, 2, 1);
        graph.insertEdge(6, 5, 1);

        System.out.println("深度优先搜索序列为：");
        graph.dfs();
        System.out.println();
        System.out.println("宽优先搜索序列为：");
        graph.bfs();
        System.out.println();
        System.out.println("结点个数" + graph.getNumOfVertex());
        System.out.println("边的数目" + graph.getNumOfEdges());


    }
}
