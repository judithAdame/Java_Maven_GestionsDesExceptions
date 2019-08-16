package com.terrain.modele;

import static com.terrain.utilitaire.MsgErreur.*;
import com.terrain.utilitaire.ValidationException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 * @author 1795904
 */
public class TerrainTest {

    /**
     * Test of setType method, of class Terrain.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetType()   throws ParseException {
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
        System.out.println("setType");
        String type = "1";           
        try {
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
            t.setType(type);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_TERRAIN_TYPE+" ("+type+")");            
        }
    }

    /**
     * Test of setpMax method, of class Terrain.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetpMax()   throws ParseException {
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
        System.out.println("setpMax");
        double pMax = 5;       
        try {
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
            t.setpMax(pMax);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_TERRAIN_PMAX+" ("+pMax+")");            
        }
    }

    /**
     * Test of setpMin method, of class Terrain.
     * @throws java.text.ParseException
     */
    @Test
    public void testSetpMin()   throws ParseException {
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
        System.out.println("setpMin");
        double pMin = 3;
        try {
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
            t.setpMin(pMin);
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_TERRAIN_PMIN+" ("+pMin+")");            
        }
    }

    /**
     * Test of addLot method, of class Terrain.
     * @throws java.text.ParseException
     */
    @Test
    public void testAddLot()   throws ParseException {
        System.out.println("addLot");        
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
        try {
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
        } catch (ValidationException ex) {
            assertEquals(ex.getMessage(), MSG_TERRAIN_PMIN+" ("+t.getLots().size()+")");            
        } 
    }

}
