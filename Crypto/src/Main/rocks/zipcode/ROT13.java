package rocks.zipcode;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13 {
    private int code;


    public ROT13(Character cs, Character cf) {
        code = cf - cs;
    }

    public ROT13() {
        code = 0;
    }

    public String crypt(String text) throws UnsupportedOperationException {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'm') { c += 13;
            } else if (c >= 'A' && c <= 'M') { c += 13;
            } else if (c >= 'n' && c <= 'z') { c -= 13;
            } else if (c >= 'N' && c <= 'Z') { c -= 13;
            }
        }
        return text;
    }

    public String cryptFile() {
        String sonnet = "sonnet18.txt";
        sonnet = encrypt(sonnet);
        return null ;
    }


    public String encrypt(String text) {
        String encrypt = crypt(text);
        return encrypt;
    }

    public String decrypt(String text) {
        String decrypt = crypt(text);
        return decrypt;
    }

    public static String rotate(String s, Character c) {
        Integer index = s.indexOf(c);
        return s.substring(index) + s.substring(0, index);
    }

}
