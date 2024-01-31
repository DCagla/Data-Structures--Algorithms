public class MinString3Heap {
    private String[] values;
    private int N = 0;

    public MinString3Heap() {
        this.values = new String[20];
    }

    public void insert(String value) {
        if (N == values.length - 1) {
            resize();
        }
        N++;
        values[N] = value;
        swimRecursive(N);
    }

    private void swimRecursive(int index) {
        if (index > 1) {
            int parent = (index - 2) / 3 + 1;
            if (values[index].compareTo(values[parent]) < 0) {
                swap(index, parent);
                swimRecursive(parent);
            }
        }
    }

    public String removeMin() {
        if (N == 0) {
            return null; 
        }
        String min = values[1];
        swap(1, N);
        N--;
        sinkRecursive(1);
        return min;
    }

    private void sinkRecursive(int index) {
        int minChildIndex = findMinChildIndex(index);
        if (minChildIndex != -1 && values[index].compareTo(values[minChildIndex]) > 0) {
            swap(index, minChildIndex);
            sinkRecursive(minChildIndex);
        }
    }

    private int findMinChildIndex(int index) {
        int minChildIndex = -1;
        int start = 3 * (index - 1) + 2;
        int end = Math.min(start + 2, N);
        for (int i = start; i <= end; i++) {
            if (minChildIndex == -1 || values[i].compareTo(values[minChildIndex]) < 0) {
                minChildIndex = i;
            }
        }
        return minChildIndex;
    }

    public void delete(int index) {
        if (index < 1 || index > N) {
            return;
        }
        values[index] = values[N];
        N--;
        swimRecursive(index);
        sinkRecursive(index);
    }

    public void update(int index, String newValue) {
        if (index < 1 || index > N) {
            return; 
        }
        String oldValue = values[index];
        values[index] = newValue;
        if (oldValue.compareTo(newValue) > 0) {
            swimRecursive(index);
        } 
        else {
            sinkRecursive(index);
        }
    }

    public void print() {
        for (int i = 1, _N = N; i <= _N; i++) {
            System.out.println(removeMin());
        }
    }

    private void swap(int i, int j) {
        String temp = values[i];
        values[i] = values[j];
        values[j] = temp;
    }

    private void resize() {
        String[] newValues = new String[values.length * 2];
        System.arraycopy(values, 1, newValues, 1, N);
        values = newValues;
    }

    public static void main(String[] args) {
        MinString3Heap heap = new MinString3Heap();
        heap.insert("Kemal");
        heap.insert("Zerrin");
        heap.insert("Ahmet");
        heap.insert("Beril");
        heap.insert("Canan");
        heap.insert("Hikmet");
        heap.insert("Okan");
        
        heap.update(2, "Mehmet");
        heap.update(4, "Fatih");
        
        heap.delete(2);
        
        heap.print();  // should print : 
                            // Ahmet 
                            // Fatih 
                            // Kemal 
                            // Mehmet 
                            // Okan 
                            // Zerrin 
    }
}