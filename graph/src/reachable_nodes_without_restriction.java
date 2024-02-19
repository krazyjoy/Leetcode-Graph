import java.util.*;

public class reachable_nodes_without_restriction {

    /*
        There is an undirected tree with n nodes labeled from 0 to n - 1 and n - 1 edges.

You are given a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree. You are also given an integer array restricted which represents restricted nodes.

Return the maximum number of nodes you can reach from node 0 without visiting a restricted node.

Note that node 0 will not be a restricted node.


     */
    class Solution {
        int ans=0;
        public int reachableNodes(int n, int[][] edges, int[] restricted) {

            Map<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();

            Set<Integer> set = new HashSet<>();
            for(int restrictNode: restricted){
                set.add(restrictNode);
            }
            for(int i=0; i<n; i++){
                graph.put(i, new ArrayList<Integer>());

            }

            for(int[] edge: edges){
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }





            dfs(graph, set, 0);

            return ans;
        }

        public void dfs(Map<Integer, List<Integer>> graph, Set<Integer> set, int node){
            ans += 1;
            set.add(node);


            for(int next_node: graph.get(node)){
                if(!set.contains(next_node))
                    dfs(graph, set, next_node);
            }


        }
    }
}
