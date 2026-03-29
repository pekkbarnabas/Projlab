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

    public void setTulajdonos(Takarito tulajdonos) {
        this.tulajdonos = tulajdonos;
    }


    /** Lecseréli az aktuális fej asszociációt.
     * @param ujFej 
     */
    public void fejetCserel(IKotrofej ujFej) {
        Skeleton.hivas(this, "fejetCserel(ujFej)");
        this.fej = ujFej;
        Skeleton.end("");
    }

    /** Lekéri a tulajdonos raktárából a sót. 
     * @param mennyiseg
    */
    public boolean sotFogyaszt(int mennyiseg) {
        Skeleton.hivas(this, "sotFogyaszt(" + mennyiseg + ")");
        
        boolean siker = false;
        if (this.tulajdonos != null) {
            Raktar r = this.tulajdonos.getRaktar();
            if (r != null) {
                siker = r.eroforrasCsokkent(Arucikk.SO, mennyiseg);
            }
        }
        
        Skeleton.end(siker ? "true" : "false");
        return siker;
    }

    /** Lekéri a tulajdonos raktárából a kerozint. 
     * @param mennyiseg
    */
    public boolean kerozintFogyaszt(int mennyiseg) {
        Skeleton.hivas(this, "kerozintFogyaszt(" + mennyiseg + ")");

        boolean siker = false;
        if (this.tulajdonos != null) {
            Raktar r = this.tulajdonos.getRaktar();
            if (r != null) {
                siker = r.eroforrasCsokkent(Arucikk.KEROZIN, mennyiseg);
            }
        }
        
        Skeleton.end(siker ? "true" : "false");
        return siker;
    }

    /** Meghívja a fej.dolgozik függvényt. */
    public void takarit() {
        Skeleton.hivas(this, "takarit()");

        if (fej != null && aktualisSav != null) {
            //Állapot lementése takarítás előtt
            int hoElotte = aktualisSav.getHovastagsag();
            boolean jegElotte = aktualisSav.isJegpancel();
            
            // A fej elvégzi a munkát
            fej.dolgozik(aktualisSav, this);
            
            // Állapot lekérdezése takarítás után
            int hoUtana = aktualisSav.getHovastagsag();
            boolean jegUtana = aktualisSav.isJegpancel();
            
            // Érdemi munka történt-e?
            boolean erdemiMunka = (hoElotte > hoUtana) || (jegElotte && !jegUtana);
            
            
            if (erdemiMunka && tulajdonos != null) {
                tulajdonos.penztKap();
            }
        }

        Skeleton.end("");
    }

    @Override
    public void elakad() { Skeleton.hivas(this, "elakad()"); Skeleton.end(""); }

    @Override
    public void megcsuszik() { Skeleton.hivas(this, "megcsuszik()"); Skeleton.end(""); }

    @Override
    public void utkozik(Jarmu masik) { Skeleton.hivas(this, "utkozik(masik)"); Skeleton.end(""); }

    public IKotrofej getFej(){
        return this.fej;
    }
}