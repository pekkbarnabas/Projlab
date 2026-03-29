package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * Két csomópontot összekötő közlekedési folyosó, amely összefogja a párhuzamos sávokat.
 */
public class Utszakasz {
    /** Gyűjtemény a szakaszt alkotó Sav objektumokról. */
    private List<Sav> savok;
    /** A két Csomopont objektum, amiket összeköt. */
    private Csomopont kezdoPont, vegpont;
    /** Az útszakasz hossza. */
    private int hossz;
    /** [-1,0,1] lehetséges értékek (alagút, normál, híd). */
    private int magassag = 0;

    public List<Sav> getSavok() {
        Skeleton.hivas(this, "getSavok()");
        Skeleton.end("[Sav lista]");
        return savok;
    }

    public void setVegpont(Csomopont vegpont) { 
        this.vegpont = vegpont; 
    }

    public Csomopont getVegpont() { 
        return this.vegpont; 
    }

    public void setSavok(List<Sav> savok) { 
        this.savok = savok; 
    }

    public void setMagassag(int magassag) {
        this.magassag = magassag;
    }

    public void addSav(Sav s) {
        if (s != null) {
            s.setUtszakasz(this);
        }
    }

    public int getMagassag() {
        Skeleton.hivas(this, "getMagassag()");
        Skeleton.end(String.valueOf(this.magassag));
        return this.magassag;
    }
}