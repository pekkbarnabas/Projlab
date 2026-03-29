package model;

import skeleton.Skeleton;

public class HanyoFej implements IKotrofej {
    @Override
    /**
     * A hó eltávolítása a sávból. A hó vastagságát 0-ra állítja, függetlenül a jelenlegi értékétől.
     * @param s
     * @param h
     */
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        if(s != null){
            s.hoCsokkent(Integer.MAX_VALUE);
        }

        Skeleton.end("");
    }
}