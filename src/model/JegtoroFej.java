package model;

import skeleton.Skeleton;

public class JegtoroFej implements IKotrofej {
    @Override
    /**
     * A jég eltávolítása a sávból.
     * @param s
     * @param h
     */
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        if(s != null && h != null){
            s.jegTorese();
        }

        Skeleton.end("");
    }
}
