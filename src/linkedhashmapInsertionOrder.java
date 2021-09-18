import java.util.LinkedHashMap;
import java.util.Map;

public class linkedhashmapInsertionOrder<K, V> extends LinkedHashMap<K, V>{

    public static void main(String[] args){
        Map<Integer,Integer> linkedhashmap=new LinkedHashMap<Integer,Integer>(4,1f,false);
        linkedhashmap.put(1,1);
        linkedhashmap.put(2,2);
        linkedhashmap.put(3,3);
        linkedhashmap.put(1,1);
        //insertion order doesnt change the order of element if reinserted
        System.out.println("Map with insertion order true "+linkedhashmap);

        Map<Integer,Integer> linkedhashmap2=new LinkedHashMap<Integer,Integer>(4,1f,true);
        linkedhashmap2.put(1,1);
        linkedhashmap2.put(2,2);
        linkedhashmap2.put(3,3);
        linkedhashmap2.put(1,1);

        //access order will put the reinserted element to the last of map and lru element to the first of map
        System.out.println("Map with access order true "+linkedhashmap2);

    }
}
