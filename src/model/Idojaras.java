package model;

import java.util.ArrayList;
import java.util.List;
import skeleton.Skeleton;

/**
 * A környezeti hatások felelőse. Időről időre gondoskodik arról, hogy a város összes sávján megnövelje a hóvastagságot.
 */
public class Idojaras implements IIdomulo {
    /** A ciklusonként lehulló hó mennyiseg.. */
    private int intenzitas;
    private List<Sav> savok = new ArrayList<>();
    
    /**
     * Beállítja a ciklusonként lehulló hó mennyiségét.
     * @param intenzitas
     */
    public void setIntenzitas(int intenzitas) { this.intenzitas = intenzitas; }
    
    /**
    * Beállítja a város összes sávját, hogy a ciklusonként lehulló hó mennyiségét figyelembe véve megnövelje a hóvastagságot.
    * @param savok
    */
    public void setSavok(List<Sav> savok) { this.savok = savok; }

    /**
     * Hozzáad egyetlen sávot a megfigyelt sávok listájához.
     * Csendes metódus, nem logol a Skeletonba.
     */
    public void addSav(Sav s) {
        if (s != null) {
            this.savok.add(s);
        }
    }

    /**
     * Végigiterál a sávokon, és minden elemen meghívja a hoNovel(int) függvényt.
     */
    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        
        // Végigmegyünk a regisztrált sávokon és meghívjuk rajtuk a havazást
        if (savok != null) {
            for (Sav s : savok) {
                s.hoNovel(intenzitas);
            }
        }
        
        Skeleton.end("");
    }
}