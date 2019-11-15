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
            Character in = (!isAlpha(text.charAt(i))) ?
                    text.charAt(i) :
                    (index < alphabet.length) ?
                            alphabet[index] :
                            alphabet[index - alphabet.length];
            encrypted.append(matchCase(text.charAt(i), in));
        }
        return encrypted.toString();
    }

    public Character matchCase(Character in, Character out) {
        if (isUpper(in)) out = out.toString().toUpperCase().charAt(0);
        else out = out.toString().toLowerCase().charAt(0);
        return out;
    }

    public Boolean isUpper(Character a) {
        return String.valueOf(a).matches("[A-Z]");
    }

    public Boolean isAlpha(Character c) {
        return String.valueOf(c).matches("[A-Za-z]");
    }

    public String decrypt(String text) {
        delta = alphabet.length - delta;

        return encrypt(text);
    }

    public String rotate(String s, Character c) {
        StringBuilder rotated = new StringBuilder();
        delta = c.compareTo(s.charAt(0));
        for (int i = 0; i < s.length(); i++) {
            char in = (i+delta < s.length()) ?
                    s.charAt(i+delta) :
                    s.charAt(i+delta - s.length());
            rotated.append(in);
        }
        return rotated.toString();
    }

}
