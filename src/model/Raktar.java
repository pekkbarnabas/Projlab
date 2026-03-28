package model;

import java.util.List;
import java.util.Map;
import skeleton.Skeleton;

/**
 * A Takarító birtokában lévő eszközök és erőforrások nyilvántartása.
 */
public class Raktar {
    /** IKotrofej objektumok listája, a levett eszközök. */
    private List<IKotrofej> fejek;
    /** A raktárban tárolt különféle árucikkek gyűjteménye. */
    private Map<Arucikk, Integer> keszletek;

    /** Bővíti az elérhető fejek listáját. */
    public void hozzaadFej(IKotrofej f) {
        Skeleton.hivas(this, "hozzaadFej(fej)");
        Skeleton.end("");
    }

    /** A megadott mennyiséggel növeli az adott árucikk értékét. */
    public void eroforrasBovit(Arucikk targy, int mennyiseg) {
        Skeleton.hivas(this, "eroforrasBovit(targy, " + mennyiseg + ")");
        Skeleton.end("");
    }
}
