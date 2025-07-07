package org.alexeidiaconu.exceptionshandling;

import org.jetbrains.annotations.Nullable;

public class RandomString {
    public static @Nullable String generateString() {

        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        int stringLength = (int) (Math.random() * 10);


        StringBuilder finalString = new StringBuilder();
        for (int i = 0; i < stringLength; i++) {
            int index = (int) (AlphaNumericString.length() * Math.random());
            finalString.append(AlphaNumericString.charAt(index));
        }
        if (finalString.isEmpty()) {
            return null;
        } else return finalString.toString();
    }

    public static void printStringAndLength(String text) throws NullPointerException {
        System.out.println("The Randomly generated string is: " + text);
        System.out.println("The String Length is :" + TextManager.stringLength(text));
    }
}
