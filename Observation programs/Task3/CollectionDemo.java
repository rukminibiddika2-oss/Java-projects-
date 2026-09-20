import java.util.*;

public class CollectionDemo {
    public static void main(String[] args) {

        // ArrayList
        ArrayList<String> list = new ArrayList<>();

        list.add("Java");
        list.add("C");
        list.add("Python");
        list.add("HTML");

        System.out.println("ArrayList: " + list);
        System.out.println("First Element: " + list.get(0));

        list.remove("HTML");
        System.out.println("After Removing: " + list);

        // HashSet
        HashSet<Integer> set = new HashSet<>();

        set.add(10);
        set.add(20);
        set.add(30);
        set.add(20);

        System.out.println("\nHashSet: " + set);

        // HashMap
        HashMap<Integer, String> map = new HashMap<>();

        map.put(101, "Ravi");
        map.put(102, "Biddika");
        map.put(103, "Sita");

        System.out.println("\nHashMap: " + map);
        System.out.println("Student 102: " + map.get(102));

        // Queue
        Queue<String> queue = new LinkedList<>();

        queue.add("A");
        queue.add("B");
        queue.add("C");

        System.out.println("\nQueue: " + queue);
        System.out.println("Removed: " + queue.remove());
        System.out.println("Queue after removal: " + queue);

        // Sorting
        Collections.sort(list);
        System.out.println("\nSorted ArrayList: " + list);
    }
}
