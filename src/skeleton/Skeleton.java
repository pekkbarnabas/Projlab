package skeleton;

import model.Auto;
import model.Busz;
import model.Buszvezeto;
import model.Csomopont;
import model.Idojaras;
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
            case 2: kikerulesTeszt(); break;
            case 3:sikertelenKikerulesTeszt(); break;
            case 4: elakadasTeszt(); break;
            case 5: megcsuszasSajatTeszt(); break;
            case 6: megcsuszasAtsodrodasTeszt(); break;
            case 7: megcsuszasBalesetTeszt(); break;
            case 8: vegallomasraErTeszt(); break;
            case 9: vegallomasraErKoztesTeszt(); break;
            case 10: buszBalesetTeszt(); break;
            case 11: buntetoIdoLetelteTeszt(); break;
            case 12: havazasTisztaSavonTeszt(); break;
            case 13: havazasSozottSavonTeszt(); break;
            case 14: SavJegesedeseTeszt(); break;
            case 15: JegpancelSozasUtanTeszt(); break;
            default: System.out.println("Nincs ilyen sorszámú teszteset.");
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
        Auto a1 = new Auto();
        a1.setNev("a1");
        Csomopont cs = new Csomopont();
        Utszakasz ut = new Utszakasz();
        Sav szomszedos = new Sav();
        Sav aktualis = new Sav();

        
        ut.setVegpont(cs); 
        cs.setKijaratok(java.util.Arrays.asList(ut)); 
        ut.setSavok(java.util.Arrays.asList(szomszedos));

        
        a1.setAktualisUtszakasz(ut); 
        a1.setAktualisSav(aktualis);
        a1.setPozicio(1.0f); 

        
        aktualis.elfogad(a1);
        
        ENABLED = true;
        
        a1.idotLep();
    }

    /**
     * UC-02: Autó sikeres kikerülési manővere
     */
    private static void kikerulesTeszt() {
        ENABLED = false; // Naplózás kikapcsolása a setup idejére

        // 3 objektum létrehozása
        Sav aktualis = new Sav();
        Sav szomszedos = new Sav();
        Auto a1 = new Auto();
        a1.setNev("a1"); 

        aktualis.setBlokkolt(true);       // Az aktuális sáv blokkolt lesz
        szomszedos.setBlokkolt(false);    // A szomszédos szabad
        aktualis.setSzomszedok(java.util.Arrays.asList(szomszedos)); 
        a1.setAktualisSav(aktualis);

        aktualis.elfogad(a1);

        ENABLED = true; // Naplózás visszakapcsolása

        a1.idotLep();
    }

    /**
     * UC-03: Autó sikertelen kikerülési manővere
     */
    private static void sikertelenKikerulesTeszt() {
        ENABLED = false; // Naplózás kikapcsolása a setup idejére

        // 1-3. lépés a kommunikációs diagramon
        Sav aktualis = new Sav();
        Sav szomszedos = new Sav();
        Auto a1 = new Auto();
        a1.setNev("a1"); 

        // Tesztkörnyezet beállítása
        aktualis.setBlokkolt(true);       
        
        // ITT A KÜLÖNBSÉG: A szomszédos sáv is blokkolt!
        szomszedos.setBlokkolt(true);    
        
        aktualis.setSzomszedok(java.util.Arrays.asList(szomszedos)); 
        a1.setAktualisSav(aktualis);

        // 4. lépés a kommunikációs diagramon: ráhelyezés
        aktualis.elfogad(a1);

        ENABLED = true; // Naplózás visszakapcsolása

        // Végrehajtás: sd UC-3
        a1.idotLep();
    }

    /**
     * UC-04: Autó elakadása extrém mély hóban
     */
    private static void elakadasTeszt() {
        ENABLED = false;

        Sav s1 = new Sav();
        Auto a1 = new Auto();
        a1.setNev("a1"); 

        s1.setHovastagsag(11);

        ENABLED = true; 

        
        s1.elfogad(a1);
    }

    /**
     * UC-05: Megcsúszás a saját sávban maradó autóval
     */
    private static void megcsuszasSajatTeszt() {
        ENABLED = false; 

        Sav s1 = new Sav();
        Auto a1 = new Auto();
        a1.setNev("a1"); 

        s1.setJegpancel(true);
        a1.setAktualisSav(s1);

        ENABLED = true;

        s1.elfogad(a1);
    }

    /**
     * UC-06: Megcsúszás és átsodródás üres sávba
     */
    private static void megcsuszasAtsodrodasTeszt() {
        ENABLED = false;

        Sav s1 = new Sav();
        Sav s2 = new Sav();
        Auto a1 = new Auto();
        a1.setNev("a1"); 

        s1.setJegpancel(true);
        s1.setSzomszedok(java.util.Arrays.asList(s2)); 
        a1.setAktualisSav(s1); 

        a1.setTesztSodrodas(true); 

        ENABLED = true;

        s1.elfogad(a1);
    }

    /**
     * UC-07: Megcsúszás, átsodródás és baleset
     */
    private static void megcsuszasBalesetTeszt() {
        ENABLED = false; 

        Sav s1 = new Sav();
        Sav s2 = new Sav();
        
        Auto a1 = new Auto();
        a1.setNev("a1"); 
        
        Auto a2 = new Auto();
        a2.setNev("a2");

        s1.setJegpancel(true);
        s1.setSzomszedok(java.util.Arrays.asList(s2)); 
        a1.setAktualisSav(s1); 
        
        
        s2.elfogad(a2);

        // a1 átsodródik
        a1.setTesztSodrodas(true); 

        ENABLED = true;

        s1.elfogad(a1);
    }

    /**
     * UC-08: Végállomásra ér a busz
     */
    private static void vegallomasraErTeszt() {
        ENABLED = false;

        Busz b = new Busz();
        b.setNev("b");
        
        Buszvezeto bv = new Buszvezeto();
        
        Csomopont aktualis = new Csomopont();
        aktualis.setNev("aktualis");
        
        Csomopont masik = new Csomopont();
        masik.setNev("masik");

        b.setTulajdonos(bv);
        
        // Lista feltöltése a két állomással
        b.setVegallomasok(java.util.Arrays.asList(aktualis, masik));
        
        // Beállítjuk az aktuális célt
        b.setVegallomas(aktualis); 

        ENABLED = true;
        b.vegallomasraEr(aktualis);
    }

    /**
     * UC-09: Busz áthaladása köztes csomóponton
     */
    private static void vegallomasraErKoztesTeszt() {
        ENABLED = false; // Setup alatt nincs logolás

        
        Busz b = new Busz();
        b.setNev("b");
        
        Buszvezeto bv = new Buszvezeto();
        
        // Ez az a csomópont, amin a busz éppen áthalad
        Csomopont aktualis = new Csomopont();
        aktualis.setNev("aktualis");
        
        // Létrehozunk egy másik csomópontot is, ami a busz igazi végállomása lesz
        Csomopont igaziCel = new Csomopont();
        igaziCel.setNev("igaziCel");

        b.setTulajdonos(bv);
        
        // A busz végállomását az 'igaziCel'-re állítjuk, 
        // így amikor az 'aktualis'-ra lép, tudni fogja, hogy az csak köztes állomás.
        b.setVegallomas(igaziCel); 

        ENABLED = true; 

        
        b.vegallomasraEr(aktualis);
    }

