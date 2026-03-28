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
                } else if (valasztas > 0 && valasztas <= 40) {
                    // Átadjuk a vezérlést a Skeletonnak
                    Skeleton.tesztesetFuttatasa(valasztas);
                } else {
                    System.out.println("Érvénytelen sorszám! Kérem 1 és 40 közötti számot adjon meg.");
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
        // ... IDE JÖN A TÖBBI 38 ...
        System.out.println("40. UC-40: Busz megcsúszása jégpáncélon");
    }
}