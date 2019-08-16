package com.terrain.modele;

import static com.terrain.utilitaire.Constant.MONTANT_FIX_VALEURFONCIERE;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * @author Judith
 */
public class TerrainDAO {

    public static double getValeurFonsier(Terrain t){
        double valeur=0.0;
        LinkedHashSet<Lot>  lots = t.getLots();
        Iterator<Lot> itr = lots.iterator();
         while(itr.hasNext()){
            valeur += LotDAO.getValeurfonciere(t, itr.next());
           // System.out.println("valeur " + valeur);            
        }        
        return valeur+MONTANT_FIX_VALEURFONCIERE;
    }
    
    public static double getTaxScolaire (Terrain t){    
        return 1.2*getValeurFonsier(t);
    }
    
    public static double getTaxMunicipal (Terrain t) {
        return 2.5*getValeurFonsier(t);
    }
}
