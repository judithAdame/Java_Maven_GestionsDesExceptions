/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.terrain.utilitaire;
import org.junit.Test;

/**
 *
 * @author Rova
 */
public class IOJsonTest {
    /**
     * Test of writeJSONToFile method, of class IOJson.
     */
    @Test
    public void testWriteJSONToFile() {
        System.out.println("writeJSONToFile");
        String path = "./json/";
        String input = "terrain.json";
        String output = "resultat.json";
        IOJson.writeJSONToFile(path + input, path + output);
    }
}
