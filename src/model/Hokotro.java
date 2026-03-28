package model;

import skeleton.Skeleton;

/**
 * A Takarító által irányított munkagép. Felelőssége, hogy mozogjon a sávok között, és a rászerelt kotrófej segítségével megtisztítsa az utakat.
 */
public class Hokotro extends Jarmu {
    /** Az IKotrofej interfészt megvalósító aktuális eszköz. */
    private IKotrofej fej;
    /** A Takarito játékos objektum, akihez a gép tartozik. */
    private Takarito tulajdonos;

    /** Lecseréli az aktuális fej asszociációt. */
    public void fejetCserel(IKotrofej ujFej) {
        Skeleton.hivas(this, "fejetCserel(ujFej)");
        Skeleton.end("");
    }

    /** Lekéri a tulajdonos raktárából a sót. */
    public boolean sotFogyaszt(int mennyiseg) {
        Skeleton.hivas(this, "sotFogyaszt(" + mennyiseg + ")");
        Skeleton.end("true");
        return true;
    }

    /** Lekéri a tulajdonos raktárából a kerozint. */
    public boolean kerozintFogyaszt(int mennyiseg) {
        Skeleton.hivas(this, "kerozintFogyaszt(" + mennyiseg + ")");
        Skeleton.end("true");
        return true;
    }

    /** Meghívja a fej.dolgozik függvényt. */
    public void takarit() {
        Skeleton.hivas(this, "takarit()");
        Skeleton.end("");
    }

    @Override
    public void elakad() { Skeleton.hivas(this, "elakad()"); Skeleton.end(""); }

    @Override
    public void megcsuszik() { Skeleton.hivas(this, "megcsuszik()"); Skeleton.end(""); }

    @Override
    public void utkozik(Jarmu masik) { Skeleton.hivas(this, "utkozik(masik)"); Skeleton.end(""); }
}