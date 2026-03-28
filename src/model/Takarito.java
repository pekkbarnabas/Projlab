package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * A tisztítási munkálatokat irányító játékos reprezentációja.
 */
public class Takarito {
    /** A játékos egyenlege. */
    private int penz;
    /** Gyűjtemény a birtokolt Hokotro objektumokról. */
    private List<Hokotro> flotta;
    /** A játékos Raktar objektuma. */
    private Raktar raktar;

    public void penztKap() {
        Skeleton.hivas(this, "penztKap()");
        Skeleton.end("");
    }

    /** Kezdeményezi az Enummal megadott árucikk megvásárlását a boltban. */
    public void vasarol(Bolt b, Arucikk targy) {
        Skeleton.hivas(this, "vasarol(bolt, targy)");
        Skeleton.end("");
    }

    /** A vásárlási folyamat során hívódik meg, fizetést végez. */
    public boolean fizet(int ar) {
        Skeleton.hivas(this, "fizet(" + ar + ")");
        Skeleton.end("true");
        return true;
    }

    /** Meghívja a hókotró fejetCserel() metódusát. */
    public void eszkozKiosztas(Hokotro h, IKotrofej ujFej) {
        Skeleton.hivas(this, "eszkozKiosztas(h, ujFej)");
        Skeleton.end("");
    }

    /** Hozzáad egy újonnan vásárolt vagy beszerzett hókotrót a takarító flottájához.*/
    public void addHokotro(Hokotro h) {
        Skeleton.hivas(this, "addHokotro(h)");
        Skeleton.end("");
    }
}