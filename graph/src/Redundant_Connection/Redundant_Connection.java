package Redundant_Connection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import Redundant_Connection.union_find;

/*
    Use dfs, for each edge check if there is already a path to connect 2 vertices
 */
public class Redundant_Connection {

    public static int[] findRedundantConnection(int[][] edges){
        int n = edges.length;


        List<List<Integer>> graph = new ArrayList<>();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge: edges){
            int src = edge[0]-1;
            int dst = edge[1]-1;

            boolean[] seen = new boolean[n];
            /* check if src and dst can be reached */
            if(dfs(graph, src, dst, seen)){
                return edge;
            }
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }
        return new int[2];
    }
    public static boolean dfs(List<List<Integer>> graph, int node, int dst, boolean[] seen){
        if(node == dst){
            return true;
        }
        seen[node] = true;
        for(int next: graph.get(node)){
            if(!seen[node]){
                if(dfs(graph, next, dst, seen)){
                    return true;
                }
            }
        }
        return false;
    }

    public static int[] findRedundantConnection_Union_Find(int[][] edges){
        int n = edges.length;
        union_find uf = new union_find(n+1); // starts from 1

        int[] redundantEdge = new int[2];
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            if(uf.find(u) == uf.find(v)){ // if already belong to same union, this new edge is redundant
                redundantEdge[0] = u;
                redundantEdge[1] = v;
            }
            else{
                uf.union(u,v);
            }
        }
        return redundantEdge;
    }

    public static void main(String[] args) {
        int[][] edges = new int[][]{
                {1,2},
                {1,3},
                {2,3}
        };
        System.out.println(Arrays.toString(findRedundantConnection_Union_Find(edges)));
    }
}
