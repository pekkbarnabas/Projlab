package model;
import java.util.List;
import skeleton.Skeleton;

public class SoproFej implements IKotrofej {
    @Override
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        if (s != null) {
            
            int hoElotte = s.getHovastagsag();
                       
            s.hoCsokkent(Integer.MAX_VALUE);
            
            // Csak akkor nézzük a szomszédot, ha volt mit átdobni!
            // Ha jégen vagyunk a hoElotte 0, így ez a blokk nem fut le!
            if (hoElotte > 0) {
                List<Sav> szomszedok = s.getSzomszedok();
                if (szomszedok != null && !szomszedok.isEmpty()) {
                    Sav szomszedos = szomszedok.get(0);
                    // Átdobjuk a havat
                    szomszedos.hoNovel(hoElotte); 
                }
            }
        }
        Skeleton.end("");
    }
}
