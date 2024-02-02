package Count_Unreachable_Pairs_Of_Nodes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    You are given an integer n. There is an undirected graph with n nodes, numbered from 0 to n-1.
    You are given a 2D integer array "edges" where edges[i] = [ai, bi] denotes that there exists an undirected edge
    connecting nodes ai and bi
    return the number of pairs of different nodes that are unreachable from each other

    brainstorm:
    use dfs to count each component's number of nodes

    how:
    return: integer `size` and size += dfs()
    terminate: when the current node has been visited

 */
public class Count_Unreachable_Pairs_Of_Nodes_2316 {
    public static void main(String[] args) {
        int[][] edges = new int[][]{{0,1}, {0,2}, {1,2}};
        int n = 3;
        System.out.println(countPairs(n, edges));

        int[][] edges2 = new int[][]{{0,2}, {0,5}, {2,4}, {1,6}, {5,4}};
        int n2 = 7;
        System.out.println(countPairs(n2, edges2));
    }
    public static int dfs(int node, boolean[] seen, Map<Integer, List<Integer>> graph){
        if(seen[node]){
            return 0;
        }
        seen[node] = true;
        int size = 1;
        for(int neigh: graph.get(node)){
            if(!seen[neigh]){
                size += dfs(neigh, seen, graph);
            }
        }
        return size;
    }
    public static long countPairs(int n, int[][] edges){
        List<Integer> component_size = new ArrayList<>();
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int[] edge: edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        long total_pairs=0;

        boolean[] seen = new boolean[n];
        for(int node: graph.keySet()){
            if(!seen[node]){
                int size = dfs(node, seen, graph);
                if(size > 0 ){
                    component_size.add(size);
                }

            }
        }
        for(int size: component_size){
            total_pairs += size * (n-size);
        }
        return total_pairs/2;
    }
}
