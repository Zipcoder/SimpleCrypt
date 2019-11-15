package crypto;

import org.junit.Assert;
import org.junit.Test;

public class TestSonnetEncryptor {
    @Test
    public void testCrypt1() {
        ROT13 rot13 = new ROT13();
        String input = SonnetEncryptor.readFile();

        String actual = rot13.crypt(input);
        String expected = "Funyy V pbzcner gurr gb n fhzzre’f qnl?Gubh neg zber ybiryl naq zber grzcrengr:Ebhtu jvaqf qb funxr gur qneyvat ohqf bs Znl,Naq fhzzre’f yrnfr ungu nyy gbb fubeg n qngr;Fbzrgvzr gbb ubg gur rlr bs urnira fuvarf,Naq bsgra vf uvf tbyq pbzcyrkvba qvzz'q;Naq rirel snve sebz snve fbzrgvzr qrpyvarf,Ol punapr be angher’f punatvat pbhefr hagevzz'q;Ohg gul rgreany fhzzre funyy abg snqr,Abe ybfr cbffrffvba bs gung snve gubh bj’fg;Abe funyy qrngu oent gubh jnaqre’fg va uvf funqr,Jura va rgreany yvarf gb gvzr gubh tebj’fg:   Fb ybat nf zra pna oerngur be rlrf pna frr,   Fb ybat yvirf guvf, naq guvf tvirf yvsr gb gurr.";
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testCrypt2() {
        ROT13 rot13 = new ROT13();
        String input = SonnetEncryptor.readFile();

        String actual = rot13.crypt(rot13.crypt(input));
        String expected = input;
        Assert.assertEquals(expected, actual);
    }
}
