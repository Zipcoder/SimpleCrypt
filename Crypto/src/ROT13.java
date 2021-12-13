import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private Character cs;
    private Character cf;

    ROT13(Character cs, Character cf) {
        this.cs = cs;
        this.cf = cf;
    }

    ROT13() {
        this.cs = 'a';
        this.cf = 'a' + 13;
    }


    public String crypt(String text) throws UnsupportedOperationException {
        String crypted = "";
        for(int i = 0; i<text.length(); i++){
            char textChar = text.charAt(i);
            int shiftDifferences = 13;
            int differenceFromLastChar = 0;
            if(textChar >= 'a' && textChar <= 'z'){
                differenceFromLastChar = 'z'-textChar;
                if(differenceFromLastChar > shiftDifferences){
                    textChar += shiftDifferences;
                }
                else
                {
                    textChar = 'a';
                    textChar +=(shiftDifferences - differenceFromLastChar-1);
                }
            }
            else if(textChar >= 'A'&& textChar <= 'Z'){
                differenceFromLastChar = 'Z'-textChar;
                if(differenceFromLastChar > shiftDifferences){
                    textChar += shiftDifferences;
                }else {
                    textChar = 'A';
                    textChar +=(shiftDifferences-differenceFromLastChar-1);
                }
            }
            crypted += textChar;
        }

        return crypted;
    }

    public String encrypt(String text) {
        return crypt(text);
    }

    public String decrypt(String text) {
        return crypt(text);
    }

    public static String rotate(String s, Character c) {
        char lastChar = s.charAt(s.length()-1);
        String rotated = "";
        for(int i = 0; i< s.length();i++){
            char textChar = s.charAt(i);
            int shiftDifferences = c - 'A';
            int differenceFromLastChar = lastChar - textChar;
            if(differenceFromLastChar >= shiftDifferences){

                textChar += shiftDifferences;
            }else {
                textChar = 'A';
                textChar += (shiftDifferences -differenceFromLastChar-1);
            }
            rotated +=textChar;
        }
        return rotated;
    }

}
