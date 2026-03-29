package model;

import skeleton.Skeleton;

public class SarkanyFej implements IKotrofej {
    @Override
    /**
     * A sárkányfej dolgozik a megadott sávon és hokotróval.
     * @param s
     * @param h
     */
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        // Kell hogy legyen kerozin
        if(h != null && h.kerozintFogyaszt(1)){
            if(s != null){
                s.jegTorese();

                s.hoCsokkent(Integer.MAX_VALUE); // Jeget és havat is eltakarítja
            }

        }
        Skeleton.end("");
    }
}
