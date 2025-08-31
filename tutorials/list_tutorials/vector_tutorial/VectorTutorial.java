package vector_tutorial;

import java.util.Arrays;
import java.util.Vector;

public class VectorTutorial {

    // Vector creation without DataType
    public static void createVector() {

        // createVectorWithoutDataType
        Vector v1 = new Vector();
        v1.add("1");
        v1.add(1);
        v1.add(true);
        System.out.println(v1);
        System.out.println("createVectorWithoutDataType: " + v1.size()); // 3
        System.out.println("createVectorWithoutDataType: " + v1.capacity()); // 10

        // createVectorWithDataType
        Vector<Integer> v2 = new Vector<>();
        v2.add(1);
        v2.add(2);
        v2.add(3);
        System.out.println("createVectorWithDataType: " + v2.size()); // 3
        System.out.println("createVectorWithDataType: " + v2.capacity()); // 10
        // v2.add("123"); ==> throws error.

        // createVectorWithArray
        Object[] arr = new Object[] { 1, 2, 3, 4, 5 };
        Vector<Integer> v3 = new Vector(Arrays.asList(arr));
        System.out.println("createVectorWithArray: " + v3.size()); // 5
        System.out.println("createVectorWithArray: " + v3.capacity()); // 5

        // createVectorWithSize
        Vector<String> v4 = new Vector<>(100);
        v4.add("Govind");
        System.out.println("createVectorWithSize: " + v4.size()); // 1
        System.out.println("createVectorWithSize: " + v4.capacity()); // n [100]

    }

    public static void addToVector() {
        Vector<String> v = new Vector<>();
        v.add("1");
        v.add("2");
        v.add("3");
        v.add("4");
        System.out.println(v); // [1, 2, 3, 4]

        // addToVectorAtIndex
        Vector<String> v1 = new Vector<>();
        v1.add("1");
        v1.add("2");
        v1.add("3");
        v1.add("4");
        v1.add(0, "0");
        System.out.println(v1); // [0, 1, 2, 3, 4]

        // addVectorToVectorAtIndex
        Vector<String> a = new Vector<>();
        Vector<String> a1 = new Vector<>();
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
        Vector<String> v = new Vector<>();
        v.add("gowind");
        v.set(0, "govind"); // returns string
        System.out.println(v); // [govind]
        v.setElementAt("govind Maddala", 0); //return void
        System.out.println(v); // [govind Maddala]
    }

    public static void deleteElement() {
        Vector<String> v = new Vector<>();

        // removing object by index
        v.add("gowind");
        v.remove(0); // []
        System.out.println(v);
        v.add("govind");
        System.out.println(v); // [govind]

        // Removing vector from vector:
        Vector<String> a = new Vector<>();
        Vector<String> a1 = new Vector<>();
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

    public static void verifyElementsInVector(){
        Vector<String> v = new Vector<>();
        v.add("govind");
        System.out.println(v.contains("govind")); //true

        Vector<String> a1 = new Vector<>();
        a1.add("govind");
        a1.add("maddala");
        System.out.println(v.containsAll(a1)); //false
    }

    public static void convertVectorToArray(){
        Vector<String> v = new Vector<>();
        v.add("govind");
        v.add("govind");
        Object[] arr = v.toArray();
        System.out.println(Arrays.toString(arr)); // [govind, govind]
    }

    public static void main(String[] args) {

        // VectorTutorial.createVector();
        // VectorTutorial.addToVector();
        // VectorTutorial.updateElement();
        // VectorTutorial.deleteElement();
        // VectorTutorial.verifyElementsInVector();
        VectorTutorial.convertVectorToArray();
    }

}
