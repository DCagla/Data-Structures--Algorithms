import java.util.Comparator;

public class MergeSort {
    // Comparable ile sıralama için
    public static void sort(Comparable[] array) {
        Comparable[] aux = new Comparable[array.length];
        sort(array, aux, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, Comparable[] aux, int low, int high) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid);
        sort(array, aux, mid + 1, high);
        merge(array, aux, low, mid, high);
    }

    // Comparator ile sıralama için
    public static void sort(Object[] array, Comparator comparator) {
        Object[] aux = new Object[array.length];
        sort(array, aux, 0, array.length - 1, comparator);
    }

    private static void sort(Object[] array, Object[] aux, int low, int high, Comparator comparator) {
        if (high <= low) return;
        int mid = low + (high - low) / 2;
        sort(array, aux, low, mid, comparator);
        sort(array, aux, mid + 1, high, comparator);
        merge(array, aux, low, mid, high, comparator);
    }

    // Merge işlemi
    private static void merge(Comparable[] array, Comparable[] aux, int low, int mid, int high) {
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (aux[j].compareTo(aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }

    // Merge işlemi (Comparator ile)
    private static void merge(Object[] array, Object[] aux, int low, int mid, int high, Comparator comparator) {
        for (int k = low; k <= high; k++) {
            aux[k] = array[k];
        }

        int i = low, j = mid + 1;
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                array[k] = aux[j++];
            } else if (j > high) {
                array[k] = aux[i++];
            } else if (comparator.compare(aux[j], aux[i]) < 0) {
                array[k] = aux[j++];
            } else {
                array[k] = aux[i++];
            }
        }
    }
}
