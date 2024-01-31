import java.util.Arrays;
import java.util.Random;

public class Tester {

    public static void main(String[] args) {
        int[] sizes = {10, 100, 1000}; // Size of arrays to test

        // Test for random arrays
        System.out.println("********** RANDOM ARRAYS **********");
        for (int size : sizes) {
            System.out.println("--- Array Size: " + size + " ---");
            int[] original = createRandomArray(size);
            for (int i = 1; i <= 5; i++) {
                testAndPrint("sort" + i, Arrays.copyOf(original, original.length));
            }
        }

        // Test for ascending arrays
        System.out.println("********* ASCENDING ARRAYS *********");
        for (int size : sizes) {
            System.out.println("--- Array Size: " + size + " ---");
            int[] original = createAscendingArray(size);
            for (int i = 1; i <= 5; i++) {
                testAndPrint("sort" + i, Arrays.copyOf(original, original.length));
            }
        }

        // Test for descending arrays
        System.out.println("********* DESCENDING ARRAYS *********");
        for (int size : sizes) {
            System.out.println("--- Array Size: " + size + " ---");
            int[] original = createDescendingArray(size);
            for (int i = 1; i <= 5; i++) {
                testAndPrint("sort" + i, Arrays.copyOf(original, original.length));
            }
        }
    }

    private static void testAndPrint(String sortMethod, int[] array) {
        System.out.println("Testing " + sortMethod + "...");
        System.out.println("Original Array: " + Arrays.toString(Arrays.copyOf(array, Math.min(array.length, 10))));

        long startTime = System.nanoTime();
        switch (sortMethod) {
            case "sort1":
                sorter.sort1(array);
                break;
            case "sort2":
                sorter.sort2(array);
                break;
            case "sort3":
                sorter.sort3(array);
                break;
            case "sort4":
                sorter.sort4(array);
                break;
            case "sort5":
                sorter.sort5(array);
                break;
        }
        long endTime = System.nanoTime();

        System.out.println("Sorted Array:   " + Arrays.toString(Arrays.copyOf(array, Math.min(array.length, 10))));
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
    }

    private static int[] createRandomArray(int size) {
        int[] array = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(size);
        }
        return array;
    }

    private static int[] createAscendingArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < size; i++) {
            array[i] = i;
        }
        return array;
    }

    private static int[] createDescendingArray(int size) {
        int[] array = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            array[size - i - 1] = i;
        }
        return array;
    }
}
