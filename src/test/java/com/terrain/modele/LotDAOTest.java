package com.terrain.modele;

import com.terrain.utilitaire.ValidationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 1795904
 */
public class LotDAOTest {
    /**
     * Test of getValeur method, of class LotDAO.
     * @throws java.text.ParseException
     * @throws com.terrain.utilitaire.ValidationException
     */
    @Test
    public void testGetValeur() throws ParseException, ValidationException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");
        Lot l = new Lot("lot 1", 3, 0, 365, date);
        System.out.println("getValeur");
        double expResult = 2555.00;
        t.addLot(l);
        double result = LotDAO.getValeur(t, l);        
        assertEquals(expResult, result, 0.0);
    }
    
    /**
     * Test of testGetValeurfonciere method, of class LotDAO.
     * @throws com.terrain.utilitaire.ValidationException
     * @throws java.text.ParseException
     */
    @Test
    public void testGetValeurfonciere() throws ValidationException, ParseException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot l = new Lot("lot 1", 3, 0, 365, date);
        t.addLot(l);
        System.out.println("getValeurfonciere");
        double expResult = 3055.00;
        double result = LotDAO.getValeurfonciere(t, l);
        assertEquals(expResult, result, 0.0);          
    }
}
