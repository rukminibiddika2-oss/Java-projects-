import java.util.*;

public class CollectionFrameworkDemo {

    public static void main(String[] args) {
        System.out.println("=============== JAVA COLLECTION FRAMEWORK DEMONSTRATION ===============");

        // 1. LIST DEMONSTRATION (Ordered, Allows Duplicates)
        System.out.println("\n[1] LIST INTERFACE (ArrayList Implementation)");
        List<String> list = new ArrayList<>();
        list.add("Java");
        list.add("Python");
        list.add("C++");
        list.add("Java"); // Duplicate entry

        System.out.println("Original List: " + list);
        System.out.println("Element at Index 1: " + list.get(1));
        list.sort(Comparator.naturalOrder());
        System.out.println("Sorted List: " + list);

        // 2. SET DEMONSTRATION (Unordered, Unique Elements)
        System.out.println("\n[2] SET INTERFACE (HashSet Implementation)");
        Set<Integer> set = new HashSet<>();
        System.out.println("Added 10: " + set.add(10));
        System.out.println("Added 20: " + set.add(20));
        System.out.println("Added 10 (Duplicate): " + set.add(10)); // Returns false
        System.out.println("Final Unique Set: " + set);

        // 3. NAVIGABLE SET DEMONSTRATION (Tree-based Range Enquiries)
        System.out.println("\n[3] NAVIGABLE SET INTERFACE (TreeSet Implementation)");
        NavigableSet<Integer> navSet = new TreeSet<>(Arrays.asList(10, 20, 30, 40, 50));
        System.out.println("Navigable Set: " + navSet);
        System.out.println("lower(30)   -> Greatest < 30: " + navSet.lower(30));
        System.out.println("floor(30)   -> Greatest <= 30: " + navSet.floor(30));
        System.out.println("ceiling(30) -> Smallest >= 30: " + navSet.ceiling(30));
        System.out.println("higher(30)  -> Smallest > 30: " + navSet.higher(30));

        // 4. QUEUE DEMONSTRATION (FIFO Operations)
        System.out.println("\n[4] QUEUE INTERFACE (LinkedList Queue Implementation)");
        Queue<String> queue = new LinkedList<>();
        queue.offer("Task 1");
        queue.offer("Task 2");
        queue.offer("Task 3");

        System.out.println("Queue Head (peek): " + queue.peek());
        System.out.println("Processing Queue (poll):");
        while (!queue.isEmpty()) {
            System.out.println(" -> Processed: " + queue.poll());
        }

        // 5. MAP DEMONSTRATION (Key-Value Pairs)
        System.out.println("\n[5] MAP INTERFACE (HashMap Implementation)");
        Map<String, Integer> map = new HashMap<>();
        map.put("Alice", 85);
        map.put("Bob", 92);
        map.put("Charlie", 78);

        System.out.println("Map Contents:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(" Key: " + entry.getKey() + " | Value: " + entry.getValue());
        }

        System.out.println("\n=======================================================================");
    }
}
