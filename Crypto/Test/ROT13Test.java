import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.Assert.*;

public class ROT13Test {


    @Test
    public void rotateStringTest0() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "ABCDEF";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'A');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest1() {
        // Given
        String s1 = "ABCDEF";
        String s2 = "DEFABC";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'D');

        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void rotateStringTest2() {
        // Given
        String s1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String s2 = "NOPQRSTUVWXYZABCDEFGHIJKLM";

        // When
        ROT13 cipher = new ROT13();
        String actual = cipher.rotate(s1, 'N');
        System.out.println(s1);
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(s2));
    }

    @Test
    public void cryptTest1() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        String A1 = "Jul qvq gur puvpxra pebff gur ebnq?";

        String Q2 = "Gb trg gb gur bgure fvqr!";
        String A2 = "To get to the other side!";

        // When
        String actual = cipher.encrypt(Q1);
        System.out.println(Q1);
        System.out.println(A1);
        // Then
        assertTrue(actual.equals(A1));

        // When
        String actual2 = cipher.decrypt(Q2);
        System.out.println(Q2);
        System.out.println(A2);
        // Then
        assertTrue(actual2.equals(A2));
    }
    @Test
    public void cryptTest2() {
        // Given
        ROT13 cipher = new ROT13('a', 'n');

        String Q1 = "Why did the chicken cross the road?";
        System.out.println(Q1);

        // When
        String actual = cipher.crypt(cipher.crypt(Q1));
        System.out.println(actual);
        // Then
        assertTrue(actual.equals(Q1));
    }

    @Test
    public void encryptFileTest() throws IOException {
        File file = new File("/Users/brandonchambers/week5/SimpleCrypt/sonnet18.txt");
        ROT13 test = new ROT13();

        String expected = "Gubh neg zber ybiryl naq zber grzcrengr:\n" +
                "Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;\n" +
                "Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;\n" +
                "Ol punapr be angher’f punatvat pbhefr hagevzz'q;\n" +
                "Abe ybfr cbffrffvba bs gung snve gubh bj’fg;\n" +
                "Jura va rgreany yvarf gb gvzr gubh tebj’fg:\n" +
                "   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr." + "\n";


        String actual = test.encrpytFile();

      Assert.assertEquals(expected, actual);


    }

}