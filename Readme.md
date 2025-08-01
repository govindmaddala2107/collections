# Collections:

- What is collections ?
  - Collections is a framework provided by Java.
  - This framework provides many interfaces, and their implemented classes in order to store group of objects(elements) in a single entity.
![Interface Provided](./images/InterfacesProvided.png)
- There is a **Collections** class which provide common **methods** like **filtering**, **sorting** etc., to perform on the classes provided.
![Classes Provided](./images/ClassesProvided.png)
![Classes Provided](./images/Hierarchy_collection.png)
![Classes Provided](./images/Hierarchy_collection_1.png)
![Classes Provided](./images/Hierarchy_map.png)
![Hierarchy of Collections](./images/image-1.png)
- HashTable <**class**> extends **Map**.
![Classes Provided](./images/ArrayListAndVector.png)
![Classes Provided](./images/ArrayListAndVectorAgenda.png)
![Classes Provided](./images/ListHeirarchy.png)
![Major Operations](./images/majorOperations.png)


![Cheat sheet](./images/cheatsheet.png)


### Hashmaps
- ![Hashmap hierarchy](image.png)
- ![Map definition](./images/image-1.png)
- ![Example-1](./images/image-2.png)
- ![Key characteristics-1](./images/image-3.png)
- ![Key characteristics-2](./images/image-4.png)
- Basic Operations of Hashmap:
  - ```
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
    ```
- Internal structure of Hashmap:
  - **Key**
    - The identifier used to retrieve the value [map.get(key)]
  - **Value**
    - The data associated with the key. [value = map.get(key)]
  - **Bucket**
    - A place where key-value pairs are stored. Think of buckets as cells in a list(array).
  - **Hash function**
    - Converts a key into an index(bucket location) for storage.
    - ![Hash function](./images/image-5.png)
    - ![Hash function characteristics](./images/image-6.png)
- How data is stored in HashMap:
  - **Step 1: Hashing the key**
    - ![Hashing the key](./images/image-7.png)
  - **Step 2: Calculating the Index**
    - ![Calculating the Index](./images/image-8.png)
  - **Step 3: Storing in the bucket**
    - ![Storing in the bucket](./images/image-9.png)
  - Example:
    - ![Example](./images/image-10.png)
- How HashMap retrieves the data:
  - ![Intro](./images/image-11.png)
  - Collision:
    ```
    package tutorials.hashmaps_tutorials;
    
    public class GenerateHash {
        public static void main(String[] args) {
            System.out.println(createHash("ABC"));   // 8
            System.out.println(createHash("BCA"));   // 8
            System.out.println(createHash("CAB"));   // 8
        }

        public static int createHash(String key) {
            int sum = 0;
            for (char c : key.toCharArray()) {
                sum += (int) c;
            }
            return sum % 10;
        }
    }
    ```
    - For same hashcode, it results in collision. In such case, keys are kept in bucket in linked-list. 
    - Class structure of each node of linked list is
      - ![Node](./images/image-12.png)
    - Handling collision
      - ![Handling collision](./images/image-13.png)
      - ![Handling collision example](./images/image-14.png)
- Rehashing [HashMap Resizing]
  - ![Rehashing](./images/image-15.png)
  - ```HashMap<Integer, String> map1 = new HashMap<>(10, 0.50f);```, here 0.50f is threshold value, when array size reaches this, array size increases.
  - Default size of bucket is 16 and threshold is 0.5f i.e at size 8 [TREEIFY_THRESHOLD], 
  - ![During rehashing](./images/image-16.png)
- Time complexity:
  - ![Time complexity](./images/image-17.png)
  - ![All](image.png)
  - ![alt text](image-1.png)
- Over-riding equals and Hash:
  - Code part:
