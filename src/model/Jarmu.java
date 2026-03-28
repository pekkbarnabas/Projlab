package model;

import skeleton.Skeleton;

/**
 * A mozgó entitások (autók, buszok, hókotrók) közös állapotát és alapvető viselkedését összefogó ősosztály.
 */
public abstract class Jarmu implements IIdomulo {
    /** A Sav objektum, ahol a jármű jelenleg tartózkodik. */
    protected Sav aktualisSav;
    /** Az Utszakasz objektum, amihez a jelenlegi sáv tartozik. */
    protected Utszakasz aktualisUtszakasz;
    /** A jármű jelenlegi helyzete az útszakaszon belül. */
    protected float pozicio;

    /** Beállítja az elakadt állapotot igazra extrém hó esetén. */
    public abstract void elakad();

    /** Lekezeli a jégen való csúszást (saját sávban vagy másik sávba). */
    public abstract void megcsuszik();

    /** Reagál az ütközésre, mozgásképtelenné válik. */
    public abstract void utkozik(Jarmu masik);

    /** A jármű neve. */
    protected String nev;

    /** Növeli a jármű pozícióját az aktuális sávon, szükség esetén sávot vált. */
    public void lep(Sav ujSav) {
        Skeleton.hivas(this, "lep()");
        if (aktualisSav != null) {
            aktualisSav.eltavolit(this);
        }
        if (ujSav != null) {
            ujSav.elfogad(this);
            this.aktualisSav = ujSav;
        }
        Skeleton.end("");
    }

    /** Ütemenként hívódik. Ha nem elakadt, növeli a pozicio értékét. */
    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        Skeleton.end("");
    }

    public void setAktualisSav(Sav s) { this.aktualisSav = s; }
    public void setAktualisUtszakasz(Utszakasz ut) { this.aktualisUtszakasz = ut; }
    public void setPozicio(float p) { this.pozicio = p; }
    public String getNev() { return this.nev; }
    public void setNev(String nev) { this.nev = nev; }
}