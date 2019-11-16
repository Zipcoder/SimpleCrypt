import java.sql.SQLOutput;

public class ROT13 {


    ROT13(Character cs, Character cf) {
    }

    ROT13() {
        new ROT13('a', 'n');
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
        String[] temp = s.split("");
        String result = "";
        int location = s.indexOf(c);

        for (int i = 0; i < temp.length; i++) {
           if (i < location) {
               result = result.concat(temp[location + i]);

           } else {
               result = result.concat(temp[Math.abs(i - location)]);
           }
        }
        return result;
    }


    public Integer getCharNumericValue(final char character) {
        return (int) character;
    }

    public Character getCharacterValue(final int ascii) {
        return (char) ascii;
    }
}
