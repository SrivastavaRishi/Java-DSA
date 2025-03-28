package com.DataStructure;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class GraphDs {
    private final int V;
    private final ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    private final boolean isGraphDirected;
    public GraphDs(int vertex, boolean isGraphDirected){
        this.V = vertex;
        this.isGraphDirected = isGraphDirected;
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    public void addEdge(int from, int to){
        adj.get(from).add(to);
        if(!isGraphDirected){
            adj.get(to).add(from);
        }
    }

    private void dfsUtil(int node, boolean[] vis, ArrayList<Integer>res)
    {
        res.add(node);
        vis[node] = true;
        for(int neighbour: adj.get(node)){
            if(!vis[neighbour]){
                dfsUtil(neighbour, vis, res);
            }
        }
    }

    public ArrayList<Integer> dfs(){
        ArrayList<Integer>res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfsUtil(i, vis, res);
            }
        }
        return res;
    }

    public ArrayList<Integer> bfs(){
        ArrayList<Integer>res = new ArrayList<>();
        boolean[] vis = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        while(!q.isEmpty()){
            int currNode = q.remove();
            vis[currNode] = true;
            res.add(currNode);
            for(int neighbour: adj.get(currNode)){
                if(!vis[neighbour]){
                    q.add(neighbour);
                }
            }
        }
        return res;
    }

}

public class Graph {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int edge, vertex;
        vertex = sc.nextInt();
        edge = sc.nextInt();
        GraphDs graph = new GraphDs(vertex, false);
        while(edge-- > 0){
            int u, v;
            u = sc.nextInt();
            v = sc.nextInt();
            graph.addEdge(u, v);
        }
        System.out.println(graph.bfs());
    }
}

