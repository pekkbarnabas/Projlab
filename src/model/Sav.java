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
    private List<Jarmu> rajtaAllok = new java.util.ArrayList<>();
    /** Az az útszakasz amihez a sáv tartozik. */
    private Utszakasz utszakasz;
    /** Az Idojaras objektum ismerete. */
    private Idojaras idojaras;
    /** A sávon lévő só mennyisége.*/
    private double so;
    /** A sávon lévő hó mennyisége. */
    private int hoVastagsag;

    /** Fagyott állapot jelzője. */
    private boolean jegPancel;
    /** Baleset esetén igaz. */
    private boolean blokkolt;

    private int athaladasokSzama = 0;
    
    private int jegesedesKuszob = 5;

    private int sozasIdozito = 0;

    /**
     * Beállítja, hogy a sáv blokkolt-e.
     * @param blokkolt
     */
    public void setBlokkolt(boolean blokkolt) { 
        Skeleton.hivas(this, "setBlokkolt(" + blokkolt + ")");
        this.blokkolt = blokkolt; 
        Skeleton.end("");
    }
    /**
     * Beállítja a szomszédos sávokat, amelyekkel a sáv kapcsolatban áll.
     * @param szomszedok
     */
    public void setSzomszedok(List<Sav> szomszedok) { this.szomszedok = szomszedok; }

    /**
     * Beállítja a sávhoz tartozó sómennyiséget.
     * @param mennyiseg
     */
    public void setSoMennyiseg(int mennyiseg){ 
        this.so = mennyiseg; 
    }

    /**
     * 
     * @param szam
     */
    public void setAthaladasokSzama(int szam) {
        this.athaladasokSzama = szam;
    }
    /**
     * Beállítja a sózás időzítőjét.
     * @param idozito
     */
    public void setSozasIdozito(int idozito) {
        this.sozasIdozito = idozito;
    }

    /**
     * Visszaadja, hogy a sáv jeges-e.
     * @return
     */
    public boolean isJegpancel(){
        return this.jegPancel;
    }
    

    public boolean isBlokkolt() {
        Skeleton.hivas(this, "isBlokkolt()");
        Skeleton.end(this.blokkolt ? "true" : "false");
        return this.blokkolt;
    }

    /** Hozzáadja a járművet a listájához. */
    public void elfogad(Jarmu j) {
        Skeleton.hivas(this, "elfogad(" + j.getNev() + ")");
        
        if (!rajtaAllok.contains(j)) {
            rajtaAllok.add(j);
        }
        
        if(this.hoVastagsag >= 10){
            isMelyHo();
            if(!(j instanceof Hokotro)){
                j.elakad();
            }
        }else if (this.jegPancel) {
            if(!(j instanceof Hokotro)){
                j.megcsuszik();
            }
        } else {
            this.atHaladasRegisztralasa();
        }
        
        Skeleton.end("");
    }
    public void setHovastagsag(int mennyiseg){
        this.hoVastagsag = mennyiseg;
    }

    public boolean isMelyHo() {
        boolean melyHo = false;
        Skeleton.hivas(this, "isMelyHo()");
        if (hoVastagsag >= 10)
            melyHo = true;
        Skeleton.end(melyHo ? "true" : "false");
        return melyHo;
    }
    /**
     * Beállítja, hogy a sáv jeges-e.
     * @param jeges
     */
    public void setJegpancel(boolean jeges) { 
        Skeleton.hivas(this, "setJegPancel(" + jeges + ")");
        this.jegPancel = jeges; 
        Skeleton.end(""); 
    }

    /** A jármű kikerül a listából. */
    public void eltavolit(Jarmu j) {
        Skeleton.hivas(this, "eltavolit(" + j.getNev() + ")");
        rajtaAllok.remove(j);
        Skeleton.end("");
    }

    /** Hókotró hívja meg, csökkenti a hóvastagságot. */
    public void hoCsokkent(int mennyiseg) {
        String maxSzo = (mennyiseg == Integer.MAX_VALUE) ? "max" : String.valueOf(mennyiseg);
        Skeleton.hivas(this, "hoCsokkent(" + maxSzo + ")");

        int eltavolitott = this.hoVastagsag;
        if(mennyiseg < this.hoVastagsag) {
            eltavolitott = mennyiseg;
        }
        this.hoVastagsag -= eltavolitott;
        
        if (this.blokkolt) {
            this.setBlokkolt(false);
        }

        Skeleton.end("");
    }

    /** Feloldja a jegPancel állapotot, és megnöveli a hóvastagságot. */
    public void jegTorese() {
        Skeleton.hivas(this, "jegTorese()");

        if (this.jegPancel) {
            this.setJegpancel(false);
            this.hoNovel(1);
        }

        Skeleton.end("");
    }

    /** Elindítja az olvadást. */
    public void sozas() {
        Skeleton.hivas(this, "sozas()");
        this.so = 1.0;
        Skeleton.end("");
    }

    /** Növeli a számlálót a jegesedés számításához. */
    public void atHaladasRegisztralasa() {
        Skeleton.hivas(this, "atHaladasRegisztralasa()");
        this.athaladasokSzama++;
            if (athaladasokSzama >= jegesedesKuszob) {
                setJegpancel(true);
            }
        Skeleton.end("");
    }

    
    public boolean isSozott(){
        Skeleton.hivas(this, "isSozott()");
        
        boolean sozott = this.so > 0; 
        
        Skeleton.end(sozott ? "true" : "false");
        return sozott;
    }

    /** Növeli a sávon lévő hó mennyiségét. */
    public boolean hoNovel(int mennyiseg) {
        Skeleton.hivas(this, "hoNovel(mennyiseg)");
        
        if (this.utszakasz != null) {
            int magassag = this.utszakasz.getMagassag();
            if (magassag == -1) {
                Skeleton.end("");
                return false;
            }
        }
        
        if(!isSozott()) {
            this.hoVastagsag += mennyiseg;
        }
        
        Skeleton.end("");
        return true;
    }

    public List<Jarmu> getRajtaAllok() {
        Skeleton.hivas(this, "getRajtaAllok()");
        
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < rajtaAllok.size(); i++) {
            sb.append(rajtaAllok.get(i).getNev());
            if (i < rajtaAllok.size() - 1) sb.append(", ");
        }
        sb.append("]");
        
        Skeleton.end(sb.toString());
        
        return new java.util.ArrayList<>(rajtaAllok);
    }

    public List<Sav> getSzomszedok() {
        Skeleton.hivas(this, "getSzomszedok()");
        Skeleton.end("[szomszedos]");
        return szomszedok;
    }

    public List<Sav> getSzomszedokCsendes() {
        return szomszedok;
    }

    @Override
    public void idotLep() {
        Skeleton.hivas(this, "idotLep()");

        // Ha van aktív sózás, csökkentjük az időzítőt
        if (sozasIdozito > 0) {
            sozasIdozito--;
            
            // Ha az időzítő lejárt (0 lett) és van jégpáncél, akkor az felolvad
            if (sozasIdozito == 0 && this.jegPancel) {
                this.setJegpancel(false);
                
                this.hoVastagsag = 0; 
            }
        }
        Skeleton.end("");
    }

    public int getHovastagsag(){
        return this.hoVastagsag;
    }

    /**
     * Beállítja az utszakaszt.
     * @param u
     */
    public void setUtszakasz(Utszakasz u) {
        this.utszakasz = u;
    }


}