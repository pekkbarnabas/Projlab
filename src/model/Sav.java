package model;

import java.util.List;
import skeleton.Skeleton;

/**
 * A közlekedés legkisebb területi egysége. Nyilvántartja az állapotát.
 */
public class Sav implements IIdomulo {
    /** Gyűjtemény az azonos útszakaszon belüli szomszédos Sav objektumokról. */
    private List<Sav> szomszedok;
    /** Gyűjtemény a rajta tartózkodó Jarmu objektumokról. */
    private List<Jarmu> rajtaAllok;
    /** Az az útszakasz amihez a sáv tartozik. */
    private Utszakasz utszakasz;
    /** Az Idojaras objektum ismerete. */
    private Idojaras idojaras;
    
    /** A sávon lévő hó mennyisége. */
    private int hoVastagsag;
    /** A só koncentrációja */
    private int soMennyiseg;

    /** Fagyott állapot jelzője. */
    private boolean jegPancel;
    /** Baleset esetén igaz. */
    private boolean blokkolt;

    public boolean isBlokkolt() {
        Skeleton.hivas(this, "isBlokkolt()");
        Skeleton.end(this.blokkolt ? "true" : "false");
        return this.blokkolt;
    }

    /** Hozzáadja a járművet a listájához. */
    public void elfogad(Jarmu j) {
        Skeleton.hivas(this, "elfogad(jarmu)");
        Skeleton.end("");
    }

    /** A jármű kikerül a listából. */
    public void eltavolit(Jarmu j) {
        Skeleton.hivas(this, "eltavolit(jarmu)");
        Skeleton.end("");
    }

    /** Hókotró hívja meg, csökkenti a hóvastagságot. */
    public void hoCsokkent(int mennyiseg) {
        Skeleton.hivas(this, "hoCsokkent(" + mennyiseg + ")");
        Skeleton.end("");
    }

    /** Feloldja a jegPancel állapotot, és megnöveli a hóvastagságot. */
    public void jegTorese() {
        Skeleton.hivas(this, "jegTorese()");
        Skeleton.end("");
    }

    /** Elindítja az olvadást. */
    public void sozas() {
        Skeleton.hivas(this, "sozas()");
        Skeleton.end("");
    }

    /** Növeli a számlálót a jegesedés számításához. */
    public void atHaladasRegisztralasa() {
        Skeleton.hivas(this, "atHaladasRegisztralasa()");
        Skeleton.end("");
    }

    /** Növeli a sávon lévő hó mennyiségét. */
    public void hoNovel(int mennyiseg) {
        Skeleton.hivas(this, "hoNovel(" + mennyiseg + ")");
        Skeleton.end("");
    }

    public List<Jarmu> getRajtaAllok() {
        Skeleton.hivas(this, "getRajtaAllok()");
        Skeleton.end("[Jarmu lista]");
        return rajtaAllok;
    }

    public List<Sav> getSzomszedok() {
        Skeleton.hivas(this, "getSzomszedok()");
        Skeleton.end("[Szomszedos Savok]");
        return szomszedok;
    }

    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");
        Skeleton.end("");
    }
}