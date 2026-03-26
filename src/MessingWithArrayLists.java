import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MessingWithArrayLists {

    void main() {

        basicExample();
        iterationExamples();
        removalExamples();
        sortingExamples();
        searchingExamples();
        nestedArrayListExample();
    }

    // ------------------------------------------------------------
    // 1. Basic add/get/set usage (your original example)
    // ------------------------------------------------------------
    private static void basicExample() {
        IO.println("\n=== Basic Example ===");

        List<String> topics = new ArrayList<>();

        topics.add("Variables");
        topics.add("Conditionals");
        topics.add("Loops");
        topics.add("Methods");

        IO.println("First topic: " + topics.get(0));
        IO.println("Third topic: " + topics.get(2));

        topics.set(1, "If Statements");

        IO.println("Topics: " + topics);
    }

    // ------------------------------------------------------------
    // 2. Iteration examples
    // ------------------------------------------------------------
    private static void iterationExamples() {
        IO.println("\n=== Iteration Examples ===");

        List<String> fruits = new ArrayList<>();
        fruits.add("Apple");
        fruits.add("Orange");
        fruits.add("Banana");

        IO.println("For-each loop:");
        for (String fruit : fruits) {
            IO.println(" - " + fruit);
        }

        IO.println("Indexed loop:");
        for (int i = 0; i < fruits.size(); i++) {
            IO.println("Index " + i + ": " + fruits.get(i));
        }
    }

    // ------------------------------------------------------------
    // 3. Removal examples
    // ------------------------------------------------------------
    private static void removalExamples() {
        IO.println("\n=== Removal Examples ===");

        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Bob");

        IO.println("Original: " + names);

        names.remove(1); // remove by index
        IO.println("After removing index 1: " + names);

        names.remove("Bob"); // remove first occurrence by value
        IO.println("After removing 'Bob': " + names);
    }

    // ------------------------------------------------------------
    // 4. Sorting examples
    // ------------------------------------------------------------
    private static void sortingExamples() {
        IO.println("\n=== Sorting Examples ===");

        List<Integer> numbers = new ArrayList<>();
        numbers.add(42);
        numbers.add(7);
        numbers.add(19);
        numbers.add(3);

        IO.println("Unsorted: " + numbers);

        Collections.sort(numbers);
        IO.println("Sorted ascending: " + numbers);

        numbers.sort(Collections.reverseOrder());
        IO.println("Sorted descending: " + numbers);
    }

    // ------------------------------------------------------------
    // 5. Searching examples
    // ------------------------------------------------------------
    private static void searchingExamples() {
        IO.println("\n=== Searching Examples ===");

        List<String> animals = new ArrayList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");

        IO.println("Animals: " + animals);

        IO.println("Contains 'Cat'? " + animals.contains("Cat"));
        IO.println("Index of 'Horse': " + animals.indexOf("Horse"));
        IO.println("Index of 'Lion': " + animals.indexOf("Lion"));
    }

    // ------------------------------------------------------------
    // 6. Nested ArrayList example
    // ------------------------------------------------------------
    private static void nestedArrayListExample() {
        IO.println("\n=== Nested ArrayList Example ===");

        List<List<Integer>> matrix = new ArrayList<>();

        matrix.add(new ArrayList<>(List.of(1, 2, 3)));
        matrix.add(new ArrayList<>(List.of(4, 5, 6)));
        matrix.add(new ArrayList<>(List.of(7, 8, 9)));

        IO.println("Matrix:");
        for (List<Integer> row : matrix) {
            IO.println(row);
        }

        IO.println("Element at row 1, col 2: " + matrix.get(1).get(2));
    }
}
