package ROT13;

import java.util.Arrays;

import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    protected String startUpper;
    protected String startLower;
    protected String registerUpper;
    protected String registerLower;
    private Boolean symmetric = false;
    private Integer shift;

    ROT13(Character cs, Character cf) {
        shift = cf - cs;
    }

    ROT13() {
        this('a', 'm');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        //if (this.symmetric != true) throw new UnsupportedOperationException();


            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                char c =text.charAt(i);
                if       (c >= 'a' && c <= 'm') c += 13;
                else if  (c >= 'A' && c <= 'M') c += 13;
                else if  (c >= 'n' && c <= 'z') c -= 13;
                else if  (c >= 'N' && c <= 'Z') c -= 13;
                sb.append(c);
            }
            return sb.toString();
        }


    public String encrypt(String text)
    {
        return crypt(text);
    }

    public String decrypt(String text) {

        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        Integer index = s.indexOf(c);
        String front = s.substring(index);
        String back = s.substring(0, index);
        String joined = front + back;
        return joined;
    }

}
