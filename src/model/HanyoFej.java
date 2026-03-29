package model;

import skeleton.Skeleton;

public class HanyoFej implements IKotrofej {
    @Override
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");

        if(s != null){
            s.hoCsokkent(Integer.MAX_VALUE);
        }

        Skeleton.end("");
    }
}