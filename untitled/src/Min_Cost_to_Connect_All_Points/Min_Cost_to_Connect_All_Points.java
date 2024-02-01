package Min_Cost_to_Connect_All_Points;

import java.util.HashSet;
import java.util.PriorityQueue;

/*
    prim's algorithm, use a priority queue, sort ascendingly by distance,
    use visited set maintain if point index has been visited

    1st trial of using Pair as hashmap did not work because I did not specify it as comparable
 */
public class Min_Cost_to_Connect_All_Points {
    public static void main(String[] args) {
        int[][] points = new int[][]{
                {0,0},{2,2},{3,10},{5,2},{7,0}
        };
        System.out.println(minCostConnectPoints(points));
    }
    public static class Pair implements Comparable<Pair>{
        int startIndex;
        int endIndex;
        int dis;
        Pair(int startIndex, int endIndex, int dis){
            this.startIndex = startIndex;
            this.endIndex = endIndex;
            this.dis = dis;
        }
        public int compareTo(Pair that){
            return this.dis - that.dis;
        }
    }
    private static int distance(int[][] points, int i, int j){
        return Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
    }
    public static int minCostConnectPoints(int[][] points){
        int cost=0;
        int n = points.length;
        HashSet<Integer> visited = new HashSet<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,0,0));
        while(!pq.isEmpty() && visited.size()< n){
            Pair curr = pq.poll();
            int endId = curr.endIndex;
            int dis = curr.dis;

            if(!visited.contains(endId)){
                visited.add(endId);
                cost += dis;
                for(int i=0; i<n; i++){
                    if(!visited.contains(i)){
                        pq.add(new Pair(endId, i, distance(points, endId, i)));
                    }
                }
            }
        }
        return cost;
    }
}
