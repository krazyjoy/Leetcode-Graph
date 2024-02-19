package Detect_Cycle_In_Graph;

import java.util.*;

public class cycle_detection_algorithm {
    /*
        Time Complexity: O(V+E)
        Space Complexity: O(V)

        DFS checks the same note is revisited,
        by keep track of parent node

        A Cycle: for each vertex v, if there exist an adjacent vertex u, where u is not a parent of v, but has been visited

     */

    public static boolean dfs(int node, int prev, Map<Integer, List<Integer>> adjList, boolean[] seen){
        if(seen[node]){
            return true; // already visited
        }
        seen[node] = true;
        if(adjList.containsKey(node)){
            for(int neigh: adjList.get(node)){

                // neighbor has been visited in another path, cycle detected
                if(neigh!=prev && seen[neigh]){
                    return true;
                }
                if(dfs(neigh, node, adjList, seen)){
                    return true;
                }
            }
        }

        return false;
    }

    public static boolean isCycle(int n, Map<Integer, List<Integer>> adjList){
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++){
            // is not seen
            if(!seen[i]){
                boolean hasCycle = dfs(i, -1, adjList, seen);
                if(hasCycle){
                    return true;
                }
            }
        }
        return false;
    }
    public static boolean bfs(Map<Integer, List<Integer>> adjList, int src, int n, boolean[] seen){
        /* parent[] keep track of the previous node for each node */

        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(src);
        while(!queue.isEmpty()){
            int node = queue.poll();
            seen[node] = true;

            for(int neigh: adjList.get(node)){
                if(!seen[neigh]){
                    parent[neigh] = node;
                    queue.add(neigh);

                }
                /* when neigh does not come from node but has seen before, there is another path that has directed to node-neigh before */
                else if(parent[neigh] != node){
                    return true;
                }
            }
        }
        return false;
    }
    public boolean detectCycleBfsCaller(int n, Map<Integer, List<Integer>> adjList){
        boolean[] seen = new boolean[n];
        for(int i=0; i<n; i++){
            if(!seen[i] && bfs(adjList, i, n, seen)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int n = 6;
        List<int[]> edges = new ArrayList<>();
        edges.add(new int[]{0,1});
        edges.add(new int[]{1,2});
        edges.add(new int[]{2,4});
        edges.add(new int[]{4,5});
        edges.add(new int[]{1,3});
        edges.add(new int[]{2,3});


        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] edge: edges){
            adjList.computeIfAbsent(edge[0], k->new ArrayList<>()).add(edge[1]);
        }
        System.out.println(isCycle(n, adjList));
    }



}
