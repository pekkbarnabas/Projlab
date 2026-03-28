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
        Skeleton.hivas(this, "vegallomasraEr(" + aktualis.getNev() + ")");

        if(this.aktualisVegallomas != null && aktualisVegallomas == aktualis){
            Csomopont masik = null;
            if(vegallomasok != null){
                for(Csomopont v : vegallomasok){
                    if(v != aktualis) {
                        masik = v;
                        break;
                    }
                }
            }

            if(masik != null){
                setVegallomas(masik);
            }

            if(tulajdonos != null){
                tulajdonos.pontotKap();
            }
        }


        Skeleton.end("");
    }

    public void setVegallomas(Csomopont cs) {
        Skeleton.hivas(this, "setVegallomas(" + (cs != null ? cs.getNev() : "null") + ")");
        this.aktualisVegallomas = cs;
        Skeleton.end("");
    }

    @Override
    public void elakad() { Skeleton.hivas(this, "elakad()"); Skeleton.end(""); }

    @Override
    public void megcsuszik() { Skeleton.hivas(this, "megcsuszik()"); Skeleton.end(""); }

    @Override
    public void utkozik(Jarmu masik) { 
        Skeleton.hivas(this, "utkozik(" + (masik != null ? masik.getNev() : "null") + ")"); 
        
        this.buntetoIdo = 3; 
        
        // A sáv járhatatlanná válik
        if (this.aktualisSav != null) {
            this.aktualisSav.setBlokkolt(true);
        } 
        
        Skeleton.end(""); 
    }

    public void setTulajdonos(Buszvezeto tulajdonos) { this.tulajdonos = tulajdonos; }

    public void setVegallomasok(List<Csomopont> vegallomasok) { this.vegallomasok = vegallomasok; }
}