import java.util.Comparator;

public class QuickSort {
	
    public static void sort(Person[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Person[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right);
        sort(array, left, pivotIndex - 1);
        sort(array, pivotIndex + 1, right);
    }

    private static int partition(Person[] array, int left, int right) {
        Person pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (array[j].compareTo(pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(Person[] array, int i, int j) {
        Person temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void sort(Person[] array, Comparator<Person> comparator) {
        sort(array, 0, array.length - 1, comparator);
    }

    private static void sort(Person[] array, int left, int right, Comparator<Person> comparator) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(array, left, right, comparator);
        sort(array, left, pivotIndex - 1, comparator);
        sort(array, pivotIndex + 1, right, comparator);
    }

    private static int partition(Person[] array, int left, int right, Comparator<Person> comparator) {
        Person pivot = array[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (comparator.compare(array[j], pivot) < 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, right);
        return i + 1;
    }

    private static void swap(Person[] array, int i, int j) {
        Person temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}