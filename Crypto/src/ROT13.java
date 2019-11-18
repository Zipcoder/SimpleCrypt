
import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

import java.io.*;



public class ROT13 {

    private int shift;


    ROT13(Character cs, Character cf)  {

       shift=cf-cs;
    }

    ROT13() {
shift=0;
    }
    //lets read a file ,encode it and write in








    public String crypt(String text) throws UnsupportedOperationException {
        return decrypt(encrypt(text));
    }

    public String encrypt(String text) {
        return shiftString(text, (char) (97 + shift));



        }

        public String decrypt (String text){
            return shiftString(text, (char) (97 + 26 - shift));

        }
        public String shiftString(String text,Character c) {
            int shift;
            if (c >= 97 && c <= 122) {
                shift = c - 97;
            } else {
                shift = c - 65;
            }

            StringBuffer result = new StringBuffer();
            char[] charArr = text.toCharArray();
            for (int i = 0; i < charArr.length; i++) {
                if (charArr[i] <= 90 && charArr[i] >= 65) {
                    charArr[i] = (char) ((charArr[i] + shift - 65) % 26 + 65);


                }
                if (charArr[i] <= 122 && charArr[i] >= 97) {
                    charArr[i] = (char) ((charArr[i] + shift - 97) % 26 + 97);


                }

            }

        return String.valueOf(charArr);
        }

        public static String rotate (String s, Character c){
            String str="";
            int l=s.indexOf(c);
            for(int i=l; i<s.length();i++){
                str=str+s.charAt(i);
            }
            for(int i=0;i<l;i++){
                str=str+s.charAt(i);
            }


            return str;


        }






        }
