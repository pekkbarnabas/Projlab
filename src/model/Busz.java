package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * Tömegközlekedési jármű, amely a játékos irányítása alatt áll. Célja a végállomások érintése.
 */
public class Busz extends Jarmu {
    /** Baleset esetén ennyi körig nem mozoghat. */
    private int buntetoIdo;
    /** A két fix pont, ami között a busz közlekedik. */
    private List<Csomopont> vegallomasok;
    /** Az a végpont, amely felé a busz éppen tart. */
    private Csomopont aktualisVegallomas;
    /** A Buszvezeto játékos objektum. */
    private Buszvezeto tulajdonos;

    /**
     * Megvizsgálja, hogy a busz a célállomásra érkezett-e, ha igen, pontot ad a vezetőnek.
     */
    public void vegallomasraEr(Csomopont aktualis) {
        Skeleton.hivas(this, "vegallomasraEr(aktualis)");
        Skeleton.end("");
    }

    public void setVegallomas() {
        Skeleton.hivas(this, "setVegallomas()");
        Skeleton.end("");
    }

    @Override
    public void elakad() { Skeleton.hivas(this, "elakad()"); Skeleton.end(""); }

    @Override
    public void megcsuszik() { Skeleton.hivas(this, "megcsuszik()"); Skeleton.end(""); }

    @Override
    public void utkozik(Jarmu masik) { Skeleton.hivas(this, "utkozik(masik)"); Skeleton.end(""); }
}