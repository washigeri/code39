package Code39;

import junit.framework.TestCase;

public class Code39Test extends TestCase {
    public void testEncodage() throws Exception {

       assertEquals(Code39.mise_enforme_code39("abc test1234567890"), "*ABC TEST1234567890*");
       assertEquals(Code39.mise_enforme_code39("@|{#~"), "**");
       assertEquals(Code39.mise_enforme_code39(". $/+%"),"*. $/+%*");
    }

    public void testCalculModulo43() throws Exception {

        assertEquals(Code39.calcul_modulo43("*ABC*"), 'X');
        assertEquals(Code39.calcul_modulo43("*01A*"), 'B');
        assertEquals(Code39.calcul_modulo43("*0123*"), '6');
        assertEquals(Code39.calcul_modulo43("*%*"), '%');
    }

    public void testCode39() throws Exception {

        assertEquals(Code39.set_code39("abc"), "*ABC*X");
        assertEquals(Code39.set_code39("01a"), "*01A*B");
        assertEquals(Code39.set_code39("0123"), "*0123*6");
        assertEquals(Code39.set_code39("%"), "*%*%");

    }


}