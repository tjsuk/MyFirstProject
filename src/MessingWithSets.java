import java.util.LinkedList;
import java.util.List;

public class MessingWithSets {

    void main() {

        basicExample();
        queueBehaviorExample();
        stackBehaviorExample();
        iterationExamples();
        removalExamples();
        searchingExamples();
        linkedListAsDequeExample();
    }

    // ------------------------------------------------------------
    // 1. Basic add/remove usage (your original example)
    // ------------------------------------------------------------
    private static void basicExample() {
        IO.println("\n=== Basic Example ===");

        LinkedList<String> tasks = new LinkedList<>();

        tasks.add("Review pull request");
        tasks.add("Run tests");
        tasks.add("Deploy build");

        String nextTask = tasks.removeFirst();
        IO.println("Next task: " + nextTask);

        tasks.addLast("Check logs");

        IO.println("Remaining tasks: " + tasks);
    }

    // ------------------------------------------------------------
    // 2. Queue behaviour (FIFO)
    // ------------------------------------------------------------
    private static void queueBehaviorExample() {
        IO.println("\n=== Queue Behaviour Example (FIFO) ===");

        LinkedList<String> queue = new LinkedList<>();

        queue.offer("User login");
        queue.offer("Load dashboard");
        queue.offer("Fetch notifications");

        IO.println("Queue: " + queue);

        IO.println("Processing: " + queue.poll());
        IO.println("Processing: " + queue.poll());

        IO.println("Remaining queue: " + queue);
    }

    // ------------------------------------------------------------
    // 3. Stack behaviour (LIFO)
    // ------------------------------------------------------------
    private static void stackBehaviorExample() {
        IO.println("\n=== Stack Behaviour Example (LIFO) ===");

        LinkedList<String> stack = new LinkedList<>();

        stack.push("Open file");
        stack.push("Edit file");
        stack.push("Save file");

        IO.println("Stack: " + stack);

        IO.println("Popped: " + stack.pop());
        IO.println("Popped: " + stack.pop());

        IO.println("Remaining stack: " + stack);
    }

    // ------------------------------------------------------------
    // 4. Iteration examples
    // ------------------------------------------------------------
    private static void iterationExamples() {
        IO.println("\n=== Iteration Examples ===");

        List<String> cities = new LinkedList<>();
        cities.add("London");
        cities.add("Paris");
        cities.add("Berlin");

        IO.println("For-each loop:");
        for (String city : cities) {
            IO.println(" - " + city);
        }

        IO.println("Indexed loop (less efficient for LinkedList):");
        for (int i = 0; i < cities.size(); i++) {
            IO.println("Index " + i + ": " + cities.get(i));
        }
    }

    // ------------------------------------------------------------
    // 5. Removal examples
    // ------------------------------------------------------------
    private static void removalExamples() {
        IO.println("\n=== Removal Examples ===");

        LinkedList<String> names = new LinkedList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("Bob");

        IO.println("Original: " + names);

        names.removeFirst(); // remove head
        IO.println("After removeFirst(): " + names);

        names.removeLast(); // remove tail
        IO.println("After removeLast(): " + names);

        names.remove("Bob"); // remove by value
        IO.println("After removing 'Bob': " + names);
    }

    // ------------------------------------------------------------
    // 6. Searching examples
    // ------------------------------------------------------------
    private static void searchingExamples() {
        IO.println("\n=== Searching Examples ===");

        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Horse");

        IO.println("Animals: " + animals);

        IO.println("Contains 'Cat'? " + animals.contains("Cat"));
        IO.println("Index of 'Horse': " + animals.indexOf("Horse"));
        IO.println("Index of 'Lion': " + animals.indexOf("Lion"));
    }

    // ------------------------------------------------------------
    // 7. LinkedList as a Deque (double-ended queue)
    // ------------------------------------------------------------
    private static void linkedListAsDequeExample() {
        IO.println("\n=== Deque Example ===");

        LinkedList<Integer> deque = new LinkedList<>();

        deque.addFirst(10);
        deque.addLast(20);
        deque.addFirst(5);
        deque.addLast(30);

        IO.println("Deque: " + deque);

        IO.println("Removed first: " + deque.removeFirst());
        IO.println("Removed last: " + deque.removeLast());

        IO.println("Remaining deque: " + deque);
    }
}
