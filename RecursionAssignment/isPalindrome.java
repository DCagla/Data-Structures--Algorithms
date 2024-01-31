public static boolean isPalindrome(String word) {
    if (word.length() == 0 || word.length() == 1) {
        return true;
    }
    if (word.charAt(0) != word.charAt(word.length() - 1)) {
        return false;
    }
    return isPalindrome(word.substring(1, word.length() - 1));
}
