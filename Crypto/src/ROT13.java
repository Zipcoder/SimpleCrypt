import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
    private final String upperCaseStart = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String lowerCaseStart = "abcdefghijklmnopqrstuvwxyz";
    protected String startUpper;
    protected String startLower;
    protected String registerUpper;
    protected String registerLower;
    private boolean symetric = false;

    ROT13(Character cs, Character cf) {
        if (toLowerCase(cs) == 'a' && toLowerCase(cf) == 'n')
            symetric = true;

        startUpper = ROT13.rotate(upperCaseStart, Character.toUpperCase(cs));
        startLower = ROT13.rotate(lowerCaseStart, Character.toLowerCase(cs));

        registerUpper = ROT13.rotate(upperCaseStart, Character.toUpperCase(cf));
        registerLower = ROT13.rotate(lowerCaseStart, Character.toLowerCase(cf));

        System.out.println(startUpper);
        System.out.println(registerUpper);
        System.out.println(startLower);
        System.out.println(registerLower);
    }

    ROT13() {
        this('a', 'm');
    }


    public String crypt(String text) throws UnsupportedOperationException {
        if (this.symetric != true) throw new UnsupportedOperationException();
        return substituteIn(text, startUpper, registerUpper, startLower, registerLower);
    }
// s == crypt(crypt(s))
    // like saying s == decrypt(encrypt(s))
    public String encrypt(String text) {
        return substituteIn(text, startUpper, registerUpper, startLower, registerLower);
    }

    public String decrypt(String text) {
        return substituteIn(text, startUpper, registerUpper, startLower, registerLower);
    }

    private String substituteIn(String text, String startUpper, String registerUpper, String startLower, String registerLower){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++){
            Character ch = text.charAt(i);
            Integer position = 0;
            if (isUpperCase(ch)){
                position = startUpper.indexOf(ch);
                sb.append(registerUpper.charAt(position));
            }
            if (isLowerCase(ch)){
                position = startLower.indexOf(ch);
                sb.append(registerLower.indexOf(ch));
            }
        }
    }

    public static String rotate(String s, Character c) {

        return "";
    }

}
