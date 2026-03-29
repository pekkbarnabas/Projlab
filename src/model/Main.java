package model;

import java.util.Scanner;
import skeleton.Skeleton;

/**
 * A program belépési pontja.
 * Felelős a menürendszer megjelenítéséért és a felhasználói parancsok bekéréséért.
 */
public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean fut = true;
        
        while (fut) {
            nyomtatMenu();
            System.out.print("Válasszon tesztesetet a sorszám megadásával (0 a kilépéshez): ");
            
            String bemenet = scanner.nextLine().trim();
            
            try {
                int valasztas = Integer.parseInt(bemenet);
                if (valasztas == 0) {
                    fut = false;
                    System.out.println("Kilépés...");
                } else if (valasztas > 0 && valasztas <= 42) {
                    // Átadjuk a vezérlést a Skeletonnak
                    Skeleton.tesztesetFuttatasa(valasztas);
                } else {
                    System.out.println("Érvénytelen sorszám! Kérem 1 és 42 közötti számot adjon meg.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Hiba: Kérem számot adjon meg!");
            }
        }
        scanner.close();
    }

    /**
     * Kiírja a konzolra az elérhető tesztesetek listáját.
     */
    private static void nyomtatMenu() {
        System.out.println("\n=== ZÚZMARAVÁROS SZKELETON ===");
        System.out.println("Tesztesetek:");
        System.out.println("1. UC-01: Autó normál haladása tiszta sávon");
        System.out.println("2. UC-02: Autó sikeres kikerülési manővere");
        System.out.println("3. UC-03: Autó sikertelen kikerülési manővere");
        System.out.println("4. UC-04: Autó elakadása extrém mély hóban");
        System.out.println("5. UC-05: Megcsúszás a saját sávban maradó autóval");
        System.out.println("6. UC-06: Megcsúszás és átsodródás üres sávba");
        System.out.println("7. UC-07: Megcsúszás, átsodródás és baleset");
        System.out.println("8. UC-08: Végállomásra ér a busz");
        System.out.println("9. UC-09: Busz áthaladása köztes csomóponton");
        System.out.println("10. UC-10: Busz balesetet szenved");
        System.out.println("11. UC-11: Jármű büntetőidejének letelte");
        System.out.println("12. UC-12: Havazás tiszta sávon");
        System.out.println("13. UC-13: Havazás sózott sávon");
        System.out.println("14. UC-14: Sáv jegesedése forgalom hatására");
        System.out.println("15. UC-15: Jégpáncél eltűnése sózás után");
        System.out.println("16. UC-16: Hókotró biztonságos haladása jeges sávon");
        System.out.println("17. UC-17: Söprőfej sikeres takarítása");
        System.out.println("18. UC-18: Söprőfej sikertelen takarítása jégen");
        System.out.println("19. UC-19: Hányófej sikeres takarítása");
        System.out.println("20. UC-20: Jégtörő fej sikeres jégtörése");
        System.out.println("21. UC-21: Sárkányfej sikeres takarítása");
        System.out.println("22. UC-22: Sárkányfej sikertelen takarítása (Nincs kerozin)");
        System.out.println("23. UC-23: Sószóró fej sikeres takarítása (Van só)");
        System.out.println("24. UC-24: Sószóró fej sikertelen takarítása (Nincs só)");
        System.out.println("25. UC-25: Takarító bevételezése");
        System.out.println("26. UC-26: Kotrófej csere a hókotrón");
        System.out.println("27. UC-27: Raktár készletének bővítése vásárlás után");
        System.out.println("28. UC-28: Raktár készletének csökkentése fogyasztáskor");
        System.out.println("29. UC-29: Vásárlás, de kevés a pénz");
        System.out.println("30. UC-30: Só vásárlása");
        System.out.println("31. UC-31: Kerozin vásárlása");
        System.out.println("32. UC-32: Új jégtörőfej vásárlása");
        System.out.println("33. UC-33: Új söprőfej vásárlása");
        System.out.println("34. UC-34: Új sárkányfej vásárlása");
        System.out.println("35. UC-35: Új hányófej vásárlása");
        System.out.println("36. UC-36: Új Hókotró gép vásárlása");
        System.out.println("37. UC-37: Havazás alagútban");
        System.out.println("38. UC-38: Takarítás tiszta sávon, nincs bevétel");
        System.out.println("39. UC-39: Blokkolt sáv felszabadítása takarítással");
        System.out.println("40. UC-40: Busz megcsúszása jégpáncélon");
        System.out.println("41. UC-41: Hányófej sikertelen takarítása (jégpáncélon)");
        System.out.println("42. UC-42: Jégtörő fej sikertelen jégtörése");
    }
}