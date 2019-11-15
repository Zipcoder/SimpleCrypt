package crypto;

import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private final char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private Integer delta;
    ROT13(Character cs, Character cf) {
        delta = cf.compareTo(cs);
    }

    ROT13() {
    }


    public String crypt(String text) throws UnsupportedOperationException {
        delta = 13;
        return encrypt(text);
    }

    public Integer getAlphabetIndex(char letter) {
        Integer index = -1;
        for (int i = 0; i < alphabet.length; i++) {
            if (String.valueOf(letter).toUpperCase().equals(String.valueOf(alphabet[i]))) {
                index = i;
                break;
            }
        }
        return index;
    }

    public String encrypt(String text) {
        StringBuilder encrypted = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            Integer index = getAlphabetIndex(text.charAt(i)) + delta;
            char in = (!String.valueOf(text.charAt(i)).matches("[A-Za-z]")) ?
                    text.charAt(i) :
                    (index < alphabet.length) ?
                            alphabet[index] :
                            alphabet[index - alphabet.length];

            encrypted.append(
                    (i == 0 || in == ' ') ? in : String.valueOf(in).toLowerCase());
        }
        return encrypted.toString();
    }

    public String decrypt(String text) {
        delta = alphabet.length - delta;

        return encrypt(text);
    }

    public String rotate(String s, Character c) {
        StringBuilder rotated = new StringBuilder();
        int delta = c.compareTo(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char in = (i+delta < s.length()) ? s.charAt(i+delta) : s.charAt(i+delta - s.length());
            rotated.append(in);
        }
        return rotated.toString();
    }

}
