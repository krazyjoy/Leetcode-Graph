package Reorder_Routes_Make_all_paths_Leads_to_City_Zero;

import java.util.*;

/*
    1466. Reorder Routes to Make all Paths Lead to City Zero
    There are n cities numbered from 0 to n - 1 and n - 1 roads such that there is only one way to travel between two different cities (this network form a tree). Last year, The ministry of transport decided to orient the roads in one direction because they are too narrow.

    Roads are represented by connections where connections[i] = [ai, bi] represents a road from city ai to city bi.

    This year, there will be a big event in the capital (city 0), and many people want to travel to this city.

    Your task consists of reorienting some roads such that each city can visit the city 0. Return the minimum number of edges changed.

    It's guaranteed that each city can reach city 0 after reorder.



    build undirected graph to visit nodes in ingoing directions
    recursively dfs neighbor nodes starting from node 0, then check if it is ingoing toward 0, then change += 1

 */
public class reorder_routes_to_make_all_paths_lead_to_city_zero {
    public static void main(String[] args) {
        // n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]
        int[][] connections = new int[][]{{0,1},{1,3},{2,3},{4,0},{4,5}};
        System.out.println(minReorder(6, connections));
    }

    public static int minReorder(int n, int[][] connections){
        HashMap<Integer, List<Integer>> graph = new HashMap<Integer, List<Integer>>();
        Set<String> roads = new HashSet<>();
        for(int i=0; i<n; i++){
            graph.put(i, new ArrayList<>());
        }
        for(int i=0; i< connections.length; i++){

            graph.get(connections[i][0]).add(connections[i][1]);
            graph.get(connections[i][1]).add(connections[i][0]);
            roads.add(hashroad(connections[i][0], connections[i][1]));

        }
        boolean[] seen = new boolean[n];
        seen[0] = true;
        return dfs(graph, roads, seen, 0);
    }
    public static int dfs(HashMap<Integer, List<Integer>> graph, Set<String> roads, boolean[] seen, int node){
        int change=0;
        for(int neigh: graph.get(node)){
            if(!seen[neigh]){
                if(roads.contains(hashroad(node, neigh))){
                    change+=1;
                }
                seen[neigh] = true;
                change += dfs(graph, roads, seen, neigh);
            }
        }
        return change;
    }
    public static String hashroad(int u, int v){
        return String.valueOf(u) + "," + String.valueOf(v);
    }

}
