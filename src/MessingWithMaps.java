import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class MessingWithMaps {

    void main() {

        basicHashMapExample();
        linkedHashMapExample();
        treeMapExample();
        overwriteExample();
        mapOperationsExample();
        iterationExamples();
        countingExample();
    }

    // ------------------------------------------------------------
    // 1. Basic HashMap example
    //    - HashMap is the most common Map implementation.
    //    - It does NOT preserve order.
    //    - Offers O(1) average-time performance for put/get/remove.
    // ------------------------------------------------------------
    private static void basicHashMapExample() {
        IO.println("\n=== HashMap Basic Example ===");

        // A HashMap stores key-value pairs with no guaranteed order.
        Map<String, Integer> ages = new HashMap<>();

        ages.put("Alice", 30);
        ages.put("Bob", 25);
        ages.put("Charlie", 35);

        // Retrieve a value by key.
        IO.println("Alice's age: " + ages.get("Alice"));

        // Print entire map (unordered).
        IO.println("HashMap contents: " + ages);
    }

    // ------------------------------------------------------------
    // 2. LinkedHashMap example
    //    - Preserves insertion order.
    //    - Slightly slower than HashMap.
    //    - Useful when predictable iteration order matters.
    // ------------------------------------------------------------
    private static void linkedHashMapExample() {
        IO.println("\n=== LinkedHashMap Example (Preserves Insertion Order) ===");

        Map<String, String> settings = new LinkedHashMap<>();

        settings.put("theme", "dark");
        settings.put("fontSize", "14px");
        settings.put("language", "en");

        // Order is exactly the order of insertion.
        IO.println("LinkedHashMap contents: " + settings);
    }

    // ------------------------------------------------------------
    // 3. TreeMap example
    //    - Automatically sorts keys.
    //    - Uses a Red-Black Tree internally.
    //    - Slower than HashMap (O(log n) operations).
    //    - Great when you need sorted keys.
    // ------------------------------------------------------------
    private static void treeMapExample() {
        IO.println("\n=== TreeMap Example (Sorted by Key) ===");

        Map<Integer, String> errorCodes = new TreeMap<>();

        errorCodes.put(500, "Server Error");
        errorCodes.put(200, "OK");
        errorCodes.put(404, "Not Found");

        // Keys are sorted automatically.
        IO.println("TreeMap contents: " + errorCodes);
    }

    // ------------------------------------------------------------
    // 4. Overwriting values
    //    - Maps replace the old value when the same key is inserted again.
    // ------------------------------------------------------------
    private static void overwriteExample() {
        IO.println("\n=== Overwrite Example ===");

        Map<String, String> capitals = new HashMap<>();

        capitals.put("France", "Paris");
        capitals.put("France", "PARIS"); // Overwrites previous value.

        IO.println("Updated capitals map: " + capitals);
    }

    // ------------------------------------------------------------
    // 5. Map operations: containsKey, containsValue, remove
    // ------------------------------------------------------------
    private static void mapOperationsExample() {
        IO.println("\n=== Map Operations Example ===");

        Map<String, Integer> scores = new HashMap<>();

        scores.put("Alice", 90);
        scores.put("Bob", 80);
        scores.put("Charlie", 85);

        IO.println("Contains key 'Bob'? " + scores.containsKey("Bob"));
        IO.println("Contains value 85? " + scores.containsValue(85));

        scores.remove("Charlie");
        IO.println("After removing Charlie: " + scores);
    }

    // ------------------------------------------------------------
    // 6. Iteration examples
    //    - Maps can be iterated by keys, values, or entries.
    // ------------------------------------------------------------
    private static void iterationExamples() {
        IO.println("\n=== Iteration Examples ===");

        Map<String, Double> prices = new LinkedHashMap<>();
        prices.put("Coffee", 2.99);
        prices.put("Tea", 1.99);
        prices.put("Sandwich", 4.49);

        // Iterate over keys.
        IO.println("Keys:");
        for (String item : prices.keySet()) {
            IO.println(" - " + item);
        }

        // Iterate over values.
        IO.println("Values:");
        for (Double price : prices.values()) {
            IO.println(" - " + price);
        }

        // Iterate over key-value pairs.
        IO.println("Entries:");
        for (Map.Entry<String, Double> entry : prices.entrySet()) {
            IO.println(" - " + entry.getKey() + ": " + entry.getValue());
        }
    }

    // ------------------------------------------------------------
    // 7. Counting example (classic Map use case)
    //    - Count occurrences of items.
    //    - Very common in analytics, logs, text processing, etc.
    // ------------------------------------------------------------
    private static void countingExample() {
        IO.println("\n=== Counting Example ===");

        String[] words = { "apple", "banana", "apple", "orange", "banana", "apple" };

        Map<String, Integer> counts = new HashMap<>();

        for (String word : words) {
            // If word not present, default to 0, then increment.
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        IO.println("Word counts: " + counts);
    }
}