/**
     * UC-10: Busz balesetet szenved
     */
    private static void buszBalesetTeszt() {
        ENABLED = false;

        // Objektumok létrehozása
        Auto a = new Auto();
        a.setNev("a");
        Busz b = new Busz();
        b.setNev("b");
        Sav s = new Sav();

        // Tesztkörnyezet beállítása
        b.setAktualisSav(s);
        a.setAktualisSav(s);
        a.setTesztSodrodas(false); // A saját sávjában fog megcsúszni

        
        // Mivel a sáv nem jeges a setup fázisban, az elfogad nem indít automatikus megcsúszást.
        s.elfogad(b);
        s.elfogad(a);

        ENABLED = true; 

        
        a.megcsuszik();
    }


    /**
     * UC-11: Jármű büntetőidejének letelte
     */
    private static void buntetoIdoLetelteTeszt() {
        ENABLED = false; 

        // Objektum létrehozása
        Auto a = new Auto();
        a.setNev("a");
        
        // Beállítjuk a büntetőidőt 1-re
        a.setBuntetoIdo(1);

        ENABLED = true; 

        
        a.idotLep();
    }

    /**
     * UC-12: Havazás tiszta sávon
     */
    private static void havazasTisztaSavonTeszt() {
        ENABLED = false; // Setup alatt nincs logolás

        // Objektumok létrehozása
        Idojaras idj = new Idojaras();
        Sav s = new Sav();
        
        
        idj.setIntenzitas(2);
        s.setHovastagsag(0); // Tiszta sáv, 0 hóval
        
        // Összekötjük az időjárást a sávval
        idj.setSavok(java.util.Arrays.asList(s));

        ENABLED = true; 

        
        idj.idotLep();
    }

    /**
     * UC-13: Havazás sózott sávon
     */
    private static void havazasSozottSavonTeszt() {
        ENABLED = false; 

        //Objektumok létrehozása
        Idojaras idj = new Idojaras();
        Sav s = new Sav();
        
       
        idj.setIntenzitas(2);
        s.setHovastagsag(0); 
        
        // A sáv sózott állapotba kerül!
        s.setSoMennyiseg(1); 
        
        idj.setSavok(java.util.Arrays.asList(s));

        ENABLED = true; 

        
        idj.idotLep();
    }

    /**
     * UC-14: Sáv jegesedése forgalom hatására
     */
    private static void SavJegesedeseTeszt() {
        ENABLED = false; // Setup alatt nincs logolás

        //  Objektum létrehozása
        Sav s = new Sav();
        
        
        s.setHovastagsag(5); // Legyen valamennyi hó, ami letaposódik
        
        
        s.setAthaladasokSzama(4); 

        ENABLED = true; 
        
        s.atHaladasRegisztralasa();
    }


    /**
     * UC-15: Jégpáncél eltűnése sózás után
     */
    private static void JegpancelSozasUtanTeszt() {
        ENABLED = false; 

        //bjektum létrehozása
        Sav s = new Sav();
        
        
        s.setJegpancel(true);  // A sáv be van fagyva
        s.setSozasIdozito(1);  // Az időzítő pont most fog lejárni

        ENABLED = true; 

        s.idotLep();
    }



}
