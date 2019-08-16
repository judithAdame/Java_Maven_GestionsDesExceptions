package com.terrain.modele;

import com.terrain.utilitaire.Constant;

/**
 * @author Judith
 */
public class LotDAO {
    public static double getValeur(Terrain t, Lot l) {
        double valeur = 0.0;
        switch (t.getType()) {
            case Constant.AGRICOLE : {
                valeur = l.getSuperficie()*t.getpMax();
                break;
            }
            case Constant.RESIDENTIEL : {
                double pMoyen = (t.getpMax()+t.getpMin())/2;
                valeur = l.getSuperficie()*pMoyen;
                break;
            }
            case Constant.COMMERCIAL : {
                valeur = l.getSuperficie()*t.getpMax();
                break;
            }
        }
        return valeur;
    }
    
    private static double getMontantDroitsPassage(Terrain t, Lot l) {
        double montant = 0.0;
        switch (t.getType()) {
            case Constant.AGRICOLE : {
                montant = Constant.MONTANT_SERVICE_BASE_500-(l.getNbDroitP() * ((5/100) * getValeur(t,l)));
                break;
            }
            case Constant.RESIDENTIEL : {
                montant = Constant.MONTANT_SERVICE_BASE_500-(l.getNbDroitP() * ((10/100) * getValeur(t, l)));
                break;
            }
            case Constant.COMMERCIAL : {
                montant = Constant.MONTANT_SERVICE_BASE_500-(l.getNbDroitP() * ((15/100) * getValeur(t, l)));
                break;
            }
        }
        return montant;
    }
   
    private static double getMontantServices(Terrain t, Lot l) {
        double montant = 0.0;
        switch (t.getType()) {
            case Constant.AGRICOLE : {
                montant = 0.0;
                break;
            }
            case Constant.RESIDENTIEL : {
                if (l.getSuperficie()<=500) {
                    montant =0.0;
                }
                else if ((l.getSuperficie()>500) && (l.getSuperficie()<=1000)){
                    montant = Constant.MONTANT_SERVICE_RESIDENTIEL_500*l.getNbServices();                
                }
                else if (l.getSuperficie()>1000){
                    montant = Constant.MONTANT_SERVICE_RESIDENTIEL_10000*l.getNbServices();                
                }
                break;
            }
            case Constant.COMMERCIAL : {
                if (l.getSuperficie()<=500) {
                    montant =Constant.MONTANT_SERVICE_COMMERCIAL_500;
                }
                else if ((l.getSuperficie()>500)){
                    montant = Constant.MONTANT_SERVICE_COMMERCIAL_1500*l.getNbServices();                
                }
                
                if (montant > 5000) {
                    montant = Constant.MONTANT_SERVICE_COMMERCIAL_MAX;
                }
                break;            
            }
        }
        return montant;
    }
    
    public static double getValeurfonciere(Terrain t, Lot l) {
        double resultat = getValeur(t,l)+getMontantDroitsPassage(t,l)+getMontantServices(t,l);
        //System.err.println("Lot "+ l.toString() +"resultat " + resultat);            
        return resultat;
    }
}
