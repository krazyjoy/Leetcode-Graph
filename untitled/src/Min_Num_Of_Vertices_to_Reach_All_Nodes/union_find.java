package Min_Num_Of_Vertices_to_Reach_All_Nodes;

import java.util.Arrays;

public class union_find {
    int[] parent;
    int[] rank;
    public union_find(int size){
        this.parent = new int[size];
        this.rank = new int[size];
        for(int i=0; i<size; i++){
            this.parent[i] = i;
        }
        Arrays.fill(this.rank, 1);
    }

    public int find(int u){
        if(this.parent[u] == u){
            return u;
        }
        return this.parent[u] = find(this.parent[u]);
    }

    public void union(int u, int v){
        int uu = find(u);
        int vv = find(v);

        if(uu!=vv){
            // make uu higher rank
            if(this.rank[uu] > this.rank[vv]){
                this.parent[vv] = uu;
            }
            else if(this.rank[uu] < this.rank[vv]){
                this.parent[uu] = vv;
            }
            else{
                this.parent[vv] = uu;
                this.rank[uu] += 1;
            }
        }
    }
}
