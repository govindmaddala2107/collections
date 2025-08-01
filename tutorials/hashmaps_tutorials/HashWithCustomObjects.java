package tutorials.hashmaps_tutorials;

import java.util.HashMap;
import java.util.Objects;

public class HashWithCustomObjects {
    public static void main(String[] args) {
        HashMap<Person, String> map = new HashMap<>();
        Person p1 = new Person("Alice", 1);
        Person p2 = new Person("Bhavik", 2);
        Person p3 = new Person("Alice", 1);

        map.put(p1, "Engineer");
        map.put(p2, "Manager");
        map.put(p3, "Manager");
        System.out.println(map.get(p1));
    }
}

class Person {
    private String name;
    private int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()){
            return false;
        }

        Person other = (Person) obj;
        // return id == other.getId() && Objects.equals(name, other.getName());
        return id == other.getId() && name == other.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, id);
    }

    @Override
    public String toString() {
        return "{ id=" + id + ", name=" + name + " }";
    }

}