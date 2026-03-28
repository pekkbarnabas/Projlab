package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * A város úthálózatának találkozási pontjai, ahol a különböző útszakaszok összefutnak.
 * Biztosítja a navigációs döntési lehetőséget a járművek számára anélkül, hogy koordinátákat tárolna.
 */
public class Csomopont {
    /** Gyűjtemény az Utszakasz objektumokról, amelyek a csomópontból kiindulnak. */
    private List<Utszakasz> kijaratok;

    public List<Utszakasz> getKijaratok() {
        Skeleton.hivas(this, "getKijaratok()");
        Skeleton.end("[Utszakasz lista]");
        return kijaratok;
    }

    public void setKijaratok(List<Utszakasz> kijaratok) { this.kijaratok = kijaratok; }
}