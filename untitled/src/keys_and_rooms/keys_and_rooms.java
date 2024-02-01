package keys_and_rooms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class keys_and_rooms {


    public static void main(String[] args) {

        Set<Integer> seen = new HashSet<>(); // to use seen as public variable set to "public static"
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(3)));
        rooms.add(new ArrayList<>());

        System.out.println(
                visit_all_rooms(seen, rooms)
        );
        seen = new HashSet<>();
        rooms = new ArrayList<>();
        rooms.add(new ArrayList<>(List.of(1,3)));
        rooms.add(new ArrayList<>(List.of(3,0,1)));
        rooms.add(new ArrayList<>(List.of(2)));
        rooms.add(new ArrayList<>(List.of(0)));
        System.out.println(
                visit_all_rooms(seen, rooms)
        );
    }


    public static boolean visit_all_rooms(Set<Integer> seen, List<List<Integer>> rooms){
        seen.add(0);
        dfs(seen, rooms, 0);

        return seen.size() == rooms.size();
    }

    public static void dfs(Set<Integer> seen, List<List<Integer>> rooms, int node){
        for(int neigh: rooms.get(node)){
            if(!seen.contains(neigh)){
                seen.add(neigh);
                dfs(seen, rooms, neigh);
            }
        }
    }
}
