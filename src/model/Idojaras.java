package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * A környezeti hatások felelőse. Időről időre gondoskodik arról, hogy a város összes sávján megnövelje a hóvastagságot.
 */
public class Idojaras implements IIdomulo {
    /** A ciklusonként lehulló hó mennyiseg.. */
    private int intenzitas;

    /**
     * Végigiterál a sávokon, és minden elemen meghívja a hoNovel(int) függvényt.
     */
    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        Skeleton.end("");
    }
}