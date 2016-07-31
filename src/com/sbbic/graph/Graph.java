package com.sbbic.graph;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by God on 2016/3/10.
 */
public class Graph {
    private int [][] edges;
    private int numOfEdges;
    private ArrayList vertexList;

    public Graph(int n) {
        edges = new int[n][n];
        vertexList = new ArrayList(n);
        numOfEdges=0;
    }

    public int getNumOfVertex() {
        return vertexList.size();
    }

    public int getNumOfEdges() {
        return numOfEdges;
    }

    public Object getValueByIndex(int i) {
        return vertexList.get(i);
    }

    public int getWeight(int v1, int v2) {
        return edges[v1][v2];
    }

    public void insertVertex(Object vertex) {
        vertexList.add(vertexList.size(), vertex);
    }

    public void insertEdge(int v1, int v2, int weight) {
        edges[v1][v2]=weight;
        numOfEdges++;

    }

    public void deleteEdge(int v1, int v2) {
        edges[v1][v2]=0;
        numOfEdges--;
    }

    public int getNextNeighbor(int v1, int v2) {
        for(int j=v2+1;j<vertexList.size();j++) {
            if (edges[v1][j] > 0) {
                return j;
            }
        }
        return -1;
    }


    public void dfs() {
       boolean[] isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            isVisited[i]=false;
        }

        for(int i=0;i<getNumOfVertex();i++) {
            if (!isVisited[i]) {
                dfs1(isVisited, i);
            }
        }

    }


    public void bfs() {
        boolean[] isVisited = new boolean[getNumOfVertex()];
        for (int i = 0; i < getNumOfVertex(); i++) {
            isVisited[i]=false;
        }

        for(int i=0;i<getNumOfVertex();i++) {
            if (!isVisited[i]) {
                bfs1(isVisited, i);
            }
        }

    }

    //私有函数，广度优先遍历
    private void bfs(boolean[] isVisited,int i) {
        int u,w;
        LinkedList queue=new LinkedList();

        //访问结点i
        System.out.print(getValueByIndex(i)+"  ");
        isVisited[i]=true;
        //结点入队列
        queue.addLast(i);
        //queue.addlast(i);
        while (!queue.isEmpty()) {
            u=((Integer)queue.removeFirst()).intValue();
            w=getFirstNeighbor(u);
            while(w!=-1) {
                if(!isVisited[w]) {
                    //访问该结点
                    System.out.print(getValueByIndex(w)+"  ");
                    //标记已被访问
                    isVisited[w]=true;
                    //入队列
                    queue.addLast(w);
                }
                //寻找下一个邻接结点
                w=getNextNeighbor(u, w);
            }
        }
    }


    private void bfs1(boolean[] isVisited, int i) {
        LinkedList queue = new LinkedList();
        System.out.print(getValueByIndex(i) + " ");
        isVisited[i]=true;
        int u;
        queue.addFirst(i);
        while (!queue.isEmpty()) {
            u = (int) queue.removeFirst();
            for(int j=0;j<getNumOfVertex();j++) {//对每个顶点进行循环
                //判断其他顶点与当前顶点u是否存在边切未访问过
                if (edges[u][j]>0&&isVisited[j]==false) {
                    System.out.print(getValueByIndex(j) + " ");//答应顶点
                    queue.addLast(j);//将找到的顶点入队
                    isVisited[j]=true;//将找到的顶点标记为已访问
                }
            }

        }
    }

    private void dfs(boolean[] isVisited, int n) {
        System.out.print(getValueByIndex(n)+" ");
        isVisited[n]=true;
        int i = getFirstNeighbor(n);
        while (i != -1) {//当前节点n和某个节点是否有边
            if (!isVisited[i]) {
                dfs(isVisited,i);
            }
            i = getNextNeighbor(n, i);
        }
        return;

    }

    private void dfs1(boolean[] isVisited, int n) {
        System.out.print(getValueByIndex(n)+" ");
        isVisited[n]=true;
        for(int i=0;i<getNumOfVertex();i++) {
            if (edges[n][i] > 0 && isVisited[i] == false) {
                dfs1(isVisited,i);
            }
        }


    }

    private int getFirstNeighbor(int n) {
        for (int i=0;i<vertexList.size();i++) {
            if (edges[n][i]>0) {
                return i;
            }
        }
        return -1;
    }
}
