package tutorials.list_tutorials.arraylist_tutorials;

import java.util.Arrays;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class ArrayListTutorial {

    // ArrayList creation without DataType
    public static void createArrayList() {

        // createArrayListWithoutDataType
        ArrayList v1 = new ArrayList();
        v1.add("1");
        v1.add(1);
        v1.add(true);
        System.out.println(v1);
        System.out.println("createArrayListWithoutDataType: " + v1.size()); // 3
        // System.out.println("createArrayListWithoutDataType: " + v1.capacity()); // 10

        // createArrayListWithDataType
        ArrayList<Integer> v2 = new ArrayList<>();
        v2.add(1);
        v2.add(2);
        v2.add(3);
        System.out.println("createArrayListWithDataType: " + v2.size()); // 3
        // System.out.println("createArrayListWithDataType: " + v2.capacity()); // 10
        // v2.add("123"); ==> throws error.

        // createArrayListWithArray
        Object[] arr = new Object[] { 1, 2, 3, 4, 5 };
        ArrayList<Integer> v3 = new ArrayList(Arrays.asList(arr));
        System.out.println("createArrayListWithArray: " + v3.size()); // 5
        // System.out.println("createArrayListWithArray: " + v3.capacity()); // 5

        // createArrayListWithSize
        ArrayList<String> v4 = new ArrayList<>(100);
        v4.add("Govind");
        System.out.println("createArrayListWithSize: " + v4.size()); // 1
        // System.out.println("createArrayListWithSize: " + v4.capacity()); // n [100]

    }

    public static void addToArrayList() {
        ArrayList<String> v = new ArrayList<>();
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        System.out.println(v); // [1, 2, 3, 4]

        // addToArrayListAtIndex
        ArrayList<String> v1 = new ArrayList<>();
        v1.add("1");
        v1.add("2");
        v1.add("3");
        v1.add("4");
        v1.add(0, "0");
        System.out.println(v1); // [0, 1, 2, 3, 4]

        // addArrayListToArrayListAtIndex
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();
        a.add("1");
        a.add("2");
        a.add("3");
        a.add("4");

        a1.add("govind");
        a1.add("maddala");

        a.add(0, "0");
        a.addAll(a1);
        a.addAll(3, a1);
        System.out.println(a); // [0, 1, 2, govind, maddala, 3, 4, govind, maddala]
    }

    public static void updateElement() {

        // updateElement
        ArrayList<String> v = new ArrayList<>();
        v.add("gowind");
        v.set(0, "govind"); // returns string
        System.out.println(v); // [govind]
        // v.setElementAt("govind Maddala", 0); //return void
        System.out.println(v); // [govind Maddala]
    }

    public static void deleteElement() {
        ArrayList<String> v = new ArrayList<>();

        // removing object by index
        v.add("gowind");
        v.add("maddala");
        v.remove(0); // []
        v.remove("maddala");

        System.out.println(v);
        v.add("govind");
        System.out.println(v); // [govind]

        // Removing ArrayList from ArrayList:
        ArrayList<String> a = new ArrayList<>();
        ArrayList<String> a1 = new ArrayList<>();
        a.add("1");
        a.add("2");

        a1.add("govind");
        a1.add("maddala");
        a.addAll(a1);
        System.out.println(a); // [1, 2, govind, maddala]
        a.removeAll(a1);
        System.out.println(a); // [1, 2]
        a.addAll(a1);
        System.out.println(a); // [1, 2, govind, maddala]
        a.add(3, "3");
        System.out.println(a); // [1, 2, govind, 3, maddala]
        a.removeAll(a1);
        System.out.println(a); // [1, 2, 3]
    }

    public static void verifyElementsInArrayList() {
        ArrayList<String> v = new ArrayList<>();
        v.add("govind");
        System.out.println(v.contains("govind")); // true

        ArrayList<String> a1 = new ArrayList<>();
        a1.add("govind");
        a1.add("maddala"); 
        System.out.println(v.containsAll(a1)); // false
    }

    public static void accessElementInArrayList() {
        ArrayList<String> v = new ArrayList<>();
        v.add("govind");
        v.add("maddala");

        System.out.println(v.get(0)); // maddala
    }

    public static void convertArrayListToArray() {
        ArrayList<String> v = new ArrayList<>();
        v.add("govind");
        v.add("govind");
        Object[] arr = v.toArray();
        String[] stringArr = v.toArray(new String[0]);
        System.out.println(stringArr.toString());
        System.out.println(Arrays.toString(arr)); // [govind, govind]
    }

    public static void getArrayListCapacityUsingReflexes()
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
        ArrayList<Integer> list = new ArrayList<>(5);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        list.add(1);
        Field field = ArrayList.class.getDeclaredField("elementData");
        field.setAccessible(true);
        Object[] elementData = (Object[]) field.get(list);
        System.out.println("ArrayList Capacity is: Before" + elementData.length);

        list.add(1);
        elementData = (Object[]) field.get(list);
        System.out.println("ArrayList Capacity is: Before" + elementData.length);
    }

    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {

        // ArrayListTutorial.createArrayList();
        // ArrayListTutorial.addToArrayList();
        // ArrayListTutorial.updateElement();
        // ArrayListTutorial.deleteElement();
        // ArrayListTutorial.verifyElementsInArrayList();
        // ArrayListTutorial.convertArrayListToArray();
        // ArrayListTutorial.getArrayListCapacityUsingReflexes();

        ArrayList<String> list = new ArrayList<>(10);

        list.add(0, "2");
        // list.add(1, "2");
        // list.add(2, "2");
        // System.out.println(list.get(0));
        // System.out.println(list);
    }

}
