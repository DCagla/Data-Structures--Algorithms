
public class BubbleSortAlgorithm {

    public static void main(String[] args) {
        int[] testArray = {4, 12, 3, 26, 18, 1, 55};
        
        BubbleSort(testArray, false);
        
        for (int i : testArray) {
            System.out.print(i + " ");
        }
    }

    public static void BubbleSort(int[] arr, boolean reverse) {
        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (reverse) {
                    if (arr[j] < arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                } else {
                    if (arr[j] > arr[j+1]) {
                        int temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                }
            }
        }
    }
}
