import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LRU_Cache {
    Queue<Integer> keys = new LinkedList<>();
    Map<Integer, Integer> map = new HashMap<>();

    public int size = 0;
    LRU_Cache(int capacity){
        size = capacity;
    }
    /* if key exists in cache, remove from queue, then add to the end */
    int get(int key){
        if(map.containsKey(key)){
            /*
             queue.remove(item)
             */
            keys.remove(key);
            keys.add(key);
            return map.get(key);

        }
        else{
            return -1;
        }

    }
    /* 1. key exists in cache, remove from queue, add to the end
       2. cache size exceeds capacity, remove items from cache

     */

    void put(int key, int value){
        if(map.containsKey(key)){
            map.put(key, value);
            keys.remove(key);
            keys.add(key);
        }
        else{
            if(map.size() > size){
                int front = keys.poll();
                map.remove(key);
            }
            map.put(key, value);
            keys.add(key);
        }
    }
}
