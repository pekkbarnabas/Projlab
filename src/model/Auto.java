package model;

import java.util.List;

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

        if (!aktualisSav.isBlokkolt() && !elakadt) {
            // Minden ticknél növeljük a pozíciót
            pozicio += 0.1f; 
            
            // Ha eléri a 100%-ot (vagy az útszakasz végét), navigációt indít
            if (pozicio >= 1.0f) {
                if (aktualisUtszakasz != null) {
                    Csomopont cs = aktualisUtszakasz.getVegpont();
                    
                    if (cs != null) {
                        List<Utszakasz> kijaratok = cs.getKijaratok();
                        if (kijaratok != null && !kijaratok.isEmpty()) {
                            Utszakasz ut = kijaratok.get(0);
                            
                            List<Sav> savok = ut.getSavok();
                            if (savok != null && !savok.isEmpty()) {
                                Sav szomszedos = savok.get(0);
                                
                                // A tényleges átmozgatás végrehajtása a szekvencia diagram szerint
                                this.lep(szomszedos);
                                
                                // Új útszakaszra értünk, a pozíció nullázódik
                                pozicio = 0.0f;
                            }
                        }
                    }
                }
            }
        }        
        Skeleton.end("");
    }
}
