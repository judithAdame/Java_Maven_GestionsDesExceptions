package com.terrain.utilitaire;

import com.terrain.modele.Lot;
import com.terrain.modele.LotDAO;
import com.terrain.modele.Terrain;
import com.terrain.modele.TerrainDAO;
import static com.terrain.utilitaire.Constant.FILE_ENCODING;
import static com.terrain.utilitaire.MsgErreur.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Iterator;
import net.sf.json.JSONArray;
import net.sf.json.JSONException;
import net.sf.json.JSONObject;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

/**
 *
 * @author Rova
 */
public class IOJson {  
    //********************************ECRITURE DU FICHIER JSON***************************************
   
    public static void writeJSONToFile(String input, String output){       
        JSONObject j = new JSONObject();
        try {
            Terrain t = IOJson.loadJSONToFile(input);
            j.accumulate("valeur_fonciere_totale", Formatage.FormatCurrency(TerrainDAO.getValeurFonsier(t)));
            j.accumulate("taxe_scolaire", Formatage.FormatCurrency(TerrainDAO.getTaxScolaire(t)));
            j.accumulate("taxe_municipale", Formatage.FormatCurrency(TerrainDAO.getTaxMunicipal(t)));
            
            Lot lot;
            JSONObject lotJSON;
            JSONArray listeLostissementJSON = new JSONArray();
            Iterator<Lot> it = t.getLots().iterator();
            while(it.hasNext()){
                lot=it.next();   
                lotJSON = new JSONObject();
                lotJSON.accumulate("description", lot.getDescription());
                lotJSON.accumulate("valeur_par_lot", Formatage.FormatCurrency(LotDAO.getValeur(t, lot)));
                listeLostissementJSON.add(lotJSON);
            }
            j.accumulate("lotissements", listeLostissementJSON);
        } catch (ValidationException ex) {
            j.accumulate("message",ex.getMessage());
        } catch (ParseException | NumberFormatException |StringIndexOutOfBoundsException ex) {
            j.accumulate("message",MSG_NUMBERFORMAT);
        }catch (JSONException ex) {
            int v1= ex.getMessage().indexOf("[")-1;
            int v2= ex.getMessage().indexOf("]")+1;
            j.accumulate("message",MSG_JSON_PROPRIETES+ex.getMessage().subSequence(v1, v2));
        }finally{
            File f = new File (output);
            try {            
                FileUtils.writeStringToFile (f, j.toString(), FILE_ENCODING);
            } catch (IOException ex) {
                System.err.println("Impossible de créer le fichier "+output);
                
            }
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+
                               "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
            System.out.println("Le resultat se trouve dans le fichier :"+ f.getAbsolutePath());
            System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*"+
                               "*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
        }
    }
    
    //********************************lECTURE SU FICHIER JSON***************************************
    private static Terrain loadJSONToFile (String fullFilePath) throws ValidationException, ParseException, JSONException, StringIndexOutOfBoundsException, NumberFormatException{
       Terrain terrain = new Terrain();
       FileInputStream f;
        try {
            f = new FileInputStream(fullFilePath);
            String mainJSON = IOUtils.toString(f, FILE_ENCODING);
            mainJSON = mainJSON.toLowerCase();
            JSONObject t = JSONObject.fromObject(mainJSON);
            
            terrain.setType(t.getString("type_terrain"));
            terrain.setpMin(Formatage.ParseCurrency(t.getString("prix_m2_min")));
            terrain.setpMax(Formatage.ParseCurrency(t.getString("prix_m2_max")));
            //System.err.println("Terrain "+terrain);
            JSONObject lotJSON;
            Lot lot;
            JSONArray listeLostissementJSON = t.getJSONArray("lotissements");
            if (listeLostissementJSON.isEmpty())
                throw new ValidationException(MSG_TERRAIN_NULLLOTS, "[]");
            for (int j = 0; j < listeLostissementJSON.size(); j++) {
                lotJSON = listeLostissementJSON.getJSONObject(j);
                lot = new Lot();
                lot.setDescription(lotJSON.getString("description"));
                lot.setNbDroitP(Integer.parseInt(lotJSON.getString("nombre_droits_passage")));
                lot.setNbServices(Integer.parseInt(lotJSON.getString("nombre_services")));
                lot.setSuperficie(Double.parseDouble(lotJSON.getString("superficie")));
                lot.setdMesure(Formatage.ParseDate(lotJSON.getString("date_mesure")));
                terrain.addLot(lot);
                //System.err.println("Lot "+j+ lot.toString());
            }
        } catch (FileNotFoundException ex) {
            System.err.println("Le fichier "+ fullFilePath + " est introuvable");
        } catch (IOException ex) {
            System.err.println("Impossible de lire le fichier "+fullFilePath);
        }
        return terrain;
    }
}
