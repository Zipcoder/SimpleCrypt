package crypto;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private static final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    ROT13(Character cs, Character cf) {
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return "";
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
        return text;
    }

    public static String rotate(String s, Character c) {
        StringBuilder rotated = new StringBuilder();
        int delta = Math.abs(c.compareTo(s.charAt(0)));
        for (int i = 0; i < s.length(); i++) {
            char in = (i+delta < s.length()) ? s.charAt(i+delta) : s.charAt(i+delta - s.length());
            rotated.append(in);
        }
        return rotated.toString();
    }

}
