package model;

import java.util.ArrayList;
import java.util.List;
import skeleton.Skeleton;

/**
 * A tisztítási munkálatokat irányító játékos reprezentációja.
 */
public class Takarito {
    /** A játékos egyenlege. */
    private int penz = 0;
    /** Gyűjtemény a birtokolt Hokotro objektumokról. */
    private List<Hokotro> flotta = new ArrayList<>();
    /** A játékos Raktar objektuma. */
    private Raktar raktar;
    //** Bolt objektum */
    private Bolt bolt;

    public void penztKap() {
        Skeleton.hivas(this, "penztKap()");

        this.penz += 10;

        Skeleton.end("");
    }

    /** Kezdeményezi az Enummal megadott árucikk megvásárlását a boltban. */
    public void vasarol(Arucikk a) {
        Skeleton.hivas(this, "vasarol(Arucikk." + a.name() + ")");
        
        if (this.bolt != null) {
            boolean sikeres = this.bolt.elad(this, a);
            
            if (sikeres) {
                if (a == Arucikk.HOKOTRO) {
                    Hokotro ujHokotro = new Hokotro();
                    this.addHokotro(ujHokotro); 
                } 
                else if (this.raktar != null) {
                    if (a == Arucikk.SO || a == Arucikk.KEROZIN) {
                        this.raktar.eroforrasBovit(a, 1);
                    } else if (a == Arucikk.JEGTOROFEJ) {
                        this.raktar.hozzaadFej(new JegtoroFej());
                    } else if (a == Arucikk.SOPROFEJ) {
                        this.raktar.hozzaadFej(new SoproFej());
                    } else if (a == Arucikk.SARKANYFEJ) {
                        this.raktar.hozzaadFej(new SarkanyFej());
                    } else if (a == Arucikk.HANYOFEJ) {
                        this.raktar.hozzaadFej(new HanyoFej());
                    }
                }
            }
        }
        
        Skeleton.end("");
    }


    /** A vásárlási folyamat során hívódik meg, fizetést végez. */
    public boolean fizet(int ar) {
        Skeleton.hivas(this, "fizet(ar)");

        if (this.penz >= ar) {
            this.penz -= ar;
            Skeleton.end("true");
            return true;
        }

        Skeleton.end("false");
        return false;
    }

    /** Meghívja a hókotró fejetCserel() metódusát. */
    public void eszkozKiosztas(Hokotro h, IKotrofej ujFej) {
        Skeleton.hivas(this, "eszkozKiosztas(h, ujFej)");

        if (h != null) {
            // Megnézzük  mi volt eddig rajta
            IKotrofej regiFej = h.getFej();
            
            // Rátesszük az újat 
            h.fejetCserel(ujFej);
            
            // Ha volt rajta régi fej, és van raktárunk, eltesszük!
            if (regiFej != null && this.raktar != null) {
                
                this.raktar.hozzaadFej(regiFej);
            }
        }


        Skeleton.end("");
    }

    /** Hozzáad egy újonnan vásárolt vagy beszerzett hókotrót a takarító flottájához.*/
    public void addHokotro(Hokotro h) {
        Skeleton.hivas(this, "addHokotro(ujHokotro)");
        this.flotta.add(h);
        Skeleton.end("");
    }

    public Raktar getRaktar() {
        Skeleton.hivas(this, "getRaktar()");
        Skeleton.end("r");
        return this.raktar;
    }

    public void setRaktar(Raktar raktar) {
        this.raktar = raktar;
    }

    public void setBolt(Bolt b) {
        this.bolt = b;
    }

    public void setPenz(int osszeg) {
        this.penz = osszeg;
    }
}