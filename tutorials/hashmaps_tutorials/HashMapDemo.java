package tutorials.hashmaps_tutorials;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapDemo {
    public static void main(String[] args) {
        // Declaration with no limit
        HashMap<Integer, String> map = new HashMap<>();
        // DEclaration with limit
        HashMap<Integer, String> map1 = new HashMap<>(10, 0.50f);

        // set data
        map.put(1, "A");
        map.put(2, "B");

        // get Data

        // with existing key
        System.out.println(map.get(1)); // "A"
        // with non-existing key
        System.out.println(map.get(3)); // null
        System.out.println(map); // {1=A, 2=B}

        // Over-riding:
        map.put(3, "Cc");
        System.out.println(map.get(3)); // Cc
        map.put(3, "C");
        System.out.println(map.get(3)); // C

        // to check key exists
        System.out.println(map.containsKey(10)); // false
        System.out.println(map.containsKey(1)); // true
        System.out.println(map.containsValue("X")); // false
        System.out.println(map.containsValue("B")); // true

        // Iterations: type:1
        Set<Integer> keys = map.keySet();
        System.out.print("{ ");
        for (int key : keys) {
            System.out.print(" " + key + "=" + map.get(key));
            System.out.print(",");
        }
        System.out.print("}");
        System.out.println();
        // Iterations: type:2
        System.out.print("{ ");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.print(" " + entry.getKey() + "=" + entry.getValue());
            System.out.print(",");
        }
        System.out.print("}");

        System.out.println();
        // keeping null as value
        map.put(4, null);
        map.put(5, null);

        // keeping null as key
        map.put(null, "Null-1");
        map.put(null, "Null-2");
        System.out.println(map.get(4)); // null
        System.out.println(map.get(null)); // Null-2

        // delete exiting key
        map.put(26, "Z");
        System.out.println(map.remove(26));         // Z

        // delete non-exiting key
        System.out.println(map.remove(25));         // null

        map.put(7, "G");
        System.out.println(map.remove(7, "g"));  // false
        System.out.println(map.remove(7, "G"));  // true
    }
}
