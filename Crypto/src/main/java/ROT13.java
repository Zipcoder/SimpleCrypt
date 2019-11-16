import java.sql.SQLOutput;
import java.util.Map;
import java.util.TreeMap;

public class ROT13 {

    Map<String, String> upperCaseMap = new TreeMap<>();
    Map<String, String> lowerCaseMap = new TreeMap<>();

    ROT13(Character cs, Character cf) {
        populateMap();
    }

    ROT13() {
        new ROT13('a', 'n');
    }


    public String crypt(String text) throws UnsupportedOperationException {

        return encrypt(text);
    }

    public String encrypt(String text) {
        char[] sTemp = text.toCharArray();
        String result = "";


        for (int i = 0; i < sTemp.length; i++) {
            if (getCharNumericValue(sTemp[i]) > 64 && getCharNumericValue(sTemp[i]) < 91) {
                //upper case
                result = result.concat(upperCaseMap.get(Character.toString(sTemp[i])));
            } else if (getCharNumericValue(sTemp[i]) > 96 && getCharNumericValue(sTemp[i]) < 122) {
                //lower case
                result = result.concat(lowerCaseMap.get(Character.toString(sTemp[i])));
            } else {
                result = result.concat(getCharacterValue(getCharNumericValue(sTemp[i])).toString());
            }
        }
        return result;
    }

    public String decrypt(String text) {
        String result = encrypt(text);
        return result;
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

    private void populateMap() {
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = s1.toLowerCase();

        String[] tempUpper = s1.split("");
        String[] rotatedUpper = rotate(s1, 'N').split("");

        String[] tempLower = s2.split("");
        String[] rotatedLower = rotate(s2, 'n').split("");

        for (int i = 0; i < tempUpper.length; i++) {
            this.upperCaseMap.put(tempUpper[i], rotatedUpper[i]);
            this.lowerCaseMap.put(tempLower[i], rotatedLower[i]);
        }

    }

    public Integer getCharNumericValue(final char character) {
        return (int) character;
    }

    public Character getCharacterValue(final int ascii) {
        return (char) ascii;
    }
}
