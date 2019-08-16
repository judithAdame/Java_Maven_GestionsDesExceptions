package com.terrain.modele;

import static com.terrain.utilitaire.MsgErreur.*;
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
public class LotTest {

    /**
     * Test of setDescription method, of class Lot.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetDescription() throws ParseException{
            Terrain t = new Terrain ("0", 4.50, 7.00);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
            Date date =  df.parse("2015-09-04");
            Lot lot = new Lot("lot 1", 3, 0, 365, date);
            System.out.println("setDescription");
            String description = "lot 1";
        try {
            t.addLot(lot);
            lot.setDescription(description);
        } catch (ValidationException ex) {
             assertEquals(ex.getMessage(), MSG_LOT_DESCRIPTION+" ("+description+")");            
        }
    }

    /**
     * Test of setNbServices method, of class Lot.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetNbServices() throws ParseException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot lot = new Lot("lot 1", 3, 0, 365, date);
        System.out.println("setNbServices");
        int nbServices = 0;
        try {
            lot.setNbServices(nbServices);
            t.addLot(lot);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_LOT_NBSERVICES+" ("+nbServices+")");            
        }
    }

    /**
     * Test of setNbDroitP method, of class Lot.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetNbDroitP() throws ParseException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot lot = new Lot("lot 1", 3, 0, 365, date);
        System.out.println("setNbDroitP");
        int nbDroitP = 3;
        try {
            t.addLot(lot);        
            lot.setNbDroitP(nbDroitP);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_LOT_NBDROITP+" ("+nbDroitP+")");            
        }        
    }

    /**
     * Test of setSuperficie method, of class Lot.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetSuperficie() throws ParseException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot lot = new Lot("lot 1", 3, 0, 365, date);
        System.out.println("setSuperficie");
        double superficie = 365;
        try {
            t.addLot(lot);        
            lot.setSuperficie(superficie);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_LOT_SUPERFICIE+" ("+superficie+")");            
        }          
    }

    /**
     * Test of setdMesure method, of class Lot.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetdMesure() throws ParseException{
        Terrain t = new Terrain ("0", 4.50, 7.00);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd", Locale.CANADA_FRENCH);
        Date date =  df.parse("2015-09-04");  
        Lot lot = new Lot("lot 1", 3, 0, 365, date);
        System.out.println("setdMesure");
        Date dMesure = date;
        try {
            t.addLot(lot);        
            lot.setdMesure(dMesure);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_TERRAIN_NBLOTS+" ("+date+")");            
        }           
    }
}
