package com.terrain.modele;
import static com.terrain.utilitaire.MsgErreur.*;
import com.terrain.utilitaire.ValidationException;
import java.util.Date;

/**
 *
 * @author Judith
 */
public class Lot {
    private String description;
    private int nbServices;
    private int nbDroitP;
    private double superficie;
    private Date dMesure;
    private Terrain terrain;

    public Lot() {}
    
    public Lot(String description, int nbDroitP, int nbServices, double superficie, Date dMesure) {
        this.description = description;
        this.nbServices = nbServices;
        this.nbDroitP = nbDroitP;
        this.superficie = superficie;
        this.dMesure = dMesure;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description)  throws ValidationException {
        if (description.isEmpty())         
            throw new ValidationException(MSG_LOT_DESCRIPTION, description);
        this.description = description;
    }

    public int getNbDroitP() {
        return nbDroitP;
    }

    public int getNbServices() {
        return nbServices;
    }

    public void setNbServices(int nbServices) throws ValidationException {
        nbServices += 2;
        if (!(nbServices>=0 && nbServices<=5))         
            throw new ValidationException(MSG_LOT_NBSERVICES, nbServices);
        this.nbServices = nbServices;
    }

    public void setNbDroitP(int nbDroitP)  throws ValidationException {
        if(!(nbDroitP>=0 && nbDroitP<=10))         
            throw new ValidationException(MSG_LOT_NBDROITP, nbDroitP);
        this.nbDroitP = nbDroitP;
    }

    public double getSuperficie() {
        return superficie;
    }

    public void setSuperficie(double superficie)  throws ValidationException {
        if (!(superficie>=0 && superficie<=50000))
            throw new ValidationException(MSG_LOT_SUPERFICIE, superficie);
        this.superficie = superficie;
    }

    public Date getdMesure() {
        return dMesure;
    }

    public void setdMesure(Date dMesure)  throws ValidationException {
        this.dMesure = dMesure;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public void setTerrain(Terrain terrain) {
        this.terrain = terrain;
    }
    
    @Override
    public String toString() {
        return "Lot{" + ", description=" + description + ", nbDroitP=" + nbDroitP + ", superficie=" + superficie + ", dMesure=" + dMesure + ", nbServices=" + nbServices + "}\n";
    }
}
