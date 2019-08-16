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
public class TerrainDAOTest {
    /**
     * Test of getValeurFonsier method, of class TerrainDAO.
     * @throws java.text.ParseException
     * @throws com.terrain.utilitaire.ValidationException
     */
    @Test
    public void testGetValeurFonsier() throws ParseException, ValidationException {
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot l1 = new Lot("lot 1", 3, 0, 365, date);    
        Lot l2 = new Lot("lot 2", 4, 0, 475, date);    
        Lot l3 = new Lot("lot 3", 2, 0, 500, date);
        Lot l4 = new Lot("lot 4", 3, 0, 365, date);
        Lot l5 = new Lot("lot 5", 4, 0, 475, date);
        Lot l6 = new Lot("lot 6", 2, 0, 500, date);
        Lot l7 = new Lot("lot 7", 3, 0, 365, date);
        Lot l8 = new Lot("lot 8", 4, 0, 475, date);
        Lot l9 = new Lot("lot 9", 2, 0, 500, date);
        Lot l10 = new Lot("lot 10", 4, 0, 475, date);
        t.addLot(l1);
        t.addLot(l2);
        t.addLot(l3);
        t.addLot(l4);
        t.addLot(l5);
        t.addLot(l6);
        t.addLot(l7);
        t.addLot(l8);
        t.addLot(l9);
        t.addLot(l10);  
        System.out.println("getValeurFonsier");
        double expResult = 37198.77;
        double result = TerrainDAO.getValeurFonsier(t);
        assertEquals(expResult, result, 2);
    }

    /**
     * Test of getTaxMunicipal method, of class TerrainDAO.
     * @throws java.text.ParseException
     * @throws com.terrain.utilitaire.ValidationException
     */
    @Test
    public void testGetTaxMunicipal()  throws ParseException, ValidationException {
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot l1 = new Lot("lot 1", 3, 0, 365, date);    
        Lot l2 = new Lot("lot 2", 4, 0, 475, date);    
        Lot l3 = new Lot("lot 3", 2, 0, 500, date);
        Lot l4 = new Lot("lot 4", 3, 0, 365, date);
        Lot l5 = new Lot("lot 5", 4, 0, 475, date);
        Lot l6 = new Lot("lot 6", 2, 0, 500, date);
        Lot l7 = new Lot("lot 7", 3, 0, 365, date);
        Lot l8 = new Lot("lot 8", 4, 0, 475, date);
        Lot l9 = new Lot("lot 9", 2, 0, 500, date);
        Lot l10 = new Lot("lot 10", 4, 0, 475, date);
        t.addLot(l1);
        t.addLot(l2);
        t.addLot(l3);
        t.addLot(l4);
        t.addLot(l5);
        t.addLot(l6);
        t.addLot(l7);
        t.addLot(l8);
        t.addLot(l9);
        t.addLot(l10);  
        System.out.println("getTaxMunicipal");
        double expResult = 92996.92;
        double result = TerrainDAO.getTaxMunicipal(t);
        assertEquals(expResult, result, 2);
    }

    /**
     * Test of getTaxeMpal method, of class TerrainDAO.
     * @throws java.text.ParseException
     * @throws com.terrain.utilitaire.ValidationException
     */
    @Test
    public void testGetTaxScolaire()  throws ParseException, ValidationException {
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot l1 = new Lot("lot 1", 3, 0, 365, date);    
        Lot l2 = new Lot("lot 2", 4, 0, 475, date);    
        Lot l3 = new Lot("lot 3", 2, 0, 500, date);
        Lot l4 = new Lot("lot 4", 3, 0, 365, date);
        Lot l5 = new Lot("lot 5", 4, 0, 475, date);
        Lot l6 = new Lot("lot 6", 2, 0, 500, date);
        Lot l7 = new Lot("lot 7", 3, 0, 365, date);
        Lot l8 = new Lot("lot 8", 4, 0, 475, date);
        Lot l9 = new Lot("lot 9", 2, 0, 500, date);
        Lot l10 = new Lot("lot 10", 4, 0, 475, date);
        t.addLot(l1);
        t.addLot(l2);
        t.addLot(l3);
        t.addLot(l4);
        t.addLot(l5);
        t.addLot(l6);
        t.addLot(l7);
        t.addLot(l8);
        t.addLot(l9);
        t.addLot(l10);  
        System.out.println("getTaxeMpal");
        double expResult = 44638.52;
        double result = TerrainDAO.getTaxScolaire(t);
        assertEquals(expResult, result, 2);
    }
}
