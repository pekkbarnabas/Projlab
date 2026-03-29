package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import skeleton.Skeleton;

/**
 * A Takarító birtokában lévő eszközök és erőforrások nyilvántartása.
 */
public class Raktar {
    /** A raktár neve. */
    private String nev = "r";
    /** IKotrofej objektumok listája, a levett eszközök. */
    private List<IKotrofej> fejek;
    /** A raktárban tárolt különféle árucikkek gyűjteménye. */
    private Map<Arucikk, Integer> keszletek = new HashMap<>();


    public void setNev(String nev) {
        this.nev = nev;
    }

    public void setKeszlet(Arucikk a, int mennyiseg){
        keszletek.put(a, mennyiseg);
    }


    /** Bővíti az elérhető fejek listáját. 
     * @param f
    */
    public void hozzaadFej(IKotrofej f) {
        Skeleton.hivas(this, "hozzaadFej(ujFej)");
        if(this.fejek == null){
            this.fejek = new ArrayList<>();
        }
        this.fejek.add(f);

        Skeleton.end("");
    }

    /** A megadott mennyiséggel növeli az adott árucikk értékét. 
     * @param targy
     * @param mennyiseg
    */
    public void eroforrasBovit(Arucikk targy, int mennyiseg) {
        Skeleton.hivas(this, "eroforrasBovit(Arucikk." + targy.name() + ", mennyiseg)");
        
        int jelenlegi = keszletek.getOrDefault(targy, 0);
        keszletek.put(targy, jelenlegi + mennyiseg);

        Skeleton.end("");
    }

    /**
     * Megpróbálja csökkenteni a megadott árucikk értékét a megadott mennyiséggel. Ha nincs elég az adott árucikkből, akkor nem változtat semmin, 
     * és false értékkel tér vissza. Ha van elég, akkor levonja a megadott mennyiséget, és true értékkel tér vissza.
     * @param a
     * @param mennyiseg
     * @return
     */
    public boolean eroforrasCsokkent(Arucikk a, int mennyiseg) {
        Skeleton.hivas(this, "eroforrasCsokkent(" + a.name() + ", " + mennyiseg + ")");
        
        boolean siker = false;
        int jelenlegi = keszletek.getOrDefault(a, 0);
        
        // Van-e elég a raktárban?
        if (jelenlegi >= mennyiseg) {
            keszletek.put(a, jelenlegi - mennyiseg); // Levonjuk
            siker = true;
        }
        
        Skeleton.end(siker ? "true" : "false");
        return siker;
    }
}
