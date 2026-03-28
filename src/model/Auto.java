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

    private boolean tesztSodrodas = false;

    public void setTesztSodrodas(boolean s) { this.tesztSodrodas = s; }

    @Override
    public void elakad() {
        Skeleton.hivas(this, "elakad()");
        this.setElakadt(true);
        Skeleton.end("");
    }

    public void setElakadt(boolean elakadt) {
        Skeleton.hivas(this, "setElakadt(" + elakadt + ")");
        this.elakadt = elakadt;
        Skeleton.end("");
    }

    @Override
    public void megcsuszik() {
        Skeleton.hivas(this, "megcsuszik()");
        
        System.out.println("\t\t[Belső random sorsolás: 1=" + tesztSodrodas + "]");

        if (!tesztSodrodas) {
            if (aktualisSav != null) {
                aktualisSav.getRajtaAllok();
            }
        } else {
            if (aktualisSav != null) {
                List<Sav> szomszedok = aktualisSav.getSzomszedokCsendes(); 
                
                if (szomszedok != null && !szomszedok.isEmpty()) {
                    Sav s2 = szomszedok.get(0);
                    
                    // Leiratkozás a régi sávról
                    aktualisSav.eltavolit(this);
                    
                    // Rálépés az új sávra
                    s2.elfogad(this);
                    this.aktualisSav = s2;
                    
                    // Lekérdezzük, áll-e ott valaki
                    List<Jarmu> rajta = s2.getRajtaAllok();
                    for (Jarmu j : rajta) {
                        if (j != this) {
                            j.utkozik(this); 
                        }
                    }
                }
            }
        }
        
        Skeleton.end("");
    }

    @Override
    public void utkozik(Jarmu masik) {
        Skeleton.hivas(this, "utkozik(" + masik.getNev() + ")");
        
        this.elakadt = true; 
        
        Skeleton.end("");
    }
    
    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        
        boolean blokkolt = false;
        if (aktualisSav != null) {
            blokkolt = aktualisSav.isBlokkolt();
        }
        
        if (blokkolt) {
            // *** UC-02 Logika: Kikerülés ***
            List<Sav> szomszedok = aktualisSav.getSzomszedok();
            if (szomszedok != null && !szomszedok.isEmpty()) {
                Sav szomszedos = szomszedok.get(0);
                
                boolean szomszedBlokkolt = szomszedos.isBlokkolt();
                if (!szomszedBlokkolt) {
                    this.savotValt(szomszedos);
                }
            }
        } else {
            // *** UC-01 Logika: Normál haladás ***
            pozicio += 0.1f; 
            
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
                                this.lep(szomszedos);
                                pozicio = 0.0f;
                            }
                        }
                    }
                }
            }
        }
        
        Skeleton.end("");
    }

    // Új metódus az átsoroláshoz
    public void savotValt(Sav ujSav) {
        Skeleton.hivas(this, "savotValt(szomszedos)");
        
        if (aktualisSav != null) {
            aktualisSav.eltavolit(this);
        }
        if (ujSav != null) {
            ujSav.elfogad(this);
            this.aktualisSav = ujSav;
        }
        
        Skeleton.end("");
    }
}
