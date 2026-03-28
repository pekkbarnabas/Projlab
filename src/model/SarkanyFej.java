package model;

import skeleton.Skeleton;

class SarkanyFej implements IKotrofej {
    @Override
    public void dolgozik(Sav s, Hokotro h) {
        Skeleton.hivas(this, "dolgozik(s, h)");
        Skeleton.end("");
    }
}
