import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class SonnetCypher {
    public static String readFile() {
        StringBuilder output = new StringBuilder();
        try{
            File file = new File("/Users/kai/Dev/Labs/WeekFive/SimpleCrypt/sonnet18.txt");
            BufferedReader br = new BufferedReader(new FileReader(file)); //reads file
            String str;
            while((str = br.readLine()) != null)
                output.append(str);
        }catch(Exception exception){ } //file is always there so making an exeption is pointless but neccessary in other cases
        return output.toString();
    }

}

