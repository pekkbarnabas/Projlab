package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * A tömegközlekedést irányító játékos reprezentációja.
 */
public class Buszvezeto {
    /** A sikeres fordulók száma. */
    private int pontszam;
    /** Aggregációs kapcsolat a Busz objektumokkal. */
    private List<Busz> buszok;

    /** Növeli a pontszam értékét. */
    public void pontotKap() {
        Skeleton.hivas(this, "pontotKap()");
        Skeleton.end("");
    }
}