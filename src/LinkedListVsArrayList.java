import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LinkedListVsArrayList {

    void main() {

        explainConcepts();

        int[] sizes = {10_000, 1_000_000}; // add your own sizes here

        for (int size : sizes) {
            IO.println("\n==============================");
            IO.println("   TESTING SIZE: " + size);
            IO.println("==============================");

            compareAddPerformance(size);
            compareGetPerformance(size);
            compareRemovePerformance(size);
            compareMiddleInsertPerformance(size);
            compareMiddleRemovePerformance(size);
        }

        explainWhyBillionIsImpossible();
    }

    // ------------------------------------------------------------
    // 1. High-level explanation of strengths and weaknesses
    // ------------------------------------------------------------
    private static void explainConcepts() {
        IO.println("\n=== Conceptual Overview ===");

        IO.println("""
                ArrayList:
                  - Dynamic array.
                  - Fast random access (O(1)).
                  - Middle inserts/removals require shifting (O(n)).
                  - Appending is very fast except during resize events.
                  - Excellent CPU cache locality.

                LinkedList:
                  - Doubly-linked list.
                  - Fast inserts/removals at ends (O(1)).
                  - Slow random access (O(n)).
                  - Middle inserts/removals require traversal (O(n)).
                  - High memory overhead (node objects).

                IMPORTANT NOTE ABOUT APPENDING:
                  - LinkedList append is ALWAYS O(1).
                  - ArrayList append is AMORTIZED O(1).
                  - ArrayList is usually faster in practice because it writes into
                    contiguous memory.
                  - ArrayList becomes slower ONLY when it must resize its internal array.
                """);
    }

    // ------------------------------------------------------------
    // 2. Add performance
    // ------------------------------------------------------------
    private static void compareAddPerformance(int size) {
        IO.println("\n=== Add Performance Test ===");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        long start, end;

        // ArrayList add
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.add(i); // Fast except during resize
        }
        end = System.currentTimeMillis();
        IO.println("ArrayList add(end):   " + (end - start) + " ms");

        // LinkedList add
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.add(i); // Always O(1), but allocates a new node each time
        }
        end = System.currentTimeMillis();
        IO.println("LinkedList add(end):  " + (end - start) + " ms");

        IO.println("""
                NOTE:
                  LinkedList append is theoretically O(1),
                  but ArrayList often wins due to:
                    - contiguous memory
                    - fewer allocations
                    - better cache locality
                  LinkedList only wins during ArrayList resize events.
                """);
    }

    // ------------------------------------------------------------
    // 3. Get performance
    // ------------------------------------------------------------
    private static void compareGetPerformance(int size) {
        IO.println("\n=== Get Performance Test ===");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start, end;

        // ArrayList get
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.get(i); // Direct index access
        }
        end = System.currentTimeMillis();
        IO.println("ArrayList get:   " + (end - start) + " ms");

        // LinkedList get
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.get(i); // Must traverse from head or tail
        }
        end = System.currentTimeMillis();
        IO.println("LinkedList get:  " + (end - start) + " ms");
    }

    // ------------------------------------------------------------
    // 4. Remove-from-front performance
    // ------------------------------------------------------------
    private static void compareRemovePerformance(int size) {
        IO.println("\n=== Remove-from-Front Performance Test ===");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        long start, end;

        // ArrayList remove(0)
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arrayList.remove(0); // Shifts all elements left
        }
        end = System.currentTimeMillis();
        IO.println("ArrayList remove(0):   " + (end - start) + " ms");

        // LinkedList remove(0)
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            linkedList.remove(0); // Updates head pointer
        }
        end = System.currentTimeMillis();
        IO.println("LinkedList remove(0):  " + (end - start) + " ms");
    }

    // ------------------------------------------------------------
    // 5. Middle insert performance
    // ------------------------------------------------------------
    private static void compareMiddleInsertPerformance(int size) {
        IO.println("\n=== Middle Insert Performance Test ===");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        int middle = size / 2;

        long start, end;

        // ArrayList insert in middle
        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000; i++) {
            arrayList.add(middle, -1);
        }
        end = System.currentTimeMillis();
        IO.println("ArrayList insert(mid):   " + (end - start) + " ms");

        // LinkedList insert in middle
        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000; i++) {
            linkedList.add(middle, -1);
        }
        end = System.currentTimeMillis();
        IO.println("LinkedList insert(mid):  " + (end - start) + " ms");

        IO.println("""
                NOTE:
                  Both operations are O(n), but:
                    - ArrayList shifts contiguous memory (fast)
                    - LinkedList must traverse node-by-node (slow)
                """);
    }

    // ------------------------------------------------------------
    // 6. Middle remove performance
    // ------------------------------------------------------------
    private static void compareMiddleRemovePerformance(int size) {
        IO.println("\n=== Middle Remove Performance Test ===");

        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < size; i++) {
            arrayList.add(i);
            linkedList.add(i);
        }

        int middle = size / 2;

        long start, end;

        // ArrayList remove in middle
        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000; i++) {
            arrayList.remove(middle); // shifts elements left
        }
        end = System.currentTimeMillis();
        IO.println("ArrayList remove(mid):   " + (end - start) + " ms");

        // LinkedList remove in middle
        start = System.currentTimeMillis();
        for (int i = 0; i < 5_000; i++) {
            linkedList.remove(middle); // must traverse to middle
        }
        end = System.currentTimeMillis();
        IO.println("LinkedList remove(mid):  " + (end - start) + " ms");

        IO.println("""
                NOTE:
                  Both are O(n), but LinkedList is slower because:
                    - it must traverse to the middle
                    - nodes are scattered in memory
                    - pointer chasing causes cache misses
                """);
    }

    // ------------------------------------------------------------
    // 7. Explain why 1 billion elements is impossible
    // ------------------------------------------------------------
    private static void explainWhyBillionIsImpossible() {
        IO.println("\n=== Why We Cannot Test 1,000,000,000 Elements ===");

        IO.println("""
                A list of one billion Integer objects cannot fit in memory.

                Memory requirements:
                  - ArrayList:
                      ~16 GB for Integer objects
                      ~4 GB for internal array
                      ~20+ GB total

                  - LinkedList:
                      ~16 GB for Integer objects
                      ~30–40 GB for Node objects
                      ~50+ GB total

                No typical machine has this much heap space available.
                Therefore, we benchmark realistic sizes instead.
                """);
    }
}