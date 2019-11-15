package crypto;

import java.io.*;

public class SonnetEncryptor {
    public static String readFile() {
        StringBuilder output = new StringBuilder();
        try {
            File file = new File("/Users/wes/dev/lab/week5/SimpleCrypt/sonnet18.txt");

            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null)
                output.append(st);
        } catch(Exception eee) {}
        return output.toString();
    }
}
