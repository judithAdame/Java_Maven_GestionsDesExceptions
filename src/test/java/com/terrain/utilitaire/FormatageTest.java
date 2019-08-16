package com.terrain.utilitaire;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1795904
 */
public class FormatageTest {
    /**
     * Test of ParseCurrency method, of class Formatage.
     * @throws java.lang.Exception
     */
    @Test
    public void testParseCurrency() throws Exception {
        System.out.println("ParseCurrency");
        String s = "5.2";
        double expResult = 5.2;
        double result = Formatage.ParseCurrency(s);
        assertEquals(expResult, result, 0.0);
    }

    /**
     * Test of FormatCurrency method, of class Formatage.
     */
    @Test
    public void testFormatCurrency() {
        System.out.println("FormatCurrency");
        double d = 10.0;
        String expResult = "10.00 $";
        String result = Formatage.FormatCurrency(d);
        assertEquals(expResult, result);
    }

    /**
     * Test of ParseDate method, of class Formatage.
     * @throws java.lang.Exception
     */
    @Test
    public void testParseDate() throws Exception {
        System.out.println("ParseDate");
        String s = "2014-11-22";
        Date expResult = Formatage.ParseDate(s);
        Date result = Formatage.ParseDate(s);
        assertEquals(expResult, result);
    }
}
