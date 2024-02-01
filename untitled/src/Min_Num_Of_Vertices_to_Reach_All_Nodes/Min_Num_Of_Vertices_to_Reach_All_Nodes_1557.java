package Min_Num_Of_Vertices_to_Reach_All_Nodes;
import Min_Num_Of_Vertices_to_Reach_All_Nodes.union_find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Min_Num_Of_Vertices_to_Reach_All_Nodes_1557 {

    public static void main(String[] args) {
        int n = 6;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(2, 5),
                Arrays.asList(3, 4),
                Arrays.asList(4, 2)
        );
        System.out.println(findSmallestSetVertices1(n, edges));
    }
    public static List<Integer> findSmallestSetVertices1(int n, List<List<Integer>> edges){
        union_find uf = new union_find(n);

        for(List<Integer> edge: edges){
            int from = edge.get(0);
            int to = edge.get(1);

            uf.union(from, to);
        }

        List<Integer> rootSet = new ArrayList<>();
        for(int i=0; i<n; i++){
            if(uf.parent[i] == i){
                rootSet.add(i);
            }
        }
        return rootSet;
    }
}
