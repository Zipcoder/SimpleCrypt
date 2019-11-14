import static java.lang.Character.isLowerCase;
import static java.lang.Character.isUpperCase;
import static java.lang.Character.toLowerCase;

public class ROT13  {
private final startUpperCase;
protected String startLower;
protected String startUpper;
protected String registerLower;
protected String registerUpper;
private boolean symmetric = false;

    ROT13(Character cs, Character cf) {
        if(toLowerCase(cs) == 'a' && toLowerCase(cf) == 'n') symmetric = true;

        startUpper = ROT13.rotate(uppercaseStart, Character.toUpperCase(cs));
        startLower = ROT13.rotate(lowercaseStart, Character.toLowerCase(cs));

        registerUpper = ROT13.rotate(uppercaseStart, Character.toUpperCase(cf));
        registerLower = ROT13.rotate(lowercaseStart, Character.toLowerCase(cf));

        System.out.println(startUpper);
        System.out.println(registerUpper);
        System.out.println(startLower);
        System.out.println(registerLower);


    ROT13() {
    this.('a', 'n');
    }

    public String crypt(String text) throws UnsupportedOperationException {
        if (this.symmetric != true) throw new Unsupported OperationalException();
        return substituteIn(text, startUpper, registerUpper, startLower, registerLower);
    }

    public String encrypt(String text) {
        return text;
    }

    public String decrypt(String text) {
            return substituteIn(registerUpper, startUpper, registerLower, startLower);
    }

    public static String rotate(String s, Character c) {

        return "";
    }

}
