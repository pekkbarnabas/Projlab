package skeleton;

import model.Auto;
import model.Csomopont;
import model.Sav;
import model.Utszakasz;

/**
 * A szekeleton működését támogató osztály.
 */
public class Skeleton {
    private static boolean ENABLED = true;
    private static int behuzas = 0;

    /**
     * Futtatja a megadott sorszámú tesztesetet.
     * @param sorszam
     */
    public static void tesztesetFuttatasa(int sorszam){
        behuzas = 0;
        System.out.println("\n[ " + sorszam + ". Teszteset elindul... ]");

        switch(sorszam){
            case 1: autoNormalMozgasTeszt(); break;
        }
    }

    /**
     * Hívja a megadott objektum metódusát, és nyomon követi a hívásokat.
     * @param peldany
     * @param uzenet
     */
    public static void hivas(Object peldany, String uzenet){
        if(!ENABLED) return;
        for(int i = 0; i < behuzas; i++) System.out.print("\t");
        System.out.println(peldany.getClass().getSimpleName().toLowerCase() + "." + uzenet);
        behuzas++;
    }

    /**
     * Jelzi, hogy egy metódus visszatért egy értékkel, és nyomon követi a hívásokat.
     * @param result
     */
    public static void end(String result){
        if(!ENABLED) return;
        behuzas--;
        for(int i = 0; i < behuzas; i++) System.out.print("\t");
        System.out.println("return" + (result.isEmpty() ? "" : " " + result));
    }


    /**
     * UC-01: Autó normál haladása tiszta sávon
     */
    private static void autoNormalMozgasTeszt() {
        ENABLED = false;
        // 1-5. lépés a kommunikációs diagramon: Pontosan 5 objektum létrehozása (<<create>>)
        Auto a1 = new Auto();
        a1.setnev("a1");
        Csomopont cs = new Csomopont();
        Utszakasz ut = new Utszakasz();
        Sav szomszedos = new Sav();
        Sav aktualis = new Sav();

        // Tesztkörnyezet gráfjának összekötése (Ezek a setterek nem logolnak a konzolra!)
        ut.setVegpont(cs); 
        cs.setKijaratok(java.util.Arrays.asList(ut)); 
        ut.setSavok(java.util.Arrays.asList(szomszedos));

        // Az Autó alapállapotának beállítása az analízis modell szerint (nem ismeri a csomópontot)
        a1.setAktualisUtszakasz(ut); 
        a1.setAktualisSav(aktualis);
        a1.setPozicio(1.0f); // Jelképesen: elérte az útszakasz végét, ezért fog navigálni

        // 6. lépés a kommunikációs diagramon: elfogad(a1)
        aktualis.elfogad(a1);
        
        ENABLED = true;
        // Szekvencia diagram szerinti végrehajtás indítása (Rendszer -> idotLep())
        a1.idotLep();
    }
}
