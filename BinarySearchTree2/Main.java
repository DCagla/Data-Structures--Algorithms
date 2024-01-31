import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        readFileAndInsert("src/input1.txt", bst);
        readFileAndInsert("src/input2.txt", bst);
        readFileAndInsert("src/input3.txt", bst);

        bst.printFrequencies();
    }

    private static void readFileAndInsert(String filePath, BinarySearchTree bst) {
        File file = new File(filePath);
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split("\\s+");
                for (String word : words) {
                    bst.insert(word);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
