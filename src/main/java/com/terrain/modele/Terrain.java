package com.terrain.modele;

import static com.terrain.utilitaire.MsgErreur.*;
import com.terrain.utilitaire.ValidationException;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 *
 * @author 1895648
 */
public class Terrain {
    private String type;
    private double pMax;
    private double pMin;
    private LinkedHashSet<Lot> lots = new LinkedHashSet(10); //je l'ai instancier rova

    public Terrain(){}
    
    public Terrain(String type, double pMin, double pMax) {
        this.type = type;
        this.pMax = pMax;
        this.pMin = pMin;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) throws ValidationException {
        if (!(("0").equals(type) || ("1").equals(type) || ("2").equals(type)))
            throw new ValidationException(MSG_TERRAIN_TYPE, type);
        this.type = type;
    }

    public double getpMax(){
        return pMax;
    }

    public void setpMax(double pMax) throws ValidationException{
        if (pMax<0)
            throw new ValidationException(MSG_TERRAIN_PMAX, pMax);
        this.pMax = pMax;
    }

    public double getpMin() {
        return pMin;
    }

    public void setpMin(double pMin)  throws ValidationException{
        if (pMin<0)
            throw new ValidationException(MSG_TERRAIN_PMIN,pMin);
        this.pMin = pMin;
    }

    public LinkedHashSet<Lot> getLots() {
        return lots;
    }

    public void addLot(Lot lot) throws ValidationException {
        if (this.lots.size()>=10)
            throw new ValidationException(MSG_TERRAIN_NBLOTS, lot.getDescription());
        if (!(isUnique(lot.getDescription())))
            throw new ValidationException(MSG_TERRAIN_DESCRIPTIONUNIQUE, lot.getDescription());
        this.lots.add(lot);
    }

    private boolean isUnique(String description) {
        Lot l;
        Iterator it = lots.iterator();
        while(it.hasNext()) {
            l = (Lot)it.next();
            if (l.getDescription().equals(description))
                return false;
        }
        return true;
    }
    
    @Override
    public String toString() {
        String str = "Terrain{" + ", type=" + type + ", pMax=" + pMax + ", pMin=" + pMin + ", Liste de lots=\n";
        if (lots == null) 
                return str+ '}';
        for (Object lot : lots) {
            str+= lot.toString();
        }
        return str+ '}';
    }
}
