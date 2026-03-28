package skeleton;


/**
 * A szekeleton működését támogató osztály.
 */
public class Skeleton {
    private static final boolean ENABLED = true;
    private static int behuzas = 0;

    /**
     * Futtatja a megadott sorszámú tesztesetet.
     * @param sorszam
     */
    public static void tesztesetFuttatasa(int sorszam){
        behuzas = 0;
        System.out.println("\n[ " + sorszam + ". Teszteset elindul... ]");

        switch(sorszam){
            case 1 -> Teszteset1.futtatasa();
            case 2 -> Teszteset2.futtatasa();
            case 3 -> Teszteset3.futtatasa();
            case 4 -> Teszteset4.futtatasa();
            case 5 -> Teszteset5.futtatasa();
            default -> System.out.println("Nincs ilyen sorszámú teszteset.");
        }
    }

    /**
     * Hívja a megadott objektum metódusát, és nyomon követi a hívásokat.
     * @param peldanyNev
     * @param uzenet
     */
    public static void hivas(String peldanyNev, String uzenet){
        if(!ENABLED) return;
        for(int i = 0; i < behuzas; i++) System.out.print("\t");
        System.out.println(peldanyNev + "." + uzenet);
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



}
