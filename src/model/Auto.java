package model;

import skeleton.Skeleton;

/**
 * A város lakosait képviselő NPC jármű. Felelőssége, hogy a topológián navigálva megkeresse a legrövidebb járható utat.
 */
public class Auto extends Jarmu {
    /** Mutatja, hogy az autó mozgásképes-e. */
    private boolean elakadt;
    /** Baleset esetén ennyi körig nem mozoghat. */
    private int buntetoIdo;

    @Override
    public void elakad() {
        Skeleton.hivas(this, "elakad()");
        Skeleton.end("");
    }

    @Override
    public void megcsuszik() {
        Skeleton.hivas(this, "megcsuszik()");
        Skeleton.end("");
    }

    @Override
    public void utkozik(Jarmu masik) {
        Skeleton.hivas(this, "utkozik(masik)");
        Skeleton.end("");
    }
    
    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        Skeleton.end("");
    }
}
