package org.example;

public class StringComparator {

    public static boolean areStringsEqual(String str1, String str2) {
        if (str1 == null || str2 == null) {
            return false;
        }
        return str1.equals(str2);
    }

    public static void main(String[] args) {
        String string1 = "Hello";
        String string2 = "Hello";
        String string3 = null;

        System.out.println(areStringsEqual(string1, string2));
        System.out.println(areStringsEqual(string1, string3));
    }
}
