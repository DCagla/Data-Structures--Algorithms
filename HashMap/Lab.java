import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Lab {

    public static void main(String[] args) {
        String str1 = "LISTEN";
        String str2 = "SILENT";
        System.out.println("Are '" + str1 + "' and '" + str2 + "' anagrams? " + checkAnagrams(str1, str2));
        String str3 = "HEART";
        String str4 = "EARTD";
        System.out.println("Are '" + str3 + "' and '" + str4 + "' anagrams? " + checkAnagrams(str3, str4));

        int[] arr4 = {1, 5, 7, -1, 4, 2};
        int x = 6;
        System.out.println("Pairs with sum " + x + ":");
        findSum(arr4, x);

        int[] arr2 = {11, 1, 13, 21, 3, 7};
        int[] arr3 = {11, 3, 7, 1};
        int[] arr5 = {1, 1};
        System.out.println("Is B1 a subset of A? " + isSubsetOf(arr2, arr3));
        System.out.println("Is B2 a subset of A? " + isSubsetOf(arr2, arr5));

    }

    public static boolean checkAnagrams(String str1, String str2) {
        if (str1.length() != str2.length()) {
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str1.length(); i++) {
            char c1 = str1.charAt(i);
            map.put(c1, map.getOrDefault(c1, 0) + 1);
            char c2 = str2.charAt(i);
            map.put(c2, map.getOrDefault(c2, 0) - 1);
        }
          for (int count : map.values()) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static void findSum(int[] arr, int x) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : arr) {
            int complement = x - num;
            if (map.containsKey(complement)) {
                System.out.println(num + " and " + complement);
            }
            map.put(num, num);
        }
    }

    public static boolean isSubsetOf(int[] arr1, int[] arr2) {
         HashSet<Integer> set = new HashSet<>();
        for (int num : arr1) {
            set.add(num);
        }
        for (int num : arr2) {
            if (!set.contains(num)) {
                return false;
            }
        }
        return true;
       }
}